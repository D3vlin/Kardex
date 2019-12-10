package com.cidenet.hulkstore.units;

import com.cidenet.hulkstore.exceptions.DaoException;

/** 
 * This class controls possible exceptions with unity table.
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-18
 */
public final class UnityDaoException extends DaoException
{
    /**
     * Throw an error message.
     * 
     * @param message
     */
    public UnityDaoException(String message) { super(message); }

    /**
     * Throw an error message and its cause.
     * 
     * @param message
     * @param cause
     */
    public UnityDaoException(String message, Throwable cause) { super(message, cause); }
}