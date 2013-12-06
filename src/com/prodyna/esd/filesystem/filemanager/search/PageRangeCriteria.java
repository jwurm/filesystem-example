/**
 * 
 */
package com.prodyna.esd.filesystem.filemanager.search;

/**
 * 
 * <b>Project:</b> filesystem-example</br> <b>Classname:</b>
 * </br>PageRangeCriteria.java <b>Created:</b>
 * 06.12.2013</br>
 * 
 * @author Jens Wurm
 * 
 *         Beschreibung: 
 */
public class PageRangeCriteria<T> implements SearchCriteria<T>{

    /**
     * @param i
     * @param j
     */
    public PageRangeCriteria(int i, int j) {
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see com.prodyna.esd.filesystem.filemanager.search.SearchCriteria#match(java.lang.Object)
     */
    @Override
    public boolean match(T element) {
        // TODO Auto-generated method stub
        return false;
    }
}
