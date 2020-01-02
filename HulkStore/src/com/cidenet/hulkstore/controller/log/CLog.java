package com.cidenet.hulkstore.controller.log;

import org.apache.log4j.Logger;

/**
 * Logger management main controller
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-12-31
 */
public final class CLog {
    
    public static void log(String className, String level, String message) {
        
        Logger log = Logger.getLogger(className);
        
        switch (level) {
            case "debug":
                log.debug(message);
                break;
                
            case "info":
                log.info(message); 
                break;
                
            case "warn":
                log.warn(message);
                break;
                
            case "error":
                log.error(message);
                break;
                
            case "fatal":
                log.fatal(message);
                break;
                
            default:
                log.error("This level is not supported.");
                break;
        }
    }
}
