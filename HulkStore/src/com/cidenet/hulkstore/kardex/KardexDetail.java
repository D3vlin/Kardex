package com.cidenet.hulkstore.kardex;

/**
 *
 * @author jduque
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
    * Method 'getDetailId'
    * 
    * @return int
    */
   public int getDetailId()
   {
        return detailId;
   }

   /**
    * Method 'setDetailId'
    * 
    * @param detailId
    */
   public void setDetailId(int detailId)
   {
        this.detailId = detailId;
   }

    /**
     * Method 'getKardexDetailDate'
     * 
     * @return String
     */
    public String getKardexDetailDate()
    {
        return kardexDetailday + "/" + kardexDetailMonth + "/" + kardexDetailYear;
    }

    /**
     * Method 'getKardexDetailYear'
     * 
     * @return int
     */
    public int getKardexDetailYear()
    {
        return kardexDetailYear;
    }

    /**
     * Method 'setKardexDetailYear'
     * 
     * @param kardexDetailYear
     */
    public void setKardexDetailYear(int kardexDetailYear)
    {
        this.kardexDetailYear = kardexDetailYear;
    }

    /**
     * Method 'getKardexDetailMonth'
     * 
     * @return int
     */
    public int getKardexDetailMonth()
    {
        return kardexDetailMonth;
    }

    /**
     * Method 'setKardexDetailMonth'
     * 
     * @param kardexDetailMonth
     */
    public void setKardexDetailMonth(int kardexDetailMonth)
    {
        this.kardexDetailMonth = kardexDetailMonth;
    }

    /**
     * Method 'getKardexDetailday'
     * 
     * @return int
     */
    public int getKardexDetailday()
    {
        return kardexDetailday;
    }

    /**
     * Method 'setKardexDetailday'
     * 
     * @param kardexDetailday
     */
    public void setKardexDetailday(int kardexDetailday)
    {
        this.kardexDetailday = kardexDetailday;
    }

    /**
     * Method 'getUserId'
     * 
     * @return int
     */
    public int getUserId()
    {
        return userId;
    }

    /**
     * Method 'setUserId'
     * 
     * @param userId
     */
    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    /**
     * Method 'getDocumentId'
     * 
     * @return int
     */
    public int getDocumentId()
    {
        return documentId;
    }

    /**
     * Method 'setDocumentId'
     * 
     * @param documentId
     */
    public void setDocumentId(int documentId)
    {
        this.documentId = documentId;
    }

    /**
     * Method 'getDocumentNumber'
     * 
     * @return int
     */
    public int getDocumentNumber()
    {
        return documentNumber;
    }

    /**
     * Method 'setDocumentNumber'
     * 
     * @param documentNumber
     */
    public void setDocumentNumber(int documentNumber)
    {
        this.documentNumber = documentNumber;
    }

    /**
     * Method 'getOperation'
     * 
     * @return short
     */
    public short getOperation()
    {
        return operation;
    }

    /**
     * Method 'setOperation'
     * 
     * @param operation
     */
    public void setOperation(short operation)
    {
        this.operation = operation;
    }

    /**
     * Method 'getObservations'
     * 
     * @return String
     */
    public String getObservations()
    {
        return observations;
    }

    /**
     * Method 'setObservations'
     * 
     * @param observations
     */
    public void setObservations(String observations)
    {
        this.observations = observations;
    }
}
