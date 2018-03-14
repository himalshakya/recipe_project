package net.shakya.himal.recipe_project.services;

import net.shakya.himal.recipe_project.commands.RecipeCommand;
import net.shakya.himal.recipe_project.domain.Recipe;

import java.util.Optional;
import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipe();

    Recipe findById(Long l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
