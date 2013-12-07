/**
 * 
 */
package com.prodyna.esd.filesystem.filemanager.search;

/**
 * 
 * <b>Project:</b> filesystem-example</br> <b>Classname:</b>
 * </br>AlwaysFalseCriteria.java <b>Created:</b>
 * 07.12.2013</br>
 * 
 * @author Jens Wurm
 * 
 *         Beschreibung: 
 */
public class AlwaysFalseCriteria<T> implements SearchCriteria<T> {

    /* (non-Javadoc)
     * @see com.prodyna.esd.filesystem.filemanager.search.SearchCriteria#matches(java.lang.Object)
     */
    @Override
    public boolean matches(T element) {
        return false;
    }
}
