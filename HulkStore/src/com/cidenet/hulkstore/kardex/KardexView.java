package com.cidenet.hulkstore.kardex;

/** 
 * This class represents the kardex model.
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-24
 */
public final class KardexView extends Kardex
{    
    /** 
     * This attribute maps to the column productName in the product table.
     */
    protected String productName;

    /** 
     * This attribute maps to the column storeName in the store table.
     */
    protected String storeName;

    /** 
     * This attribute maps to the column unityDescription in the unity table.
     */
    protected String unityDescription;

    /**
     * Gets the value of productName.
     * 
     * @return String
     */
    public String getProductName() { return productName; }

    /**
     * Sets the value of productName.
     * 
     * @param productName
     */
    public void setProductName(String productName) { this.productName = productName; }

    /**
     * Gets the value of storeName.
     * 
     * @return String
     */
    public String getStoreName() { return storeName; }

    /**
     * Sets the value of storeName.
     * 
     * @param storeName
     */
    public void setStoreName(String storeName) { this.storeName = storeName; }

    /**
     * Gets the value of unityDescription.
     * 
     * @return String
     */
    public String getUnityDescription() { return unityDescription; }

    /**
     * Sets the value of unityDescription.
     * 
     * @param unityDescription
     */
    public void setUnityDescription(String unityDescription) { this.unityDescription = unityDescription; }
}