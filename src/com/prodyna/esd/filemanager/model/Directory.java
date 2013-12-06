/**
 * ESD Design patterns example.
 * Copyright (c) 2013 by PRODYNA AG.
 */
package com.prodyna.esd.filemanager.model;

import java.util.List;

/**
 * @author oschimmel
 *
 */
public interface Directory extends FileSystemElement {

	void remove(FileSystemElement fileSystemElement);
	
	void add(FileSystemElement fileSystemElement);

	public List<FileSystemElement> getElements();

}