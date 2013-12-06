/**
 * ESD Design patterns example.
 * Copyright (c) 2013 by PRODYNA AG.
 */
package com.prodyna.esd.filemanager.model;

import com.prodyna.esd.filemanager.observer.Observable;
import com.prodyna.esd.filemanager.visitor.Visitable;

/**
 * Common interface for all file system elements.
 * 
 * @author Oliver Schimmel
 * 
 */
public interface FileSystemElement extends Observable, Visitable {

	/**
	 * Gets the file or directory size.
	 * 
	 * @return size in bytes.
	 */
	long getSize();

	/**
	 * Gets the name.
	 * @return name
	 */
	public abstract String getName();

	public abstract Directory getParentDirectory();

	/**
	 * Moves this element to its new given parent.
	 * @param target target directory where to move this element.
	 */
	void moveTo(Directory target);
}
