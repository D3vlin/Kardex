package com.cidenet.hulkstore.stores;

import com.cidenet.hulkstore.jdbc.AbstractDAO;
import com.cidenet.hulkstore.jdbc.ResourceManager;
import java.sql.Connection;
import java.util.Collection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public final class StoreDaoImpl extends AbstractDAO implements StoreDao
{
	/** 
	 * The factory class for this DAO has two versions of the create() method - one that
         * takes no arguments and one that takes a Connection argument. If the Connection version
         * is chosen then the connection will be stored in this attribute and will be used by all
         * calls to this DAO, otherwise a new Connection will be allocated for each operation.
	 */
	protected java.sql.Connection userConn;

	/** 
	 * All finder methods in this class use this SELECT constant to build their queries
	 */
	protected final String SQL_SELECT = "SELECT storeId, storeName, address, state FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( storeId, storeName, address, state ) VALUES ( ?, ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET storeId = ?, storeName = ?, address = ?, state = ? WHERE storeId = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE storeId = ?";

	/** 
	 * Index of column storeId
	 */
	protected static final int COLUMN_STORE_ID = 1;

	/** 
	 * Index of column storeName
	 */
	protected static final int COLUMN_STORE_NAME = 2;

	/** 
	 * Index of column address
	 */
	protected static final int COLUMN_ADDRESS = 3;

	/** 
	 * Index of column state
	 */
	protected static final int COLUMN_STATE = 4;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 4;

	/** 
	 * Index of primary-key column storeId
	 */
	protected static final int PK_COLUMN_STORE_ID = 1;

	/** 
	 * Inserts a new row in the store table.
	 */
	public StorePk insert(StoreDto dto) throws StoreDaoException
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
			stmt.setInt( index++, dto.getStoreId() );
			stmt.setString( index++, dto.getStoreName() );
			stmt.setString( index++, dto.getAddress() );
			stmt.setShort( index++, dto.getState() );
			System.out.println( "Executing " + SQL_INSERT + " with DTO: " + dto );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		
			// retrieve values from auto-increment columns
			rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				dto.setStoreId( rs.getInt( 1 ) );
			}
		
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new StoreDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the store table.
	 */
	public boolean update(StorePk pk, StoreDto dto) throws StoreDaoException
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
			stmt.setInt( index++, dto.getStoreId() );
			stmt.setString( index++, dto.getStoreName() );
			stmt.setString( index++, dto.getAddress() );
			stmt.setShort( index++, dto.getState() );
			stmt.setInt( 5, pk.getStoreId() );
			int rows = stmt.executeUpdate();
			reset(dto);
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
                        return true;
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new StoreDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the store table.
	 */
	public void delete(StorePk pk) throws StoreDaoException
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
			stmt.setInt( 1, pk.getStoreId() );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new StoreDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the store table that matches the specified primary-key value.
	 */
	public StoreDto findByPrimaryKey(StorePk pk) throws StoreDaoException
	{
		return findByPrimaryKey( pk.getStoreId() );
	}

	/** 
	 * Returns all rows from the store table that match the criteria 'storeId = :storeId'.
	 */
	public StoreDto findByPrimaryKey(int storeId) throws StoreDaoException
	{
		StoreDto ret[] = findByDynamicSelect( SQL_SELECT + " WHERE storeId = ?", new Object[] {  new Integer(storeId) } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the store table that match the criteria ''.
	 */
	public StoreDto[] findAll() throws StoreDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY state ASC, storeId ASC", null );
	}

	/** 
	 * Returns all rows from the store table that match the criteria 'storeId = :storeId'.
	 */
	public StoreDto[] findWhereStoreIdEquals(int storeId) throws StoreDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE storeId = ? ORDER BY storeId", new Object[] {  new Integer(storeId) } );
	}

	/** 
	 * Returns all rows from the store table that match the criteria 'storeName = :storeName'.
	 */
	public StoreDto[] findWhereStoreNameEquals(String storeName) throws StoreDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE storeName = ? ORDER BY storeName", new Object[] { storeName } );
	}

	/** 
	 * Returns all rows from the store table that match the criteria 'address = :address'.
	 */
	public StoreDto[] findWhereAddressEquals(String address) throws StoreDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE address = ? ORDER BY address", new Object[] { address } );
	}

	/** 
	 * Returns all rows from the store table that match the criteria 'state = :state'.
	 */
	public StoreDto[] findWhereStateEquals(short state) throws StoreDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE state = ? ORDER BY state", new Object[] {  new Short(state) } );
	}

	/**
	 * Method 'StoreDaoImpl'
	 * 
	 */
	public StoreDaoImpl()
	{
	}

	/**
	 * Method 'StoreDaoImpl'
	 * 
	 * @param userConn
	 */
	public StoreDaoImpl(final java.sql.Connection userConn)
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
		return "bd_hulkstore.store";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected StoreDto fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			StoreDto dto = new StoreDto();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected StoreDto[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			StoreDto dto = new StoreDto();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		StoreDto ret[] = new StoreDto[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(StoreDto dto, ResultSet rs) throws SQLException
	{
		dto.setStoreId( rs.getInt( COLUMN_STORE_ID ) );
		dto.setStoreName( rs.getString( COLUMN_STORE_NAME ) );
		dto.setAddress( rs.getString( COLUMN_ADDRESS ) );
		dto.setState( rs.getShort( COLUMN_STATE ) );
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(StoreDto dto)
	{
	}

	/** 
	 * Returns all rows from the store table that match the specified arbitrary SQL statement
	 */
	public StoreDto[] findByDynamicSelect(String sql, Object[] sqlParams) throws StoreDaoException
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
			throw new StoreDaoException( "Exception: " + _e.getMessage(), _e );
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
	 * Returns all rows from the store table that match the specified arbitrary SQL statement
	 */
	public StoreDto[] findByDynamicWhere(String sql, Object[] sqlParams) throws StoreDaoException
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
			throw new StoreDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

    @Override
    public String findNextStoreId() throws StoreDaoException {
        // declare variables
        final boolean isConnSupplied = (userConn != null);
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // get the user-specified connection or get a connection from the ResourceManager
            conn = isConnSupplied ? userConn : ResourceManager.getConnection();
            
            // construct the SQL statement
            final String SQL = "SELECT LPAD((SELECT COUNT(*) + 1 FROM " + getTableName() + "), 6, '0') AS nextStoredId";
            
            System.out.println( "Executing " + SQL);
            stmt = conn.prepareStatement( SQL );

            rs = stmt.executeQuery();
            rs.next();
            
            return rs.getString(1);
        }
        catch (Exception _e) {
            _e.printStackTrace();
            throw new StoreDaoException( "Exception: " + _e.getMessage(), _e );
        }
        finally {
            ResourceManager.close(rs);
            ResourceManager.close(stmt);
            if (!isConnSupplied) {
                ResourceManager.close(conn);
            }

        }
    }

    @Override
    public StoreDto[] getStoreView() throws StoreDaoException {
        // declare variables
        final boolean isConnSupplied = (userConn != null);
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
                // get the user-specified connection or get a connection from the ResourceManager
                conn = isConnSupplied ? userConn : ResourceManager.getConnection();

                // construct the SQL statement
                final String SQL = "SELECT * FROM bd_hulkstore.vi_store";


                System.out.println( "Executing " + SQL );
                // prepare statement
                stmt = conn.prepareStatement( SQL );
                stmt.setMaxRows( maxRows );

                rs = stmt.executeQuery();

                // fetch the results
                return fetchMultiResults(rs);
        }
        catch (Exception _e) {
                _e.printStackTrace();
                throw new StoreDaoException( "Exception: " + _e.getMessage(), _e );
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
