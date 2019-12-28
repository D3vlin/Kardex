package com.cidenet.hulkstore.model.dto.kardex;

/**
 * This abstract class represents the kardex detail model.
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-24
 */
public abstract class KardexDetail extends Kardex
{
    /** 
     * This attribute maps to the column detailId in the kardex_detail table.
     */
    protected int detailId;

    /** 
     * This attribute maps to the column kardexDetailYear in the kardex_detail table.
     */
    protected int kardexDetailYear;

    /** 
     * This attribute maps to the column kardexDetailMonth in the kardex_detail table.
     */
    protected int kardexDetailMonth;

    /** 
     * This attribute maps to the column kardexDetailday in the kardex_detail table.
     */
    protected int kardexDetailday;

    /** 
     * This attribute maps to the column userId in the kardex_detail table.
     */
    protected int userId;

    /** 
     * This attribute maps to the column documentId in the kardex_detail table.
     */
    protected int documentId;

    /** 
     * This attribute maps to the column documentNumber in the kardex_detail table.
     */
    protected int documentNumber;

    /** 
     * This attribute maps to the column operation in the kardex_detail table.
     */
    protected short operation;

    /** 
     * This attribute maps to the column observations in the kardex_detail table.
     */
    protected String observations;
    
    /**
    * Gets the value of detailId.
    * 
    * @return int
    */
   public int getDetailId() { return detailId; }

   /**
    * Sets the value of detailId.
    * 
    * @param detailId
    */
   public void setDetailId(int detailId) { this.detailId = detailId; }

    /**
     * Gets the value of kardex detail date.
     * 
     * @return String
     */
    public String getKardexDetailDate()
    {
        return kardexDetailday + "/" + kardexDetailMonth + "/" + kardexDetailYear;
    }

    /**
     * Gets the value of kardexDetailYear.
     * 
     * @return int
     */
    public int getKardexDetailYear() { return kardexDetailYear; }

    /**
     * Sets the value of kardexDetailYear.
     * 
     * @param kardexDetailYear
     */
    public void setKardexDetailYear(int kardexDetailYear) { this.kardexDetailYear = kardexDetailYear; }

    /**
     * Gets the value of kardexDetailMonth.
     * 
     * @return int
     */
    public int getKardexDetailMonth() { return kardexDetailMonth; }

    /**
     * Sets the value of kardexDetailMonth.
     * 
     * @param kardexDetailMonth
     */
    public void setKardexDetailMonth(int kardexDetailMonth) { this.kardexDetailMonth = kardexDetailMonth; }

    /**
     * Gets the value of kardexDetailday.
     * 
     * @return int
     */
    public int getKardexDetailday() { return kardexDetailday; }

    /**
     * Sets the value of kardexDetailday.
     * 
     * @param kardexDetailday
     */
    public void setKardexDetailday(int kardexDetailday) { this.kardexDetailday = kardexDetailday; }

    /**
     * Gets the value of userId.
     * 
     * @return int
     */
    public int getUserId() { return userId; }

    /**
     * Sets the value of userId.
     * 
     * @param userId
     */
    public void setUserId(int userId) { this.userId = userId; }

    /**
     * Gets the value of documentId.
     * 
     * @return int
     */
    public int getDocumentId() { return documentId; }

    /**
     * Sets the value of documentId.
     * 
     * @param documentId
     */
    public void setDocumentId(int documentId) { this.documentId = documentId; }

    /**
     * Gets the value of documentNumber.
     * 
     * @return int
     */
    public int getDocumentNumber() { return documentNumber; }

    /**
     * Sets the value of documentNumber.
     * 
     * @param documentNumber
     */
    public void setDocumentNumber(int documentNumber) { this.documentNumber = documentNumber; }

    /**
     * Gets the value of operation.
     * 
     * @return short
     */
    public short getOperation() { return operation; }

    /**
     * Sets the value of operation.
     * 
     * @param operation
     */
    public void setOperation(short operation) { this.operation = operation; }

    /**
     * Gets the value of observations.
     * 
     * @return String
     */
    public String getObservations() { return observations; }

    /**
     * Sets the value of observations.
     * 
     * @param observations
     */
    public void setObservations(String observations) { this.observations = observations; }
}