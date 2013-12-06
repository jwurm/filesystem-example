/**
 * Design patterns example
 */
package com.prodyna.esd.filemanager.model;

import com.prodyna.esd.filemanager.model.impl.TextFileImpl.TextEncoding;

/**
 * @author dgornjakovic
 * 
 */
public interface TextDocument extends File {

	TextEncoding getEncoding();
	long getNumberOfPages();

}
