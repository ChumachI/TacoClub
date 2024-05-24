package sia.tacocloud.repository;

import java.util.Optional;

import sia.tacocloud.entity.Ingredient;

public interface IngredientRepository {
    Iterable<Ingredient> findAll();
    Optional<Ingredient> findById(String id);
    Ingredient save(Ingredient ingredient);
}
