/**
 * 
 */
package com.prodyna.esd.filesystem.filemanager.search;

import com.prodyna.esd.filemanager.model.TextDocument;

/**
 * 
 * <b>Project:</b> filesystem-example</br> <b>Classname:</b>
 * </br>SearchCriteriaBuilder.java <b>Created:</b>
 * 06.12.2013</br>
 * 
 * @author Jens Wurm
 * 
 *         Beschreibung: 
 */
public class SearchCriteriaBuilder<T>  {

    /**
     * @param criteria1
     * @return
     */
    public SearchCriteriaBuilder set(SearchCriteria<TextDocument> criteria1) {
        // TODO Auto-generated method stub
        return this;
    }

    /**
     * @param criteria2
     * @return
     */
    public SearchCriteriaBuilder and(SearchCriteria<TextDocument> criteria2) {
        // TODO Auto-generated method stub
        return this;
    }

    /**
     * @return
     */
    public SearchCriteria<TextDocument> getSearchCriteria() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param criteria2
     * @return
     */
    public SearchCriteriaBuilder or(SearchCriteria<TextDocument> criteria2) {
        // TODO Auto-generated method stub
        return this;
    }

}
