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

package pl.themolka.sql.type;

public class IntType implements SQLType {
    public static final int MIN_VALUE = Integer.MIN_VALUE;
    public static final int MAX_VALUE = Integer.MAX_VALUE;
    private final String name;
    private boolean primary = false;
    
    public IntType(String name) {
        this.name = name;
    }
    
    public IntType(String name, boolean primary) {
        this.name = name;
        this.primary = primary;
    }
    
    @Override
    public String getName() {
        return this.name;
    }
    
    @Override
    public int getSize() {
        return -1;
    }
    
    @Override
    public final String getTypeName() {
        return "INT";
    }
    
    @Override
    public boolean isPrimaryKey() {
        return this.primary;
    }
    
}
