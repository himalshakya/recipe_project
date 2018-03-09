package net.shakya.himal.recipe_project.repositories;

import net.shakya.himal.recipe_project.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByName(String name);
}
