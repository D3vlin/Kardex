package com.cidenet.hulkstore.dto;

import java.io.Serializable;

public class Users implements Serializable
{
	/** 
	 * This attribute maps to the column userId in the users table.
	 */
	protected int userId;

	/** 
	 * This attribute maps to the column userName in the users table.
	 */
	protected String userName;

	/** 
	 * This attribute maps to the column userPass in the users table.
	 */
	protected String userPass;

	/** 
	 * This attribute maps to the column identification in the users table.
	 */
	protected String identification;

	/** 
	 * This attribute maps to the column realName in the users table.
	 */
	protected String realName;

	/** 
	 * This attribute maps to the column surname in the users table.
	 */
	protected String surname;

	/** 
	 * This attribute maps to the column userProfile in the users table.
	 */
	protected short userProfile;

	/** 
	 * This attribute maps to the column state in the users table.
	 */
	protected short state;

	/**
	 * Method 'Users'
	 * 
	 */
	public Users()
	{
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
	}

	/**
	 * Method 'getUserName'
	 * 
	 * @return String
	 */
	public String getUserName()
	{
		return userName;
	}

	/**
	 * Method 'setUserName'
	 * 
	 * @param userName
	 */
	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	/**
	 * Method 'getUserPass'
	 * 
	 * @return String
	 */
	public String getUserPass()
	{
		return userPass;
	}

	/**
	 * Method 'setUserPass'
	 * 
	 * @param userPass
	 */
	public void setUserPass(String userPass)
	{
		this.userPass = userPass;
	}

	/**
	 * Method 'getIdentification'
	 * 
	 * @return String
	 */
	public String getIdentification()
	{
		return identification;
	}

	/**
	 * Method 'setIdentification'
	 * 
	 * @param identification
	 */
	public void setIdentification(String identification)
	{
		this.identification = identification;
	}

	/**
	 * Method 'getRealName'
	 * 
	 * @return String
	 */
	public String getRealName()
	{
		return realName;
	}

	/**
	 * Method 'setRealName'
	 * 
	 * @param realName
	 */
	public void setRealName(String realName)
	{
		this.realName = realName;
	}

	/**
	 * Method 'getSurname'
	 * 
	 * @return String
	 */
	public String getSurname()
	{
		return surname;
	}

	/**
	 * Method 'setSurname'
	 * 
	 * @param surname
	 */
	public void setSurname(String surname)
	{
		this.surname = surname;
	}

	/**
	 * Method 'getUserProfile'
	 * 
	 * @return short
	 */
	public short getUserProfile()
	{
		return userProfile;
	}

	/**
	 * Method 'setUserProfile'
	 * 
	 * @param userProfile
	 */
	public void setUserProfile(short userProfile)
	{
		this.userProfile = userProfile;
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
		
		if (!(_other instanceof Users)) {
			return false;
		}
		
		final Users _cast = (Users) _other;
		if (userId != _cast.userId) {
			return false;
		}
		
		if (userName == null ? _cast.userName != userName : !userName.equals( _cast.userName )) {
			return false;
		}
		
		if (userPass == null ? _cast.userPass != userPass : !userPass.equals( _cast.userPass )) {
			return false;
		}
		
		if (identification == null ? _cast.identification != identification : !identification.equals( _cast.identification )) {
			return false;
		}
		
		if (realName == null ? _cast.realName != realName : !realName.equals( _cast.realName )) {
			return false;
		}
		
		if (surname == null ? _cast.surname != surname : !surname.equals( _cast.surname )) {
			return false;
		}
		
		if (userProfile != _cast.userProfile) {
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
		_hashCode = 29 * _hashCode + userId;
		if (userName != null) {
			_hashCode = 29 * _hashCode + userName.hashCode();
		}
		
		if (userPass != null) {
			_hashCode = 29 * _hashCode + userPass.hashCode();
		}
		
		if (identification != null) {
			_hashCode = 29 * _hashCode + identification.hashCode();
		}
		
		if (realName != null) {
			_hashCode = 29 * _hashCode + realName.hashCode();
		}
		
		if (surname != null) {
			_hashCode = 29 * _hashCode + surname.hashCode();
		}
		
		_hashCode = 29 * _hashCode + (int) userProfile;
		_hashCode = 29 * _hashCode + (int) state;
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return UsersPk
	 */
	public UsersPk createPk()
	{
		return new UsersPk(userId);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.cidenet.hulkstore.dto.Users: " );
		ret.append( "userId=" + userId );
		ret.append( ", userName=" + userName );
		ret.append( ", userPass=" + userPass );
		ret.append( ", identification=" + identification );
		ret.append( ", realName=" + realName );
		ret.append( ", surname=" + surname );
		ret.append( ", userProfile=" + userProfile );
		ret.append( ", state=" + state );
		return ret.toString();
	}

}
