package com.cidenet.hulkstore.model.dto.kardex;

import java.io.Serializable;

/** 
 * This class represents the kardex detail model.
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-24
 */
public final class KardexDetailDto extends KardexDetail implements Serializable
{
    /** 
     * This attribute represents whether the primitive attribute userId is null.
     */
    protected boolean userIdNull = true;

    /**
     * Empty Constructor. 
     */
    public KardexDetailDto() {}

    /**
     * Constructor for a new kardex detail.
     * 
     * @param detailId
     * @param productId
     * @param storeId
     * @param kardexDetailYear
     * @param kardexDetailMonth
     * @param kardexDetailday
     * @param userId
     * @param documentId
     * @param documentNumber
     * @param operation
     * @param quantity
     * @param unityValue
     * @param totalValue
     * @param observations 
     */
    public KardexDetailDto(int detailId, int productId, int storeId, int kardexDetailYear, int kardexDetailMonth, int kardexDetailday, int userId, int documentId, int documentNumber, short operation, double quantity, double unityValue, double totalValue, String observations)
    {
        this.detailId = detailId;
        this.productId = productId;
        this.storeId = storeId;
        this.kardexDetailYear = kardexDetailYear;
        this.kardexDetailMonth = kardexDetailMonth;
        this.kardexDetailday = kardexDetailday;
        this.userId = userId;
        this.userIdNull = false;
        this.documentId = documentId;
        this.documentNumber = documentNumber;
        this.operation = operation;
        this.quantity = quantity;
        this.unityValue = unityValue;
        this.totalValue = totalValue;
        this.observations = observations;
        this.state = 1;
    }
    
    /**
     * Constructor.
     * 
     * @param detailId
     * @param productId
     * @param storeId
     * @param kardexDetailYear
     * @param kardexDetailMonth
     * @param kardexDetailday
     * @param userId
     * @param documentId
     * @param documentNumber
     * @param operation
     * @param quantity
     * @param unityValue
     * @param totalValue
     * @param observations
     * @param state 
     */
    public KardexDetailDto(int detailId, int productId, int storeId, int kardexDetailYear, int kardexDetailMonth, int kardexDetailday, int userId, int documentId, int documentNumber, short operation, double quantity, double unityValue, double totalValue, String observations, short state)
    {
        this.detailId = detailId;
        this.productId = productId;
        this.storeId = storeId;
        this.kardexDetailYear = kardexDetailYear;
        this.kardexDetailMonth = kardexDetailMonth;
        this.kardexDetailday = kardexDetailday;
        this.userId = userId;
        this.userIdNull = false;
        this.documentId = documentId;
        this.documentNumber = documentNumber;
        this.operation = operation;
        this.quantity = quantity;
        this.unityValue = unityValue;
        this.totalValue = totalValue;
        this.observations = observations;
        this.state = state;
    }   

    /**
     * Sets the value of userId
     * 
     * @param userId
     */
    @Override
    public void setUserId(int userId)
    {
        this.userId = userId;
        this.userIdNull = false;
    }

    /**
     * Sets the value of userIdNull
     * 
     * @param value
     */
    public void setUserIdNull(boolean value) { this.userIdNull = value; }

    /**
     * Method 'isUserIdNull'
     * 
     * @return boolean
     */
    public boolean isUserIdNull() { return userIdNull; }

    /**
     * Method 'createPk'.
     * 
     * @return KardexDetailPk
     */
    public KardexDetailPk createPk() { return new KardexDetailPk(detailId, productId, storeId); }

    /**
     * Method 'toString'
     * 
     * @return String
     */
    @Override
    public String toString()
    {
        StringBuilder response = new StringBuilder();
        response.append("com.cidenet.hulkstore.dto.KardexDetail: ");
        response.append("detailId=").append(detailId);
        response.append(", productId=").append(productId);
        response.append(", storeId=").append(storeId);
        response.append(", kardexDetailYear=").append(kardexDetailYear);
        response.append(", kardexDetailMonth=").append(kardexDetailMonth);
        response.append(", kardexDetailday=").append(kardexDetailday);
        response.append(", userId=").append(userId);
        response.append(", documentId=").append(documentId);
        response.append(", documentNumber=").append(documentNumber);
        response.append(", operation=").append(operation);
        response.append(", quantity=").append(quantity);
        response.append(", unityValue=").append(unityValue);
        response.append(", totalValue=").append(totalValue);
        response.append(", observations=").append(observations);
        response.append(", state=").append(state);
        return response.toString();
    }
}