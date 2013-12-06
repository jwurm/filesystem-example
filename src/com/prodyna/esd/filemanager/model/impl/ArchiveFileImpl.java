/**
 * ESD Desing patterns example
 * Copyright (c) 2013 by Prodyna AG 
 */
package com.prodyna.esd.filemanager.model.impl;

import com.prodyna.esd.filemanager.model.ArchiveFile;
import com.prodyna.esd.filemanager.model.CompressionType;
import com.prodyna.esd.filemanager.model.Directory;
import com.prodyna.esd.filemanager.visitor.FileSystemElementVisitor;

/**
 * @author bignjatovic
 * 
 */
public class ArchiveFileImpl extends FileImpl implements ArchiveFile {

	private CompressionType compresionType;
	private long uncompressed;


	/**
	 * @param size
	 * @param compresionType
	 * @param uncompressed
	 */
	ArchiveFileImpl(String name, Directory parent, long size, CompressionType compresionType, long uncompressed) {
		super(name, parent, size);
		this.compresionType = compresionType;
		this.uncompressed = uncompressed;
	}

	@Override
	public CompressionType getCompresionType() {
		return compresionType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.prodyna.esd.filemanager.model.Archive#getUncompresed()
	 */
	@Override
	public long getUncompressed() {
		return uncompressed;
	}

	@Override
	public void accept(FileSystemElementVisitor visitor) {
		visitor.visit(this);
	}

}
