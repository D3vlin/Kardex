package com.cidenet.hulkstore.kardex;

import java.io.Serializable;

/** 
 * This class represents the primary key of the kardex table.
 */
public class KardexPk implements Serializable
{
	protected int productId;

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
	 * Sets the value of storeId
	 */
	public void setStoreId(int storeId)
	{
		this.storeId = storeId;
	}

	/** 
	 * Gets the value of storeId
	 */
	public int getStoreId()
	{
		return storeId;
	}

	/**
	 * Method 'KardexPk'
	 * 
	 */
	public KardexPk()
	{
	}

	/**
	 * Method 'KardexPk'
	 * 
	 * @param productId
	 * @param storeId
	 */
	public KardexPk(final int productId, final int storeId)
	{
		this.productId = productId;
		this.storeId = storeId;
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
	 * Sets the value of storeIdNull
	 */
	public void setStoreIdNull(boolean storeIdNull)
	{
		this.storeIdNull = storeIdNull;
	}

	/** 
	 * Gets the value of storeIdNull
	 */
	public boolean isStoreIdNull()
	{
		return storeIdNull;
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
		
		if (!(_other instanceof KardexPk)) {
			return false;
		}
		
		final KardexPk _cast = (KardexPk) _other;
		if (productId != _cast.productId) {
			return false;
		}
		
		if (storeId != _cast.storeId) {
			return false;
		}
		
		if (productIdNull != _cast.productIdNull) {
			return false;
		}
		
		if (storeIdNull != _cast.storeIdNull) {
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
		_hashCode = 29 * _hashCode + storeId;
		_hashCode = 29 * _hashCode + (productIdNull ? 1 : 0);
		_hashCode = 29 * _hashCode + (storeIdNull ? 1 : 0);
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
		ret.append( "com.cidenet.hulkstore.dto.KardexPk: " );
		ret.append( "productId=" + productId );
		ret.append( ", storeId=" + storeId );
		return ret.toString();
	}

}
