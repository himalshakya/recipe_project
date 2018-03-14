package net.shakya.himal.recipe_project.commands;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryCommand {
    private Long id;
    private String name;
}
