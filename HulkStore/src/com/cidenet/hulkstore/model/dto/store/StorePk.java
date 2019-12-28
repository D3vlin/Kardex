package com.cidenet.hulkstore.model.dto.store;

import java.io.Serializable;

/** 
 * This class represents the primary key of the store table.
 * 
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-15
 */
public final class StorePk implements Serializable
{
    protected int storeId;

    /** 
     * This attribute represents whether the primitive attribute storeId is null.
     */
    protected boolean storeIdNull;

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
     * 
     */
    public StorePk() {}

    /**
     * Constructor.
     * 
     * @param storeId
     */
    public StorePk(final int storeId)
    {
        this.storeId = storeId;
        this.storeIdNull = false;
    }

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
}