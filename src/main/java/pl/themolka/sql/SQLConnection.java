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

public class SQLConnection {
    public static final String DEFAULT_DRIVER = "com.mysql.jdbc.Driver"; // MySQL default Java driver
    public static final int DEFAULT_PORT = 3306; // MySQL server default port
    private final String driver;
    private final String address;
    private final int port;
    private final User user;
    private final String database;
    
    public SQLConnection(String address, User user, String database) {
        this.driver = SQLConnection.DEFAULT_DRIVER;
        this.address = address;
        this.port = SQLConnection.DEFAULT_PORT;
        this.user = user;
        this.database = database;
    }
    
    public SQLConnection(String address, int port, User user, String database) {
        this.driver = SQLConnection.DEFAULT_DRIVER;
        this.address = address;
        this.port = port;
        this.user = user;
        this.database = database;
    }
    
    public SQLConnection(String driver, String address, User user, String database) {
        this.driver = driver;
        this.address = address;
        this.port = SQLConnection.DEFAULT_PORT;
        this.user = user;
        this.database = database;
    }
    
    public SQLConnection(String driver, String address, int port, User user, String database) {
        this.driver = driver;
        this.address = address;
        this.port = port;
        this.user = user;
        this.database = database;
    }
    
    public String getDriver() {
        return this.driver;
    }
    
    public String getAddress() {
        return this.address;
    }
    
    public int getPort() {
        return this.port;
    }
    
    public User getUser() {
        return this.user;
    }
    
    public String getDatabase() {
        return this.database;
    }
    
}
