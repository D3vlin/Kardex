package com.cidenet.hulkstore.model.dto.kardex;

/**
 * This abstract class represents the kardex model.
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-24
 */
public abstract class Kardex
{
    /** 
     * This attribute maps to the column productId.
     */
    protected int productId;

    /** 
     * This attribute maps to the column storeId.
     */
    protected int storeId;

    /** 
     * This attribute maps to the column quantity.
     */
    protected double quantity;

    /** 
     * This attribute maps to the column unityValue.
     */
    protected double unityValue;

    /** 
     * This attribute maps to the column totalValue.
     */
    protected double totalValue;
    
    /** 
     * This attribute maps to the column state.
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
     * Gets the value of storeId.
     * 
     * @return int
     */
    public int getStoreId() { return storeId; }

    /**
     * Sets the value of storeId.
     * 
     * @param storeId
     */
    public void setStoreId(int storeId) { this.storeId = storeId; }

    /**
     * Gets the value of quantity.
     * 
     * @return double
     */
    public double getQuantity() { return quantity; }

    /**
     * Sets the value of quantity.
     * 
     * @param quantity
     */
    public void setQuantity(double quantity) { this.quantity = quantity; }

    /**
     * Gets the value of unityValue.
     * 
     * @return double
     */
    public double getUnityValue() { return unityValue; }

    /**
     * Sets the value of unityValue.
     * 
     * @param unityValue
     */
    public void setUnityValue(double unityValue) { this.unityValue = unityValue; }

    /**
     * Gets the value of totalValue.
     * 
     * @return double
     */
    public double getTotalValue() { return totalValue; }

    /**
     * Sets the value of totalValue.
     * 
     * @param totalValue
     */
    public void setTotalValue(double totalValue) { this.totalValue = totalValue; }

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