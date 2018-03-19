package net.shakya.himal.recipe_project.services;

import lombok.extern.slf4j.Slf4j;
import net.shakya.himal.recipe_project.commands.IngredientCommand;
import net.shakya.himal.recipe_project.converters.IngredientToIngredientCommand;
import net.shakya.himal.recipe_project.domain.Recipe;
import net.shakya.himal.recipe_project.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService{

    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final RecipeRepository repository;

    public IngredientServiceImpl(IngredientToIngredientCommand ingredientToIngredientCommand, RecipeRepository repository) {
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.repository = repository;
    }

    @Override
    public IngredientCommand findByRecipeIdAndIngredientId(long receipeId, long ingredientId) {

        Optional<Recipe> recipeOptional = repository.findById(receipeId);

        if (!recipeOptional.isPresent()){
            // todo impl error handling
            log.error("recipe id not found. Id : " + receipeId);
        }

        Recipe recipe = recipeOptional.get();
        Optional<IngredientCommand> ingredientCommandOptional = recipe.getIngredients()
                .stream()
                .filter(ingredient -> ingredient.getId() == ingredientId)
                .map(ingredient -> ingredientToIngredientCommand.convert(ingredient))
                .findFirst();

        if(!ingredientCommandOptional.isPresent()){
            // todo impl error handling
            log.error("Ingredient id not found: " + ingredientId);
        }

        return ingredientCommandOptional.get();
    }
}
