package com.cidenet.hulkstore.controller.reports;

import com.cidenet.hulkstore.stores.StoreDto;
import java.util.ArrayList;

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
    
    public void generateStoreReport(StoreDto[] stores, ArrayList<String> header);
}
