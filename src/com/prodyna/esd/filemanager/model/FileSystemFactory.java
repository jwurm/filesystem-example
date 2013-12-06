/**
 * ESD Design patterns example.
 * Copyright (c) 2013 by PRODYNA AG.
 */
package com.prodyna.esd.filemanager.model;

import com.prodyna.esd.filemanager.model.impl.TextFileImpl.TextEncoding;

/**
 * @author oschimmel
 * 
 */
public interface FileSystemFactory {

	Directory createDirectory(String name, Directory parent);

	TextDocument createTextFile(String name, Directory parent, long size,
			TextEncoding encoding, long numberOfPages);

	ArchiveFile createArchiveFile(String name, Directory parent, long size,
			CompressionType type, long uncompressedSize);

	ImageFile createImageFile(String name, Directory parent, long size,
			ImageType type, int width, int height);

}
