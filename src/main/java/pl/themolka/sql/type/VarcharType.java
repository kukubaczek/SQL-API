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

import pl.themolka.sql.exception.SizeTypeException;

public class VarcharType implements SQLType {
    public static final int MIN_SIZE = 0;
    public static final int MAX_SIZE = 255;
    public static final int DEFAULT_SIZE = 255;
    private final String name;
    private final int size;
    
    public VarcharType(String name) {
        this.name = name;
        this.size = VarcharType.DEFAULT_SIZE;
    }
    
    public VarcharType(String name, int size) {
        if (size < BigintType.MIN_VALUE || size > BigintType.MAX_VALUE) {
            throw new SizeTypeException("Size of the " + this.getTypeName() + " type is too low or too big");
        }
        this.name = name;
        this.size = size;
    }
    
    @Override
    public String getName() {
        return this.name;
    }
    
    @Override
    public int getSize() {
        return this.size;
    }
    
    @Override
    public final String getTypeName() {
        return "VARCHAR";
    }
    
    @Override
    public boolean isPrimaryKey() {
        return false;
    }
    
}
