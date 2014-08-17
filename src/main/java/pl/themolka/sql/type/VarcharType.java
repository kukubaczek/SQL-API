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
