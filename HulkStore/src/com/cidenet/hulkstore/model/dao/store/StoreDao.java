package com.cidenet.hulkstore.model.dao.store;

import com.cidenet.hulkstore.model.dao.AbstractDao;
import com.cidenet.hulkstore.model.dao.ResourceManager;
import com.cidenet.hulkstore.model.dto.store.StoreDto;
import com.cidenet.hulkstore.model.dto.store.StorePk;
import java.sql.Connection;
import java.util.Collection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/** 
 * This class handles queries to the store table.
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-12
 */
public final class StoreDao extends AbstractDao
{
    /** 
     * The factory class for this DAO has two versions of the create() method - one that
     * takes no arguments and one that takes a Connection argument. If the Connection version
     * is chosen then the connection will be stored in this attribute and will be used by all
     * calls to this DAO, otherwise a new Connection will be allocated for each operation.
     */
    protected java.sql.Connection userConn;

    /** 
     * All finder methods in this class use this SELECT constant to build their queries.
     */
    protected final String SQL_SELECT = "SELECT storeId, storeName, address, state FROM " + getTableName() + "";

    /** 
     * Finder methods will pass this value to the JDBC setMaxRows method.
     */
    protected int maxRows;

    /** 
     * SQL INSERT statement for this table.
     */
    protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( storeId, storeName, address, state ) VALUES ( ?, ?, ?, ? )";

    /** 
     * SQL UPDATE statement for this table.
     */
    protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET storeId = ?, storeName = ?, address = ?, state = ? WHERE storeId = ?";
    
    /** 
     * SQL DELETE statement for this table
     */
    protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE storeId = ?";

    /** 
     * Indexes of the columns in the store table.
     */
    protected static final int COLUMN_STORE_ID = 1;
    protected static final int COLUMN_STORE_NAME = 2;
    protected static final int COLUMN_ADDRESS = 3;
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
     * @param storeDto
     * @return StorePk
     * @throws com.cidenet.hulkstore.model.dao.store.StoreDaoException
     */
    public StorePk insert(StoreDto storeDto) throws StoreDaoException
    {
        // declare variables
        long t1 = System.currentTimeMillis();
        final boolean isConnSupplied = (userConn != null);
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet;

        try {
            // get the user-specified connection or get a connection from the ResourceManager
            connection = isConnSupplied ? userConn : ResourceManager.getConnection();

            statement = connection.prepareStatement( SQL_INSERT, Statement.RETURN_GENERATED_KEYS );
            int index = 1;
            statement.setInt( index++, storeDto.getStoreId() );
            statement.setString( index++, storeDto.getStoreName() );
            statement.setString( index++, storeDto.getAddress() );
            statement.setShort( index++, storeDto.getState() );
            System.out.println( "Executing " + SQL_INSERT + " with DTO: " + storeDto );
            int rows = statement.executeUpdate();
            long t2 = System.currentTimeMillis();
            System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );

            // retrieve values from auto-increment columns
            resultSet = statement.getGeneratedKeys();
            if (resultSet != null && resultSet.next()) {
                storeDto.setStoreId( resultSet.getInt( 1 ) );
            }

            reset(storeDto);
            return storeDto.createPk();
        
        } catch (Exception exception) { throw new StoreDaoException( "Exception: " + exception.getMessage(), exception ); 
        
        } finally {
            ResourceManager.close(statement);
            if (!isConnSupplied) { ResourceManager.close(connection); }
        }
    }

    /** 
     * Updates a single row in the store table.
     * @param storePk
     * @param storeDto
     * @return boolean
     * @throws com.cidenet.hulkstore.model.dao.store.StoreDaoException
     */
    public boolean update(StorePk storePk, StoreDto storeDto) throws StoreDaoException
    {
        // declare variables
        long t1 = System.currentTimeMillis();
        final boolean isConnSupplied = (userConn != null);
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // get the user-specified connection or get a connection from the ResourceManager
            connection = isConnSupplied ? userConn : ResourceManager.getConnection();

            System.out.println( "Executing " + SQL_UPDATE + " with DTO: " + storeDto );
            statement = connection.prepareStatement( SQL_UPDATE );
            int index=1;
            statement.setInt( index++, storeDto.getStoreId() );
            statement.setString( index++, storeDto.getStoreName() );
            statement.setString( index++, storeDto.getAddress() );
            statement.setShort( index++, storeDto.getState() );
            statement.setInt( 5, storePk.getStoreId() );
            int rows = statement.executeUpdate();
            reset(storeDto);
            long t2 = System.currentTimeMillis();
            System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
            
            return rows > 0;
            
        } catch (Exception exception) { throw new StoreDaoException( "Exception: " + exception.getMessage(), exception );
        
        } finally {
            ResourceManager.close(statement);
            if (!isConnSupplied) { ResourceManager.close(connection); }
        }
    }

    /** 
     * Deletes a single row in the store table.
     * 
     * @param storePk
     * @return boolean
     * @throws com.cidenet.hulkstore.model.dao.store.StoreDaoException
     */
    public boolean delete(StorePk storePk) throws StoreDaoException
    {
        // declare variables
        long t1 = System.currentTimeMillis();
        final boolean isConnSupplied = (userConn != null);
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // get the user-specified connection or get a connection from the ResourceManager
            connection = isConnSupplied ? userConn : ResourceManager.getConnection();

            System.out.println( "Executing " + SQL_DELETE + " with PK: " + storePk );
            statement = connection.prepareStatement( SQL_DELETE );
            statement.setInt( 1, storePk.getStoreId() );
            int rows = statement.executeUpdate();
            long t2 = System.currentTimeMillis();
            System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
            
            return rows > 0;
        
        } catch (Exception exception) { throw new StoreDaoException( "Exception: " + exception.getMessage(), exception );
        
        } finally {
            ResourceManager.close(statement);
            if (!isConnSupplied) { ResourceManager.close(connection); }
        }

    }

    /** 
     * Returns the rows from the store table that matches the specified primary-key value.
     * 
     * @param storePk
     * @return StoreDto
     * @throws com.cidenet.hulkstore.model.dao.store.StoreDaoException
     */
    public StoreDto findByPrimaryKey(StorePk storePk) throws StoreDaoException
    {
        return findByPrimaryKey( storePk.getStoreId() );
    }

    /** 
     * Returns all rows from the store table that match the criteria 'storeId = :storeId'.
     * 
     * @param storeId
     * @return StoreDto
     * @throws com.cidenet.hulkstore.model.dao.store.StoreDaoException
     */
    public StoreDto findByPrimaryKey(int storeId) throws StoreDaoException
    {
        StoreDto ret[] = findByDynamicSelect( SQL_SELECT + " WHERE storeId = ?", new Object[] {storeId} );
        return ret.length==0 ? null : ret[0];
    }

    /** 
     * Returns all rows from the store table that match the criteria ''.
     * 
     * @return StoreDto[]
     * @throws com.cidenet.hulkstore.model.dao.store.StoreDaoException
     */
    public StoreDto[] findAll() throws StoreDaoException
    {
        return findByDynamicSelect( SQL_SELECT + " ORDER BY state ASC, storeId ASC", null );
    }

    /**
     * Empty Constructor.
     */
    public StoreDao() {}

    /**
     * Constructor.
     * 
     * @param userConn
     */
    public StoreDao(final java.sql.Connection userConn) { this.userConn = userConn; }

    /** 
     * Sets the value of maxRows.
     * 
     * @param maxRows
     */
    public void setMaxRows(int maxRows) { this.maxRows = maxRows; }

    /** 
     * Gets the value of maxRows.
     * 
     * @return int
     */
    public int getMaxRows() { return maxRows; }

    /**
     * Returns the name of the table.
     * 
     * @return String
     */
    public String getTableName() { return "bd_hulkstore.store"; }

    /** 
     * Fetches a single row from the result set.
     * 
     * @param resultSet
     * @return StoreDto
     * @throws java.sql.SQLException
     */
    protected StoreDto fetchSingleResult(ResultSet resultSet) throws SQLException
    {
        if (resultSet.next()) {
            StoreDto storeDto = new StoreDto();
            populateDto( storeDto, resultSet);
            return storeDto;
            
        } else { return null; }
    }

    /** 
     * Fetches multiple rows from the result set.
     * 
     * @param resultSet
     * @return StoreDto[]
     * @throws java.sql.SQLException
     */
    protected StoreDto[] fetchMultiResults(ResultSet resultSet) throws SQLException
    {
        Collection resultList = new ArrayList();
        while (resultSet.next()) {
            StoreDto storeDto = new StoreDto();
            populateDto( storeDto, resultSet);
            resultList.add( storeDto );
        }

        StoreDto response[] = new StoreDto[ resultList.size() ];
        resultList.toArray( response );
        return response;
    }

    /** 
     * Populates a DTO with data from a ResultSet.
     * 
     * @param storeDto
     * @param resultSet
     * @throws java.sql.SQLException
     */
    protected void populateDto(StoreDto storeDto, ResultSet resultSet) throws SQLException
    {
        storeDto.setStoreId( resultSet.getInt( COLUMN_STORE_ID ) );
        storeDto.setStoreName( resultSet.getString( COLUMN_STORE_NAME ) );
        storeDto.setAddress( resultSet.getString( COLUMN_ADDRESS ) );
        storeDto.setState( resultSet.getShort( COLUMN_STATE ) );
    }

    /** 
     * Resets the modified attributes in the DTO.
     * 
     * @param storeDto
     */
    protected void reset(StoreDto storeDto) {}

    /** 
     * Returns all rows from the store table that match the specified arbitrary SQL statement.
     * 
     * @param sql
     * @param sqlParams
     * @return StoreDto[]
     * @throws com.cidenet.hulkstore.model.dao.store.StoreDaoException
     */
    public StoreDto[] findByDynamicSelect(String sql, Object[] sqlParams) throws StoreDaoException
    {
        // declare variables
        final boolean isConnSupplied = (userConn != null);
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // get the user-specified connection or get a connection from the ResourceManager
            connection = isConnSupplied ? userConn : ResourceManager.getConnection();

            System.out.println( "Executing " + sql );
            // prepare statement
            statement = connection.prepareStatement( sql );
            statement.setMaxRows( maxRows );

            // bind parameters
            for (int i=0; sqlParams!=null && i<sqlParams.length; i++ ) {
                    statement.setObject( i+1, sqlParams[i] );
            }

            resultSet = statement.executeQuery();

            // fetch the results
            return fetchMultiResults(resultSet);
            
        } catch (Exception exception) { throw new StoreDaoException( "Exception: " + exception.getMessage(), exception );
        
        } finally {
            ResourceManager.close(resultSet);
            ResourceManager.close(statement);
            if (!isConnSupplied) { ResourceManager.close(connection); }
        }
    }

    /** 
     * Returns all rows from the store table that match the specified arbitrary SQL statement.
     * 
     * @param sql
     * @param sqlParams
     * @return StoreDto[]
     * @throws com.cidenet.hulkstore.model.dao.store.StoreDaoException
     */
    public StoreDto[] findByDynamicWhere(String sql, Object[] sqlParams) throws StoreDaoException
    {
        // declare variables
        final boolean isConnSupplied = (userConn != null);
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // get the user-specified connection or get a connection from the ResourceManager
            connection = isConnSupplied ? userConn : ResourceManager.getConnection();

            // construct the SQL statement
            final String SQL = SQL_SELECT + " WHERE " + sql;

            System.out.println( "Executing " + SQL );
            // prepare statement
            statement = connection.prepareStatement( SQL );
            statement.setMaxRows( maxRows );

            // bind parameters
            for (int i=0; sqlParams!=null && i<sqlParams.length; i++ ) {
                statement.setObject( i+1, sqlParams[i] );
            }

            resultSet = statement.executeQuery();

            // fetch the results
            return fetchMultiResults(resultSet);
            
        } catch (Exception exception) { throw new StoreDaoException( "Exception: " + exception.getMessage(), exception );
        
        } finally {
            ResourceManager.close(resultSet);
            ResourceManager.close(statement);
            if (!isConnSupplied) { ResourceManager.close(connection); }
        }
    }

    /**
     * Returns the next available id for the next store.
     * 
     * @return String
     * @throws StoreDaoException 
     */
    public String findNextStoreId() throws StoreDaoException {
        // declare variables
        final boolean isConnSupplied = (userConn != null);
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // get the user-specified connection or get a connection from the ResourceManager
            connection = isConnSupplied ? userConn : ResourceManager.getConnection();
            
            // construct the SQL statement
            final String SQL = "SELECT LPAD((SELECT COUNT(*) + 1 FROM " + getTableName() + "), 6, '0') AS nextStoredId";
            
            System.out.println( "Executing " + SQL);
            statement = connection.prepareStatement( SQL );

            resultSet = statement.executeQuery();
            resultSet.next();
            
            return resultSet.getString(1);
            
        } catch (Exception exception) { throw new StoreDaoException( "Exception: " + exception.getMessage(), exception );
        
        } finally {
            ResourceManager.close(resultSet);
            ResourceManager.close(statement);
            if (!isConnSupplied) { ResourceManager.close(connection); }
        }
    }

    /**
     * Returns all rows from the store view.
     * 
     * @return StoreDto[]
     * @throws StoreDaoException 
     */
    public StoreDto[] getViewStore() throws StoreDaoException {
        // declare variables
        final boolean isConnSupplied = (userConn != null);
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // get the user-specified connection or get a connection from the ResourceManager
            connection = isConnSupplied ? userConn : ResourceManager.getConnection();

            // construct the SQL statement
            final String SQL = "SELECT * FROM bd_hulkstore.vi_store";

            System.out.println( "Executing " + SQL );
            // prepare statement
            statement = connection.prepareStatement( SQL );
            statement.setMaxRows( maxRows );

            resultSet = statement.executeQuery();

            // fetch the results
            return fetchMultiResults(resultSet);
        
        } catch (Exception exception) { throw new StoreDaoException( "Exception: " + exception.getMessage(), exception );
        
        } finally {
            ResourceManager.close(resultSet);
            ResourceManager.close(statement);
            if (!isConnSupplied) { ResourceManager.close(connection); }
        }
    }
}