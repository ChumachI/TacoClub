package sia.tacocloud.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import sia.tacocloud.entity.IngredientUDT;
import sia.tacocloud.repository.IngredientRepository;

@Component
public class IngredientUDTByIdConverter implements Converter<String, IngredientUDT> {

    private IngredientRepository ingredientRepository;

    public IngredientUDTByIdConverter(IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    @Nullable
    public IngredientUDT convert(String id) {
        return ingredientRepository.findById(id).map(x -> new IngredientUDT(x.getName(), x.getType())).orElse(null);
    }
}
