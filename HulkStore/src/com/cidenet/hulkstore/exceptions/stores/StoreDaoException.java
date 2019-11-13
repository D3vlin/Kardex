package com.cidenet.hulkstore.exceptions.stores;

import com.cidenet.hulkstore.exceptions.DaoException;

public class StoreDaoException extends DaoException
{
	/**
	 * Method 'StoreDaoException'
	 * 
	 * @param message
	 */
	public StoreDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'StoreDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public StoreDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
