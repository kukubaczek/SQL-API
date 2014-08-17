package pl.themolka.sql.type;

public interface SQLType {
    String getName();
    
    int getSize();
    
    String getTypeName();
    
    boolean isPrimaryKey();
    
}
