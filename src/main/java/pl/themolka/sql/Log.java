/*
 * Copyright (C) 2014 TheMolkaPL
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

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
