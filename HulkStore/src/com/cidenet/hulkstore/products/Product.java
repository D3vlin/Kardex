package com.cidenet.hulkstore.products;

/**
 * This abstract class represents the product model.
 * 
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-15
 */
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
     * Gets the value of productId.
     * 
     * @return int
     */
    public int getProductId() { return productId; }

    /**
     * Sets the value of productId.
     * 
     * @param productId
     */
    public void setProductId(int productId) { this.productId = productId; }

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
     * Gets the value of unityId.
     * 
     * @return int
     */
    public int getUnityId() { return unityId; }

    /**
     * Sets the value of unityId.
     * 
     * @param unityId
     */
    public void setUnityId(int unityId) { this.unityId = unityId; }

    /**
     * Gets the value of state.
     * 
     * @return short
     */
    public short getState() { return state; }

    /**
     * Sets the value of state.
     * 
     * @param state
     */
    public void setState(short state) { this.state = state; }
}