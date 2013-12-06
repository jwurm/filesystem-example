/**
 * ESD Design patterns example.
 * Copyright (c) 2013 by PRODYNA AG.
 */
package com.prodyna.esd.filemanager.model.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.prodyna.esd.filemanager.event.DirectoryAddedEvent;
import com.prodyna.esd.filemanager.event.DirectoryRemovedEvent;
import com.prodyna.esd.filemanager.event.EventMediator;
import com.prodyna.esd.filemanager.event.FileAddedEvent;
import com.prodyna.esd.filemanager.event.FileRemovedEvent;
import com.prodyna.esd.filemanager.event.FileSystemEvent;
import com.prodyna.esd.filemanager.model.Directory;
import com.prodyna.esd.filemanager.model.File;
import com.prodyna.esd.filemanager.model.FileSystemElement;
import com.prodyna.esd.filemanager.visitor.FileSystemElementVisitor;

/**
 * Implementation of file system directory.
 * 
 * @author Oliver
 * 
 */
public class DirectoryImpl extends FileSystemElementImpl implements Directory {

	private List<FileSystemElement> elements;

	/**
	 * To create a directory implementation please use
	 * {@link FileSystemFactoryImpl#createDirectory(String, Directory)}.
	 * 
	 * @param name
	 *            name of the directory
	 * @param parent
	 *            parent directory
	 */
	DirectoryImpl(String name, Directory parent) {
		this(name, parent, Collections.<FileSystemElement> emptyList());
	}

	/**
	 * @param elements
	 */
	public DirectoryImpl(String name, Directory parent,
			List<FileSystemElement> elements) {
		super(name, parent);
		this.elements = new ArrayList<FileSystemElement>(elements);
	}

	/**
	 * @return the elements
	 */
	@Override
	public List<FileSystemElement> getElements() {
		return elements;
	}

	/**
	 * Add a new directory or file to this directory.
	 * 
	 * @param fileSystemElement
	 *            file element to add.
	 */
	@Override
	public void add(FileSystemElement fileSystemElement) {
		elements.add(fileSystemElement);
		sendAddEvent(fileSystemElement);
	}

	/**
	 * Removes the already existing file system element from this directory.
	 * 
	 * @param fileSystemElement
	 *            element to remove.
	 */
	@Override
	public void remove(FileSystemElement fileSystemElement) {
		elements.remove(fileSystemElement);
		sendRemoveEvent(fileSystemElement);
	}

	private void sendRemoveEvent(FileSystemElement fileSystemElement) {
		FileSystemEvent event;
		if (fileSystemElement instanceof File) {
			event = new FileRemovedEvent(fileSystemElement, this);
		} else if (fileSystemElement instanceof Directory) {
			event = new DirectoryRemovedEvent(fileSystemElement, this);
		} else {
			event = null;
		}

		EventMediator.getInstance().notifyListeners(event);
	}

	private void sendAddEvent(FileSystemElement fileSystemElement) {
		FileSystemEvent event;
		if (fileSystemElement instanceof File) {
			event = new FileAddedEvent(fileSystemElement, this);
		} else if (fileSystemElement instanceof Directory) {
			event = new DirectoryAddedEvent(fileSystemElement, this);
		} else {
			event = null;
		}
		EventMediator.getInstance().notifyListeners(event);
	}

	@Override
	public long getSize() {
		long result = 0;

		for (FileSystemElement fileSystemElement : elements) {
			result += fileSystemElement.getSize();
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.prodyna.esd.filemanager.visitor.Visitable#accept(com.prodyna.esd.
	 * filemanager.visitor.Visitor)
	 */
	@Override
	public void accept(FileSystemElementVisitor visitor) {
		visitor.visit(this);
	}
}
