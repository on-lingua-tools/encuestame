/*
 ************************************************************************************
 * Copyright (C) 2001-2009 encuestame: system online surveys Copyright (C) 2009
 * encuestame Development Team.
 * Licensed under the Apache Software License version 2.0
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to  in writing,  software  distributed
 * under the License is distributed  on  an  "AS IS"  BASIS,  WITHOUT  WARRANTIES  OR
 * CONDITIONS OF ANY KIND, either  express  or  implied.  See  the  License  for  the
 * specific language governing permissions and limitations under the License.
 ************************************************************************************
 */
package org.encuestame.business.service.imp;

import org.encuestame.core.service.util.MessageSourceFactoryBean;

/**
 * Interface to Service Manager.
 * @author Picado, Juan juan@encuestame.org
 * @since 26/04/2009 20:12:31
 * @version $Id$
 */
public interface IServiceManager{

    /**
     * Getter {@link IApplicationServices}.
     * @return {@link IApplicationServices}
     */
    public IApplicationServices getApplicationServices();

    /**
     * Setter.
     * @param applicationServices {@link IApplicationServices}
     */
    public void setApplicationServices(IApplicationServices applicationServices);

    /**
     * Getter.
     * @return {@link MessageSourceFactoryBean}
     */
    public MessageSourceFactoryBean getMessageSource();

    /**
     * Setter.
     * @param messageSource {@link MessageSourceFactoryBean}
     */
    public void setMessageSource(MessageSourceFactoryBean messageSource);
}