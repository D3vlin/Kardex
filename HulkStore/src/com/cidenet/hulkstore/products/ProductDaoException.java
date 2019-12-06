package com.cidenet.hulkstore.products;

import com.cidenet.hulkstore.exceptions.DaoException;

/** 
 * This class controls possible exceptions with product table.
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-15
 */
public final class ProductDaoException extends DaoException
{
    /**
     * Throw an error message.
     * 
     * @param message
     */
    public ProductDaoException(String message) { super(message); }

    /**
     * Throw an error message and its cause.
     * 
     * @param message
     * @param cause
     */
    public ProductDaoException(String message, Throwable cause) { super(message, cause); }
}