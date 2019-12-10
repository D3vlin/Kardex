package com.cidenet.hulkstore.exceptions;

/** 
 * This class controls possible exceptions.
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-24
 */
public class DaoException extends Exception
{
    protected Throwable throwable;

    /**
     * Throw an error message.
     * 
     * @param message
     */
    public DaoException(String message) { super(message); }

    /**
     * Throw an error message and its cause.
     * 
     * @param message
     * @param cause
     */
    public DaoException(String message, Throwable cause)
    {
        super(message);
        this.throwable = cause;
    }

    /**
     * Method 'getCause'
     * 
     * @return Throwable
     */
    public Throwable getCause() { return throwable; }
}