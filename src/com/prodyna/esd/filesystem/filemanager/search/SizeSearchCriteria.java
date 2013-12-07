package com.prodyna.esd.filesystem.filemanager.search;

import com.prodyna.esd.filemanager.model.FileSystemElement;

/**
 * 
 * @author jtrumpfheller
 *
 * @param <T>
 */
public class SizeSearchCriteria<T extends FileSystemElement> implements
		SearchCriteria<T> {

	private long min = -1l;
	private long max = -1l;

	public SizeSearchCriteria<T> min(int i) {
		this.min = i;
		return this;
	}

	public SizeSearchCriteria<T> max(int i) {
		this.max = i;
		return this;
	}

	public boolean matches(T element) {

		long size = element.getSize();

		if (min != -1l && size < min) {
			return false;
		}

		if (max != -1l && size > max) {
			return false;
		}

		return true;
	}

}
