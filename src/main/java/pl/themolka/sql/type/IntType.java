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
