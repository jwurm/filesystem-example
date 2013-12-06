/**
 * ESD Design patterns example.
 * Copyright (c) 2013 by PRODYNA AG.
 */
package com.prodyna.esd.filemanager.model;

/**
 * 
 * @author Oliver Schimmel
 *
 */
public interface File extends FileSystemElement {

	/**
	 * @return the size
	 */
	public abstract long getSize();

}