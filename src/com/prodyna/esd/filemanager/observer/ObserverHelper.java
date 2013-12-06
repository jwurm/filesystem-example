/**
 * 
 */
package com.prodyna.esd.filemanager.observer;

import java.util.ArrayList;
import java.util.List;

import com.prodyna.esd.filemanager.event.FileSystemEvent;

/**
 * 
 * <b>Project:</b> filesystem-example</br> <b>Classname:</b>
 * </br>ObserverHelper.java <b>Created:</b>
 * 06.12.2013</br>
 * 
 * @author Jens Wurm
 * 
 *         Beschreibung: 
 */
public class ObserverHelper {

	private List<FileSystemListener> listeners;
	
    /**
     * @param listener
     */
    public void addListener(FileSystemListener listener) {
    	
    	if (listeners == null){
    		listeners = new ArrayList<FileSystemListener>();
    	}
    	
    	listeners.add(listener);
    }

    /**
     * @param event
     */
    public void notifyListeners(FileSystemEvent event) {
      
    	if (listeners == null){
    		return;
    	}
    	
    	for (FileSystemListener listener : listeners) {
		}
    }

    /**
     * @param listener
     */
    public void removeListener(FileSystemListener listener) {
    	
    	if (listeners == null){
    		return;
    	}
        
    	listeners.remove(listener);
    }
}
