/**
 * 
 */
package com.prodyna.esd.filesystem.filemanager.search;

import com.prodyna.esd.filemanager.model.FileSystemElement;
import com.prodyna.esd.filemanager.model.ImageFile;
import com.prodyna.esd.filemanager.model.TextDocument;

/**
 * 
 * <b>Project:</b> filesystem-example</br> <b>Classname:</b>
 * </br>NameSearchCriteria.java <b>Created:</b>
 * 06.12.2013</br>
 * 
 * @author Jens Wurm
 * 
 *         Beschreibung: 
 */
public class NameSearchCriteria<T> implements SearchCriteria<T> {

    /**
     * @param string
     */
    public NameSearchCriteria(String string) {
        // TODO Auto-generated constructor stub
    }

    
    /**
     * @param textFile2
     * @return
     */
    public boolean match(T file) {
        // TODO Auto-generated method stub
        return false;
    }
}
