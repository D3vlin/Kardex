package com.cidenet.hulkstore.kardex;

import java.io.Serializable;

public final class KardexDetailDto extends KardexDetail implements Serializable
{
    /** 
     * This attribute represents whether the primitive attribute userId is null.
     */
    protected boolean userIdNull = true;

    /**
     * Method 'KardexDetail'
     * 
     */
    public KardexDetailDto() {}

    /**
     * Method 'KardexDetail'
     * 
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
     * Method 'setUserId'
     * 
     * @param userId
     */
    public void setUserId(int userId)
    {
        this.userId = userId;
        this.userIdNull = false;
    }

    /**
     * Method 'setUserIdNull'
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
     * Method 'createPk'
     * 
     * @return KardexDetailPk
     */
    public KardexDetailPk createPk() { return new KardexDetailPk(detailId, productId, storeId); }

    /**
     * Method 'equals'
     * 
     * @param _other
     * @return boolean
     */
    public boolean equals(Object _other)
    {
        if (_other == null) { return false; }

        if (_other == this) { return true; }

        if (!(_other instanceof KardexDetailDto)) { return false; }

        final KardexDetailDto _cast = (KardexDetailDto) _other;
        
        if (detailId != _cast.detailId) { return false; }

        if (productId != _cast.productId) { return false; }

        if (storeId != _cast.storeId) { return false; }

        if (kardexDetailYear != _cast.kardexDetailYear) { return false; }

        if (kardexDetailMonth != _cast.kardexDetailMonth) { return false; }

        if (kardexDetailday != _cast.kardexDetailday) { return false; }

        if (userId != _cast.userId) { return false; }

        if (userIdNull != _cast.userIdNull) { return false; }

        if (documentId != _cast.documentId) { return false; }

        if (documentNumber != _cast.documentNumber) { return false; }

        if (operation != _cast.operation) { return false; }

        if (quantity != _cast.quantity) { return false; }

        if (unityValue != _cast.unityValue) { return false; }

        if (totalValue != _cast.totalValue) { return false; }

        if (observations == null ? _cast.observations != observations : !observations.equals( _cast.observations )) { return false; }

        if (state != _cast.state) { return false; }

        return true;
    }

    /**
     * Method 'hashCode'
     * 
     * @return int
     */
    public int hashCode()
    {
        int _hashCode = 0;
        _hashCode = 29 * _hashCode + detailId;
        _hashCode = 29 * _hashCode + productId;
        _hashCode = 29 * _hashCode + storeId;
        _hashCode = 29 * _hashCode + kardexDetailYear;
        _hashCode = 29 * _hashCode + kardexDetailMonth;
        _hashCode = 29 * _hashCode + kardexDetailday;
        _hashCode = 29 * _hashCode + userId;
        _hashCode = 29 * _hashCode + (userIdNull ? 1 : 0);
        _hashCode = 29 * _hashCode + documentId;
        _hashCode = 29 * _hashCode + documentNumber;
        _hashCode = 29 * _hashCode + (int) operation;
        long temp_quantity = Double.doubleToLongBits(quantity);
        _hashCode = 29 * _hashCode + (int) (temp_quantity ^ (temp_quantity >>> 32));
        long temp_unityValue = Double.doubleToLongBits(unityValue);
        _hashCode = 29 * _hashCode + (int) (temp_unityValue ^ (temp_unityValue >>> 32));
        long temp_totalValue = Double.doubleToLongBits(totalValue);
        _hashCode = 29 * _hashCode + (int) (temp_totalValue ^ (temp_totalValue >>> 32));
        if (observations != null) {
                _hashCode = 29 * _hashCode + observations.hashCode();
        }

        _hashCode = 29 * _hashCode + (int) state;
        return _hashCode;
    }

    /**
     * Method 'toString'
     * 
     * @return String
     */
    public String toString()
    {
            StringBuffer ret = new StringBuffer();
            ret.append( "com.cidenet.hulkstore.dto.KardexDetail: " );
            ret.append( "detailId=" + detailId );
            ret.append( ", productId=" + productId );
            ret.append( ", storeId=" + storeId );
            ret.append( ", kardexDetailYear=" + kardexDetailYear );
            ret.append( ", kardexDetailMonth=" + kardexDetailMonth );
            ret.append( ", kardexDetailday=" + kardexDetailday );
            ret.append( ", userId=" + userId );
            ret.append( ", documentId=" + documentId );
            ret.append( ", documentNumber=" + documentNumber );
            ret.append( ", operation=" + operation );
            ret.append( ", quantity=" + quantity );
            ret.append( ", unityValue=" + unityValue );
            ret.append( ", totalValue=" + totalValue );
            ret.append( ", observations=" + observations );
            ret.append( ", state=" + state );
            return ret.toString();
    }

}
