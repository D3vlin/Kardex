package com.cidenet.hulkstore.users;

import java.io.Serializable;

/** 
 * This class represents the primary key of the users table.
 */
public final class UsersPk implements Serializable
{
	protected int userId;

	/** 
	 * This attribute represents whether the primitive attribute userId is null.
	 */
	protected boolean userIdNull;

	/** 
	 * Sets the value of userId
	 */
	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	/** 
	 * Gets the value of userId
	 */
	public int getUserId()
	{
		return userId;
	}

	/**
	 * Method 'UsersPk'
	 * 
	 */
	public UsersPk()
	{
	}

	/**
	 * Method 'UsersPk'
	 * 
	 * @param userId
	 */
	public UsersPk(final int userId)
	{
		this.userId = userId;
                this.userIdNull = false;
	}

	/** 
	 * Sets the value of userIdNull
	 */
	public void setUserIdNull(boolean userIdNull)
	{
		this.userIdNull = userIdNull;
	}

	/** 
	 * Gets the value of userIdNull
	 */
	public boolean isUserIdNull()
	{
		return userIdNull;
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
		
		if (!(_other instanceof UsersPk)) {
			return false;
		}
		
		final UsersPk _cast = (UsersPk) _other;
		if (userId != _cast.userId) {
			return false;
		}
		
		if (userIdNull != _cast.userIdNull) {
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
		_hashCode = 29 * _hashCode + userId;
		_hashCode = 29 * _hashCode + (userIdNull ? 1 : 0);
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
		ret.append( "com.cidenet.hulkstore.dto.UsersPk: " );
		ret.append( "userId=" + userId );
		return ret.toString();
	}

}
