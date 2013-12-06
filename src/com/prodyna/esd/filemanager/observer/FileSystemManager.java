/**
 * 
 */
package com.prodyna.esd.filemanager.observer;

/**
 * 
 * <b>Project:</b> filesystem-example</br> <b>Classname:</b>
 * </br>FileSystemManager.java <b>Created:</b>
 * 06.12.2013</br>
 * 
 * @author Jens Wurm
 * 
 *         Beschreibung: 
 */
public interface FileSystemManager {

    /**
     * @param fileSystemListener
     */
    void addListener(FileSystemListener fileSystemListener);
}
