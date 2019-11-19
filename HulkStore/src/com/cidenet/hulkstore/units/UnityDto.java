package com.cidenet.hulkstore.units;

import java.io.Serializable;

public final class UnityDto implements Serializable
{
	/** 
	 * This attribute maps to the column unityId in the unity table.
	 */
	protected int unityId;

	/** 
	 * This attribute maps to the column unityDescription in the unity table.
	 */
	protected String unityDescription;

	/** 
	 * This attribute represents whether the primitive attribute unityId is null.
	 */
	protected boolean unityIdNull = true;

	/** 
	 * This attribute maps to the column state in the unity table.
	 */
	protected short state;

	/**
	 * Method 'Unity'
	 * 
	 */
	public UnityDto()
	{
	}
        
	public UnityDto(int unityId, String unityDescription)
	{
            this.unityId = unityId;
            this.unityDescription = unityDescription;
            this.unityIdNull = false;
            this.state = (short) 1;
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
	}

	/**
	 * Method 'getUnityDescription'
	 * 
	 * @return String
	 */
	public String getUnityDescription()
	{
		return unityDescription;
	}

	/**
	 * Method 'setUnityDescription'
	 * 
	 * @param unityDescription
	 */
	public void setUnityDescription(String unityDescription)
	{
		this.unityDescription = unityDescription;
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
		
		if (!(_other instanceof UnityDto)) {
			return false;
		}
		
		final UnityDto _cast = (UnityDto) _other;
		if (unityId != _cast.unityId) {
			return false;
		}
		
		if (unityDescription == null ? _cast.unityDescription != unityDescription : !unityDescription.equals( _cast.unityDescription )) {
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
		_hashCode = 29 * _hashCode + unityId;
		if (unityDescription != null) {
			_hashCode = 29 * _hashCode + unityDescription.hashCode();
		}
		
		_hashCode = 29 * _hashCode + (int) state;
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return UnityPk
	 */
	public UnityPk createPk()
	{
		return new UnityPk(unityId);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.cidenet.hulkstore.dto.Unity: " );
		ret.append( "unityId=" + unityId );
		ret.append( ", unityDescription=" + unityDescription );
		ret.append( ", state=" + state );
		return ret.toString();
	}

}
