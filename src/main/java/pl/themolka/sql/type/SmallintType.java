package pl.themolka.sql.type;

public class SmallintType implements SQLType {
    public static final int MIN_VALUE = -32768;
    public static final int MAX_VALUE = 32767;
    private final String name;
    private boolean primary = false;
    
    public SmallintType(String name) {
        this.name = name;
    }
    
    public SmallintType(String name, boolean primary) {
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
        return "SMALLINT";
    }
    
    @Override
    public boolean isPrimaryKey() {
        return this.primary;
    }
    
}
