package com.cidenet.hulkstore.documents;

import java.io.Serializable;

/**
 * This class represents the document model.
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-24
 */
public final class DocumentDto implements Serializable
{
    /** 
     * This attribute maps to the column documentId in the document table.
     */
    private int documentId;

    /** 
     * This attribute maps to the column documentDescription in the document table.
     */
    private String documentDescription;

    /** 
     * This attribute represents whether the primitive attribute documentId is null.
     */
    private boolean documentIdNull = true;

    /** 
     * This attribute maps to the column state in the document table.
     */
    private short state;

    /**
     * Empty Constructor.
     */
    public DocumentDto() {}
        
    /**
     * Constructor for a new document.
     * 
     * @param documentId
     * @param documentDescription
     */
    public DocumentDto(int documentId, String documentDescription)
    {
        this.documentId = documentId;
        this.documentDescription = documentDescription;
        this.documentIdNull = false;
        this.state = (short) 1;
    }

    /**
     * Constructor.
     * 
     * @param documentId
     * @param documentDescription
     * @param state 
     */
    public DocumentDto(int documentId, String documentDescription, short state) 
    {
        this.documentId = documentId;
        this.documentDescription = documentDescription;
        this.documentIdNull = false;
        this.state = state;
    }
    
    /**
     * Gets the value of documentId.
     * 
     * @return documentId
     */
    public int getDocumentId() { return documentId; }

    /**
     * Sets the value of documentId.
     * 
     * @param documentId
     */
    public void setDocumentId(int documentId) { this.documentId = documentId; }

    /**
     * Gets the value of documentDescription.
     * 
     * @return documentDescription
     */
    public String getDocumentDescription() { return documentDescription; }

    /**
     * Sets the value of documentDescription.
     * 
     * @param documentDescription
     */
    public void setDocumentDescription(String documentDescription) { this.documentDescription = documentDescription; }

    /**
     * Gets the value of state.
     * 
     * @return state
     */
    public short getState() { return state; }

    /**
     * Sets the value of state.
     * 
     * @param state
     */
    public void setState(short state) { this.state = state; }

    /**
     * Method 'createPk'.
     * 
     * @return DocumentPk
     */
    public DocumentPk createPk() { return new DocumentPk(documentId); }

    /**
     * Method 'toString'.
     * 
     * @return String
     */
    public String toString()
    {
        StringBuilder response = new StringBuilder();
        response.append("com.cidenet.hulkstore.dto.Document: ");
        response.append("documentId=").append(documentId);
        response.append(", documentDescription=").append(documentDescription);
        response.append(", state=").append(state);
        return response.toString();
    }
}