package com.cidenet.hulkstore.model.dao;

import com.cidenet.hulkstore.model.dao.document.DocumentDao;
import com.cidenet.hulkstore.model.dao.kardex.KardexDao;
import com.cidenet.hulkstore.model.dao.kardex.KardexDetailDao;
import com.cidenet.hulkstore.products.ProductDao;
import com.cidenet.hulkstore.stores.StoreDao;
import com.cidenet.hulkstore.units.UnityDao;
import com.cidenet.hulkstore.users.UsersDao;
import java.sql.Connection;

/**
 * This class is responsible for creating DAO instances.
 * 
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-24
 */
public final class DaoFactory
{
    /**
     * createProductDao.
     * 
     * @return ProductDao
     */
    public static ProductDao createProductDao() { return new ProductDao(); }

    /**
     * createProductDao.
     * 
     * @param conn
     * @return ProductDao
     */
    public static ProductDao createProductDao(Connection conn) { return new ProductDao( conn ); }

    /**
     * createStoreDao.
     * 
     * @return StoreDao
     */
    public static StoreDao createStoreDao() { return new StoreDao(); }

    /**
     * createStoreDao.
     * 
     * @param conn
     * @return StoreDao
     */
    public static StoreDao createStoreDao(Connection conn) { return new StoreDao( conn ); }

    /**
     * createUnityDao.
     * 
     * @return UnityDao
     */
    public static UnityDao createUnityDao() { return new UnityDao(); }

    /**
     * createUnityDao.
     * 
     * @param conn
     * @return UnityDao
     */
    public static UnityDao createUnityDao(Connection conn) { return new UnityDao( conn ); }

    /**
     * createUsersDao.
     * 
     * @return UsersDao
     */
    public static UsersDao createUsersDao() { return new UsersDao(); }

    /**
     * createUsersDao.
     * 
     * @param conn
     * @return UsersDao
     */
    public static UsersDao createUsersDao(Connection conn) { return new UsersDao( conn ); }

    /**
     * createDocumentDao.
     * 
     * @return DocumentDao
     */
    public static DocumentDao createDocumentDao() { return new DocumentDao(); }

    /**
     * createDocumentDao.
     * 
     * @param conn
     * @return DocumentDao
     */
    public static DocumentDao createDocumentDao(Connection conn) { return new DocumentDao( conn ); }

    /**
     * createKardexDao.
     * 
     * @return KardexDao
     */
    public static KardexDao createKardexDao() { return new KardexDao(); }

    /**
     * createKardexDao.
     * 
     * @param conn
     * @return KardexDao
     */
    public static KardexDao createKardexDao(Connection conn) { return new KardexDao( conn ); }

    /**
     * createKardexDetailDao.
     * 
     * @return KardexDetailDao
     */
    public static KardexDetailDao createKardexDetailDao() { return new KardexDetailDao(); }

    /**
     * createKardexDetailDao.
     * 
     * @param conn
     * @return KardexDetailDao
     */
    public static KardexDetailDao createKardexDetailDao(Connection conn) { return new KardexDetailDao( conn ); }
}