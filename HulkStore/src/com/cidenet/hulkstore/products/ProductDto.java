package com.cidenet.hulkstore.products;

import java.io.Serializable;

public final class ProductDto extends Product implements Serializable
{
	/** 
	 * This attribute represents whether the primitive attribute unityId is null.
	 */
	protected boolean unityIdNull = true;

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
	 * Method 'createPk'
	 * 
	 * @return ProductPk
	 */
	public ProductPk createPk()
	{
		return new ProductPk(productId);
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
