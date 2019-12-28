package com.cidenet.hulkstore.model.dto.kardex;

/** 
 * This class represents the kardex detail view model.
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-24
 */
public final class KardexDetailView extends KardexDetail
{   
    /** 
     * This attribute maps to the column documentDescription in the document table.
     */
    protected String documentDescription;

    /**
     * Gets the value of document description.
     * 
     * @return String
     */
    public String getDocumentDescription() { return documentDescription; }

    /**
     * Sets the value of document description.
     * 
     * @param documentDescription
     */
    public void setDocumentDescription(String documentDescription) { this.documentDescription = documentDescription; }    
}