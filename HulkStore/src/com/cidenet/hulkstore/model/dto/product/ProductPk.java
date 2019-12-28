package com.cidenet.hulkstore.model.dto.product;

import java.io.Serializable;

/** 
 * This class represents the primary key of the product table.
 * 
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-15
 */
public final class ProductPk implements Serializable
{
    /** 
     * This attribute maps to the column productId in the product table.
     */
    protected int productId;

    /** 
     * This attribute represents whether the primitive attribute productId is null.
     */
    protected boolean productIdNull;

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
     * Empty Constructor.
     */
    public ProductPk() {}

    /**
     * Constructor.
     * 
     * @param productId
     */
    public ProductPk(final int productId)
    {
        this.productId = productId;
        this.productIdNull = false;
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
     * Method 'toString'
     * 
     * @return String
     */
    public String toString()
    {
        StringBuilder response = new StringBuilder();
        response.append("com.cidenet.hulkstore.dto.ProductPk: ");
        response.append("productId=").append(productId);
        return response.toString();
    }
}