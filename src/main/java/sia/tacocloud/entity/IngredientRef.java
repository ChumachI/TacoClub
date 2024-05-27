package sia.tacocloud.entity;

import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table
public class IngredientRef {
    private final String ingredient;
}
