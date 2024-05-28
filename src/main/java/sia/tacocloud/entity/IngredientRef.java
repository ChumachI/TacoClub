package sia.tacocloud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table
@Entity
public class IngredientRef {
    private final String ingredient;
}
