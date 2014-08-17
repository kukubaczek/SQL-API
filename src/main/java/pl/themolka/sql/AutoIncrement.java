package pl.themolka.sql;

import pl.themolka.sql.type.SQLType;

public class AutoIncrement {
    private final SQLType increment;
    
    public AutoIncrement(SQLType increment) {
        this.increment = increment;
    }
    
    public SQLType getIncrement() {
        return this.increment;
    }
    
}
