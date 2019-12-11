package com.cidenet.hulkstore.stores;

import java.io.Serializable;

/**
 * This class represents the product model.
 * 
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-12
 */
public final class StoreDto implements Serializable
{
    /** 
     * This attribute maps to the column storeId in the store table.
     */
    protected int storeId;

    /** 
     * This attribute maps to the column storeName in the store table.
     */
    protected String storeName;

    /** 
     * This attribute maps to the column address in the store table.
     */
    protected String address;

    /** 
     * This attribute maps to the column state in the store table.
     */
    protected short state;

    /**
     * Empty Constructor.
     * 
     */
    public StoreDto() {}
    
    /**
     * Constructor.
     * 
     * @param storeId
     * @param storeName
     * @param address 
     */
    public StoreDto(int storeId, String storeName, String address)
    {
        this.storeId = storeId;
        this.storeName = storeName;
        this.address = address;
        this.state = 1;
    }
    
    /**
     * Constructor.
     * 
     * @param storeId
     * @param storeName
     * @param address 
     * @param state 
     */
    public StoreDto(int storeId, String storeName, String address, short state) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.address = address;
        this.state = state;
    }
    
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
     * Gets the value of address.
     * 
     * @return String
     */
    public String getAddress() { return address; }

    /**
     * Sets the value of address.
     * 
     * @param address
     */
    public void setAddress(String address) { this.address = address; }

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

    /**
     * Method 'createPk'
     * 
     * @return StorePk
     */
    public StorePk createPk() { return new StorePk(storeId); }

    /**
     * Method 'toString'
     * 
     * @return String
     */
    public String toString()
    {
        StringBuilder ret = new StringBuilder();
        ret.append("com.cidenet.hulkstore.dto.Store: ");
        ret.append("storeId=").append(storeId);
        ret.append(", storeName=").append(storeName);
        ret.append(", address=").append(address);
        ret.append(", state=").append(state);
        return ret.toString();
    }
}