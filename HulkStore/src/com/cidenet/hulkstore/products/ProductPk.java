package com.cidenet.hulkstore.products;

import java.io.Serializable;

/** 
 * This class represents the primary key of the product table.
 */
public class ProductPk implements Serializable
{
	protected int productId;

	/** 
	 * This attribute represents whether the primitive attribute productId is null.
	 */
	protected boolean productIdNull;

	/** 
	 * Sets the value of productId
	 */
	public void setProductId(int productId)
	{
		this.productId = productId;
	}

	/** 
	 * Gets the value of productId
	 */
	public int getProductId()
	{
		return productId;
	}

	/**
	 * Method 'ProductPk'
	 * 
	 */
	public ProductPk()
	{
	}

	/**
	 * Method 'ProductPk'
	 * 
	 * @param productId
	 */
	public ProductPk(final int productId)
	{
		this.productId = productId;
	}

	/** 
	 * Sets the value of productIdNull
	 */
	public void setProductIdNull(boolean productIdNull)
	{
		this.productIdNull = productIdNull;
	}

	/** 
	 * Gets the value of productIdNull
	 */
	public boolean isProductIdNull()
	{
		return productIdNull;
	}

	/**
	 * Method 'equals'
	 * 
	 * @param _other
	 * @return boolean
	 */
	public boolean equals(Object _other)
	{
		if (_other == null) {
			return false;
		}
		
		if (_other == this) {
			return true;
		}
		
		if (!(_other instanceof ProductPk)) {
			return false;
		}
		
		final ProductPk _cast = (ProductPk) _other;
		if (productId != _cast.productId) {
			return false;
		}
		
		if (productIdNull != _cast.productIdNull) {
			return false;
		}
		
		return true;
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 */
	public int hashCode()
	{
		int _hashCode = 0;
		_hashCode = 29 * _hashCode + productId;
		_hashCode = 29 * _hashCode + (productIdNull ? 1 : 0);
		return _hashCode;
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.cidenet.hulkstore.dto.ProductPk: " );
		ret.append( "productId=" + productId );
		return ret.toString();
	}

}
