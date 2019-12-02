package com.cidenet.hulkstore.kardex;

/**
 *
 * @author jduque
 */
public final class KardexDetailView extends KardexDetail
{   
    /** 
     * This attribute maps to the column documentDescription in the document table.
     */
    protected String documentDescription;

    public String getDocumentDescription() {
        return documentDescription;
    }

    public void setDocumentDescription(String documentDescription) {
        this.documentDescription = documentDescription;
    }    
}
