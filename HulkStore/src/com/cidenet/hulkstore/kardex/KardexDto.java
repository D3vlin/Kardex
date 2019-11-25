package com.cidenet.hulkstore.kardex;

import java.io.Serializable;

public class KardexDto implements Serializable
{
	/** 
	 * This attribute maps to the column productId in the kardex table.
	 */
	protected int productId;

	/** 
	 * This attribute maps to the column storeId in the kardex table.
	 */
	protected int storeId;

	/** 
	 * This attribute maps to the column quantity in the kardex table.
	 */
	protected double quantity;

	/** 
	 * This attribute maps to the column unityValue in the kardex table.
	 */
	protected double unityValue;

	/** 
	 * This attribute maps to the column totalValue in the kardex table.
	 */
	protected double totalValue;

	/** 
	 * This attribute represents whether the primitive attribute totalValue is null.
	 */
	protected boolean totalValueNull = true;

	/** 
	 * This attribute maps to the column state in the kardex table.
	 */
	protected short state;

	/**
	 * Method 'Kardex'
	 * 
	 */
	public KardexDto()
	{
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
	 * Method 'getQuantity'
	 * 
	 * @return double
	 */
	public double getQuantity()
	{
		return quantity;
	}

	/**
	 * Method 'setQuantity'
	 * 
	 * @param quantity
	 */
	public void setQuantity(double quantity)
	{
		this.quantity = quantity;
	}

	/**
	 * Method 'getUnityValue'
	 * 
	 * @return double
	 */
	public double getUnityValue()
	{
		return unityValue;
	}

	/**
	 * Method 'setUnityValue'
	 * 
	 * @param unityValue
	 */
	public void setUnityValue(double unityValue)
	{
		this.unityValue = unityValue;
	}

	/**
	 * Method 'getTotalValue'
	 * 
	 * @return double
	 */
	public double getTotalValue()
	{
		return totalValue;
	}

	/**
	 * Method 'setTotalValue'
	 * 
	 * @param totalValue
	 */
	public void setTotalValue(double totalValue)
	{
		this.totalValue = totalValue;
		this.totalValueNull = false;
	}

	/**
	 * Method 'setTotalValueNull'
	 * 
	 * @param value
	 */
	public void setTotalValueNull(boolean value)
	{
		this.totalValueNull = value;
	}

	/**
	 * Method 'isTotalValueNull'
	 * 
	 * @return boolean
	 */
	public boolean isTotalValueNull()
	{
		return totalValueNull;
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
		
		if (!(_other instanceof KardexDto)) {
			return false;
		}
		
		final KardexDto _cast = (KardexDto) _other;
		if (productId != _cast.productId) {
			return false;
		}
		
		if (storeId != _cast.storeId) {
			return false;
		}
		
		if (quantity != _cast.quantity) {
			return false;
		}
		
		if (unityValue != _cast.unityValue) {
			return false;
		}
		
		if (totalValue != _cast.totalValue) {
			return false;
		}
		
		if (totalValueNull != _cast.totalValueNull) {
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
		_hashCode = 29 * _hashCode + storeId;
		long temp_quantity = Double.doubleToLongBits(quantity);
		_hashCode = 29 * _hashCode + (int) (temp_quantity ^ (temp_quantity >>> 32));
		long temp_unityValue = Double.doubleToLongBits(unityValue);
		_hashCode = 29 * _hashCode + (int) (temp_unityValue ^ (temp_unityValue >>> 32));
		long temp_totalValue = Double.doubleToLongBits(totalValue);
		_hashCode = 29 * _hashCode + (int) (temp_totalValue ^ (temp_totalValue >>> 32));
		_hashCode = 29 * _hashCode + (totalValueNull ? 1 : 0);
		_hashCode = 29 * _hashCode + (int) state;
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return KardexPk
	 */
	public KardexPk createPk()
	{
		return new KardexPk(productId, storeId);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.cidenet.hulkstore.dto.Kardex: " );
		ret.append( "productId=" + productId );
		ret.append( ", storeId=" + storeId );
		ret.append( ", quantity=" + quantity );
		ret.append( ", unityValue=" + unityValue );
		ret.append( ", totalValue=" + totalValue );
		ret.append( ", state=" + state );
		return ret.toString();
	}

}
