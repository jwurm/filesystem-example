/**
 * 
 */
package com.prodyna.esd.filesystem.filemanager.search;

import java.util.ArrayList;
import java.util.List;


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
    
    private SearchCriteria<T> rootCriteria;
    
    public SearchCriteriaBuilder(){
        rootCriteria=new AlwaysFalseCriteria<T>();
    }

    /**
     * @param criteria1
     * @return
     */
    public SearchCriteriaBuilder<T> set(SearchCriteria<T> criteria1) {
        rootCriteria=criteria1;
        return this;
    }

    /**
     * @param criteria2
     * @return
     */
    public SearchCriteriaBuilder<T> and(SearchCriteria<T> criteria2) {
        AndSearchCriteria andSearchCriteria = new AndSearchCriteria(rootCriteria, criteria2);
        rootCriteria=andSearchCriteria;
        return this;
    }

    /**
     * @return
     */
    public SearchCriteria<T> getSearchCriteria() {
        return rootCriteria;
    }

    /**
     * @param criteria2
     * @return
     */
    public SearchCriteriaBuilder<T> or(SearchCriteria<T> criteria2) {
        OrSearchCriteria<T> orSearchCriteria = new OrSearchCriteria<T>(rootCriteria, criteria2);
        rootCriteria=orSearchCriteria;
        return this;
    }

}
