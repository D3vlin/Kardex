package com.cidenet.hulkstore.kardex;

import com.cidenet.hulkstore.jdbc.AbstractDAO;
import com.cidenet.hulkstore.jdbc.ResourceManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/** 
 * This class handles queries to the kardex table.
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-24
 */
public final class KardexDao extends AbstractDAO
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
    protected final String SQL_SELECT = "SELECT productId, storeId, quantity, unityValue, totalValue, state FROM " + getTableName() + "";

    /** 
     * Finder methods will pass this value to the JDBC setMaxRows method.
     */
    protected int maxRows;

    /** 
     * SQL INSERT statement for this table.
     */
    protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( productId, storeId, quantity, unityValue, totalValue, state ) VALUES ( ?, ?, ?, ?, ?, ? )";

    /** 
     * SQL UPDATE statement for this table.
     */
    protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET productId = ?, storeId = ?, quantity = ?, unityValue = ?, totalValue = ?, state = ? WHERE productId = ? AND storeId = ?";

    /** 
     * Indexes of the columns in the kardex table.
     */
    protected static final int COLUMN_PRODUCT_ID = 1;
    protected static final int COLUMN_STORE_ID = 2;
    protected static final int COLUMN_QUANTITY = 3;
    protected static final int COLUMN_UNITY_VALUE = 4;
    protected static final int COLUMN_TOTAL_VALUE = 5;
    protected static final int COLUMN_STATE = 6;

    /** 
     * Number of columns in the kardex table.
     */
    protected static final int NUMBER_OF_COLUMNS = 6;


    /** 
     * Index of primary-key column productId.
     */
    protected static final int PK_COLUMN_PRODUCT_ID = 1;

    /** 
     * Index of primary-key column storeId.
     */
    protected static final int PK_COLUMN_STORE_ID = 2;
    
    /** 
     * Indexes of the columns in the kardex view.
     */
    protected static final int COLUMN_VIEW_PRODUCT_ID = 1;
    protected static final int COLUMN_VIEW_PRODUCT_NAME = 2;
    protected static final int COLUMN_VIEW_UNITY_DESCRIPTION = 3;
    protected static final int COLUMN_VIEW_STORE_ID = 4;
    protected static final int COLUMN_VIEW_STORE_NAME = 5;
    protected static final int COLUMN_VIEW_QUANTITY = 6;
    protected static final int COLUMN_VIEW_UNITY_VALUE = 7;

    /** 
     * Number of columns in the vi_kardex view.
     */
    protected static final int KARDEX_VIEW_COLUMNS = 14;

    /** 
     * Inserts a new row in the kardex table.
     * 
     * @param kardexDto
     * @return KardexPk
     * @throws com.cidenet.hulkstore.kardex.KardexDaoException
     */
    public KardexPk insert(KardexDto kardexDto) throws KardexDaoException
    {
        // declare variables
        long t1 = System.currentTimeMillis();
        boolean isConnSupplied = (userConn != null);
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // get the user-specified connection or get a connection from the ResourceManager
            connection = isConnSupplied ? userConn : ResourceManager.getConnection();

            statement = connection.prepareStatement( SQL_INSERT );
            int index = 1;
            statement.setInt( index++, kardexDto.getProductId() );
            statement.setInt( index++, kardexDto.getStoreId() );
            statement.setDouble( index++, kardexDto.getQuantity() );
            statement.setDouble( index++, kardexDto.getUnityValue() );
            
            if (kardexDto.isTotalValueNull()) { statement.setNull( index++, java.sql.Types.DOUBLE ); } 
            else { statement.setDouble( index++, kardexDto.getTotalValue() ); }

            statement.setShort( index++, kardexDto.getState() );
            System.out.println( "Executing " + SQL_INSERT + " with DTO: " + kardexDto );
            int rows = statement.executeUpdate();
            long t2 = System.currentTimeMillis();
            System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
            reset(kardexDto);
            return kardexDto.createPk();
        
        } catch (Exception exception) { throw new KardexDaoException( "Exception: " + exception.getMessage(), exception );
        
        } finally {
            ResourceManager.close(statement);
            if (!isConnSupplied) { ResourceManager.close(connection); }
        }
    }

    /** 
     * Updates a single row in the kardex table.
     * 
     * @param kardexPk
     * @param kardexDto
     * @return boolean
     * @throws com.cidenet.hulkstore.kardex.KardexDaoException
     */
    public boolean update(KardexPk kardexPk, KardexDto kardexDto) throws KardexDaoException
    {
        long t1 = System.currentTimeMillis();
        // declare variables
        boolean isConnSupplied = (userConn != null);
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // get the user-specified connection or get a connection from the ResourceManager
            connection = isConnSupplied ? userConn : ResourceManager.getConnection();

            System.out.println( "Executing " + SQL_UPDATE + " with DTO: " + kardexDto );
            statement = connection.prepareStatement( SQL_UPDATE );
            int index=1;
            statement.setInt( index++, kardexDto.getProductId() );
            statement.setInt( index++, kardexDto.getStoreId() );
            statement.setDouble( index++, kardexDto.getQuantity() );
            statement.setDouble( index++, kardexDto.getUnityValue() );

            if (kardexDto.isTotalValueNull()) { statement.setNull( index++, java.sql.Types.DOUBLE ); }
            else { statement.setDouble( index++, kardexDto.getTotalValue() ); }

            statement.setShort( index++, kardexDto.getState() );
            statement.setInt( 7, kardexPk.getProductId() );
            statement.setInt( 8, kardexPk.getStoreId() );
            int rows = statement.executeUpdate();
            reset(kardexDto);
            long t2 = System.currentTimeMillis();
            System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
            return true;
            
        } catch (Exception _e) { throw new KardexDaoException( "Exception: " + _e.getMessage(), _e );
        
        } finally {
            ResourceManager.close(statement);
            if (!isConnSupplied) { ResourceManager.close(connection); }
        }
    }

    /** 
     * Returns all rows from the kardex table that match the criteria ''.
     * 
     * @return KardexDto
     * @throws com.cidenet.hulkstore.kardex.KardexDaoException
     */
    public KardexDto[] findAll() throws KardexDaoException
    {
        return findByDynamicSelect( SQL_SELECT + " ORDER BY productId, storeId", null );
    }

    /**
     * Empmty Constructor.
     * 
     */
    public KardexDao() {}

    /**
     * Constructor.
     * 
     * @param userConn
     */
    public KardexDao(final java.sql.Connection userConn) { this.userConn = userConn; }

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
    public String getTableName() { return "bd_hulkstore.kardex"; }

    /** 
     * Fetches multiple rows from the result set.
     * 
     * @param rs
     * @return KardexView
     * @throws java.sql.SQLException
     */
    protected KardexView[] fetchKardexView(ResultSet rs) throws SQLException
    {
        ArrayList resultList = fetchMultiResults(rs, true);   
        KardexView kardexView[] = new KardexView[ resultList.size() ];
        resultList.toArray( kardexView );
        return kardexView;
    }

    /** 
     * Fetches multiple rows from the result set.
     * 
     * @param resultSet
     * @return KardexDto
     * @throws java.sql.SQLException
     */
    protected KardexDto[] fetchKardexDto(ResultSet resultSet) throws SQLException
    {
        ArrayList resultList = fetchMultiResults(resultSet, false);   
        KardexDto kardexDto[] = new KardexDto[ resultList.size() ];
        resultList.toArray( kardexDto );
        return kardexDto;
    }

    /** 
     * Fetches multiple rows from the result set
     * @param resultSet
     * @param view
     * @return ArrayList
     * @throws java.sql.SQLException
     */
    protected ArrayList fetchMultiResults(ResultSet resultSet, boolean view) throws SQLException
    {
        ArrayList resultList = new ArrayList();

        while (resultSet.next()) {

            if(view) {
                KardexView kardexView = new KardexView();
                populateKardexView( kardexView, resultSet);
                resultList.add( kardexView );
            } else {
                KardexDto kardexDto = new KardexDto();
                populateDto( kardexDto, resultSet);
                resultList.add( kardexDto );
            }
        }

        return resultList;
    }

    /** 
     * Populates a DTO with data from a ResultSet.
     * 
     * @param kardexDto
     * @param resultSet
     * @throws java.sql.SQLException
     */
    protected void populateDto(KardexDto kardexDto, ResultSet resultSet) throws SQLException
    {
        kardexDto.setProductId( resultSet.getInt( COLUMN_PRODUCT_ID ) );
        kardexDto.setStoreId( resultSet.getInt( COLUMN_STORE_ID ) );
        kardexDto.setQuantity( resultSet.getDouble( COLUMN_QUANTITY ) );
        kardexDto.setUnityValue( resultSet.getDouble( COLUMN_UNITY_VALUE ) );
        kardexDto.setTotalValue( resultSet.getDouble( COLUMN_TOTAL_VALUE ) );
        kardexDto.setState( resultSet.getShort( COLUMN_STATE ) );            
        if (resultSet.wasNull()) { kardexDto.setTotalValueNull( true ); }
    }

    /** 
     * Populates a DTO with data from a ResultSet.
     * 
     * @param kardexView
     * @param resultSet
     * @throws java.sql.SQLException
     */
    protected void populateKardexView(KardexView kardexView, ResultSet resultSet) throws SQLException
    {
        kardexView.setProductId( resultSet.getInt( COLUMN_VIEW_PRODUCT_ID ) );
        kardexView.setProductName(resultSet.getString( COLUMN_VIEW_PRODUCT_NAME ) );
        kardexView.setStoreId( resultSet.getInt( COLUMN_VIEW_STORE_ID ) );
        kardexView.setStoreName(resultSet.getString( COLUMN_VIEW_STORE_NAME ) );
        kardexView.setQuantity( resultSet.getDouble( COLUMN_VIEW_QUANTITY ) );
        kardexView.setUnityDescription(resultSet.getString( COLUMN_VIEW_UNITY_DESCRIPTION ) );
        kardexView.setUnityValue( resultSet.getDouble( COLUMN_VIEW_UNITY_VALUE ) );	
    }

    /** 
     * Resets the modified attributes in the DTO.
     * 
     * @param kardexDto
     */
    protected void reset(KardexDto kardexDto) {}

    /** 
     * Returns all rows from the kardex table that match the specified arbitrary SQL statement.
     * 
     * @param sql
     * @param sqlParams
     * @return KardexDto
     * @throws com.cidenet.hulkstore.kardex.KardexDaoException
     */
    public KardexDto[] findByDynamicSelect(String sql, Object[] sqlParams) throws KardexDaoException
    {
        // declare variables
        boolean isConnSupplied = (userConn != null);
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resulSet = null;

        try {
            // get the user-specified connection or get a connection from the ResourceManager
            connection = isConnSupplied ? userConn : ResourceManager.getConnection();

            System.out.println( "Executing " + sql );
            // prepare statement
            statement = connection.prepareStatement( sql );
            statement.setMaxRows( maxRows );

            // bind parameters
            for (int i = 0; sqlParams != null && i < sqlParams.length; i++ ) {
                statement.setObject( i + 1, sqlParams[i] );
            }

            resulSet = statement.executeQuery();

            // fetch the results
            return fetchKardexDto(resulSet);
        
        } catch (Exception exception) { throw new KardexDaoException( "Exception: " + exception.getMessage(), exception );
        
        } finally {
            ResourceManager.close(resulSet);
            ResourceManager.close(statement);
            if (!isConnSupplied) { ResourceManager.close(connection); }
        }
    }

    /** 
     * Returns all rows from the kardex table that match the specified arbitrary SQL statement.
     * 
     * @param sql
     * @param sqlParams
     * @return KardexDto
     * @throws com.cidenet.hulkstore.kardex.KardexDaoException
     */
    public KardexDto[] findByDynamicWhere(String sql, Object[] sqlParams) throws KardexDaoException
    {
        // declare variables
        boolean isConnSupplied = (userConn != null);
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resulSet = null;

        try {
            // get the user-specified connection or get a connection from the ResourceManager
            connection = isConnSupplied ? userConn : ResourceManager.getConnection();

            // construct the SQL statement
            String SQL = SQL_SELECT + " WHERE " + sql;

            System.out.println( "Executing " + SQL );
            // prepare statement
            statement = connection.prepareStatement( SQL );
            statement.setMaxRows( maxRows );

            // bind parameters
            for (int i=0; sqlParams!=null && i<sqlParams.length; i++ ) {
                    statement.setObject( i+1, sqlParams[i] );
            }

            resulSet = statement.executeQuery();

            // fetch the results
            return fetchKardexDto(resulSet);
            
        } catch (Exception exception) { throw new KardexDaoException( "Exception: " + exception.getMessage(), exception );
        
        } finally {
            ResourceManager.close(resulSet);
            ResourceManager.close(statement);
            if (!isConnSupplied) { ResourceManager.close(connection); }
        }
    }

    /** 
     * Returns all rows from the kardex view.
     * 
     * @param productId
     * @param storeId
     * @return KardexView
     * @throws com.cidenet.hulkstore.kardex.KardexDaoException
     */
    public KardexView[] getKardexView(int productId, int storeId) throws KardexDaoException {
        // declare variables
        boolean isConnSupplied = (userConn != null);
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // get the user-specified connection or get a connection from the ResourceManager
            connection = isConnSupplied ? userConn : ResourceManager.getConnection();

            // construct the SQL statement
            String SQL = "SELECT * FROM bd_hulkstore.vi_kardex WHERE productId = " + productId + " and storeId = " + storeId;


            System.out.println( "Executing " + SQL );
            // prepare statement
            statement = connection.prepareStatement( SQL );
            statement.setMaxRows( maxRows );

            resultSet = statement.executeQuery();

            // fetch the results
            return fetchKardexView(resultSet);
            
        } catch (Exception _e) { throw new KardexDaoException( "Exception: " + _e.getMessage(), _e );
        
        } finally {
            ResourceManager.close(resultSet);
            ResourceManager.close(statement);
            if (!isConnSupplied) { ResourceManager.close(connection); }
        }
    }
}