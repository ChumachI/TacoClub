package sia.tacocloud.entity;

import java.io.Serializable;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Table
@AllArgsConstructor
// @NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Ingredient implements Serializable {
    
    @PrimaryKey
    private final String id;
    private final String name;
    private final Type type;
    
    public enum Type {
        WRAP,
        PROTEIN,
        VEGGIES,
        CHEESE, 
        SAUCE
    }
}
