/**
 * Design patterns example
 */
package com.prodyna.esd.filemanager.model.impl;

import com.prodyna.esd.filemanager.model.Directory;
import com.prodyna.esd.filemanager.model.TextDocument;
import com.prodyna.esd.filemanager.visitor.FileSystemElementVisitor;

/**
 * @author dgornjakovic
 * 
 */
public class TextFileImpl extends FileImpl implements TextDocument {

	public enum TextEncoding {
		UTF8, CP50, UTF16, PDF, WORD;
	}

	private final TextEncoding encoding;
	private final long numberOfPages;

	/**
	 * @param size
	 * @param extension
	 * @param encoding
	 */
	public TextFileImpl(String name, Directory parent, long size, TextEncoding encoding, long numberOfPages) {
		super(name, parent, size);
		this.encoding = encoding;
		this.numberOfPages = numberOfPages;
	}

	@Override
	public TextEncoding getEncoding() {
		return encoding;
	}

	@Override
	public long getNumberOfPages() {
		return numberOfPages;
	}

	@Override
	public void accept(FileSystemElementVisitor visitor) {
		 visitor.visit(this);
	}
}
