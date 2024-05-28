package sia.tacocloud.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table
public class Ingredient implements Serializable {
    
    @Id
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
