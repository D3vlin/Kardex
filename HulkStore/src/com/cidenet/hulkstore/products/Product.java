package com.cidenet.hulkstore.products;

public abstract class Product
{
    /** 
     * This attribute maps to the column productId in the product table.
     */
    protected int productId;

    /** 
     * This attribute maps to the column productName in the product table.
     */
    protected String productName;

    /** 
     * This attribute maps to the column unityId in the product table.
     */
    protected int unityId;

    /** 
     * This attribute maps to the column state in the product table.
     */
    protected short state;

    /**
     * Method 'getProductId'
     * 
     * @return int
     */
    public int getProductId()
    {
            return productId;
    }

    /**
     * Method 'setProductId'
     * 
     * @param productId
     */
    public void setProductId(int productId)
    {
            this.productId = productId;
    }

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
     * Method 'getUnityId'
     * 
     * @return int
     */
    public int getUnityId()
    {
            return unityId;
    }

    /**
     * Method 'setUnityId'
     * 
     * @param unityId
     */
    public void setUnityId(int unityId)
    {
            this.unityId = unityId;
    }

    /**
     * Method 'getState'
     * 
     * @return short
     */
    public short getState()
    {
            return state;
    }

    /**
     * Method 'setState'
     * 
     * @param state
     */
    public void setState(short state)
    {
            this.state = state;
    }
}
