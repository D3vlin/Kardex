package com.cidenet.hulkstore.model.dto.users;

import java.io.Serializable;

/** 
 * This class represents the primary key of the users table.
 * 
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-19
 */
public final class UsersPk implements Serializable
{
    protected int userId;

    /** 
     * This attribute represents whether the primitive attribute userId is null.
     */
    protected boolean userIdNull;

    /** 
     * Sets the value of userId.
     * 
     * @param userId
     */
    public void setUserId(int userId) { this.userId = userId; }

    /** 
     * Gets the value of userId.
     * 
     * @return int
     */
    public int getUserId() { return userId; }

    /**
     * Empty Constructor.
     */
    public UsersPk() {}

    /**
     * Constructor.
     * 
     * @param userId
     */
    public UsersPk(final int userId)
    {
        this.userId = userId;
        this.userIdNull = false;
    }

    /** 
     * Sets the value of userIdNull.
     * 
     * @param userIdNull
     */
    public void setUserIdNull(boolean userIdNull) { this.userIdNull = userIdNull; }

    /** 
     * Gets the value of userIdNull.
     * 
     * @return boolean
     */
    public boolean isUserIdNull() { return userIdNull; }
}