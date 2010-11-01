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
package org.encuestame.mvc.controller.json.chart;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.encuestame.core.exception.EnMeDomainNotFoundException;
import org.encuestame.mvc.controller.AbstractJsonController;
import org.encuestame.utils.web.UnitTweetPollResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * TweetPoll Json Data Chart.
 * @author Picado, Juan juanATencuestame.org
 * @since Sep 15, 2010 10:30:29 AM
 * @version $Id:$
 */

@Controller("tweetPollJsonDataChart")
public class TweetPollJsonDataChart extends AbstractJsonController{

        //@PreAuthorize("hasRole('ENCUESTAME_USER')")
        @RequestMapping(value = "/api/{username}/tweetPoll/votes.json", method = RequestMethod.GET)
        public ModelMap get(
                @PathVariable String username,
                @RequestParam(value = "tweetPollId") Long tweetPollId,
                HttpServletRequest request,
                HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException {
             log.debug("TweetPollId "+tweetPollId);
             log.debug("TweetPollId "+ (tweetPollId instanceof Long));
             //TODO: we need check if user able to display this tweetpoll. eg. If is published or if is public
             List<UnitTweetPollResult> results;
            try {
                results = getTweetPollService().getResultsByTweetPollId(tweetPollId);
                log.debug("TweetPoll results "+results.size());
                setItemResponse("votesResult", results);
            } catch (EnMeDomainNotFoundException e) {
                log.equals(e);
                setError(e.getMessage(), response);
            }
             return returnData();
        }
}
