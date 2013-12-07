/**
 * 
 */
package com.prodyna.esd.filesystem.filemanager.search;

import java.util.regex.Pattern;

import com.prodyna.esd.filemanager.model.FileSystemElement;

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
public class NameSearchCriteria<T extends FileSystemElement> implements SearchCriteria<T> {

	private String value;
	
    /**
     * @param string
     */
    public NameSearchCriteria(String string) {
    	this.value = string;
    }

    
    /**
     * @param textFile2
     * @return
     */
    public boolean matches(T file) {
    	return Pattern.matches(value, file.getName() );
    }
}
