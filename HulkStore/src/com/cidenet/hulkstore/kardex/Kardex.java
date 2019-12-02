package com.cidenet.hulkstore.kardex;

/**
 *
 * @author jduque
 */
public abstract class Kardex
{
    /** 
     * This attribute maps to the column productId
     */
    protected int productId;

    /** 
     * This attribute maps to the column storeId
     */
    protected int storeId;

    /** 
     * This attribute maps to the column quantity
     */
    protected double quantity;

    /** 
     * This attribute maps to the column unityValue
     */
    protected double unityValue;

    /** 
     * This attribute maps to the column totalValue
     */
    protected double totalValue;
    
    /** 
     * This attribute maps to the column state
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
     * Method 'getStoreId'
     * 
     * @return int
     */
    public int getStoreId()
    {
        return storeId;
    }

    /**
     * Method 'setStoreId'
     * 
     * @param storeId
     */
    public void setStoreId(int storeId)
    {
        this.storeId = storeId;
    }

    /**
     * Method 'getQuantity'
     * 
     * @return double
     */
    public double getQuantity()
    {
        return quantity;
    }

    /**
     * Method 'setQuantity'
     * 
     * @param quantity
     */
    public void setQuantity(double quantity)
    {
        this.quantity = quantity;
    }

    /**
     * Method 'getUnityValue'
     * 
     * @return double
     */
    public double getUnityValue()
    {
        return unityValue;
    }

    /**
     * Method 'setUnityValue'
     * 
     * @param unityValue
     */
    public void setUnityValue(double unityValue)
    {
        this.unityValue = unityValue;
    }

    /**
     * Method 'getTotalValue'
     * 
     * @return double
     */
    public double getTotalValue()
    {
        return totalValue;
    }

    /**
     * Method 'setTotalValue'
     * 
     * @param totalValue
     */
    public void setTotalValue(double totalValue)
    {
        this.totalValue = totalValue;
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
