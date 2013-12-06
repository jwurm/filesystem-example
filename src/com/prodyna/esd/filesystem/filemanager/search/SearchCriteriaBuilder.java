/**
 * 
 */
package com.prodyna.esd.filesystem.filemanager.search;


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
    public SearchCriteriaBuilder<T> set(SearchCriteria<T> criteria1) {
        // TODO Auto-generated method stub
        return this;
    }

    /**
     * @param criteria2
     * @return
     */
    public SearchCriteriaBuilder<T> and(SearchCriteria<T> criteria2) {
        // TODO Auto-generated method stub
        return this;
    }

    /**
     * @return
     */
    public SearchCriteria<T> getSearchCriteria() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param criteria2
     * @return
     */
    public SearchCriteriaBuilder<T> or(SearchCriteria<T> criteria2) {
        // TODO Auto-generated method stub
        return this;
    }

}
