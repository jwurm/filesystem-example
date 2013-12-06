package com.prodyna.esd.filesystem.filemanager.search;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.prodyna.esd.filemanager.model.FileSystemFactory;
import com.prodyna.esd.filemanager.model.TextDocument;
import com.prodyna.esd.filemanager.model.impl.FileSystemFactoryImpl;

public class SearchCriteriaBuilderTest {

	private SearchCriteriaBuilder<TextDocument> builder;
	private NameSearchCriteria<TextDocument> nameSearchCriteria;
	private SearchCriteria<TextDocument> sizeSearchCriteria;

	@Before
	public void setUp() throws Exception {
		builder = new SearchCriteriaBuilder<TextDocument>();
		nameSearchCriteria = new NameSearchCriteria<TextDocument>("Hello");
		sizeSearchCriteria = new SizeSearchCriteria<TextDocument>().min(10).max(1000);
	}

	@Test
	public void testSearchCriteriaBuilder() {
		SearchCriteriaBuilder<TextDocument> builder = new SearchCriteriaBuilder<TextDocument>();
		SearchCriteria<TextDocument> searchCriteria = builder.getSearchCriteria();
		Assert.assertNotNull(searchCriteria);
		
		FileSystemFactory factory = new FileSystemFactoryImpl();		
		Assert.assertFalse(searchCriteria.matches(factory.createTextFile("test", null, 1, null, 10)));
	}

	@Test
	public void testSet() {
		builder.set(nameSearchCriteria);
		SearchCriteria<TextDocument> criteria = builder.getSearchCriteria();
		Assert.assertEquals(nameSearchCriteria, criteria);
	}

	@Test
	public void testAnd() {
		builder.set(nameSearchCriteria).and(sizeSearchCriteria);
		SearchCriteria<TextDocument> criteria = builder.getSearchCriteria();
		Assert.assertTrue(criteria instanceof AndSearchCriteria);
	}

	@Test
	public void testOr() {
		builder.set(nameSearchCriteria).or(sizeSearchCriteria);
		SearchCriteria<TextDocument> criteria = builder.getSearchCriteria();
		Assert.assertTrue(criteria instanceof OrSearchCriteria);
	}

}
