package net.shakya.himal.recipe_project.converters;

import lombok.Synchronized;
import net.shakya.himal.recipe_project.commands.RecipeCommand;
import net.shakya.himal.recipe_project.domain.Recipe;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {

    private final NotesToNotesCommand notesCommandConverter;
    private final IngredientToIngredientCommand ingredientCommandConverter;
    private final CategoryToCategoryCommand categoryCommandConverter;

    public RecipeToRecipeCommand(NotesToNotesCommand notesCommandConverter, IngredientToIngredientCommand ingredientCommandConverter, CategoryToCategoryCommand categoryCommandConverter) {
        this.notesCommandConverter = notesCommandConverter;
        this.ingredientCommandConverter = ingredientCommandConverter;
        this.categoryCommandConverter = categoryCommandConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public RecipeCommand convert(Recipe source) {

        if (source == null) {
            return null;
        }

        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(source.getId());
        recipeCommand.setDescription(source.getDescription());
        recipeCommand.setPrepTime(source.getPrepTime());
        recipeCommand.setCookTime(source.getCookTime());
        recipeCommand.setServings(source.getServings());
        recipeCommand.setSource(source.getSource());
        recipeCommand.setUrl(source.getUrl());
        recipeCommand.setDirections(source.getDirections());
        recipeCommand.setDifficulty(source.getDifficulty());
        recipeCommand.setImage(source.getImage());
        recipeCommand.setNotesCommand(notesCommandConverter.convert(source.getNotes()));

        if (source.getCategories() != null && source.getCategories().size() > 0){
            source.getCategories().forEach(category -> recipeCommand.getCategories().add(categoryCommandConverter.convert(category)));
        }

        if (source.getIngredients() != null && source.getIngredients().size() > 0){
            source.getIngredients().forEach(ingredient -> recipeCommand.getIngredients().add(ingredientCommandConverter.convert(ingredient)));
        }

        return recipeCommand;
    }
}
