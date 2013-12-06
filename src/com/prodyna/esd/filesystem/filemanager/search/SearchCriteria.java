/**
 * 
 */
package com.prodyna.esd.filesystem.filemanager.search;

import com.prodyna.esd.filemanager.model.FileSystemElement;

/**
 * 
 * <b>Project:</b> filesystem-example</br> <b>Classname:</b>
 * </br>SearchCriteria.java <b>Created:</b> 06.12.2013</br>
 * 
 * @author Jens Wurm
 * 
 *         Beschreibung:
 */
public interface SearchCriteria<T> {

	boolean match(FileSystemElement element);

}
