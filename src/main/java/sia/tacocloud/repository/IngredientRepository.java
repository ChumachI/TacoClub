package sia.tacocloud.repository;

import java.util.List;
import java.util.Optional;

import sia.tacocloud.entity.Ingredient;


public interface IngredientRepository {
    List<Ingredient> findAll();
    Optional<Ingredient> findById(String id);
    Ingredient save(Ingredient ingredient);
}
