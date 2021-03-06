package com.cidenet.hulkstore.model.dto.kardex;

import java.io.Serializable;

/** 
 * This class represents the primary key of the kardex_detail table.
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-24
 */
public final class KardexDetailPk implements Serializable
{
    /** 
     * This attribute maps to the column detailId in the kardex detail table.
     */
    protected int detailId;
    
    /** 
     * This attribute maps to the column productId in the kardex detail table.
     */
    protected int productId;
    
    /** 
     * This attribute maps to the column storeId in the kardex detail table.
     */
    protected int storeId;

    /** 
     * This attribute represents whether the primitive attribute detailId is null.
     */
    protected boolean detailIdNull;

    /** 
     * This attribute represents whether the primitive attribute productId is null.
     */
    protected boolean productIdNull;

    /** 
     * This attribute represents whether the primitive attribute storeId is null.
     */
    protected boolean storeIdNull;

    /** 
     * Sets the value of detailId.
     * 
     * @param detailId
     */
    public void setDetailId(int detailId) { this.detailId = detailId; }

    /** 
     * Gets the value of detailId.
     * 
     * @return int
     */
    public int getDetailId() { return detailId; }

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
     * Sets the value of storeId
     * 
     * @param storeId
     */
    public void setStoreId(int storeId) { this.storeId = storeId; }

    /** 
     * Gets the vaue of storeId.
     * 
     * @return int
     */
    public int getStoreId() { return storeId; }

    /**
     * Empty Constructor
     */
    public KardexDetailPk() {}

    /**
     * Costructor.
     * 
     * @param detailId
     * @param productId
     * @param storeId
     */
    public KardexDetailPk(final int detailId, final int productId, final int storeId)
    {
        this.detailId = detailId;
        this.productId = productId;
        this.storeId = storeId;
        this.detailIdNull = false;
    }

    /** 
     * Sets the value of detailIdNull.
     * 
     * @param detailIdNull
     */
    public void setDetailIdNull(boolean detailIdNull) { this.detailIdNull = detailIdNull; }

    /** 
     * Gets the value of detailIdNull.
     * 
     * @return boolean
     */
    public boolean isDetailIdNull() { return detailIdNull; }

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
     * Gets the value of storeIdNull.
     * 
     * @return boolean
     */
    public boolean isStoreIdNull() { return storeIdNull; }
    
    /**
     * Method 'equals'
     * 
     * @param other
     * @return boolean
     */
    @Override
    public boolean equals(Object other)
    {
        if (other == null) { return false; }
        if (other == this) { return true; }
        if (!(other instanceof KardexDetailPk)) { return false; }

        final KardexDetailPk cast = (KardexDetailPk) other;

        if (detailId != cast.detailId) { return false; }
        if (productId != cast.productId) { return false; }
        if (storeId != cast.storeId) { return false; }
        if (detailIdNull != cast.detailIdNull) { return false; }
        if (productIdNull != cast.productIdNull) { return false; }
        if (storeIdNull != cast.storeIdNull) { return false; }

        return true;
    }
    
    /**
     * Method 'hashCode'
     * 
     * @return int
     */
    @Override
    public int hashCode()
    {
        int _hashCode = 13;
        _hashCode *= (_hashCode + detailId);
        _hashCode *= (_hashCode + productId);
        _hashCode *= (_hashCode + storeId);
        _hashCode *= (_hashCode + (detailIdNull ? 1 : 0));
        _hashCode *= (_hashCode + (productIdNull ? 1 : 0));
        _hashCode *= (_hashCode + (storeIdNull ? 1 : 0));

        return _hashCode;
    }
}