/**
 * 
 */
package com.prodyna.esd.filesystem.filemanager.search;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.prodyna.esd.filemanager.model.FileSystemFactory;
import com.prodyna.esd.filemanager.model.TextDocument;
import com.prodyna.esd.filemanager.model.impl.FileSystemFactoryImpl;

/**
 * Tests for {@link SizeSearchCriteria}.
 * 
 * @author Oliver Schimmel
 */
public class SizeSearchCriteriaTest {

	private TextDocument textFile1;
	private TextDocument textFile2;
	private TextDocument textFile3;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		FileSystemFactory factory = new FileSystemFactoryImpl();		
		textFile1 = factory.createTextFile("test", null, 100, null, 10);
		textFile2 = factory.createTextFile("test", null, 200, null, 10);
		textFile3 = factory.createTextFile("test", null, 300, null, 10);
	}

	@Test
	public void testMin() {
		SizeSearchCriteria<TextDocument> criteria = new SizeSearchCriteria<TextDocument>();
		criteria.min(110);
		Assert.assertFalse(criteria.matches(textFile1));		
		Assert.assertTrue(criteria.matches(textFile2));
		Assert.assertTrue(criteria.matches(textFile3));
	}

	@Test
	public void testMax() {
		SizeSearchCriteria<TextDocument> criteria = new SizeSearchCriteria<TextDocument>();
		criteria.max(250);
		Assert.assertTrue(criteria.matches(textFile1));		
		Assert.assertTrue(criteria.matches(textFile2));
		Assert.assertFalse(criteria.matches(textFile3));
	}

	@Test
	public void testMinMax() {
		SizeSearchCriteria<TextDocument> criteria = new SizeSearchCriteria<TextDocument>();
		criteria.min(110).max(220);
		Assert.assertFalse(criteria.matches(textFile1));		
		Assert.assertTrue(criteria.matches(textFile2));
		Assert.assertFalse(criteria.matches(textFile3));
	}
	
}
