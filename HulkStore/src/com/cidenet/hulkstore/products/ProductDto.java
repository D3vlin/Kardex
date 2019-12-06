package com.cidenet.hulkstore.products;

import java.io.Serializable;

/**
 * This class represents the product model.
 * 
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-15
 */
public final class ProductDto extends Product implements Serializable
{
    /** 
     * This attribute represents whether the primitive attribute unityId is null.
     */
    protected boolean unityIdNull = true;

    /**
     * Empty Constructor.
     */
    public ProductDto() {}
    
    /**
     * Constructor. 
     * 
     * @param productId
     * @param productName
     * @param unityId 
     */
    public ProductDto(int productId, String productName, int unityId)
    {
        this.productId = productId;
        this.productName = productName;
        this.unityId = unityId;
        this.unityIdNull = false;
        this.state = (short) 1;
    }

    /**
     * Sets the value of unityIdNull.
     * 
     * @param value
     */
    public void setUnityIdNull(boolean value) { this.unityIdNull = value; }

    /**
     * Method 'isUnityIdNull'
     * 
     * @return boolean
     */
    public boolean isUnityIdNull() { return unityIdNull; }

    /**
     * Method 'createPk'
     * 
     * @return ProductPk
     */
    public ProductPk createPk() { return new ProductPk(productId); }

    /**
     * Method 'toString'
     * 
     * @return String
     */
    public String toString()
    {
        StringBuilder response = new StringBuilder();
        response.append("com.cidenet.hulkstore.dto.Product: ");
        response.append("productId=").append(productId);
        response.append(", productName=").append(productName);
        response.append(", unityId=").append(unityId);
        response.append(", state=").append(state);
        return response.toString();
    }
}