package com.cidenet.hulkstore.kardex;

import java.io.Serializable;

/** 
 * This class represents the primary key of the kardex table.
 * 
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-24
 */
public final class KardexPk implements Serializable
{
    /** 
     * This attribute maps to the column productId in the kardex detail table.
     */
    protected int productId;
    
    /** 
     * This attribute maps to the column storeId in the kardex detail table.
     */
    protected int storeId;

    /** 
     * This attribute represents whether the primitive attribute productId is null.
     */
    protected boolean productIdNull;

    /** 
     * This attribute represents whether the primitive attribute storeId is null.
     */
    protected boolean storeIdNull;

    /** 
     * Sets the value of productId.
     * 
     * @param productId
     */
    public void setProductId(int productId) { this.productId = productId; }

    /** 
     * Gets the value of productId.
     * 
     * @return int
     */
    public int getProductId() { return productId; }

    /** 
     * Sets the value of storeId.
     * 
     * @param storeId
     */
    public void setStoreId(int storeId) { this.storeId = storeId; }

    /** 
     * Gets the value of storeId.
     * 
     * @return int
     */
    public int getStoreId() { return storeId; }

    /**
     * Empty Constructor. 
     */
    public KardexPk() {}

    /**
     * Constructor.
     * 
     * @param productId
     * @param storeId
     */
    public KardexPk(final int productId, final int storeId)
    {
        this.productId = productId;
        this.storeId = storeId;
        this.productIdNull = false;
        this.storeIdNull = false;
    }

    /** 
     * Sets the value of productIdNull.
     * 
     * @param productIdNull
     */
    public void setProductIdNull(boolean productIdNull) { this.productIdNull = productIdNull; }

    /** 
     * Gets the value of productIdNull.
     * 
     * @return boolean
     */
    public boolean isProductIdNull() { return productIdNull; }

    /** 
     * Sets the value of storeIdNull.
     * 
     * @param storeIdNull
     */
    public void setStoreIdNull(boolean storeIdNull) { this.storeIdNull = storeIdNull; }

    /** 
     * Gets the value of storeIdNull
     * 
     * @return boolean
     */
    public boolean isStoreIdNull() { return storeIdNull; }
}