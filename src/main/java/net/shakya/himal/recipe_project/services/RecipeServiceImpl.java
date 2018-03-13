package net.shakya.himal.recipe_project.services;

import lombok.extern.slf4j.Slf4j;
import net.shakya.himal.recipe_project.domain.Recipe;
import net.shakya.himal.recipe_project.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository repository;

    public RecipeServiceImpl(RecipeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Set<Recipe> getRecipe() {
        log.debug("Running getRecipes...........");

        Set<Recipe> recipeSet = new HashSet<>();
        repository.findAll().iterator().forEachRemaining(recipeSet::add);

        return recipeSet;
    }

    @Override
    public Recipe findById(Long recipeId) {

        Optional<Recipe> recipeOptional = repository.findById(recipeId);

        if (!recipeOptional.isPresent()){
            throw  new RuntimeException("Recipe Not Found");
        }

        return recipeOptional.get();
    }
}
