package com.cidenet.hulkstore.products;

import com.cidenet.hulkstore.jdbc.AbstractDAO;
import com.cidenet.hulkstore.jdbc.ResourceManager;
import java.sql.Connection;
import java.util.Collection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDaoImpl extends AbstractDAO implements ProductDao
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
	protected final String SQL_SELECT = "SELECT productId, productName, unityId, state FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( productId, productName, unityId, state ) VALUES ( ?, ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET productId = ?, productName = ?, unityId = ?, state = ? WHERE productId = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE productId = ?";

	/** 
	 * Index of column productId
	 */
	protected static final int COLUMN_PRODUCT_ID = 1;

	/** 
	 * Index of column productName
	 */
	protected static final int COLUMN_PRODUCT_NAME = 2;

	/** 
	 * Index of column unityId
	 */
	protected static final int COLUMN_UNITY_ID = 3;

	/** 
	 * Index of column unityDescription on view
	 */
	protected static final int COLUMN_VIEW_UNITY_DESCRIPTION = 3;

	/** 
	 * Index of column state
	 */
	protected static final int COLUMN_STATE = 4;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 4;

	/** 
	 * Index of primary-key column productId
	 */
	protected static final int PK_COLUMN_PRODUCT_ID = 1;

	/** 
	 * Inserts a new row in the product table.
	 */
	public ProductPk insert(ProductDto dto) throws ProductDaoException
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
			stmt.setInt( index++, dto.getProductId() );
			stmt.setString( index++, dto.getProductName() );
			if (dto.isUnityIdNull()) {
				stmt.setNull( index++, java.sql.Types.INTEGER );
			} else {
				stmt.setInt( index++, dto.getUnityId() );
			}
		
			stmt.setShort( index++, dto.getState() );
			System.out.println( "Executing " + SQL_INSERT + " with DTO: " + dto );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		
			// retrieve values from auto-increment columns
			rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				dto.setProductId( rs.getInt( 1 ) );
			}
		
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			throw new ProductDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the product table.
	 */
	public boolean update(ProductPk pk, ProductDto dto) throws ProductDaoException
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
			stmt.setString( index++, dto.getProductName() );
			if (dto.isUnityIdNull()) {
				stmt.setNull( index++, java.sql.Types.INTEGER );
			} else {
				stmt.setInt( index++, dto.getUnityId() );
			}
		
			stmt.setShort( index++, dto.getState() );
			stmt.setInt( 5, pk.getProductId() );
			int rows = stmt.executeUpdate();
			reset(dto);
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
                        return true;
		}
		catch (Exception _e) {
			throw new ProductDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the product table.
	 */
	public void delete(ProductPk pk) throws ProductDaoException
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
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			throw new ProductDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the product table that matches the specified primary-key value.
	 */
	public ProductDto findByPrimaryKey(ProductPk pk) throws ProductDaoException
	{
		return findByPrimaryKey( pk.getProductId() );
	}

	/** 
	 * Returns all rows from the product table that match the criteria 'productId = :productId'.
	 */
	public ProductDto findByPrimaryKey(int productId) throws ProductDaoException
	{
		ProductDto ret[] = findByDynamicSelect( SQL_SELECT + " WHERE productId = ?", new Object[] {  new Integer(productId) } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the product table that match the criteria ''.
	 */
	public ProductDto[] findAll() throws ProductDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY productId", null );
	}
        
        /** 
	 * Returns all rows from the product table that match the criteria 'unityId = :unityId'.
	 */
	public ProductDto[] findByUnity(int unityId) throws ProductDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE unityId = ?", new Object[] {  new Integer(unityId) } );
	}

	/** 
	 * Returns all rows from the product table that match the criteria 'productId = :productId'.
	 */
	public ProductDto[] findWhereProductIdEquals(int productId) throws ProductDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE productId = ? ORDER BY productId", new Object[] {  new Integer(productId) } );
	}

	/** 
	 * Returns all rows from the product table that match the criteria 'productName = :productName'.
	 */
	public ProductDto[] findWhereProductNameEquals(String productName) throws ProductDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE productName = ? ORDER BY productName", new Object[] { productName } );
	}

	/** 
	 * Returns all rows from the product table that match the criteria 'unityId = :unityId'.
	 */
	public ProductDto[] findWhereUnityIdEquals(int unityId) throws ProductDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE unityId = ? ORDER BY unityId", new Object[] {  new Integer(unityId) } );
	}

	/** 
	 * Returns all rows from the product table that match the criteria 'state = :state'.
	 */
	public ProductDto[] findWhereStateEquals(short state) throws ProductDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE state = ? ORDER BY state", new Object[] {  new Short(state) } );
	}

	/**
	 * Method 'ProductDaoImpl'
	 * 
	 */
	public ProductDaoImpl()
	{
	}

	/**
	 * Method 'ProductDaoImpl'
	 * 
	 * @param userConn
	 */
	public ProductDaoImpl(final java.sql.Connection userConn)
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
		return "bd_hulkstore.product";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected ProductDto fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			ProductDto dto = new ProductDto();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected ProductDto[] fetchMultiResults(ResultSet rs, boolean view) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			ProductDto dto = new ProductDto();
                        
                        if(view) {
                            populateViewDto( dto, rs);
                        } else {
                            populateDto( dto, rs);
                        }
			
			resultList.add( dto );
		}
		
		ProductDto ret[] = new ProductDto[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(ProductDto dto, ResultSet rs) throws SQLException
	{
		dto.setProductId( rs.getInt( COLUMN_PRODUCT_ID ) );
		dto.setProductName( rs.getString( COLUMN_PRODUCT_NAME ) );
		dto.setUnityId( rs.getInt( COLUMN_UNITY_ID ) );
		if (rs.wasNull()) {
			dto.setUnityIdNull( true );
		}
		
		dto.setState( rs.getShort( COLUMN_STATE ) );
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateViewDto(ProductDto dto, ResultSet rs) throws SQLException
	{
		dto.setProductId( rs.getInt( COLUMN_PRODUCT_ID ) );
		dto.setProductName( rs.getString( COLUMN_PRODUCT_NAME ) );
		dto.setUnityDescription( rs.getString( COLUMN_VIEW_UNITY_DESCRIPTION ) );
		if (rs.wasNull()) {
			dto.setUnityIdNull( true );
		}
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(ProductDto dto)
	{
	}

	/** 
	 * Returns all rows from the product table that match the specified arbitrary SQL statement
	 */
	public ProductDto[] findByDynamicSelect(String sql, Object[] sqlParams) throws ProductDaoException
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
			return fetchMultiResults(rs, false);
		}
		catch (Exception _e) {
			throw new ProductDaoException( "Exception: " + _e.getMessage(), _e );
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
	 * Returns all rows from the product table that match the specified arbitrary SQL statement
	 */
	public ProductDto[] findByDynamicWhere(String sql, Object[] sqlParams) throws ProductDaoException
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
			return fetchMultiResults(rs, false);
		}
		catch (Exception _e) {
			throw new ProductDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}
        
    public String findNextProductId() throws ProductDaoException {
        // declare variables
        final boolean isConnSupplied = (userConn != null);
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // get the user-specified connection or get a connection from the ResourceManager
            conn = isConnSupplied ? userConn : ResourceManager.getConnection();
            
            // construct the SQL statement
            final String SQL = "SELECT LPAD((SELECT COUNT(*) + 1 FROM " + getTableName() + "), 6, '0') AS nextProductId";
            
            System.out.println( "Executing " + SQL);
            stmt = conn.prepareStatement( SQL );

            rs = stmt.executeQuery();
            rs.next();
            
            return rs.getString(1);
        }
        catch (Exception _e) {
            throw new ProductDaoException( "Exception: " + _e.getMessage(), _e );
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
    public ProductDto[] getProductView() throws ProductDaoException {
        // declare variables
        final boolean isConnSupplied = (userConn != null);
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
                // get the user-specified connection or get a connection from the ResourceManager
                conn = isConnSupplied ? userConn : ResourceManager.getConnection();

                // construct the SQL statement
                final String SQL = "SELECT * FROM bd_hulkstore.vi_Product";


                System.out.println( "Executing " + SQL );
                // prepare statement
                stmt = conn.prepareStatement( SQL );
                stmt.setMaxRows( maxRows );

                rs = stmt.executeQuery();

                // fetch the results
                return fetchMultiResults(rs, true);
        }
        catch (Exception _e) {
                _e.printStackTrace();
                throw new ProductDaoException( "Exception: " + _e.getMessage(), _e );
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
