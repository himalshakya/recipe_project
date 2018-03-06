package net.shakya.himal.recipe_project.repositories;

import net.shakya.himal.recipe_project.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
