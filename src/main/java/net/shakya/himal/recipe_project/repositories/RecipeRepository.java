package net.shakya.himal.recipe_project.repositories;

import net.shakya.himal.recipe_project.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
