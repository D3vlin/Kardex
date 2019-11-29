package com.cidenet.hulkstore.products;

import java.io.Serializable;

/**
 *
 * @author jduque
 */
public final class ProductView extends Product implements Serializable
{  
    /** 
     * This attribute maps to the column unityDescription in the unity table.
     */
    private String unityDescription;

    /**
     * Method 'getUnityDescription'
     * 
     * @return string
     */
    public String getUnityDescription()
    {
            return unityDescription;
    }

    /**
     * Method 'setUnityDescription'
     * 
     * @param unityDescription
     */
    public void setUnityDescription(String unityDescription)
    {
            this.unityDescription = unityDescription;
    }
}
