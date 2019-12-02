package com.cidenet.hulkstore.kardex;

import java.io.Serializable;

/** 
 * This class represents the primary key of the kardex_detail table.
 */
public class KardexDetailPk implements Serializable
{
	protected int detailId;

	protected int productId;

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
	 * Sets the value of detailId
	 */
	public void setDetailId(int detailId)
	{
		this.detailId = detailId;
	}

	/** 
	 * Gets the value of detailId
	 */
	public int getDetailId()
	{
		return detailId;
	}

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
	 * Method 'KardexDetailPk'
	 * 
	 */
	public KardexDetailPk()
	{
	}

	/**
	 * Method 'KardexDetailPk'
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
	 * Sets the value of detailIdNull
	 */
	public void setDetailIdNull(boolean detailIdNull)
	{
		this.detailIdNull = detailIdNull;
	}

	/** 
	 * Gets the value of detailIdNull
	 */
	public boolean isDetailIdNull()
	{
		return detailIdNull;
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
		
		if (!(_other instanceof KardexDetailPk)) {
			return false;
		}
		
		final KardexDetailPk _cast = (KardexDetailPk) _other;
		if (detailId != _cast.detailId) {
			return false;
		}
		
		if (productId != _cast.productId) {
			return false;
		}
		
		if (storeId != _cast.storeId) {
			return false;
		}
		
		if (detailIdNull != _cast.detailIdNull) {
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
		_hashCode = 29 * _hashCode + detailId;
		_hashCode = 29 * _hashCode + productId;
		_hashCode = 29 * _hashCode + storeId;
		_hashCode = 29 * _hashCode + (detailIdNull ? 1 : 0);
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
		ret.append( "com.cidenet.hulkstore.dto.KardexDetailPk: " );
		ret.append( "detailId=" + detailId );
		ret.append( ", productId=" + productId );
		ret.append( ", storeId=" + storeId );
		return ret.toString();
	}

}
