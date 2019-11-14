package com.cidenet.hulkstore.products;

import com.cidenet.hulkstore.exceptions.DaoException;

public class ProductDaoException extends DaoException
{
	/**
	 * Method 'ProductDaoException'
	 * 
	 * @param message
	 */
	public ProductDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'ProductDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public ProductDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
