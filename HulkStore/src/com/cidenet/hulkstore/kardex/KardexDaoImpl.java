package com.cidenet.hulkstore.kardex;

import com.cidenet.hulkstore.jdbc.AbstractDAO;
import com.cidenet.hulkstore.jdbc.ResourceManager;
import java.sql.Connection;
import java.util.Collection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class KardexDaoImpl extends AbstractDAO implements KardexDao
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
	protected final String SQL_SELECT = "SELECT productId, storeId, quantity, unityValue, totalValue, state FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( productId, storeId, quantity, unityValue, totalValue, state ) VALUES ( ?, ?, ?, ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET productId = ?, storeId = ?, quantity = ?, unityValue = ?, totalValue = ?, state = ? WHERE productId = ? AND storeId = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE productId = ? AND storeId = ?";

	/** 
	 * Index of column productId
	 */
	protected static final int COLUMN_PRODUCT_ID = 1;

	/** 
	 * Index of column storeId
	 */
	protected static final int COLUMN_STORE_ID = 2;

	/** 
	 * Index of column quantity
	 */
	protected static final int COLUMN_QUANTITY = 3;

	/** 
	 * Index of column unityValue
	 */
	protected static final int COLUMN_UNITY_VALUE = 4;

	/** 
	 * Index of column totalValue
	 */
	protected static final int COLUMN_TOTAL_VALUE = 5;

	/** 
	 * Index of column state
	 */
	protected static final int COLUMN_STATE = 6;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 6;

	/** 
	 * Index of primary-key column productId
	 */
	protected static final int PK_COLUMN_PRODUCT_ID = 1;

	/** 
	 * Index of primary-key column storeId
	 */
	protected static final int PK_COLUMN_STORE_ID = 2;

	/** 
	 * Inserts a new row in the kardex table.
	 */
	public KardexPk insert(KardexDto dto) throws KardexDaoException
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
		
			stmt = conn.prepareStatement( SQL_INSERT );
			int index = 1;
			stmt.setInt( index++, dto.getProductId() );
			stmt.setInt( index++, dto.getStoreId() );
			stmt.setDouble( index++, dto.getQuantity() );
			stmt.setDouble( index++, dto.getUnityValue() );
			if (dto.isTotalValueNull()) {
				stmt.setNull( index++, java.sql.Types.DOUBLE );
			} else {
				stmt.setDouble( index++, dto.getTotalValue() );
			}
		
			stmt.setShort( index++, dto.getState() );
			System.out.println( "Executing " + SQL_INSERT + " with DTO: " + dto );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
                        _e.printStackTrace();
			throw new KardexDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the kardex table.
	 */
	public void update(KardexPk pk, KardexDto dto) throws KardexDaoException
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
			stmt.setInt( index++, dto.getProductId() );
			stmt.setInt( index++, dto.getStoreId() );
			stmt.setDouble( index++, dto.getQuantity() );
			stmt.setDouble( index++, dto.getUnityValue() );
			if (dto.isTotalValueNull()) {
				stmt.setNull( index++, java.sql.Types.DOUBLE );
			} else {
				stmt.setDouble( index++, dto.getTotalValue() );
			}
		
			stmt.setShort( index++, dto.getState() );
			stmt.setInt( 7, pk.getProductId() );
			stmt.setInt( 8, pk.getStoreId() );
			int rows = stmt.executeUpdate();
			reset(dto);
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new KardexDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the kardex table.
	 */
	public void delete(KardexPk pk) throws KardexDaoException
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
			stmt.setInt( 1, pk.getProductId() );
			stmt.setInt( 2, pk.getStoreId() );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new KardexDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the kardex table that matches the specified primary-key value.
	 */
	public KardexDto findByPrimaryKey(KardexPk pk) throws KardexDaoException
	{
		return findByPrimaryKey( pk.getProductId(), pk.getStoreId() );
	}

	/** 
	 * Returns all rows from the kardex table that match the criteria 'productId = :productId AND storeId = :storeId'.
	 */
	public KardexDto findByPrimaryKey(int productId, int storeId) throws KardexDaoException
	{
		KardexDto ret[] = findByDynamicSelect( SQL_SELECT + " WHERE productId = ? AND storeId = ?", new Object[] {  new Integer(productId),  new Integer(storeId) } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the kardex table that match the criteria ''.
	 */
	public KardexDto[] findAll() throws KardexDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY productId, storeId", null );
	}

	/** 
	 * Returns all rows from the kardex table that match the criteria 'productId = :productId'.
	 */
	public KardexDto[] findByProduct(int productId) throws KardexDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE productId = ?", new Object[] {  new Integer(productId) } );
	}

	/** 
	 * Returns all rows from the kardex table that match the criteria 'storeId = :storeId'.
	 */
	public KardexDto[] findByStore(int storeId) throws KardexDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE storeId = ?", new Object[] {  new Integer(storeId) } );
	}

	/** 
	 * Returns all rows from the kardex table that match the criteria 'productId = :productId'.
	 */
	public KardexDto[] findWhereProductIdEquals(int productId) throws KardexDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE productId = ? ORDER BY productId", new Object[] {  new Integer(productId) } );
	}

	/** 
	 * Returns all rows from the kardex table that match the criteria 'storeId = :storeId'.
	 */
	public KardexDto[] findWhereStoreIdEquals(int storeId) throws KardexDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE storeId = ? ORDER BY storeId", new Object[] {  new Integer(storeId) } );
	}

	/** 
	 * Returns all rows from the kardex table that match the criteria 'quantity = :quantity'.
	 */
	public KardexDto[] findWhereQuantityEquals(double quantity) throws KardexDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE quantity = ? ORDER BY quantity", new Object[] {  new Double(quantity) } );
	}

	/** 
	 * Returns all rows from the kardex table that match the criteria 'unityValue = :unityValue'.
	 */
	public KardexDto[] findWhereUnityValueEquals(double unityValue) throws KardexDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE unityValue = ? ORDER BY unityValue", new Object[] {  new Double(unityValue) } );
	}

	/** 
	 * Returns all rows from the kardex table that match the criteria 'totalValue = :totalValue'.
	 */
	public KardexDto[] findWhereTotalValueEquals(double totalValue) throws KardexDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE totalValue = ? ORDER BY totalValue", new Object[] {  new Double(totalValue) } );
	}

	/** 
	 * Returns all rows from the kardex table that match the criteria 'state = :state'.
	 */
	public KardexDto[] findWhereStateEquals(short state) throws KardexDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE state = ? ORDER BY state", new Object[] {  new Short(state) } );
	}

	/**
	 * Method 'KardexDaoImpl'
	 * 
	 */
	public KardexDaoImpl()
	{
	}

	/**
	 * Method 'KardexDaoImpl'
	 * 
	 * @param userConn
	 */
	public KardexDaoImpl(final java.sql.Connection userConn)
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
		return "bd_hulkstore.kardex";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected KardexDto fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			KardexDto dto = new KardexDto();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected KardexDto[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			KardexDto dto = new KardexDto();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		KardexDto ret[] = new KardexDto[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(KardexDto dto, ResultSet rs) throws SQLException
	{
		dto.setProductId( rs.getInt( COLUMN_PRODUCT_ID ) );
		dto.setStoreId( rs.getInt( COLUMN_STORE_ID ) );
		dto.setQuantity( rs.getDouble( COLUMN_QUANTITY ) );
		dto.setUnityValue( rs.getDouble( COLUMN_UNITY_VALUE ) );
		dto.setTotalValue( rs.getDouble( COLUMN_TOTAL_VALUE ) );
		if (rs.wasNull()) {
			dto.setTotalValueNull( true );
		}
		
		dto.setState( rs.getShort( COLUMN_STATE ) );
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(KardexDto dto)
	{
	}

	/** 
	 * Returns all rows from the kardex table that match the specified arbitrary SQL statement
	 */
	public KardexDto[] findByDynamicSelect(String sql, Object[] sqlParams) throws KardexDaoException
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
			return fetchMultiResults(rs);
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

	/** 
	 * Returns all rows from the kardex table that match the specified arbitrary SQL statement
	 */
	public KardexDto[] findByDynamicWhere(String sql, Object[] sqlParams) throws KardexDaoException
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
			return fetchMultiResults(rs);
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
