/**
 * encuestame: system online surveys Copyright (C) 2005-2008 encuestame
 * Development Team
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of version 3 of the GNU General Public License as published by the
 * Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, writes to the Free Software Foundation, Inc., 59 Temple
 * Place, Suite 330, Boston, MA 02111-1307 USA
 */
package org.encuestame.core.persistence.dao.imp;

import java.util.List;

import org.encuestame.core.persistence.pojo.Questions;
import org.encuestame.core.persistence.pojo.QuestionPattern;
import org.hibernate.HibernateException;

 /**
  * Interface to implement Question Dao.
  * @author Picado, Juan juan@encuestame.org
  * @since  02/06/2009 19:44:21
  */
public interface IQuestionDao extends IBaseDao {

    /**
     * Create Question.
     * @param question question
     * @throws HibernateException exception
     */
    public void createQuestion(final Questions question) throws HibernateException;

    /**
     * Load All Questions.
     * @return List of {@link Questions}
     * @throws HibernateException exception
     */
    public List<Questions> loadAllQuestions() throws HibernateException;

    /**
     * Load All Questions Patron.
     * @return  List of {@link QuestionPattern}
     * @throws HibernateException exception
     */
    public List<QuestionPattern> loadAllQuestionPattern()
    throws HibernateException;

    /**
     * Load pattern info.
     * @param patronId patron id
     * @return QuestionPatron
     * @throws HibernateException exception
     */
    public QuestionPattern loadPatternInfo(final Long patronId) throws HibernateException;
}
