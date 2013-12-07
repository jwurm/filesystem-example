/**
 * 
 */
package com.prodyna.esd.filesystem.filemanager.search;

import com.prodyna.esd.filemanager.model.FileSystemElement;
import com.prodyna.esd.filemanager.model.TextDocument;

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
public class PageRangeCriteria<T extends FileSystemElement> implements SearchCriteria<T>{

	private long min;
	private long max;
	
    /**
     * @param i
     * @param j
     */
    public PageRangeCriteria(int i, int j) {
        this.min = i;
        this.max = j;
    }

    /* (non-Javadoc)
     * @see com.prodyna.esd.filesystem.filemanager.search.SearchCriteria#match(java.lang.Object)
     */
    @Override
    public boolean matches(T element) {
    	
    	if (!(element instanceof TextDocument)){
    		return false;
    	}
    	
    	long numberOfPages = (((TextDocument) element).getNumberOfPages());
    	
    	if (numberOfPages < min){
    		return false;
    	}
    	
    	if (numberOfPages > max){
    		return false;
    	}
    	
        return true;
    }
}
