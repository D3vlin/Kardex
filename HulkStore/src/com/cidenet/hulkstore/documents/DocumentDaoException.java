package com.cidenet.hulkstore.documents;

import com.cidenet.hulkstore.exceptions.DaoException;

/** 
 * This class controls possible exceptions with documents.
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-24
 */
public final class DocumentDaoException extends DaoException
{
    /**
     * Throw an error message.
     * 
     * @param message
     */
    public DocumentDaoException(String message) { super(message); }

    /**
     * Throw an error message and its cause.
     * 
     * @param message
     * @param cause
     */
    public DocumentDaoException(String message, Throwable cause) { super(message, cause); }
}