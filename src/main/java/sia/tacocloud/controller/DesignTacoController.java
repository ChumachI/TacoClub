package sia.tacocloud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import sia.tacocloud.entity.Ingredient;
import sia.tacocloud.entity.Ingredient.Type;
import sia.tacocloud.entity.Taco;
import sia.tacocloud.entity.TacoOrder;
import sia.tacocloud.repository.IngredientRepository;




@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

    private IngredientRepository ingredientRepository;
    
    public DesignTacoController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model){
        Iterable<Ingredient> ingredients = ingredientRepository.findAll();

        Type[] types = Type.values();

        for(Type type : types){
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order(){
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco")
    public Taco taco(){
        return new Taco();
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    @PostMapping
    public String processTaco(@Valid Taco taco,Errors errors, @ModelAttribute TacoOrder tacoOrder){
        if(errors.hasErrors()){
            log.info(errors.getAllErrors().get(0).getDefaultMessage());
            return "design";
        }
        tacoOrder.addTaco(taco);
        log.info("Processing taco {}", taco);
        
        return "redirect:/orders/current";
    }
    
    

    private Object filterByType(Iterable<Ingredient> ingredients, Type type) {
        List<Ingredient> filtered = new ArrayList<>();
        for(Ingredient ingredient : ingredients){
            if(ingredient.getType().equals(type)){
                filtered.add(ingredient);
            }
        }
        return filtered;
    }
    
}
