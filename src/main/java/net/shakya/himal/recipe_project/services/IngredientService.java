package net.shakya.himal.recipe_project.services;

import net.shakya.himal.recipe_project.commands.IngredientCommand;

public interface IngredientService {

    IngredientCommand findByRecipeIdAndIngredientId(long receipeId, long ingredientId);
}
