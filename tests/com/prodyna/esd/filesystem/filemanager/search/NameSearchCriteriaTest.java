package com.prodyna.esd.filesystem.filemanager.search;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.prodyna.esd.filemanager.model.Directory;
import com.prodyna.esd.filemanager.model.FileSystemElement;
import com.prodyna.esd.filemanager.model.FileSystemFactory;
import com.prodyna.esd.filemanager.model.ImageFile;
import com.prodyna.esd.filemanager.model.TextDocument;
import com.prodyna.esd.filemanager.model.impl.FileSystemFactoryImpl;

public class NameSearchCriteriaTest {

	private ImageFile imageFile;
	private TextDocument textFile2;
	private Directory directory;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		FileSystemFactory factory = new FileSystemFactoryImpl();		
		imageFile = factory.createImageFile("test1", null, 200, null, 640, 480);
		textFile2 = factory.createTextFile("test2", null, 200, null, 10);
		directory = factory.createDirectory("test3", null);
	}

	@Test
	public void testMatchesName() {
		NameSearchCriteria<FileSystemElement> criteria = new NameSearchCriteria<FileSystemElement>("test2");
		Assert.assertFalse(criteria.matches(imageFile));		
		Assert.assertTrue(criteria.matches(textFile2));
		Assert.assertFalse(criteria.matches(directory));
	}

	
	@Test
	public void testMatchesExpression1() {
		NameSearchCriteria<FileSystemElement> criteria = new NameSearchCriteria<FileSystemElement>("test.*");
		Assert.assertTrue(criteria.matches(imageFile));		
		Assert.assertTrue(criteria.matches(textFile2));
		Assert.assertTrue(criteria.matches(directory));
	}

	@Test
	public void testMatchesExpression2() {
		NameSearchCriteria<FileSystemElement> criteria = new NameSearchCriteria<FileSystemElement>(".*2");
		Assert.assertFalse(criteria.matches(imageFile));		
		Assert.assertTrue(criteria.matches(textFile2));
		Assert.assertFalse(criteria.matches(directory));
	}

}
