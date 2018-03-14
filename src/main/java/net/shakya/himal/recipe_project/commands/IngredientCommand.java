package net.shakya.himal.recipe_project.commands;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.shakya.himal.recipe_project.domain.Recipe;
import net.shakya.himal.recipe_project.domain.UnitOfMeasure;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class IngredientCommand {
    private long id;
    private String description;
    private BigDecimal amount;
    private UnitOfMeasureCommand unitOfMeasure;
}
