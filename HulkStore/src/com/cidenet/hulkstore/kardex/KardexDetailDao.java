package com.cidenet.hulkstore.kardex;

import com.cidenet.hulkstore.jdbc.AbstractDAO;
import com.cidenet.hulkstore.jdbc.ResourceManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class KardexDetailDao extends AbstractDAO
{
	/** 
	 * The factory class for this DAO has two versions of the create() method - one that
takes no arguments and one that takes a Connection argument. If the Connection version
is chosen then the connection will be stored in this attribute and will be used by all
calls to this DAO, otherwise a new Connection will be allocated for each operation.
	 */
	protected java.sql.Connection userConn;

	/** 
	 * All finder methods in this class use this SELECT constant to build their queries
	 */
	protected final String SQL_SELECT = "SELECT detailId, productId, storeId, kardexDetailYear, kardexDetailMonth, kardexDetailday, userId, documentId, documentNumber, operation, quantity, unityValue, totalValue, observations, state FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( detailId, productId, storeId, kardexDetailYear, kardexDetailMonth, kardexDetailday, userId, documentId, documentNumber, operation, quantity, unityValue, totalValue, observations, state ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET detailId = ?, productId = ?, storeId = ?, kardexDetailYear = ?, kardexDetailMonth = ?, kardexDetailday = ?, userId = ?, documentId = ?, documentNumber = ?, operation = ?, quantity = ?, unityValue = ?, totalValue = ?, observations = ?, state = ? WHERE detailId = ? AND productId = ? AND storeId = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE detailId = ? AND productId = ? AND storeId = ?";

	/** 
	 * Indexes of the columns in the kardex_detail table
	 */
	protected static final int COLUMN_DETAIL_ID = 1;
	protected static final int COLUMN_PRODUCT_ID = 2;
	protected static final int COLUMN_STORE_ID = 3;
	protected static final int COLUMN_KARDEX_DETAIL_YEAR = 4;
	protected static final int COLUMN_KARDEX_DETAIL_MONTH = 5;
	protected static final int COLUMN_KARDEX_DETAILDAY = 6;
	protected static final int COLUMN_USER_ID = 7;
	protected static final int COLUMN_DOCUMENT_ID = 8;
	protected static final int COLUMN_DOCUMENT_NUMBER = 9;
	protected static final int COLUMN_OPERATION = 10;
	protected static final int COLUMN_QUANTITY = 11;
	protected static final int COLUMN_UNITY_VALUE = 12;
	protected static final int COLUMN_TOTAL_VALUE = 13;
	protected static final int COLUMN_OBSERVATIONS = 14;
	protected static final int COLUMN_STATE = 15;

	/** 
	 * Number of columns in the kardex_detail table
	 */
	protected static final int KARDEX_DETAIL_COLUMNS = 15;

	/** 
	 * Index of primary-key column detailId in the kardex_detail table
	 */
	protected static final int PK_COLUMN_DETAIL_ID = 1;

	/** 
	 * Index of primary-key column productId in the kardex_detail table
	 */
	protected static final int PK_COLUMN_PRODUCT_ID = 2;

	/** 
	 * Index of primary-key column storeId in the kardex_detail table
	 */
	protected static final int PK_COLUMN_STORE_ID = 3;

	/** 
	 * Indexes of the columns in the vi_kardexdetail view
	 */
	protected static final int COLUMN_VIEW_DETAIL_ID = 1;
	protected static final int COLUMN_VIEW_KARDEX_DETAIL_YEAR = 2;
	protected static final int COLUMN_VIEW_KARDEX_DETAIL_MONTH = 3;
	protected static final int COLUMN_VIEW_KARDEX_DETAILDAY = 4;
	protected static final int COLUMN_VIEW_DOCUMENT_ID = 5;
	protected static final int COLUMN_VIEW_DOCUMENT_DESCRIPTION = 6;
	protected static final int COLUMN_VIEW_DOCUMENT_NUMBER = 7;
	protected static final int COLUMN_VIEW_OPERATION = 8;
	protected static final int COLUMN_VIEW_QUANTITY = 9;
	protected static final int COLUMN_VIEW_UNITY_VALUE = 10;
	protected static final int COLUMN_VIEW_TOTAL_VALUE = 11;
	protected static final int COLUMN_VIEW_OBSERVATIONS = 12;
	protected static final int COLUMN_VIEW_PRODUCT_ID = 13;
	protected static final int COLUMN_VIEW_STORE_ID = 14;

	/** 
	 * Number of columns in the vi_kardexdetail view
	 */
	protected static final int KARDEX_DETAIL_VIEW_COLUMNS = 14;

	/** 
	 * Inserts a new row in the kardex_detail table.
	 */
	public KardexDetailPk insert(KardexDetailDto dto) throws KardexDetailDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			stmt = conn.prepareStatement( SQL_INSERT, Statement.RETURN_GENERATED_KEYS );
			int index = 1;
			stmt.setInt( index++, dto.getDetailId() );
			stmt.setInt( index++, dto.getProductId() );
			stmt.setInt( index++, dto.getStoreId() );
			stmt.setInt( index++, dto.getKardexDetailYear() );
			stmt.setInt( index++, dto.getKardexDetailMonth() );
			stmt.setInt( index++, dto.getKardexDetailday() );
			if (dto.isUserIdNull()) {
				stmt.setNull( index++, java.sql.Types.INTEGER );
			} else {
				stmt.setInt( index++, dto.getUserId() );
			}
		
			stmt.setInt( index++, dto.getDocumentId() );
			stmt.setInt( index++, dto.getDocumentNumber() );
			stmt.setShort( index++, dto.getOperation() );
			stmt.setDouble( index++, dto.getQuantity() );
			stmt.setDouble( index++, dto.getUnityValue() );
			stmt.setDouble( index++, dto.getTotalValue() );
			stmt.setString( index++, dto.getObservations() );
			stmt.setShort( index++, dto.getState() );
			System.out.println( "Executing " + SQL_INSERT + " with DTO: " + dto );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		
			// retrieve values from auto-increment columns
			rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				dto.setDetailId( rs.getInt( 1 ) );
			}
		
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new KardexDetailDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the kardex_detail table.
	 */
	public boolean update(KardexDetailPk pk, KardexDetailDto dto) throws KardexDetailDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			System.out.println( "Executing " + SQL_UPDATE + " with DTO: " + dto );
			stmt = conn.prepareStatement( SQL_UPDATE );
			int index=1;
			stmt.setInt( index++, dto.getDetailId() );
			stmt.setInt( index++, dto.getProductId() );
			stmt.setInt( index++, dto.getStoreId() );
			stmt.setInt( index++, dto.getKardexDetailYear() );
			stmt.setInt( index++, dto.getKardexDetailMonth() );
			stmt.setInt( index++, dto.getKardexDetailday() );
			if (dto.isUserIdNull()) {
				stmt.setNull( index++, java.sql.Types.INTEGER );
			} else {
				stmt.setInt( index++, dto.getUserId() );
			}
		
			stmt.setInt( index++, dto.getDocumentId() );
			stmt.setInt( index++, dto.getDocumentNumber() );
			stmt.setShort( index++, dto.getOperation() );
			stmt.setDouble( index++, dto.getQuantity() );
			stmt.setDouble( index++, dto.getUnityValue() );
			stmt.setDouble( index++, dto.getTotalValue() );
			stmt.setString( index++, dto.getObservations() );
			stmt.setShort( index++, dto.getState() );
			stmt.setInt( 16, pk.getDetailId() );
			stmt.setInt( 17, pk.getProductId() );
			stmt.setInt( 18, pk.getStoreId() );
			int rows = stmt.executeUpdate();
			reset(dto);
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
                        return true;
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new KardexDetailDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the kardex_detail table.
	 */
	public void delete(KardexDetailPk pk) throws KardexDetailDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			System.out.println( "Executing " + SQL_DELETE + " with PK: " + pk );
			stmt = conn.prepareStatement( SQL_DELETE );
			stmt.setInt( 1, pk.getDetailId() );
			stmt.setInt( 2, pk.getProductId() );
			stmt.setInt( 3, pk.getStoreId() );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new KardexDetailDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the kardex_detail table that matches the specified primary-key value.
	 */
	public KardexDetailDto findByPrimaryKey(KardexDetailPk pk) throws KardexDetailDaoException
	{
		return findByPrimaryKey( pk.getDetailId(), pk.getProductId(), pk.getStoreId() );
	}

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'detailId = :detailId AND productId = :productId AND storeId = :storeId'.
	 */
	public KardexDetailDto findByPrimaryKey(int detailId, int productId, int storeId) throws KardexDetailDaoException
	{
		KardexDetailDto ret[] = findByDynamicSelect( SQL_SELECT + " WHERE detailId = ? AND productId = ? AND storeId = ?", new Object[] {  new Integer(detailId),  new Integer(productId),  new Integer(storeId) } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria ''.
	 */
	public KardexDetailDto[] findAll() throws KardexDetailDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY detailId, productId, storeId", null );
	}

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'documentId = :documentId'.
	 */
	public KardexDetailDto[] findByDocument(int documentId) throws KardexDetailDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE documentId = ?", new Object[] {  new Integer(documentId) } );
	}

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'productId = :productId AND storeId = :storeId'.
	 */
	public KardexDetailDto[] findByKardex(int productId, int storeId) throws KardexDetailDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE productId = ? AND storeId = ?", new Object[] {  new Integer(productId),  new Integer(storeId) } );
	}

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'userId = :userId'.
	 */
	public KardexDetailDto[] findByUsers(int userId) throws KardexDetailDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE userId = ?", new Object[] {  new Integer(userId) } );
	}

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'detailId = :detailId'.
	 */
	public KardexDetailDto[] findWhereDetailIdEquals(int detailId) throws KardexDetailDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE detailId = ? ORDER BY detailId", new Object[] {  new Integer(detailId) } );
	}

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'productId = :productId'.
	 */
	public KardexDetailDto[] findWhereProductIdEquals(int productId) throws KardexDetailDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE productId = ? ORDER BY productId", new Object[] {  new Integer(productId) } );
	}

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'storeId = :storeId'.
	 */
	public KardexDetailDto[] findWhereStoreIdEquals(int storeId) throws KardexDetailDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE storeId = ? ORDER BY storeId", new Object[] {  new Integer(storeId) } );
	}

	/** 
	 * Returns a single row from the kardex_detail table that match the criteria 'productId = :productId and storeId = :storeId'.
	 */
        public KardexDetailDto[] findWhereProductIdAndStoreIdEquals(int productId, int storeId) throws KardexDetailDaoException
        {
            return findByDynamicSelect( SQL_SELECT + " WHERE productId = ? and storeId = ?", new Object[] {  new Integer(productId), new Integer(storeId) } );
        }

	/** 
	 * Returns the last record of the kardex_detail table that match the criteria 'productId =: productId and storeId =: storeId'.
	 */
        public KardexDetailDto findLastKardexDetail(int productId, int storeId) throws KardexDetailDaoException
        {
            KardexDetailDto ret[] = findByDynamicSelect( SQL_SELECT + " WHERE productId = ? and storeId = ?", new Object[] {  new Integer(productId), new Integer(storeId) } );
            return ret[ret.length - 1];
        }

	/** 
	 * Returns a single row from the kardex_detail table that match the criteria 'productId = :productId and storeId = :storeId and state = 1'.
	 */
        public KardexDetailDto[] findActiveDetails(int productId, int storeId) throws KardexDetailDaoException
        {
            return findByDynamicSelect( SQL_SELECT + " WHERE productId = ? and storeId = ? and state = 1", new Object[] {  new Integer(productId), new Integer(storeId) } );
        }

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'kardexDetailYear = :kardexDetailYear'.
	 */
	public KardexDetailDto[] findWhereKardexDetailYearEquals(int kardexDetailYear) throws KardexDetailDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE kardexDetailYear = ? ORDER BY kardexDetailYear", new Object[] {  new Integer(kardexDetailYear) } );
	}

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'kardexDetailMonth = :kardexDetailMonth'.
	 */
	public KardexDetailDto[] findWhereKardexDetailMonthEquals(int kardexDetailMonth) throws KardexDetailDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE kardexDetailMonth = ? ORDER BY kardexDetailMonth", new Object[] {  new Integer(kardexDetailMonth) } );
	}

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'kardexDetailday = :kardexDetailday'.
	 */
	public KardexDetailDto[] findWhereKardexDetaildayEquals(int kardexDetailday) throws KardexDetailDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE kardexDetailday = ? ORDER BY kardexDetailday", new Object[] {  new Integer(kardexDetailday) } );
	}

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'userId = :userId'.
	 */
	public KardexDetailDto[] findWhereUserIdEquals(int userId) throws KardexDetailDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE userId = ? ORDER BY userId", new Object[] {  new Integer(userId) } );
	}

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'documentId = :documentId'.
	 */
	public KardexDetailDto[] findWhereDocumentIdEquals(int documentId) throws KardexDetailDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE documentId = ? ORDER BY documentId", new Object[] {  new Integer(documentId) } );
	}

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'documentNumber = :documentNumber'.
	 */
	public KardexDetailDto[] findWhereDocumentNumberEquals(int documentNumber) throws KardexDetailDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE documentNumber = ? ORDER BY documentNumber", new Object[] {  new Integer(documentNumber) } );
	}

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'operation = :operation'.
	 */
	public KardexDetailDto[] findWhereOperationEquals(short operation) throws KardexDetailDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE operation = ? ORDER BY operation", new Object[] {  new Short(operation) } );
	}

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'quantity = :quantity'.
	 */
	public KardexDetailDto[] findWhereQuantityEquals(double quantity) throws KardexDetailDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE quantity = ? ORDER BY quantity", new Object[] {  new Double(quantity) } );
	}

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'unityValue = :unityValue'.
	 */
	public KardexDetailDto[] findWhereUnityValueEquals(double unityValue) throws KardexDetailDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE unityValue = ? ORDER BY unityValue", new Object[] {  new Double(unityValue) } );
	}

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'totalValue = :totalValue'.
	 */
	public KardexDetailDto[] findWhereTotalValueEquals(double totalValue) throws KardexDetailDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE totalValue = ? ORDER BY totalValue", new Object[] {  new Double(totalValue) } );
	}

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'observations = :observations'.
	 */
	public KardexDetailDto[] findWhereObservationsEquals(String observations) throws KardexDetailDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE observations = ? ORDER BY observations", new Object[] { observations } );
	}

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'state = :state'.
	 */
	public KardexDetailDto[] findWhereStateEquals(short state) throws KardexDetailDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE state = ? ORDER BY state", new Object[] {  new Short(state) } );
	}

	/**
	 * Method 'KardexDetailDaoImpl'
	 * 
	 */
	public KardexDetailDao()
	{
	}

	/**
	 * Method 'KardexDetailDaoImpl'
	 * 
	 * @param userConn
	 */
	public KardexDetailDao(final java.sql.Connection userConn)
	{
		this.userConn = userConn;
	}

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows)
	{
		this.maxRows = maxRows;
	}

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows()
	{
		return maxRows;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "bd_hulkstore.kardex_detail";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected KardexDetailDto fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			KardexDetailDto dto = new KardexDetailDto();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}
        
        /** 
	 * Fetches multiple rows from the result set
	 */
	protected KardexDetailView[] fetchKardexDetailView(ResultSet rs) throws SQLException
	{
            ArrayList resultList = fetchMultiResults(rs, true);   
            KardexDetailView kardexDetailView[] = new KardexDetailView[ resultList.size() ];
            resultList.toArray( kardexDetailView );
            return kardexDetailView;
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected KardexDetailDto[] fetchKardexDetailDto(ResultSet rs) throws SQLException
	{
            ArrayList resultList = fetchMultiResults(rs, false);   
            KardexDetailDto kardexDetailDto[] = new KardexDetailDto[ resultList.size() ];
            resultList.toArray( kardexDetailDto );
            return kardexDetailDto;
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected ArrayList fetchMultiResults(ResultSet rs, boolean view) throws SQLException
	{
            ArrayList resultList = new ArrayList();
            
            while (rs.next()) {
                if(view) {
                    KardexDetailView kardexDetailView = new KardexDetailView();
                    populateKardexDetailView( kardexDetailView, rs);
                    resultList.add( kardexDetailView );
                } else {
                    KardexDetailDto kardexDetailDto = new KardexDetailDto();
                    populateDto( kardexDetailDto, rs);
                    resultList.add( kardexDetailDto );
                }                    
            }
            
            return resultList;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(KardexDetailDto dto, ResultSet rs) throws SQLException
	{
		dto.setDetailId( rs.getInt( COLUMN_DETAIL_ID ) );
		dto.setProductId( rs.getInt( COLUMN_PRODUCT_ID ) );
		dto.setStoreId( rs.getInt( COLUMN_STORE_ID ) );
		dto.setKardexDetailYear( rs.getInt( COLUMN_KARDEX_DETAIL_YEAR ) );
		dto.setKardexDetailMonth( rs.getInt( COLUMN_KARDEX_DETAIL_MONTH ) );
		dto.setKardexDetailday( rs.getInt( COLUMN_KARDEX_DETAILDAY ) );
		dto.setUserId( rs.getInt( COLUMN_USER_ID ) );
		if (rs.wasNull()) {
			dto.setUserIdNull( true );
		}
		
		dto.setDocumentId( rs.getInt( COLUMN_DOCUMENT_ID ) );
		dto.setDocumentNumber( rs.getInt( COLUMN_DOCUMENT_NUMBER ) );
		dto.setOperation( rs.getShort( COLUMN_OPERATION ) );
		dto.setQuantity( rs.getDouble( COLUMN_QUANTITY ) );
		dto.setUnityValue( rs.getDouble( COLUMN_UNITY_VALUE ) );
		dto.setTotalValue( rs.getDouble( COLUMN_TOTAL_VALUE ) );
		dto.setObservations( rs.getString( COLUMN_OBSERVATIONS ) );
		dto.setState( rs.getShort( COLUMN_STATE ) );
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateKardexDetailView(KardexDetailView kardexDetailView, ResultSet rs) throws SQLException
	{
            kardexDetailView.setDetailId( rs.getInt( COLUMN_VIEW_DETAIL_ID ) );
            kardexDetailView.setKardexDetailYear( rs.getInt( COLUMN_VIEW_KARDEX_DETAIL_YEAR ) );
            kardexDetailView.setKardexDetailMonth( rs.getInt( COLUMN_VIEW_KARDEX_DETAIL_MONTH ) );
            kardexDetailView.setKardexDetailday( rs.getInt( COLUMN_VIEW_KARDEX_DETAILDAY ) );
            kardexDetailView.setDocumentId( rs.getInt( COLUMN_VIEW_DOCUMENT_ID ) );
            kardexDetailView.setDocumentDescription(rs.getString( COLUMN_VIEW_DOCUMENT_DESCRIPTION ) );
            kardexDetailView.setDocumentNumber( rs.getInt( COLUMN_VIEW_DOCUMENT_NUMBER ) );
            kardexDetailView.setOperation( rs.getShort( COLUMN_VIEW_OPERATION ) );
            kardexDetailView.setQuantity( rs.getDouble( COLUMN_VIEW_QUANTITY ) );
            kardexDetailView.setUnityValue( rs.getDouble( COLUMN_VIEW_UNITY_VALUE ) );
            kardexDetailView.setTotalValue( rs.getDouble( COLUMN_VIEW_TOTAL_VALUE ) );
            kardexDetailView.setObservations( rs.getString( COLUMN_VIEW_OBSERVATIONS ) );                
            kardexDetailView.setProductId( rs.getInt( COLUMN_VIEW_PRODUCT_ID ) );
            kardexDetailView.setStoreId( rs.getInt( COLUMN_VIEW_STORE_ID ) );
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(KardexDetailDto dto)
	{
	}

	/** 
	 * Returns all rows from the kardex_detail table that match the specified arbitrary SQL statement
	 */
	public KardexDetailDto[] findByDynamicSelect(String sql, Object[] sqlParams) throws KardexDetailDaoException
	{
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			// construct the SQL statement
			final String SQL = sql;
		
		
			System.out.println( "Executing " + SQL );
			// prepare statement
			stmt = conn.prepareStatement( SQL );
			stmt.setMaxRows( maxRows );
		
			// bind parameters
			for (int i=0; sqlParams!=null && i<sqlParams.length; i++ ) {
				stmt.setObject( i+1, sqlParams[i] );
			}
		
		
			rs = stmt.executeQuery();
		
			// fetch the results
			return fetchKardexDetailDto(rs);
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new KardexDetailDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns all rows from the kardex_detail table that match the specified arbitrary SQL statement
	 */
	public KardexDetailDto[] findByDynamicWhere(String sql, Object[] sqlParams) throws KardexDetailDaoException
	{
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			// construct the SQL statement
			final String SQL = SQL_SELECT + " WHERE " + sql;
		
		
			System.out.println( "Executing " + SQL );
			// prepare statement
			stmt = conn.prepareStatement( SQL );
			stmt.setMaxRows( maxRows );
		
			// bind parameters
			for (int i=0; sqlParams!=null && i<sqlParams.length; i++ ) {
				stmt.setObject( i+1, sqlParams[i] );
			}
		
		
			rs = stmt.executeQuery();
		
			// fetch the results
			return fetchKardexDetailDto(rs);
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new KardexDetailDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}
        
        /** 
	 * Returns the next available id for the next record
	 */
        public String findNextDetailId() throws KardexDetailDaoException
        {
            // declare variables
            final boolean isConnSupplied = (userConn != null);
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;

            try {
                // get the user-specified connection or get a connection from the ResourceManager
                conn = isConnSupplied ? userConn : ResourceManager.getConnection();

                // construct the SQL statement
                final String SQL = "SELECT LPAD((SELECT COUNT(*) + 1 FROM " + getTableName() + "), 6, '0') AS nextDetailId";

                System.out.println( "Executing " + SQL);
                stmt = conn.prepareStatement( SQL );

                rs = stmt.executeQuery();
                rs.next();

                return rs.getString(1);
            }
            catch (Exception _e) {
                throw new KardexDetailDaoException( "Exception: " + _e.getMessage(), _e );
            }
            finally {
                ResourceManager.close(rs);
                ResourceManager.close(stmt);
                if (!isConnSupplied) {
                    ResourceManager.close(conn);
                }

            }
        }
        
        public KardexDetailView[] getKardexDetailView(int productId, int storeId) throws KardexDaoException {
        // declare variables
        final boolean isConnSupplied = (userConn != null);
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // get the user-specified connection or get a connection from the ResourceManager
            conn = isConnSupplied ? userConn : ResourceManager.getConnection();

            // construct the SQL statement
            final String SQL = "SELECT * FROM bd_hulkstore.vi_kardexdetail WHERE productId = " + productId + " and storeId = " + storeId;


            System.out.println( "Executing " + SQL );
            // prepare statement
            stmt = conn.prepareStatement( SQL );
            stmt.setMaxRows( maxRows );

            rs = stmt.executeQuery();

            // fetch the results
            return fetchKardexDetailView(rs);
        }
        catch (Exception _e) {
                _e.printStackTrace();
                throw new KardexDaoException( "Exception: " + _e.getMessage(), _e );
        }
        finally {
                ResourceManager.close(rs);
                ResourceManager.close(stmt);
                if (!isConnSupplied) {
                        ResourceManager.close(conn);
                }

        }
    }

}
