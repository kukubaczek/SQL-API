package pl.themolka.sql;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Log {
    public static final Logger LOGGER = Logger.getLogger("SQL-API");
    
    public static void cmd(String query) {
        Log.debug("Executing database command: " + query);
    }
    
    public static void debug(String debug) {
        Log.LOGGER.log(Level.INFO, debug);
    }
    
    public static void error(String error) {
        Log.LOGGER.log(Level.WARNING, error);
    }
    
    public static void error(String error, Throwable throwable) {
        Log.LOGGER.log(Level.WARNING, error, throwable);
    }
    
}
