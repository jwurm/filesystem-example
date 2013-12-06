/**
 * ESD Desing patterns example
 * Copyright (c) 2013 by Prodyna AG 
 */
package com.prodyna.esd.filemanager.model;

/**
 * @author bignjatovic
 *
 */
public interface ArchiveFile extends File {

	public abstract CompressionType getCompresionType();

	public abstract long getUncompressed();

}