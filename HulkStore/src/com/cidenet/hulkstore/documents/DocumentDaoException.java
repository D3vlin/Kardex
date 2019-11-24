package com.cidenet.hulkstore.documents;

import com.cidenet.hulkstore.exceptions.DaoException;

public class DocumentDaoException extends DaoException
{
	/**
	 * Method 'DocumentDaoException'
	 * 
	 * @param message
	 */
	public DocumentDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'DocumentDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public DocumentDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
