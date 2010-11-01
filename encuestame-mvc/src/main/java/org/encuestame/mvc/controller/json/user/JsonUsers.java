/*
 ************************************************************************************
 * Copyright (C) 2001-2010 encuestame: system online surveys Copyright (C) 2009
 * encuestame Development Team.
 * Licensed under the Apache Software License version 2.0
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to  in writing,  software  distributed
 * under the License is distributed  on  an  "AS IS"  BASIS,  WITHOUT  WARRANTIES  OR
 * CONDITIONS OF ANY KIND, either  express  or  implied.  See  the  License  for  the
 * specific language governing permissions and limitations under the License.
 ************************************************************************************
 */
package org.encuestame.mvc.controller.json.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.encuestame.core.exception.EnMeDomainNotFoundException;
import org.encuestame.mvc.controller.AbstractJsonController;
import org.encuestame.utils.web.UnitUserBean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Description Class.
 * @author Picado, Juan juanATencuestame.org
 * @since Oct 30, 2010 11:08:20 PM
 * @version Id:
 */
@Controller
public class JsonUsers extends AbstractJsonController{


    /**
     * Get List of Users.
     * @param username username
     * @param request request
     * @param response response
     * @return list of json users.
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    @PreAuthorize("hasRole('ENCUESTAME_USER')")
    @RequestMapping(value = "/api/admon/users.json", method = RequestMethod.GET)
    public ModelMap get(
            @RequestParam(value = "limit", required = false) Integer limit,
            @RequestParam(value = "start", required = false) Integer start,
            HttpServletRequest request,
            HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException {
        try {
            //TODO: should be limit and paginate results.
            log.debug("limit "+limit);
            log.debug("start "+start);
            final List<UnitUserBean> userList = getServiceManager()
                  .getApplicationServices().getSecurityService().loadListUsers(getUserPrincipalUsername());
            setItemResponse("users", userList);
        } catch (Exception e) {
            log.error(e);
            setError(e.getMessage(), response);
        }
        return returnData();
    }

    /**
     * Get User Info.
     * @param userId
     * @param request
     * @param response
     * @return
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    @PreAuthorize("hasRole('ENCUESTAME_OWNER')")
    @RequestMapping(value = "/api/admon/user-info.json", method = RequestMethod.GET)
    public ModelMap getUserInfo(
            @RequestParam(value = "id", required = true) Long userId,
            HttpServletRequest request,
            HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException {
        try {
            final UnitUserBean user = getServiceManager().getApplicationServices().getSecurityService()
                                    .getUserCompleteInfo(userId, getUserPrincipalUsername());
            log.debug("user info "+userId);
            if (user == null) {
                setError(new EnMeDomainNotFoundException("user not found").getMessage(), response);
                log.error(new EnMeDomainNotFoundException("user not found").getMessage());
            } else {
                setItemResponse("user", user);
            }
        } catch (Exception e) {
            log.error(e);
            setError(e.getMessage(), response);
        }
        return returnData();
    }

    /**
     * Create User.
     * @param username
     * @param email
     * @param request
     * @param response
     * @return
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    @PreAuthorize("hasRole('ENCUESTAME_OWNER')")
    @RequestMapping(value = "/api/admon/create-user.json", method = RequestMethod.POST)
    public ModelMap createUser(
            @RequestParam(value = "newUsername", required = true) String username,
            @RequestParam(value = "newEmailUser", required = true) String email,
            HttpServletRequest request,
            HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException {
        try {
            log.debug("user newUsername "+username);
            log.debug("user newEmailUser "+email);
            final UnitUserBean userBean = new UnitUserBean();
            userBean.setEmail(email);
            userBean.setUsername(username);
            final Integer emails = getServiceManager().getApplicationServices()
                 .getSecurityService().searchUsersByEmail(email).size();
            final Integer usernames = getServiceManager().getApplicationServices()
                 .getSecurityService().searchUsersByUsername(username).size();
            if(emails > 0 || usernames > 0){
                setError("user or email exist are used.", response);
            } else {
                getServiceManager().getApplicationServices().getSecurityService().createUser(userBean, getUserPrincipalUsername());
                setItemResponse("usserAdded", "ok");
            }
        } catch (Exception e) {
            log.error(e);
            setError(e.getMessage(), response);
        }
        return returnData();
    }
}
