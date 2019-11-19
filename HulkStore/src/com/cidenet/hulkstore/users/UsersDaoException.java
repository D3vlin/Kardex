package com.cidenet.hulkstore.users;

import com.cidenet.hulkstore.exceptions.DaoException;

public final class UsersDaoException extends DaoException
{
	/**
	 * Method 'UsersDaoException'
	 * 
	 * @param message
	 */
	public UsersDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'UsersDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public UsersDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
