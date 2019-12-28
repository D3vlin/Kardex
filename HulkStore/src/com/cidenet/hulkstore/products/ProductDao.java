package com.cidenet.hulkstore.products;

import com.cidenet.hulkstore.model.dao.AbstractDao;
import com.cidenet.hulkstore.model.dao.ResourceManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/** 
 * This class handles queries to the product table.
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-15
 */
public final class ProductDao extends AbstractDao
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
    protected final String SQL_SELECT = "SELECT productId, productName, unityId, state FROM " + getTableName() + "";

    /** 
     * Finder methods will pass this value to the JDBC setMaxRows method.
     */
    protected int maxRows;

    /** 
     * SQL INSERT statement for this table.
     */
    protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( productId, productName, unityId, state ) VALUES ( ?, ?, ?, ? )";

    /** 
     * SQL UPDATE statement for this table.
     */
    protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET productId = ?, productName = ?, unityId = ?, state = ? WHERE productId = ?";
    
    /** 
     * SQL DELETE statement for this table
     */
    protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE productId = ?";

    /** 
     * Indexes of the columns in the product table.
     */
    protected static final int COLUMN_PRODUCT_ID = 1;
    protected static final int COLUMN_PRODUCT_NAME = 2;
    protected static final int COLUMN_UNITY_ID = 3;
    protected static final int COLUMN_STATE = 4;

    /** 
     * Number of columns in the product table.
     */
    protected static final int NUMBER_OF_COLUMNS = 4;

    /** 
     * Index of primary-key column productId.
     */
    protected static final int PK_COLUMN_PRODUCT_ID = 1;

    /** 
     * Indexes of the columns in the product view.
     */
    protected static final int COLUMN_VIEW_PRODUCT_ID = 1;
    protected static final int COLUMN_VIEW_PRODUCT_NAME = 2;
    protected static final int COLUMN_VIEW_UNITY_DESCRIPTION = 3;

    /** 
     * Number of columns in the product view.
     */
    protected static final int PRODUCT_VIEW_COLUMNS = 4;

    /** 
     * Inserts a new row in the product table.
     * 
     * @param productDto
     * @return ProductPk
     * @throws com.cidenet.hulkstore.products.ProductDaoException 
     */
    public ProductPk insert(ProductDto productDto) throws ProductDaoException
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
            statement.setInt( index++, productDto.getProductId() );
            statement.setString( index++, productDto.getProductName() );
            
            if (productDto.isUnityIdNull()) { statement.setNull( index++, java.sql.Types.INTEGER ); }
            else { statement.setInt( index++, productDto.getUnityId() ); }

            statement.setShort( index++, productDto.getState() );
            System.out.println( "Executing " + SQL_INSERT + " with DTO: " + productDto );
            int rows = statement.executeUpdate();
            long t2 = System.currentTimeMillis();
            System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );

            // retrieve values from auto-increment columns
            resultSet = statement.getGeneratedKeys();
            if (resultSet != null && resultSet.next()) {
                productDto.setProductId( resultSet.getInt( 1 ) );
            }

            reset(productDto);
            return productDto.createPk();
            
        } catch (Exception exception) { throw new ProductDaoException( "Exception: " + exception.getMessage(), exception );
        
        } finally {
            ResourceManager.close(statement);
            if (!isConnSupplied) { ResourceManager.close(connection); }		
        }		
    }

    /** 
     * Updates a single row in the product table.
     * 
     * @param productPk
     * @param productDto
     * @return booelan
     * @throws com.cidenet.hulkstore.products.ProductDaoException
     */
    public boolean update(ProductPk productPk, ProductDto productDto) throws ProductDaoException
    {
        // declare variables
        long t1 = System.currentTimeMillis();
        final boolean isConnSupplied = (userConn != null);
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // get the user-specified connection or get a connection from the ResourceManager
            connection = isConnSupplied ? userConn : ResourceManager.getConnection();

            System.out.println( "Executing " + SQL_UPDATE + " with DTO: " + productDto );
            statement = connection.prepareStatement( SQL_UPDATE );
            int index=1;
            statement.setInt( index++, productDto.getProductId() );
            statement.setString( index++, productDto.getProductName() );
            
            if (productDto.isUnityIdNull()) { statement.setNull( index++, java.sql.Types.INTEGER ); }
            else { statement.setInt( index++, productDto.getUnityId() ); }

            statement.setShort( index++, productDto.getState() );
            statement.setInt( 5, productPk.getProductId() );
            int rows = statement.executeUpdate();
            reset(productDto);
            long t2 = System.currentTimeMillis();
            System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
            
            return rows > 0;
            
        } catch (Exception exception) { throw new ProductDaoException( "Exception: " + exception.getMessage(), exception );
        
        } finally {
            ResourceManager.close(statement);
            if (!isConnSupplied) { ResourceManager.close(connection); }
        }
    }
    
    /** 
     * Deletes a single row in the product table.
     * 
     * @param productPk
     * @return boolean
     * @throws com.cidenet.hulkstore.products.ProductDaoException
     */
    public boolean delete(ProductPk productPk) throws ProductDaoException
    {
        // declare variables
        long t1 = System.currentTimeMillis();
        final boolean isConnSupplied = (userConn != null);
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // get the user-specified connection or get a connection from the ResourceManager
            connection = isConnSupplied ? userConn : ResourceManager.getConnection();

            System.out.println( "Executing " + SQL_DELETE + " with PK: " + productPk );
            statement = connection.prepareStatement( SQL_DELETE );
            statement.setInt( 1, productPk.getProductId() );
            int rows = statement.executeUpdate();
            long t2 = System.currentTimeMillis();
            System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
            
            return rows > 0;
        
        } catch (Exception exception) { throw new ProductDaoException( "Exception: " + exception.getMessage(), exception );
        
        } finally {
            ResourceManager.close(statement);
            if (!isConnSupplied) { ResourceManager.close(connection); }
        }
   }

    /** 
     * Returns the rows from the product table that matches the specified primary-key value.
     * 
     * @param productPk
     * @return ProductDto
     * @throws com.cidenet.hulkstore.products.ProductDaoException
     */
    public ProductDto findByPrimaryKey(ProductPk productPk) throws ProductDaoException
    {
        return findByPrimaryKey( productPk.getProductId() );
    }

    /** 
     * Returns all rows from the product table that match the criteria 'productId = :productId'.
     * 
     * @param productId
     * @return ProductDto
     * @throws com.cidenet.hulkstore.products.ProductDaoException
     */
    public ProductDto findByPrimaryKey(int productId) throws ProductDaoException
    {
        ProductDto response[] = findByDynamicSelect( SQL_SELECT + " WHERE productId = ?", new Object[] {productId} );
        return response.length==0 ? null : response[0];
    }

    /** 
     * Returns all rows from the product table that match the criteria ''.
     * 
     * @return ProductDto[]
     * @throws com.cidenet.hulkstore.products.ProductDaoException
     */
    public ProductDto[] findAll() throws ProductDaoException
    {
        return findByDynamicSelect( SQL_SELECT + " ORDER BY productId", null );
    }

    /**
     * Empty Constructor.
     * 
     */
    public ProductDao() {}

    /**
     * Constructor.
     * 
     * @param userConn
     */
    public ProductDao(final java.sql.Connection userConn) { this.userConn = userConn; }

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
    public String getTableName() { return "bd_hulkstore.product"; }

    /** 
     * Fetches a single row from the result set.
     * 
     * @param resultSet
     * @return ProductDto
     * @throws java.sql.SQLException
     */
    protected ProductDto fetchSingleResult(ResultSet resultSet) throws SQLException
    {
        if (resultSet.next()) {
            ProductDto productDto = new ProductDto();
            populateDto( productDto, resultSet);
            return productDto;
            
        } else { return null; }
    }

    /** 
     * Fetches multiple rows from the result set.
     * 
     * @param resultSet
     * @return ProductView[]
     * @throws java.sql.SQLException
     */
    protected ProductView[] fetchProductView(ResultSet resultSet) throws SQLException
    {
        ArrayList resultList = fetchMultiResults(resultSet, true);   
        ProductView productView[] = new ProductView[ resultList.size() ];
        resultList.toArray( productView );
        return productView;
    }

    /** 
     * Fetches multiple rows from the result set.
     * 
     * @param resultSet
     * @return ProductDto[]
     * @throws java.sql.SQLException
     */
    protected ProductDto[] fetchProductDto(ResultSet resultSet) throws SQLException
    {
        ArrayList resultList = fetchMultiResults(resultSet, false);   
        ProductDto productDto[] = new ProductDto[ resultList.size() ];
        resultList.toArray( productDto );
        return productDto;
    }

    /** 
     * Fetches multiple rows from the result set.
     * 
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
                ProductView productView = new ProductView();
                populateProductView( productView, resultSet);
                resultList.add( productView );
            } else {                            
                ProductDto productDto = new ProductDto();
                populateDto( productDto, resultSet);
                resultList.add( productDto );
            }			
        }
        return resultList;
    }

    /** 
     * Populates a DTO with data from a ResultSet.
     * 
     * @param productDto
     * @param resultSet
     * @throws java.sql.SQLException
     */
    protected void populateDto(ProductDto productDto, ResultSet resultSet) throws SQLException
    {
        productDto.setProductId( resultSet.getInt( COLUMN_PRODUCT_ID ) );
        productDto.setProductName( resultSet.getString( COLUMN_PRODUCT_NAME ) );
        productDto.setUnityId( resultSet.getInt( COLUMN_UNITY_ID ) );        
        if (resultSet.wasNull()) { productDto.setUnityIdNull( true ); }
        productDto.setState( resultSet.getShort( COLUMN_STATE ) );
    }

    /** 
     * Populates a view product with data from a ResultSet.
     * 
     * @param viewProduct
     * @param resultSet
     * @throws java.sql.SQLException
     */
    protected void populateProductView(ProductView viewProduct, ResultSet resultSet) throws SQLException
    {
        viewProduct.setProductId( resultSet.getInt( COLUMN_VIEW_PRODUCT_ID ) );
        viewProduct.setProductName( resultSet.getString( COLUMN_VIEW_PRODUCT_NAME ) );
        viewProduct.setUnityDescription( resultSet.getString( COLUMN_VIEW_UNITY_DESCRIPTION ) );
    }

    /** 
     * Resets the modified attributes in the DTO.
     * 
     * @param productDto
     */
    protected void reset(ProductDto productDto) {}

    /** 
     * Returns all rows from the product table that match the specified arbitrary SQL statement.
     * 
     * @param sql
     * @param sqlParams
     * @return ProductDto[]
     * @throws com.cidenet.hulkstore.products.ProductDaoException
     */
    public ProductDto[] findByDynamicSelect(String sql, Object[] sqlParams) throws ProductDaoException
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
            return fetchProductDto(resultSet);
            
        } catch (Exception exception) { throw new ProductDaoException( "Exception: " + exception.getMessage(), exception );
        
        } finally {
            ResourceManager.close(resultSet);
            ResourceManager.close(statement);
            if (!isConnSupplied) { ResourceManager.close(connection); }
        }
    }

    /** 
     * Returns all rows from the product table that match the specified arbitrary SQL statement.
     * 
     * @param sql
     * @param sqlParams
     * @return ProductDto[]
     * @throws com.cidenet.hulkstore.products.ProductDaoException
     */
    public ProductDto[] findByDynamicWhere(String sql, Object[] sqlParams) throws ProductDaoException
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
            return fetchProductDto(resultSet);
        
        } catch (Exception exception) { throw new ProductDaoException( "Exception: " + exception.getMessage(), exception );
        
        } finally {
            ResourceManager.close(resultSet);
            ResourceManager.close(statement);
            if (!isConnSupplied) { ResourceManager.close(connection); }
        }
    }
    
    /**
     * Returns the next available id for the next produt.
     * 
     * @return String
     * @throws ProductDaoException 
     */
    public String findNextProductId() throws ProductDaoException {
        // declare variables
        final boolean isConnSupplied = (userConn != null);
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // get the user-specified connection or get a connection from the ResourceManager
            connection = isConnSupplied ? userConn : ResourceManager.getConnection();
            
            // construct the SQL statement
            final String SQL = "SELECT LPAD((SELECT COUNT(*) + 1 FROM " + getTableName() + "), 6, '0') AS nextProductId";
            
            System.out.println( "Executing " + SQL);
            statement = connection.prepareStatement( SQL );

            resultSet = statement.executeQuery();
            resultSet.next();
            
            return resultSet.getString(1);
            
        } catch (Exception exception) { throw new ProductDaoException( "Exception: " + exception.getMessage(), exception );
        
        } finally {
            ResourceManager.close(resultSet);
            ResourceManager.close(statement);
            if (!isConnSupplied) { ResourceManager.close(connection); }
        }
    }
        
    /**
     * Returns all rows from the product view.
     * 
     * @return ProductView[]
     * @throws ProductDaoException 
     */
    public ProductView[] getViewProduct() throws ProductDaoException {
        // declare variables
        final boolean isConnSupplied = (userConn != null);
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // get the user-specified connection or get a connection from the ResourceManager
            connection = isConnSupplied ? userConn : ResourceManager.getConnection();

            // construct the SQL statement
            final String SQL = "SELECT * FROM bd_hulkstore.vi_Product";

            System.out.println( "Executing " + SQL );
            // prepare statement
            statement = connection.prepareStatement( SQL );
            statement.setMaxRows( maxRows );

            resultSet = statement.executeQuery();

            // fetch the results
            return fetchProductView(resultSet);
            
        } catch (Exception exception) { throw new ProductDaoException( "Exception: " + exception.getMessage(), exception );
        
        } finally {
            ResourceManager.close(resultSet);
            ResourceManager.close(statement);
            if (!isConnSupplied) { ResourceManager.close(connection); }
        }
    }
}