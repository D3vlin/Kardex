package com.cidenet.hulkstore.kardex;

import com.cidenet.hulkstore.exceptions.DaoException;

public class KardexDetailDaoException extends DaoException
{
	/**
	 * Method 'KardexDetailDaoException'
	 * 
	 * @param message
	 */
	public KardexDetailDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'KardexDetailDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public KardexDetailDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
