package com.cidenet.hulkstore.kardex;

import java.io.Serializable;

/**
 * This class represents the kardex model.
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-24
 */
public final class KardexDto extends Kardex implements Serializable
{
    /** 
     * This attribute represents whether the primitive attribute totalValue is null.
     */
    protected boolean totalValueNull = true;

    /**
     * Empty Constructor    
     */
    public KardexDto() {}

    /**
     * Constructor.
     * 
     * @param productId
     * @param storeId
     * @param quantity
     * @param unityValue
     * @param totalValue
     * @param state
     */
    public KardexDto(int productId, int storeId, double quantity, double unityValue, double totalValue, short state)
    {
        this.productId = productId;
        this.storeId = storeId;
        this.quantity = quantity;
        this.unityValue = unityValue;
        this.totalValue = totalValue;
        this.state = state;
    }    

    /**
     * Sets the value of totalValue and totalValueNull.
     * 
     * @param totalValue
     */
    public void setTotalValue(double totalValue)
    {
        this.totalValue = totalValue;
        this.totalValueNull = false;
    }

    /**
     * Sets the value of totalValueNull
     * 
     * @param value
     */
    public void setTotalValueNull(boolean value) { this.totalValueNull = value; }

    /**
     * Method 'isTotalValueNull'
     * 
     * @return boolean
     */
    public boolean isTotalValueNull() { return totalValueNull; }

    /**
     * Method 'createPk'
     * 
     * @return KardexPk
     */
    public KardexPk createPk() { return new KardexPk(productId, storeId); }

	
    /**
     * Method 'toString'
     * 
     * @return String
     */
    public String toString()
    {
        StringBuilder response = new StringBuilder();
        response.append("com.cidenet.hulkstore.dto.Kardex: ");
        response.append("productId=").append(productId);
        response.append(", storeId=").append(storeId);
        response.append(", quantity=").append(quantity);
        response.append(", unityValue=").append(unityValue);
        response.append(", totalValue=").append(totalValue);
        response.append(", state=").append(state);
        return response.toString();
    }
}