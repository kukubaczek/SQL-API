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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import pl.themolka.sql.exception.PrimaryKeyNotDefinedException;
import pl.themolka.sql.type.SQLType;

public class SQLTable {
    private final SQLConnection connection;
    private final String name;
    private final SQLType[] types;
    private final AutoIncrement increment;
    private Connection jConnection;
    
    public SQLTable(SQLConnection connection, String name, SQLType[] type, AutoIncrement increment) {
        this.connection = connection;
        this.name = name;
        this.types = type;
        this.increment = increment;
        createConnection();
    }
    
    public SQLConnection getConnection() {
        return this.connection;
    }
    
    public Connection getJConnection() {
        return this.jConnection;
    }
    
    public String getName() {
        return this.name;
    }
    
    public SQLType[] getTypes() {
        return this.types;
    }
    
    public AutoIncrement getIncrement() {
        return this.increment;
    }
    
    public void execute(String query) {
        try {
            Statement statement = jConnection.createStatement();
            Log.cmd(query);
            statement.execute(query);
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public ResultSet select(String query) {
        ResultSet result = null;
        try {
            Statement statement = jConnection.createStatement();
            Log.cmd(query);
            result = statement.executeQuery(query);
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
    public void create() {
        SQLType primary = null;
        StringBuilder builder = new StringBuilder();
        boolean incrementUsed = false;
        
        for (SQLType type : this.getTypes()) {
            int size = type.getSize();
            builder.append(type.getName()).append(" ").append(type.getTypeName());
            if (size > -1) {
                builder.append("(").append(size).append(")");
            }
            
            if (type.isPrimaryKey()) {
                primary = type;
            }
            
            if (!incrementUsed && this.getIncrement().getIncrement().equals(type)) {
                incrementUsed = true;
                builder.append(" AUTO_INCREMENT");
            }
            
            builder.append(", ");
        }
        
        if (primary == null) {
            throw new PrimaryKeyNotDefinedException("Any of Type objects is not a PRIMARY KEY");
        }
        
        String query = "CREATE TABLE IF NOT EXISTS " + this.getName() + " (" +
                builder.toString() + "PRIMARY KEY(" + primary.getName() + "));";
        Log.cmd(query);
        this.execute(query);
    }
    
    private void createConnection() {
        try {
            User user = this.getConnection().getUser();
            Class.forName(this.getConnection().getDriver()).newInstance();
            this.jConnection = DriverManager.getConnection("jdbc:mysql://" + this.getConnection().getAddress() + ":" + this.getConnection().getPort()
                    + "/" + this.getConnection().getDatabase(), user.getLogin(), user.getPassword());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
