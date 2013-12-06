/**
 * 
 */
package com.prodyna.esd.filemanager.observer;

import com.prodyna.esd.filemanager.event.FileSystemEvent;

/**
 * 
 * <b>Project:</b> filesystem-example</br> <b>Classname:</b>
 * </br>FileSystemListener.java <b>Created:</b>
 * 06.12.2013</br>
 * 
 * @author Jens Wurm
 * 
 *         Beschreibung: 
 */
public interface FileSystemListener {

	void eventCallback(FileSystemEvent event);

}
