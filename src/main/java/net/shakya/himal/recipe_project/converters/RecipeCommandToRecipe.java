package net.shakya.himal.recipe_project.converters;

import lombok.Builder;
import lombok.Synchronized;
import net.shakya.himal.recipe_project.commands.RecipeCommand;
import net.shakya.himal.recipe_project.domain.Recipe;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {

    private final IngredientCommandToIngredient ingredientConverter;
    private final NotesCommandToNotes notesConverter;
    private final CategoryCommandToCategory categoryConverter;

    public RecipeCommandToRecipe(IngredientCommandToIngredient ingredientConverter, NotesCommandToNotes notesConverter, CategoryCommandToCategory categoryConverter) {
        this.ingredientConverter = ingredientConverter;
        this.notesConverter = notesConverter;
        this.categoryConverter = categoryConverter;
    }

    @Nullable
    @Synchronized
    @Override
    public Recipe convert(RecipeCommand source) {

        if (source == null){
            return null;
        }

        Recipe recipe = new Recipe();
        recipe.setId(source.getId());
        recipe.setDescription(source.getDescription());
        recipe.setPrepTime(source.getPrepTime());
        recipe.setCookTime(source.getCookTime());
        recipe.setServings(source.getServings());
        recipe.setSource(source.getSource());
        recipe.setUrl(source.getUrl());
        recipe.setDirections(source.getDirections());
        recipe.setDifficulty(source.getDifficulty());
        recipe.setImage(source.getImage());
        recipe.setNotes(notesConverter.convert(source.getNotesCommand()));

        if (source.getCategories() != null && source.getCategories().size() > 0){
            source.getCategories().forEach(category -> recipe.getCategories().add(categoryConverter.convert(category)));
        }

        if (source.getIngredients() != null && source.getIngredients().size() > 0){
            source.getIngredients().forEach(ingredient -> recipe.getIngredients().add(ingredientConverter.convert(ingredient)));
        }

        return recipe;
    }
}
