package com.cidenet.hulkstore.kardex;

import java.io.Serializable;

public class KardexDetailDto implements Serializable
{
	/** 
	 * This attribute maps to the column detailId in the kardex_detail table.
	 */
	protected int detailId;

	/** 
	 * This attribute maps to the column productId in the kardex_detail table.
	 */
	protected int productId;

	/** 
	 * This attribute maps to the column storeId in the kardex_detail table.
	 */
	protected int storeId;

	/** 
	 * This attribute maps to the column kardexDetailYear in the kardex_detail table.
	 */
	protected int kardexDetailYear;

	/** 
	 * This attribute maps to the column kardexDetailMonth in the kardex_detail table.
	 */
	protected int kardexDetailMonth;

	/** 
	 * This attribute maps to the column kardexDetailday in the kardex_detail table.
	 */
	protected int kardexDetailday;

	/** 
	 * This attribute maps to the column userId in the kardex_detail table.
	 */
	protected int userId;

	/** 
	 * This attribute represents whether the primitive attribute userId is null.
	 */
	protected boolean userIdNull = true;

	/** 
	 * This attribute maps to the column documentId in the kardex_detail table.
	 */
	protected int documentId;

	/** 
	 * This attribute maps to the column documentNumber in the kardex_detail table.
	 */
	protected int documentNumber;

	/** 
	 * This attribute maps to the column operation in the kardex_detail table.
	 */
	protected short operation;

	/** 
	 * This attribute maps to the column quantity in the kardex_detail table.
	 */
	protected double quantity;

	/** 
	 * This attribute maps to the column unityValue in the kardex_detail table.
	 */
	protected double unityValue;

	/** 
	 * This attribute maps to the column totalValue in the kardex_detail table.
	 */
	protected double totalValue;

	/** 
	 * This attribute maps to the column observations in the kardex_detail table.
	 */
	protected String observations;

	/** 
	 * This attribute maps to the column state in the kardex_detail table.
	 */
	protected short state;

	/**
	 * Method 'KardexDetail'
	 * 
	 */
	public KardexDetailDto()
	{
	}

	/**
	 * Method 'getDetailId'
	 * 
	 * @return int
	 */
	public int getDetailId()
	{
		return detailId;
	}

	/**
	 * Method 'setDetailId'
	 * 
	 * @param detailId
	 */
	public void setDetailId(int detailId)
	{
		this.detailId = detailId;
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
	 * Method 'getKardexDetailYear'
	 * 
	 * @return int
	 */
	public int getKardexDetailYear()
	{
		return kardexDetailYear;
	}

	/**
	 * Method 'setKardexDetailYear'
	 * 
	 * @param kardexDetailYear
	 */
	public void setKardexDetailYear(int kardexDetailYear)
	{
		this.kardexDetailYear = kardexDetailYear;
	}

	/**
	 * Method 'getKardexDetailMonth'
	 * 
	 * @return int
	 */
	public int getKardexDetailMonth()
	{
		return kardexDetailMonth;
	}

	/**
	 * Method 'setKardexDetailMonth'
	 * 
	 * @param kardexDetailMonth
	 */
	public void setKardexDetailMonth(int kardexDetailMonth)
	{
		this.kardexDetailMonth = kardexDetailMonth;
	}

	/**
	 * Method 'getKardexDetailday'
	 * 
	 * @return int
	 */
	public int getKardexDetailday()
	{
		return kardexDetailday;
	}

	/**
	 * Method 'setKardexDetailday'
	 * 
	 * @param kardexDetailday
	 */
	public void setKardexDetailday(int kardexDetailday)
	{
		this.kardexDetailday = kardexDetailday;
	}

	/**
	 * Method 'getUserId'
	 * 
	 * @return int
	 */
	public int getUserId()
	{
		return userId;
	}

	/**
	 * Method 'setUserId'
	 * 
	 * @param userId
	 */
	public void setUserId(int userId)
	{
		this.userId = userId;
		this.userIdNull = false;
	}

	/**
	 * Method 'setUserIdNull'
	 * 
	 * @param value
	 */
	public void setUserIdNull(boolean value)
	{
		this.userIdNull = value;
	}

	/**
	 * Method 'isUserIdNull'
	 * 
	 * @return boolean
	 */
	public boolean isUserIdNull()
	{
		return userIdNull;
	}

	/**
	 * Method 'getDocumentId'
	 * 
	 * @return int
	 */
	public int getDocumentId()
	{
		return documentId;
	}

	/**
	 * Method 'setDocumentId'
	 * 
	 * @param documentId
	 */
	public void setDocumentId(int documentId)
	{
		this.documentId = documentId;
	}

	/**
	 * Method 'getDocumentNumber'
	 * 
	 * @return int
	 */
	public int getDocumentNumber()
	{
		return documentNumber;
	}

	/**
	 * Method 'setDocumentNumber'
	 * 
	 * @param documentNumber
	 */
	public void setDocumentNumber(int documentNumber)
	{
		this.documentNumber = documentNumber;
	}

	/**
	 * Method 'getOperation'
	 * 
	 * @return short
	 */
	public short getOperation()
	{
		return operation;
	}

	/**
	 * Method 'setOperation'
	 * 
	 * @param operation
	 */
	public void setOperation(short operation)
	{
		this.operation = operation;
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
	}

	/**
	 * Method 'getObservations'
	 * 
	 * @return String
	 */
	public String getObservations()
	{
		return observations;
	}

	/**
	 * Method 'setObservations'
	 * 
	 * @param observations
	 */
	public void setObservations(String observations)
	{
		this.observations = observations;
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
		
		if (!(_other instanceof KardexDetailDto)) {
			return false;
		}
		
		final KardexDetailDto _cast = (KardexDetailDto) _other;
		if (detailId != _cast.detailId) {
			return false;
		}
		
		if (productId != _cast.productId) {
			return false;
		}
		
		if (storeId != _cast.storeId) {
			return false;
		}
		
		if (kardexDetailYear != _cast.kardexDetailYear) {
			return false;
		}
		
		if (kardexDetailMonth != _cast.kardexDetailMonth) {
			return false;
		}
		
		if (kardexDetailday != _cast.kardexDetailday) {
			return false;
		}
		
		if (userId != _cast.userId) {
			return false;
		}
		
		if (userIdNull != _cast.userIdNull) {
			return false;
		}
		
		if (documentId != _cast.documentId) {
			return false;
		}
		
		if (documentNumber != _cast.documentNumber) {
			return false;
		}
		
		if (operation != _cast.operation) {
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
		
		if (observations == null ? _cast.observations != observations : !observations.equals( _cast.observations )) {
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
		_hashCode = 29 * _hashCode + detailId;
		_hashCode = 29 * _hashCode + productId;
		_hashCode = 29 * _hashCode + storeId;
		_hashCode = 29 * _hashCode + kardexDetailYear;
		_hashCode = 29 * _hashCode + kardexDetailMonth;
		_hashCode = 29 * _hashCode + kardexDetailday;
		_hashCode = 29 * _hashCode + userId;
		_hashCode = 29 * _hashCode + (userIdNull ? 1 : 0);
		_hashCode = 29 * _hashCode + documentId;
		_hashCode = 29 * _hashCode + documentNumber;
		_hashCode = 29 * _hashCode + (int) operation;
		long temp_quantity = Double.doubleToLongBits(quantity);
		_hashCode = 29 * _hashCode + (int) (temp_quantity ^ (temp_quantity >>> 32));
		long temp_unityValue = Double.doubleToLongBits(unityValue);
		_hashCode = 29 * _hashCode + (int) (temp_unityValue ^ (temp_unityValue >>> 32));
		long temp_totalValue = Double.doubleToLongBits(totalValue);
		_hashCode = 29 * _hashCode + (int) (temp_totalValue ^ (temp_totalValue >>> 32));
		if (observations != null) {
			_hashCode = 29 * _hashCode + observations.hashCode();
		}
		
		_hashCode = 29 * _hashCode + (int) state;
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return KardexDetailPk
	 */
	public KardexDetailPk createPk()
	{
		return new KardexDetailPk(detailId, productId, storeId);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.cidenet.hulkstore.dto.KardexDetail: " );
		ret.append( "detailId=" + detailId );
		ret.append( ", productId=" + productId );
		ret.append( ", storeId=" + storeId );
		ret.append( ", kardexDetailYear=" + kardexDetailYear );
		ret.append( ", kardexDetailMonth=" + kardexDetailMonth );
		ret.append( ", kardexDetailday=" + kardexDetailday );
		ret.append( ", userId=" + userId );
		ret.append( ", documentId=" + documentId );
		ret.append( ", documentNumber=" + documentNumber );
		ret.append( ", operation=" + operation );
		ret.append( ", quantity=" + quantity );
		ret.append( ", unityValue=" + unityValue );
		ret.append( ", totalValue=" + totalValue );
		ret.append( ", observations=" + observations );
		ret.append( ", state=" + state );
		return ret.toString();
	}

}
