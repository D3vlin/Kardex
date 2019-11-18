package com.cidenet.hulkstore.controller.reports;

import com.cidenet.hulkstore.products.ProductDto;
import com.cidenet.hulkstore.stores.StoreDto;

/**
 * Reports Interface
 * 
 * Available methods for the report management controller.
 * 
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-14
 */
public interface IReports {
    
    public void generateStoreReport(StoreDto[] stores);
    
    public void generateProductReport(ProductDto[] products);
}
