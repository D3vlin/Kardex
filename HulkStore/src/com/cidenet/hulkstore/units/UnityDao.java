package com.cidenet.hulkstore.units;

import com.cidenet.hulkstore.jdbc.AbstractDAO;
import com.cidenet.hulkstore.jdbc.ResourceManager;
import java.sql.Connection;
import java.util.Collection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/** 
 * This class handles queries to the unity table.
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-18
 */
public final class UnityDao extends AbstractDAO
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
    protected final String SQL_SELECT = "SELECT unityId, unityDescription, state FROM " + getTableName() + "";

    /** 
     * Finder methods will pass this value to the JDBC setMaxRows method.
     */
    protected int maxRows;

    /** 
     * SQL INSERT statement for this table.
     */
    protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( unityId, unityDescription, state ) VALUES ( ?, ?, ? )";

    /** 
     * SQL UPDATE statement for this table.
     */
    protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET unityId = ?, unityDescription = ?, state = ? WHERE unityId = ?";
    
    /** 
     * SQL DELETE statement for this table
     */
    protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE unityId = ?";

    /** 
     * Indexes of the columns in the unity table.
     */
    protected static final int COLUMN_UNITY_ID = 1;
    protected static final int COLUMN_UNITY_DESCRIPTION = 2;
    protected static final int COLUMN_STATE = 3;

    /** 
     * Number of columns.
     */
    protected static final int NUMBER_OF_COLUMNS = 3;

    /** 
     * Index of primary-key column unityId.
     */
    protected static final int PK_COLUMN_UNITY_ID = 1;

    /** 
     * Inserts a new row in the unity table.
     * 
     * @param unityDto
     * @return UnityPk
     * @throws com.cidenet.hulkstore.units.UnityDaoException 
     */
    public UnityPk insert(UnityDto unityDto) throws UnityDaoException
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
            statement.setInt( index++, unityDto.getUnityId() );
            statement.setString( index++, unityDto.getUnityDescription() );
            statement.setShort( index++, unityDto.getState() );
            System.out.println( "Executing " + SQL_INSERT + " with DTO: " + unityDto );
            int rows = statement.executeUpdate();
            long t2 = System.currentTimeMillis();
            System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );

            // retrieve values from auto-increment columns
            resultSet = statement.getGeneratedKeys();
            if (resultSet != null && resultSet.next()) {
                unityDto.setUnityId( resultSet.getInt( 1 ) );
            }

            reset(unityDto);
            return unityDto.createPk();
            
        } catch (Exception exception) { throw new UnityDaoException( "Exception: " + exception.getMessage(), exception );
        
        } finally {
            ResourceManager.close(statement);
            if (!isConnSupplied) { ResourceManager.close(connection); }
        }
    }

    /** 
     * Updates a single row in the unity table.
     * 
     * @param unityPk
     * @param unityDto
     * @return boolean
     * @throws com.cidenet.hulkstore.units.UnityDaoException
     */
    public boolean update(UnityPk unityPk, UnityDto unityDto) throws UnityDaoException
    {
        // declare variables
        long t1 = System.currentTimeMillis();
        final boolean isConnSupplied = (userConn != null);
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // get the user-specified connection or get a connection from the ResourceManager
            connection = isConnSupplied ? userConn : ResourceManager.getConnection();

            System.out.println( "Executing " + SQL_UPDATE + " with DTO: " + unityDto );
            statement = connection.prepareStatement( SQL_UPDATE );
            int index=1;
            statement.setInt( index++, unityDto.getUnityId() );
            statement.setString( index++, unityDto.getUnityDescription() );
            statement.setShort( index++, unityDto.getState() );
            statement.setInt( index++, unityPk.getUnityId() );
            int rows = statement.executeUpdate();
            reset(unityDto);
            long t2 = System.currentTimeMillis();
            System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
            
            return rows > 0;
        
        } catch (Exception exception) { throw new UnityDaoException( "Exception: " + exception.getMessage(), exception );
        
        } finally {
            ResourceManager.close(statement);
            if (!isConnSupplied) { ResourceManager.close(connection); }
        }
    }
    
    /** 
     * Deletes a single row in the unity table.
     * 
     * @param unityPk
     * @return boolean
     * @throws com.cidenet.hulkstore.units.UnityDaoException
     */
    public boolean delete(UnityPk unityPk) throws UnityDaoException
    {
        // declare variables
        long t1 = System.currentTimeMillis();
        final boolean isConnSupplied = (userConn != null);
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // get the user-specified connection or get a connection from the ResourceManager
            connection = isConnSupplied ? userConn : ResourceManager.getConnection();

            System.out.println( "Executing " + SQL_DELETE + " with PK: " + unityPk );
            statement = connection.prepareStatement( SQL_DELETE );
            statement.setInt( 1, unityPk.getUnityId() );
            int rows = statement.executeUpdate();
            long t2 = System.currentTimeMillis();
            System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
            
            return rows > 0;
        
        } catch (Exception exception) { throw new UnityDaoException( "Exception: " + exception.getMessage(), exception );
        
        } finally {
            ResourceManager.close(statement);
            if (!isConnSupplied) { ResourceManager.close(connection); }
        }
   }

    /** 
     * Returns the rows from the unity table that matches the specified primary-key value.
     * 
     * @param unityPk
     * @return UnityDto
     * @throws com.cidenet.hulkstore.units.UnityDaoException
     */
    public UnityDto findByPrimaryKey(UnityPk unityPk) throws UnityDaoException
    {
        return findByPrimaryKey( unityPk.getUnityId() );
    }

    /** 
     * Returns all rows from the unity table that match the criteria 'unityId = :unityId'.
     * 
     * @param unityId
     * @return UnityDto
     * @throws com.cidenet.hulkstore.units.UnityDaoException
     */
    public UnityDto findByPrimaryKey(int unityId) throws UnityDaoException
    {
        UnityDto ret[] = findByDynamicSelect( SQL_SELECT + " WHERE unityId = ?", new Object[] {unityId} );
        return ret.length==0 ? null : ret[0];
    }

    /** 
     * Returns all rows from the unity table that match the criteria ''.
     * 
     * @return UnityDto[]
     * @throws com.cidenet.hulkstore.units.UnityDaoException
     */
    public UnityDto[] findAll() throws UnityDaoException
    {
        return findByDynamicSelect( SQL_SELECT + " ORDER BY unityId", null );
    }

    /** 
     * Returns all rows from the unity table that match the criteria 'state = :state'.
     * 
     * @param state
     * @return UnityDto[]
     * @throws com.cidenet.hulkstore.units.UnityDaoException
     */
    public UnityDto[] findWhereStateEquals(short state) throws UnityDaoException
    {
        return findByDynamicSelect( SQL_SELECT + " WHERE state = ? ORDER BY state", new Object[] {state} );
    }

    /**
     * Empty Constructor.
     * 
     */
    public UnityDao() {}

    /**
     * Constructor.
     * 
     * @param userConn
     */
    public UnityDao(final java.sql.Connection userConn) { this.userConn = userConn; }

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
    public String getTableName() { return "bd_hulkstore.unity"; }

    /** 
     * Fetches a single row from the result set.
     * 
     * @param resultSet
     * @return UnityDto
     * @throws java.sql.SQLException
     */
    protected UnityDto fetchSingleResult(ResultSet resultSet) throws SQLException
    {
        if (resultSet.next()) {
                UnityDto unityDto = new UnityDto();
                populateDto( unityDto, resultSet);
                return unityDto;
                
        } else { return null; }
    }

    /** 
     * Fetches multiple rows from the result set.
     * 
     * @param resultSet
     * @return UnityDto[]
     * @throws java.sql.SQLException
     */
    protected UnityDto[] fetchMultiResults(ResultSet resultSet) throws SQLException
    {
        Collection resultList = new ArrayList();
        while (resultSet.next()) 
        {
            UnityDto unityDto = new UnityDto();
            populateDto( unityDto, resultSet);
            resultList.add( unityDto );
        }

        UnityDto respose[] = new UnityDto[ resultList.size() ];
        resultList.toArray( respose );
        return respose;
    }

    /** 
     * Populates a DTO with data from a ResultSet.
     * 
     * @param unityDto
     * @param resultSet
     * @throws java.sql.SQLException
     */
    protected void populateDto(UnityDto unityDto, ResultSet resultSet) throws SQLException
    {
        unityDto.setUnityId( resultSet.getInt( COLUMN_UNITY_ID ) );
        unityDto.setUnityDescription( resultSet.getString( COLUMN_UNITY_DESCRIPTION ) );
        unityDto.setState( resultSet.getShort( COLUMN_STATE ) );
    }

    /** 
     * Resets the modified attributes in the DTO.
     * 
     * @param unityDto
     */
    protected void reset(UnityDto unityDto) {}

    /** 
     * Returns all rows from the unity table that match the specified arbitrary SQL statement.
     * 
     * @param sql
     * @param sqlParams
     * @return UnityDto[]
     * @throws com.cidenet.hulkstore.units.UnityDaoException
     */
    public UnityDto[] findByDynamicSelect(String sql, Object[] sqlParams) throws UnityDaoException
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
            
        } catch (Exception exception) { throw new UnityDaoException( "Exception: " + exception.getMessage(), exception );
        
        } finally {
            ResourceManager.close(resultSet);
            ResourceManager.close(statement);
            if (!isConnSupplied) { ResourceManager.close(connection); }
        }
    }

    /** 
     * Returns all rows from the unity table that match the specified arbitrary SQL statement.
     * 
     * @param sql
     * @param sqlParams
     * @return UnityDto[]
     * @throws com.cidenet.hulkstore.units.UnityDaoException
     */
    public UnityDto[] findByDynamicWhere(String sql, Object[] sqlParams) throws UnityDaoException
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
            
        } catch (Exception exception) { throw new UnityDaoException( "Exception: " + exception.getMessage(), exception );
        
        } finally {
            ResourceManager.close(resultSet);
            ResourceManager.close(statement);
            if (!isConnSupplied) { ResourceManager.close(connection); }
        }
    }

    /**
     * Returns the next available id for the next unity.
     * 
     * @return String
     * @throws UnityDaoException 
     */
    public String findNextUnityId() throws UnityDaoException {
        // declare variables
        final boolean isConnSupplied = (userConn != null);
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // get the user-specified connection or get a connection from the ResourceManager
            connection = isConnSupplied ? userConn : ResourceManager.getConnection();
            
            // construct the SQL statement
            final String SQL = "SELECT LPAD((SELECT COUNT(*) + 1 FROM " + getTableName() + "), 6, '0') AS nextUnityId";
            
            System.out.println( "Executing " + SQL);
            statement = connection.prepareStatement( SQL );

            resultSet = statement.executeQuery();
            resultSet.next();
            
            return resultSet.getString(1);
            
        } catch (Exception exception) { throw new UnityDaoException( "Exception: " + exception.getMessage(), exception );
        
        } finally {
            ResourceManager.close(resultSet);
            ResourceManager.close(statement);
            if (!isConnSupplied) { ResourceManager.close(connection); }
        }
    }
}