package net.shakya.himal.recipe_project.services;

import lombok.extern.slf4j.Slf4j;
import net.shakya.himal.recipe_project.commands.RecipeCommand;
import net.shakya.himal.recipe_project.converters.RecipeCommandToRecipe;
import net.shakya.himal.recipe_project.converters.RecipeToRecipeCommand;
import net.shakya.himal.recipe_project.domain.Recipe;
import net.shakya.himal.recipe_project.repositories.RecipeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository repository;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    public RecipeServiceImpl(RecipeRepository repository, RecipeCommandToRecipe recipeCommandToRecipe, RecipeToRecipeCommand recipeToRecipeCommand) {
        this.repository = repository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

    @Override
    public Set<Recipe> getRecipe() {
        log.debug("Running getRecipes...........");

        Set<Recipe> recipeSet = new HashSet<>();
        repository.findAll().iterator().forEachRemaining(recipeSet::add);

        return recipeSet;
    }

    @Override
    public Recipe findById(Long recipeId) {

        Optional<Recipe> recipeOptional = repository.findById(recipeId);

        if (!recipeOptional.isPresent()){
            throw  new RuntimeException("Recipe Not Found");
        }

        return recipeOptional.get();
    }

    @Override
    @Transactional
    public RecipeCommand saveRecipeCommand(RecipeCommand command) {
        Recipe detatchedRecipe = recipeCommandToRecipe.convert(command);
        Recipe savedRecipe = repository.save(detatchedRecipe);
        log.debug("Saved RecipeId : " + savedRecipe.getId());

        return recipeToRecipeCommand.convert(savedRecipe);
    }
}
