package com.cidenet.hulkstore.model.dto.document;

import java.io.Serializable;

/** 
 * This class represents the primary key of the document table.
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-24
 */
public final class DocumentPk implements Serializable
{
    /** 
     * This attribute maps to the column documentId in the document table.
     */
    protected int documentId;

    /** 
     * This attribute represents whether the primitive attribute documentId is null.
     */
    protected boolean documentIdNull;

    /** 
     * Sets the value of documentId.
     * 
     * @param documentId
     */
    public void setDocumentId(int documentId) { this.documentId = documentId; }

    /** 
     * Gets the value of documentId.
     * 
     * @return int
     */
    public int getDocumentId() { return documentId; }

    /**
     * Empty Constructor.
     */
    public DocumentPk() {}

    /**
     * Constructor for a new documentPk.
     * 
     * @param documentId
     */
    public DocumentPk(final int documentId)
    {
        this.documentId = documentId;
        this.documentIdNull = false;
    }

    /** 
     * Gets the value of documentIdNull.
     * 
     * @return boolean
     */
    public boolean isDocumentIdNull() { return documentIdNull; }
}