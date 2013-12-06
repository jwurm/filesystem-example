/**
 * ESD Design patterns example.
 * Copyright (c) 2013 by PRODYNA AG.
 */
package com.prodyna.esd.filemanager.model.impl;

import com.prodyna.esd.filemanager.model.Directory;
import com.prodyna.esd.filemanager.model.File;

/**
 * Abstract implementation of files.
 * 
 * 
 * @author Oliver Schimmel
 * 
 */
public abstract class FileImpl extends FileSystemElementImpl implements File {

	private long size;
	
	/**
	 * Constructor using size and extension.
	 * 
	 * @param name name
	 * @param parent parent directory
	 * @param size file size 
	 * 
	 */
	protected FileImpl(String name, Directory parent, long size) {
		super(name, parent);
		this.size = size;
	}

	@Override
	public long getSize() {
		return size;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getName() + "(" + getSize() + " bytes)";
	}

	
}
