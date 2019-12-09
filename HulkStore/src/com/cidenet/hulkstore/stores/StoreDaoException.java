package com.cidenet.hulkstore.stores;

import com.cidenet.hulkstore.exceptions.DaoException;

/** 
 * This class controls possible exceptions with store table.
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-12
 */
public final class StoreDaoException extends DaoException
{
    /**
     * Throw an error message.
     * 
     * @param message
     */
    public StoreDaoException(String message) { super(message); }

    /**
     * Throw an error message and its cause.
     * 
     * @param message
     * @param cause
     */
    public StoreDaoException(String message, Throwable cause) { super(message, cause); }
}