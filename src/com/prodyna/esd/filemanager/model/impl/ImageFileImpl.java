package com.prodyna.esd.filemanager.model.impl;

import com.prodyna.esd.filemanager.model.Directory;
import com.prodyna.esd.filemanager.model.ImageFile;
import com.prodyna.esd.filemanager.model.ImageType;
import com.prodyna.esd.filemanager.visitor.FileSystemElementVisitor;

public class ImageFileImpl extends FileImpl implements ImageFile {

	/**
	 * @param name
	 * @param parent
	 * @param size
	 * @param extension
	 */
	public ImageFileImpl(String name, Directory parent, long size,
			ImageType type, int width, int height) {
		super(name, parent, size);
		this.type = type;
		this.width = width;
		this.height = height;
	}

	private int width;
	private int height;
	
	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}
	
	ImageType type;

	@Override
	public ImageType getType() {
		return type;
	}

	@Override
	public void accept(FileSystemElementVisitor visitor) {
		visitor.visit(this);
	}

}
