package com.cidenet.hulkstore.stores;

import java.io.Serializable;

/** 
 * This class represents the primary key of the store table.
 */
public final class StorePk implements Serializable
{
	protected int storeId;

	/** 
	 * This attribute represents whether the primitive attribute storeId is null.
	 */
	protected boolean storeIdNull;

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
	 * Method 'StorePk'
	 * 
	 */
	public StorePk()
	{
	}

	/**
	 * Method 'StorePk'
	 * 
	 * @param storeId
	 */
	public StorePk(final int storeId)
	{
		this.storeId = storeId;
                this.storeIdNull = false;
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
		
		if (!(_other instanceof StorePk)) {
			return false;
		}
		
		final StorePk _cast = (StorePk) _other;
		if (storeId != _cast.storeId) {
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
		_hashCode = 29 * _hashCode + storeId;
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
		ret.append( "com.cidenet.hulkstore.dto.StorePk: " );
		ret.append( "storeId=" + storeId );
		return ret.toString();
	}

}
