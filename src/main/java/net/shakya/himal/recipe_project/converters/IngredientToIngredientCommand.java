package net.shakya.himal.recipe_project.converters;

import lombok.Synchronized;
import net.shakya.himal.recipe_project.commands.IngredientCommand;
import net.shakya.himal.recipe_project.domain.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    private final UnitOfMeasureToUnitOfMeasureCommand converter;

    public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand converter) {
        this.converter = converter;
    }

    @Synchronized
    @Nullable
    @Override
    public IngredientCommand convert(Ingredient source) {
        if (source == null){
            return null;
        }

        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(source.getId());
        ingredientCommand.setDescription(source.getDescription());
        ingredientCommand.setAmount(source.getAmount());
        ingredientCommand.setUnitOfMeasure(converter.convert(source.getUom()));

        return ingredientCommand;
    }
}
