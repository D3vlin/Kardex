package com.cidenet.hulkstore.model.dao.kardex;

import com.cidenet.hulkstore.model.dao.DaoException;

/** 
 * This class controls possible exceptions with kardex detail.
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-24
 */
public final class KardexDetailDaoException extends DaoException
{
    /**
     * Throw an error message.
     * 
     * @param message
     */
    public KardexDetailDaoException(String message) { super(message); }

    /**
     * Throw an error message and its cause.
     * 
     * @param message
     * @param cause
     */
    public KardexDetailDaoException(String message, Throwable cause) { super(message, cause); }
}