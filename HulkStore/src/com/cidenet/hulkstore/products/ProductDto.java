package com.cidenet.hulkstore.products;

import java.io.Serializable;

public class ProductDto implements Serializable
{
	/** 
	 * This attribute maps to the column productId in the product table.
	 */
	protected int productId;

	/** 
	 * This attribute maps to the column productName in the product table.
	 */
	protected String productName;

	/** 
	 * This attribute maps to the column unityId in the product table.
	 */
	protected int unityId;

	/** 
	 * This attribute represents whether the primitive attribute unityId is null.
	 */
	protected boolean unityIdNull = true;

	/** 
	 * This attribute maps to the column state in the product table.
	 */
	protected short state;

	/**
	 * Method 'Product'
	 * 
	 */
	public ProductDto()
	{
	}
        
	public ProductDto(int productId, String productName, int unityId)
	{
            this.productId = productId;
            this.productName = productName;
            this.unityId = unityId;
            this.unityIdNull = false;
            this.state = (short) 1;
	}

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
	 * Method 'getProductName'
	 * 
	 * @return String
	 */
	public String getProductName()
	{
		return productName;
	}

	/**
	 * Method 'setProductName'
	 * 
	 * @param productName
	 */
	public void setProductName(String productName)
	{
		this.productName = productName;
	}

	/**
	 * Method 'getUnityId'
	 * 
	 * @return int
	 */
	public int getUnityId()
	{
		return unityId;
	}

	/**
	 * Method 'setUnityId'
	 * 
	 * @param unityId
	 */
	public void setUnityId(int unityId)
	{
		this.unityId = unityId;
		this.unityIdNull = false;
	}

	/**
	 * Method 'setUnityIdNull'
	 * 
	 * @param value
	 */
	public void setUnityIdNull(boolean value)
	{
		this.unityIdNull = value;
	}

	/**
	 * Method 'isUnityIdNull'
	 * 
	 * @return boolean
	 */
	public boolean isUnityIdNull()
	{
		return unityIdNull;
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
		
		if (!(_other instanceof ProductDto)) {
			return false;
		}
		
		final ProductDto _cast = (ProductDto) _other;
		if (productId != _cast.productId) {
			return false;
		}
		
		if (productName == null ? _cast.productName != productName : !productName.equals( _cast.productName )) {
			return false;
		}
		
		if (unityId != _cast.unityId) {
			return false;
		}
		
		if (unityIdNull != _cast.unityIdNull) {
			return false;
		}
		
		if (state != _cast.state) {
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
		if (productName != null) {
			_hashCode = 29 * _hashCode + productName.hashCode();
		}
		
		_hashCode = 29 * _hashCode + unityId;
		_hashCode = 29 * _hashCode + (unityIdNull ? 1 : 0);
		_hashCode = 29 * _hashCode + (int) state;
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return ProductPk
	 */
	public ProductPk createPk()
	{
		return new ProductPk(productId);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.cidenet.hulkstore.dto.Product: " );
		ret.append( "productId=" + productId );
		ret.append( ", productName=" + productName );
		ret.append( ", unityId=" + unityId );
		ret.append( ", state=" + state );
		return ret.toString();
	}

}
