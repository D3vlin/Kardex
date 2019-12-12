package com.cidenet.hulkstore.units;

import java.io.Serializable;

/**
 * Main view of Unit Management.
 * 
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-18
 */
public final class UnityDto implements Serializable
{
    /** 
     * This attribute maps to the column unityId in the unity table.
     */
    protected int unityId;

    /** 
     * This attribute maps to the column unityDescription in the unity table.
     */
    protected String unityDescription;

    /** 
     * This attribute represents whether the primitive attribute unityId is null.
     */
    protected boolean unityIdNull = true;

    /** 
     * This attribute maps to the column state in the unity table.
     */
    protected short state;

    /**
     * Empty Constructor.
     * 
     */
    public UnityDto() {}
        
    /**
     * Constructor.
     * 
     * @param unityId
     * @param unityDescription 
     */
    public UnityDto(int unityId, String unityDescription)
    {
        this.unityId = unityId;
        this.unityDescription = unityDescription;
        this.unityIdNull = false;
        this.state = (short) 1;
    }

    public UnityDto(int unityId, String unityDescription, short state) {
        this.unityId = unityId;
        this.unityDescription = unityDescription;
        this.unityIdNull = false;
        this.state = state;
    }
    
    /**
     * Gets the value of unityId.
     * 
     * @return int
     */
    public int getUnityId() { return unityId; }

    /**
     * Sets the value of unityId.
     * 
     * @param unityId
     */
    public void setUnityId(int unityId) { this.unityId = unityId; }

    /**
     * Gets the value of unityDescription.
     * 
     * @return String
     */
    public String getUnityDescription() { return unityDescription; }

    /**
     * Sets the value of unityDescription.
     * 
     * @param unityDescription
     */
    public void setUnityDescription(String unityDescription) { this.unityDescription = unityDescription; }

    /**
     * Gets the value of state.
     * 
     * @return short
     */
    public short getState() { return state; }

    /**
     * Sets the value of state.
     * 
     * @param state
     */
    public void setState(short state) { this.state = state; }

    /**
     * Method 'createPk'
     * 
     * @return UnityPk
     */
    public UnityPk createPk() { return new UnityPk(unityId); }

    /**
     * Method 'toString'
     * 
     * @return String
     */
    public String toString()
    {
        StringBuilder ret = new StringBuilder();
        ret.append("com.cidenet.hulkstore.dto.Unity: ");
        ret.append("unityId=").append(unityId);
        ret.append(", unityDescription=").append(unityDescription);
        ret.append(", state=").append(state);
        return ret.toString();
    }
}