package com.cidenet.hulkstore.units;

import java.io.Serializable;

/** 
 * This class represents the primary key of the unity table.
 */
public class UnityPk implements Serializable
{
	protected int unityId;

	/** 
	 * This attribute represents whether the primitive attribute unityId is null.
	 */
	protected boolean unityIdNull;

	/** 
	 * Sets the value of unityId
	 */
	public void setUnityId(int unityId)
	{
		this.unityId = unityId;
	}

	/** 
	 * Gets the value of unityId
	 */
	public int getUnityId()
	{
		return unityId;
	}

	/**
	 * Method 'UnityPk'
	 * 
	 */
	public UnityPk()
	{
	}

	/**
	 * Method 'UnityPk'
	 * 
	 * @param unityId
	 */
	public UnityPk(final int unityId)
	{
		this.unityId = unityId;
                this.unityIdNull = false;
	}

	/** 
	 * Sets the value of unityIdNull
	 */
	public void setUnityIdNull(boolean unityIdNull)
	{
		this.unityIdNull = unityIdNull;
	}

	/** 
	 * Gets the value of unityIdNull
	 */
	public boolean isUnityIdNull()
	{
		return unityIdNull;
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
		
		if (!(_other instanceof UnityPk)) {
			return false;
		}
		
		final UnityPk _cast = (UnityPk) _other;
		if (unityId != _cast.unityId) {
			return false;
		}
		
		if (unityIdNull != _cast.unityIdNull) {
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
		_hashCode = 29 * _hashCode + unityId;
		_hashCode = 29 * _hashCode + (unityIdNull ? 1 : 0);
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
		ret.append( "com.cidenet.hulkstore.dto.UnityPk: " );
		ret.append( "unityId=" + unityId );
		return ret.toString();
	}

}
