package com.cidenet.hulkstore.units;

import com.cidenet.hulkstore.exceptions.DaoException;

public final class UnityDaoException extends DaoException
{
	/**
	 * Method 'UnityDaoException'
	 * 
	 * @param message
	 */
	public UnityDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'UnityDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public UnityDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
