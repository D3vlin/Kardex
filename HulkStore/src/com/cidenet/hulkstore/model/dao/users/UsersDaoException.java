package com.cidenet.hulkstore.model.dao.users;

import com.cidenet.hulkstore.model.dao.DaoException;

/**
 * This class controls possible exceptions with user table.
 * 
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-19
 */
public final class UsersDaoException extends DaoException
{
    /**
     * Throw an error message.
     * 
     * @param message
     */
    public UsersDaoException(String message) { super(message); }

    /**
     * Throw an error message and its cause.
     * 
     * @param message
     * @param cause
     */
    public UsersDaoException(String message, Throwable cause) { super(message, cause); }
}