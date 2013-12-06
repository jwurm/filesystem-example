/**
 * 
 */
package com.prodyna.esd.filemanager.visitor;

import java.util.ArrayList;
import java.util.List;

import com.prodyna.esd.filemanager.model.FileSystemElement;
import com.prodyna.esd.filesystem.filemanager.search.SearchCriteria;

/**
 * @author fassmus
 * 
 */
public abstract class SearchVisitor<T extends FileSystemElement> extends
		FileSystemElementVisitor {

	private SearchCriteria<T> criteria;

	private List<T> matches;

	public SearchVisitor(SearchCriteria<T> criteria) {
		this.criteria = criteria;
		matches = new ArrayList<T>();
	}

	public List<T> getMatches() {
		return matches;
	}

	protected void matches(T element) {
		if (criteria.matches(element)) {
			matches.add(element);
		}
	}

}
