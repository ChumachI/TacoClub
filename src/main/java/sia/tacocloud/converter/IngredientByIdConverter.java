package sia.tacocloud.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import sia.tacocloud.entity.Ingredient;
import sia.tacocloud.repository.IngredientRepository;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private IngredientRepository ingredientRepository;

    public IngredientByIdConverter(IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    @Nullable
    public Ingredient convert(String id) {
        return ingredientRepository.findById(id).orElse(null);
    }
}
