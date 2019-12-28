package com.cidenet.hulkstore.model.dto.unity;

import java.io.Serializable;

/** 
 * This class represents the primary key of the unity table.
 * 
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-18
 */
public final class UnityPk implements Serializable
{
    /** 
     * This attribute maps to the column unityId in the unity table.
     */
    protected int unityId;

    /** 
     * This attribute represents whether the primitive attribute unityId is null.
     */
    protected boolean unityIdNull;

    /** 
     * Sets the value of unityId.
     * 
     * @param unityId
     */
    public void setUnityId(int unityId) { this.unityId = unityId; }

    /** 
     * Gets the value of unityId.
     * 
     * @return int
     */
    public int getUnityId() { return unityId; }

    /**
     * Empty Constructor.     * 
     */
    public UnityPk() {}

    /**
     * Constructor.
     * 
     * @param unityId
     */
    public UnityPk(final int unityId)
    {
        this.unityId = unityId;
        this.unityIdNull = false;
    }

    /** 
     * Sets the value of unityIdNull.
     * 
     * @param unityIdNull
     */
    public void setUnityIdNull(boolean unityIdNull) { this.unityIdNull = unityIdNull; }

    /** 
     * Gets the value of unityIdNull.
     * 
     * @return boolean
     */
    public boolean isUnityIdNull() { return unityIdNull; }

    /**
     * Method 'toString'
     * 
     * @return String
     */
    public String toString()
    {
        StringBuilder ret = new StringBuilder();
        ret.append("com.cidenet.hulkstore.dto.UnityPk: ");
        ret.append("unityId=").append(unityId);
        return ret.toString();
    }
}