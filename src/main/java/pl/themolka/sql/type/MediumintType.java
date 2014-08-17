package pl.themolka.sql.type;

public class MediumintType implements SQLType {
    public static final long MIN_VALUE = -8388608;
    public static final long MAX_VALUE = 8388607;
    private final String name;
    private boolean primary = false;
    
    public MediumintType(String name) {
        this.name = name;
    }
    
    public MediumintType(String name, boolean primary) {
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
        return "MEDIUMINT";
    }
    
    @Override
    public boolean isPrimaryKey() {
        return this.primary;
    }
    
}
