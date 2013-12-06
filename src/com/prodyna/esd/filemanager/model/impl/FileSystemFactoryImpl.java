/**
 * ESD Design patterns example.
 * Copyright (c) 2013 by PRODYNA AG.
 */
package com.prodyna.esd.filemanager.model.impl;

import com.prodyna.esd.filemanager.model.ArchiveFile;
import com.prodyna.esd.filemanager.model.CompressionType;
import com.prodyna.esd.filemanager.model.Directory;
import com.prodyna.esd.filemanager.model.FileSystemFactory;
import com.prodyna.esd.filemanager.model.ImageFile;
import com.prodyna.esd.filemanager.model.ImageType;
import com.prodyna.esd.filemanager.model.TextDocument;
import com.prodyna.esd.filemanager.model.impl.TextFileImpl.TextEncoding;

/**
 * @author oschimmel
 *
 */
public class FileSystemFactoryImpl implements FileSystemFactory {

	@Override
	public Directory createDirectory(String name, Directory parent) {
		return new DirectoryImpl(name, parent);
	}

	@Override
	public TextDocument createTextFile(String name, Directory parent, long size, TextEncoding encoding, long numberOfPages) {
		return new TextFileImpl(name, parent, size, encoding, numberOfPages);
	}

	@Override
	public ImageFile createImageFile(String name, Directory parent, long size, ImageType type, int width, int height) {
		return new ImageFileImpl(name, parent, size, type, width, height);
	}

	@Override
	public ArchiveFile createArchiveFile(String name, Directory parent,
			long size, CompressionType type, long uncompresssed) {
		return new ArchiveFileImpl(name, parent, size, type, uncompresssed);
	}

}
