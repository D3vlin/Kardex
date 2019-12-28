package com.cidenet.hulkstore.model.dao.kardex;

import com.cidenet.hulkstore.exceptions.DaoException;

/** 
 * This class controls possible exceptions with kardex.
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-24
 */
public final class KardexDaoException extends DaoException
{
    /**
     * Throw an error message.
     * 
     * @param message
     */
    public KardexDaoException(String message) { super(message); }

    /**
     * Throw an error message and its cause.
     * 
     * @param message
     * @param cause
     */
    public KardexDaoException(String message, Throwable cause) { super(message, cause); }
}