/**
 * 
 */
package com.prodyna.esd.filemanager.visitor;

/**
 * 
 * <b>Project:</b> filesystem-example</br> <b>Classname:</b>
 * </br>Visitable.java <b>Created:</b>
 * 06.12.2013</br>
 * 
 * @author Jens Wurm
 * 
 *         Beschreibung: 
 */
public interface Visitable {

    /**
     * @param visitor
     */
    void accept(FileSystemElementVisitor visitor);

}
