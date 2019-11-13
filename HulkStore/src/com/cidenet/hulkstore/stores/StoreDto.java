package com.cidenet.hulkstore.stores;

import java.io.Serializable;

public class StoreDto implements Serializable
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
	 * Method 'Store'
	 * 
	 */
	public StoreDto()
	{
	}
        
	public StoreDto(int storeId, String storeName, String address)
	{
            this.storeId = storeId;
            this.storeName = storeName;
            this.address = address;
            this.state = 1;
	}

	/**
	 * Method 'getStoreId'
	 * 
	 * @return int
	 */
	public int getStoreId()
	{
		return storeId;
	}

	/**
	 * Method 'setStoreId'
	 * 
	 * @param storeId
	 */
	public void setStoreId(int storeId)
	{
		this.storeId = storeId;
	}

	/**
	 * Method 'getStoreName'
	 * 
	 * @return String
	 */
	public String getStoreName()
	{
		return storeName;
	}

	/**
	 * Method 'setStoreName'
	 * 
	 * @param storeName
	 */
	public void setStoreName(String storeName)
	{
		this.storeName = storeName;
	}

	/**
	 * Method 'getAddress'
	 * 
	 * @return String
	 */
	public String getAddress()
	{
		return address;
	}

	/**
	 * Method 'setAddress'
	 * 
	 * @param address
	 */
	public void setAddress(String address)
	{
		this.address = address;
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
		
		if (!(_other instanceof StoreDto)) {
			return false;
		}
		
		final StoreDto _cast = (StoreDto) _other;
		if (storeId != _cast.storeId) {
			return false;
		}
		
		if (storeName == null ? _cast.storeName != storeName : !storeName.equals( _cast.storeName )) {
			return false;
		}
		
		if (address == null ? _cast.address != address : !address.equals( _cast.address )) {
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
		_hashCode = 29 * _hashCode + storeId;
		if (storeName != null) {
			_hashCode = 29 * _hashCode + storeName.hashCode();
		}
		
		if (address != null) {
			_hashCode = 29 * _hashCode + address.hashCode();
		}
		
		_hashCode = 29 * _hashCode + (int) state;
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return StorePk
	 */
	public StorePk createPk()
	{
		return new StorePk(storeId);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.cidenet.hulkstore.dto.Store: " );
		ret.append( "storeId=" + storeId );
		ret.append( ", storeName=" + storeName );
		ret.append( ", address=" + address );
		ret.append( ", state=" + state );
		return ret.toString();
	}

}
