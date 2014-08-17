package pl.themolka.sql.type;

public class BigintType implements SQLType {
    public static final long MIN_VALUE = Long.MIN_VALUE;
    public static final long MAX_VALUE = Long.MAX_VALUE;
    private final String name;
    private boolean primary = false;
    
    public BigintType(String name) {
        this.name = name;
    }
    
    public BigintType(String name, boolean primary) {
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
        return "BIGINT";
    }
    
    @Override
    public boolean isPrimaryKey() {
        return this.primary;
    }
    
}
