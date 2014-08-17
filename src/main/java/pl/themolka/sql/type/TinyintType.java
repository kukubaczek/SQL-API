package pl.themolka.sql.type;

public class TinyintType implements SQLType {
    public static final int MIN_VALUE = -128;
    public static final int MAX_VALUE = 127;
    private final String name;
    private boolean primary = false;
    
    public TinyintType(String name) {
        this.name = name;
    }
    
    public TinyintType(String name, boolean primary) {
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
        return "TINYINT";
    }
    
    @Override
    public boolean isPrimaryKey() {
        return this.primary;
    }
    
}
