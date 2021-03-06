/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.cidenet.hulkstore.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the document table.
 */
public class DocumentPk implements Serializable
{
	protected int documentId;

	/** 
	 * This attribute represents whether the primitive attribute documentId is null.
	 */
	protected boolean documentIdNull;

	/** 
	 * Sets the value of documentId
	 */
	public void setDocumentId(int documentId)
	{
		this.documentId = documentId;
	}

	/** 
	 * Gets the value of documentId
	 */
	public int getDocumentId()
	{
		return documentId;
	}

	/**
	 * Method 'DocumentPk'
	 * 
	 */
	public DocumentPk()
	{
	}

	/**
	 * Method 'DocumentPk'
	 * 
	 * @param documentId
	 */
	public DocumentPk(final int documentId)
	{
		this.documentId = documentId;
	}

	/** 
	 * Sets the value of documentIdNull
	 */
	public void setDocumentIdNull(boolean documentIdNull)
	{
		this.documentIdNull = documentIdNull;
	}

	/** 
	 * Gets the value of documentIdNull
	 */
	public boolean isDocumentIdNull()
	{
		return documentIdNull;
	}

	/**
	 * Method 'equals'
	 * 
	 * @param _other
	 * @return boolean
	 */
	public boolean equals(Object _other)
	{
		if (_other == null) {
			return false;
		}
		
		if (_other == this) {
			return true;
		}
		
		if (!(_other instanceof DocumentPk)) {
			return false;
		}
		
		final DocumentPk _cast = (DocumentPk) _other;
		if (documentId != _cast.documentId) {
			return false;
		}
		
		if (documentIdNull != _cast.documentIdNull) {
			return false;
		}
		
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
		_hashCode = 29 * _hashCode + documentId;
		_hashCode = 29 * _hashCode + (documentIdNull ? 1 : 0);
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
		ret.append( "com.cidenet.hulkstore.dto.DocumentPk: " );
		ret.append( "documentId=" + documentId );
		return ret.toString();
	}

}
