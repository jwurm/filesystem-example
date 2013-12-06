/**
 * ESD Design patterns example.
 * Copyright (c) 2013 by PRODYNA AG.
 */
package com.prodyna.esd.filemanager.model.impl;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
public class FileSystemFactoryImplTest {

	private static final long NUMBER_OF_PAGES = 10;

	FileSystemFactory factory;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		factory = new FileSystemFactoryImpl();
	}

	/**
	 * Test method for {@link com.prodyna.esd.filemanager.model.impl.FileSystemFactoryImpl#createDirectory(java.lang.String, com.prodyna.esd.filemanager.model.Directory)}.
	 */
	@Test
	public void testCreateDirectory() {
		Directory directory = factory.createDirectory("test", null);
		Directory directory2 = factory.createDirectory("test2", directory);
		
		Assert.assertEquals("test", directory.getName());
		Assert.assertEquals("test2", directory2.getName());
		
		Assert.assertEquals("test", directory2.getParentDirectory().getName());
	}

	/**
	 * Test method for {@link com.prodyna.esd.filemanager.model.impl.FileSystemFactoryImpl#createTextFile(java.lang.String, com.prodyna.esd.filemanager.model.Directory, long, java.lang.String, com.prodyna.esd.filemanager.model.impl.TextFileImpl.TextEncoding)}.
	 */
	@Test
	public void testCreateTextFile() {
		Directory directory = factory.createDirectory("test", null);
		TextDocument textDocument = factory.createTextFile("text1", directory, 1000, TextEncoding.UTF8, NUMBER_OF_PAGES);
		
		Assert.assertEquals("text1", textDocument.getName());
		Assert.assertEquals("test",  textDocument.getParentDirectory().getName());
		Assert.assertEquals(1000, textDocument.getSize());
		Assert.assertEquals("UTF8", textDocument.getEncoding().name());
	}

	/**
	 * Test method for {@link com.prodyna.esd.filemanager.model.impl.FileSystemFactoryImpl#createImageFile(java.lang.String, com.prodyna.esd.filemanager.model.Directory, long, java.lang.String, com.prodyna.esd.filemanager.model.ImageType)}.
	 */
	@Test
	public void testCreateImageFile() {
		Directory directory = factory.createDirectory("test", null);
		ImageFile imageFile = factory.createImageFile("image1", directory, 1000, ImageType.GIF, 640, 480);
		
		Assert.assertEquals("image1", imageFile.getName());
		Assert.assertEquals("test",  imageFile.getParentDirectory().getName());
		Assert.assertEquals(1000, imageFile.getSize());
		Assert.assertEquals("GIF", imageFile.getType().name());
		Assert.assertEquals(640, imageFile.getWidth());
		Assert.assertEquals(480, imageFile.getHeight());
	}

	/**
	 * Test method for {@link com.prodyna.esd.filemanager.model.impl.FileSystemFactoryImpl#createArchiveFile(java.lang.String, com.prodyna.esd.filemanager.model.Directory, long, java.lang.String, com.prodyna.esd.filemanager.model.CompresionType)}.
	 */
	@Test
	public void testCreateArchiveFile() {
		Directory directory = factory.createDirectory("test", null);
		ArchiveFile archiveFile = factory.createArchiveFile("archive1", directory, 1000, CompressionType.JAR, 2000);
		
		Assert.assertEquals("archive1", archiveFile.getName());
		Assert.assertEquals("test",  archiveFile.getParentDirectory().getName());
		Assert.assertEquals(1000, archiveFile.getSize());
		Assert.assertEquals("JAR", archiveFile.getCompresionType().name());
		Assert.assertEquals(2000, archiveFile.getUncompressed());
	}

}
