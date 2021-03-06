/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.cidenet.hulkstore.dto;

import com.cidenet.hulkstore.dao.*;
import com.cidenet.hulkstore.factory.*;
import com.cidenet.hulkstore.exceptions.*;
import java.io.Serializable;
import java.util.*;

public class Document implements Serializable
{
	/** 
	 * This attribute maps to the column documentId in the document table.
	 */
	protected int documentId;

	/** 
	 * This attribute maps to the column documentDescription in the document table.
	 */
	protected String documentDescription;

	/** 
	 * This attribute maps to the column state in the document table.
	 */
	protected short state;

	/**
	 * Method 'Document'
	 * 
	 */
	public Document()
	{
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
	 * Method 'getDocumentDescription'
	 * 
	 * @return String
	 */
	public String getDocumentDescription()
	{
		return documentDescription;
	}

	/**
	 * Method 'setDocumentDescription'
	 * 
	 * @param documentDescription
	 */
	public void setDocumentDescription(String documentDescription)
	{
		this.documentDescription = documentDescription;
	}

	/**
	 * Method 'getState'
	 * 
	 * @return short
	 */
	public short getState()
	{
		return state;
	}

	/**
	 * Method 'setState'
	 * 
	 * @param state
	 */
	public void setState(short state)
	{
		this.state = state;
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
		
		if (!(_other instanceof Document)) {
			return false;
		}
		
		final Document _cast = (Document) _other;
		if (documentId != _cast.documentId) {
			return false;
		}
		
		if (documentDescription == null ? _cast.documentDescription != documentDescription : !documentDescription.equals( _cast.documentDescription )) {
			return false;
		}
		
		if (state != _cast.state) {
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
		if (documentDescription != null) {
			_hashCode = 29 * _hashCode + documentDescription.hashCode();
		}
		
		_hashCode = 29 * _hashCode + (int) state;
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return DocumentPk
	 */
	public DocumentPk createPk()
	{
		return new DocumentPk(documentId);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.cidenet.hulkstore.dto.Document: " );
		ret.append( "documentId=" + documentId );
		ret.append( ", documentDescription=" + documentDescription );
		ret.append( ", state=" + state );
		return ret.toString();
	}

}
