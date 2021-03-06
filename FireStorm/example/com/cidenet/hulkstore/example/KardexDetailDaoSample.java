/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.cidenet.hulkstore.example;

import java.math.*;
import java.util.Date;
import java.util.Collection;
import com.cidenet.hulkstore.dao.KardexDetailDao;
import com.cidenet.hulkstore.dto.KardexDetail;
import com.cidenet.hulkstore.exceptions.KardexDetailDaoException;
import com.cidenet.hulkstore.factory.KardexDetailDaoFactory;

public class KardexDetailDaoSample
{
	/**
	 * Method 'main'
	 * 
	 * @param arg
	 * @throws Exception
	 */
	public static void main(String[] arg) throws Exception
	{
		// Uncomment one of the lines below to test the generated code
		
		// findAll();
		// findByDocument(0);
		// findByKardex(0, 0);
		// findByUsers(0);
		// findWhereDetailIdEquals(0);
		// findWhereProductIdEquals(0);
		// findWhereStoreIdEquals(0);
		// findWhereKardexDetailYearEquals(0);
		// findWhereKardexDetailMonthEquals(0);
		// findWhereKardexDetaildayEquals(0);
		// findWhereUserIdEquals(0);
		// findWhereDocumentIdEquals(0);
		// findWhereDocumentNumberEquals(0);
		// findWhereOperationEquals(0);
		// findWhereQuantityEquals(0);
		// findWhereUnityValueEquals(0);
		// findWhereTotalValueEquals(0);
		// findWhereObservationsEquals("");
		// findWhereStateEquals(0);
	}

	/**
	 * Method 'findAll'
	 * 
	 */
	public static void findAll()
	{
		try {
			KardexDetailDao _dao = getKardexDetailDao();
			KardexDetail _result[] = _dao.findAll();
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findByDocument'
	 * 
	 * @param documentId
	 */
	public static void findByDocument(int documentId)
	{
		try {
			KardexDetailDao _dao = getKardexDetailDao();
			KardexDetail _result[] = _dao.findByDocument(documentId);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findByKardex'
	 * 
	 * @param productId
	 * @param storeId
	 */
	public static void findByKardex(int productId, int storeId)
	{
		try {
			KardexDetailDao _dao = getKardexDetailDao();
			KardexDetail _result[] = _dao.findByKardex(productId, storeId);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findByUsers'
	 * 
	 * @param userId
	 */
	public static void findByUsers(int userId)
	{
		try {
			KardexDetailDao _dao = getKardexDetailDao();
			KardexDetail _result[] = _dao.findByUsers(userId);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereDetailIdEquals'
	 * 
	 * @param detailId
	 */
	public static void findWhereDetailIdEquals(int detailId)
	{
		try {
			KardexDetailDao _dao = getKardexDetailDao();
			KardexDetail _result[] = _dao.findWhereDetailIdEquals(detailId);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereProductIdEquals'
	 * 
	 * @param productId
	 */
	public static void findWhereProductIdEquals(int productId)
	{
		try {
			KardexDetailDao _dao = getKardexDetailDao();
			KardexDetail _result[] = _dao.findWhereProductIdEquals(productId);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereStoreIdEquals'
	 * 
	 * @param storeId
	 */
	public static void findWhereStoreIdEquals(int storeId)
	{
		try {
			KardexDetailDao _dao = getKardexDetailDao();
			KardexDetail _result[] = _dao.findWhereStoreIdEquals(storeId);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereKardexDetailYearEquals'
	 * 
	 * @param kardexDetailYear
	 */
	public static void findWhereKardexDetailYearEquals(int kardexDetailYear)
	{
		try {
			KardexDetailDao _dao = getKardexDetailDao();
			KardexDetail _result[] = _dao.findWhereKardexDetailYearEquals(kardexDetailYear);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereKardexDetailMonthEquals'
	 * 
	 * @param kardexDetailMonth
	 */
	public static void findWhereKardexDetailMonthEquals(int kardexDetailMonth)
	{
		try {
			KardexDetailDao _dao = getKardexDetailDao();
			KardexDetail _result[] = _dao.findWhereKardexDetailMonthEquals(kardexDetailMonth);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereKardexDetaildayEquals'
	 * 
	 * @param kardexDetailday
	 */
	public static void findWhereKardexDetaildayEquals(int kardexDetailday)
	{
		try {
			KardexDetailDao _dao = getKardexDetailDao();
			KardexDetail _result[] = _dao.findWhereKardexDetaildayEquals(kardexDetailday);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereUserIdEquals'
	 * 
	 * @param userId
	 */
	public static void findWhereUserIdEquals(int userId)
	{
		try {
			KardexDetailDao _dao = getKardexDetailDao();
			KardexDetail _result[] = _dao.findWhereUserIdEquals(userId);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereDocumentIdEquals'
	 * 
	 * @param documentId
	 */
	public static void findWhereDocumentIdEquals(int documentId)
	{
		try {
			KardexDetailDao _dao = getKardexDetailDao();
			KardexDetail _result[] = _dao.findWhereDocumentIdEquals(documentId);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereDocumentNumberEquals'
	 * 
	 * @param documentNumber
	 */
	public static void findWhereDocumentNumberEquals(int documentNumber)
	{
		try {
			KardexDetailDao _dao = getKardexDetailDao();
			KardexDetail _result[] = _dao.findWhereDocumentNumberEquals(documentNumber);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereOperationEquals'
	 * 
	 * @param operation
	 */
	public static void findWhereOperationEquals(short operation)
	{
		try {
			KardexDetailDao _dao = getKardexDetailDao();
			KardexDetail _result[] = _dao.findWhereOperationEquals(operation);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereQuantityEquals'
	 * 
	 * @param quantity
	 */
	public static void findWhereQuantityEquals(double quantity)
	{
		try {
			KardexDetailDao _dao = getKardexDetailDao();
			KardexDetail _result[] = _dao.findWhereQuantityEquals(quantity);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereUnityValueEquals'
	 * 
	 * @param unityValue
	 */
	public static void findWhereUnityValueEquals(double unityValue)
	{
		try {
			KardexDetailDao _dao = getKardexDetailDao();
			KardexDetail _result[] = _dao.findWhereUnityValueEquals(unityValue);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereTotalValueEquals'
	 * 
	 * @param totalValue
	 */
	public static void findWhereTotalValueEquals(double totalValue)
	{
		try {
			KardexDetailDao _dao = getKardexDetailDao();
			KardexDetail _result[] = _dao.findWhereTotalValueEquals(totalValue);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereObservationsEquals'
	 * 
	 * @param observations
	 */
	public static void findWhereObservationsEquals(String observations)
	{
		try {
			KardexDetailDao _dao = getKardexDetailDao();
			KardexDetail _result[] = _dao.findWhereObservationsEquals(observations);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereStateEquals'
	 * 
	 * @param state
	 */
	public static void findWhereStateEquals(short state)
	{
		try {
			KardexDetailDao _dao = getKardexDetailDao();
			KardexDetail _result[] = _dao.findWhereStateEquals(state);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'getKardexDetailDao'
	 * 
	 * @return KardexDetailDao
	 */
	public static KardexDetailDao getKardexDetailDao()
	{
		return KardexDetailDaoFactory.create();
	}

	/**
	 * Method 'display'
	 * 
	 * @param dto
	 */
	public static void display(KardexDetail dto)
	{
		StringBuffer buf = new StringBuffer();
		buf.append( dto.getDetailId() );
		buf.append( ", " );
		buf.append( dto.getProductId() );
		buf.append( ", " );
		buf.append( dto.getStoreId() );
		buf.append( ", " );
		buf.append( dto.getKardexDetailYear() );
		buf.append( ", " );
		buf.append( dto.getKardexDetailMonth() );
		buf.append( ", " );
		buf.append( dto.getKardexDetailday() );
		buf.append( ", " );
		buf.append( dto.getUserId() );
		buf.append( ", " );
		buf.append( dto.getDocumentId() );
		buf.append( ", " );
		buf.append( dto.getDocumentNumber() );
		buf.append( ", " );
		buf.append( dto.getOperation() );
		buf.append( ", " );
		buf.append( dto.getQuantity() );
		buf.append( ", " );
		buf.append( dto.getUnityValue() );
		buf.append( ", " );
		buf.append( dto.getTotalValue() );
		buf.append( ", " );
		buf.append( dto.getObservations() );
		buf.append( ", " );
		buf.append( dto.getState() );
		System.out.println( buf.toString() );
	}

}
