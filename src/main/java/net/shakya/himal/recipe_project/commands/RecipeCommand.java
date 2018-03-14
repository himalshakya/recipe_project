package net.shakya.himal.recipe_project.commands;

import lombok.*;
import net.shakya.himal.recipe_project.domain.Category;
import net.shakya.himal.recipe_project.domain.Difficulty;
import net.shakya.himal.recipe_project.domain.Ingredient;
import net.shakya.himal.recipe_project.domain.Notes;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"categories", "ingredients"})
@ToString(exclude = {"categories", "ingredients"})
public class RecipeCommand {
    private long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    private Set<IngredientCommand> ingredients = new HashSet<>();
    private Difficulty difficulty;
    private Byte[] image;
    private NotesCommand notesCommand;
    private Set<CategoryCommand> categories = new HashSet<>();;
}
