package com.cidenet.hulkstore.kardex;

import com.cidenet.hulkstore.exceptions.DaoException;

public class KardexDaoException extends DaoException
{
	/**
	 * Method 'KardexDaoException'
	 * 
	 * @param message
	 */
	public KardexDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'KardexDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public KardexDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
