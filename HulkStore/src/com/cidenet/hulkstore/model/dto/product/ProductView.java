package com.cidenet.hulkstore.model.dto.product;

import java.io.Serializable;

/**
 * This class represents the product view model.
 * 
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-15
 */
public final class ProductView extends Product implements Serializable
{  
    /** 
     * This attribute maps to the column unityDescription in the unity table.
     */
    private String unityDescription;

    /**
     * Gets the value of unityDescription.
     * 
     * @return string
     */
    public String getUnityDescription() { return unityDescription; }

    /**
     * Gets the value of unityDescription.
     * 
     * @param unityDescription
     */
    public void setUnityDescription(String unityDescription) { this.unityDescription = unityDescription; }
}