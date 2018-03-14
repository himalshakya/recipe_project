package net.shakya.himal.recipe_project.commands;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UnitOfMeasureCommand {
    private long id;
    private String description;
}
