package net.shakya.himal.recipe_project.commands;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.shakya.himal.recipe_project.domain.Recipe;

@Data
@NoArgsConstructor
public class NotesCommand {
    private long id;
    private String recipeNotes;
}
