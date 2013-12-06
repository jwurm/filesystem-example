/**
 * ESD Design patterns example.
 * Copyright (c) 2013 by PRODYNA AG.
 */
package com.prodyna.esd.filemanager.model.impl;

import com.prodyna.esd.filemanager.event.FileSystemEvent;
import com.prodyna.esd.filemanager.model.Directory;
import com.prodyna.esd.filemanager.model.FileSystemElement;
import com.prodyna.esd.filemanager.observer.FileSystemListener;
import com.prodyna.esd.filemanager.observer.ObserverHelper;

/**
 * @author oschimmel
 *
 */
public abstract class FileSystemElementImpl implements FileSystemElement {

	/** Name of directory or file. */
	protected String name;
	
	/** Parent directory or <code>null</code> if this is the root. */
	private Directory parentDirectory;
	
	private ObserverHelper observerHelper = new ObserverHelper();



	/**
	 * @param name
	 * @param parent
	 */
	public FileSystemElementImpl(String name, Directory parent) {
		this.name = name;
		parentDirectory = parent;
	}



	@Override
	public void moveTo(Directory target) {
		parentDirectory = target;
	}

	/**
	 * @return the name
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * @return the parentDirectory
	 */
	@Override
	public Directory getParentDirectory() {
		return parentDirectory;
	}

	/**
	 * @param listener
	 * @see com.prodyna.esd.filemanager.observer.ObserverHelper#addListener(com.prodyna.esd.filemanager.observer.FileSystemListener)
	 */
	public void addListener(FileSystemListener listener) {
		observerHelper.addListener(listener);
	}
	
	
	/**
	 * @param listener
	 * @see com.prodyna.esd.filemanager.observer.ObserverHelper#removeListener(com.prodyna.esd.filemanager.observer.FileSystemListener)
	 */
	public void removeListener(FileSystemListener listener) {
		observerHelper.removeListener(listener);
	}
	
	
	/**
	 * @param event
	 * @see com.prodyna.esd.filemanager.observer.ObserverHelper#notifyListeners(com.prodyna.esd.filemanager.event.FileSystemEvent)
	 */
	public void notifyListeners(FileSystemEvent event) {
		observerHelper.notifyListeners(event);
	}
	
	
}
