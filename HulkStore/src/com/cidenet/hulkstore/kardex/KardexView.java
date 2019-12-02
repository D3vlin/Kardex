package com.cidenet.hulkstore.kardex;

/**
 *
 * @author jduque
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
     * Method 'getProductName'
     * 
     * @return String
     */
    public String getProductName()
    {
        return productName;
    }

    /**
     * Method 'setProductName'
     * 
     * @param productName
     */
    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    /**
     * Method 'getStoreName'
     * 
     * @return String
     */
    public String getStoreName()
    {
        return storeName;
    }

    /**
     * Method 'setStoreName'
     * 
     * @param storeName
     */
    public void setStoreName(String storeName)
    {
        this.storeName = storeName;
    }

    /**
     * Method 'getUnityDescription'
     * 
     * @return String
     */
    public String getUnityDescription()
    {
        return unityDescription;
    }

    /**
     * Method 'setUnityDescription'
     * 
     * @param unityDescription
     */
    public void setUnityDescription(String unityDescription)
    {
        this.unityDescription = unityDescription;
    }
}
