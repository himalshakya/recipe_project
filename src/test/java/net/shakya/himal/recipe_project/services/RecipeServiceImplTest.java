package net.shakya.himal.recipe_project.services;

import net.shakya.himal.recipe_project.domain.Recipe;
import net.shakya.himal.recipe_project.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class RecipeServiceImplTest {

    RecipeService recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        recipeService =  new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipe() {

        Recipe recipe = new Recipe();
        HashSet<Recipe> recipesPassed = new HashSet<>();
        recipesPassed.add(recipe);

        Mockito.when(recipeService.getRecipe()).thenReturn(recipesPassed);


        Set<Recipe> recipes = recipeService.getRecipe();
        assertEquals(recipes.size(), 1);

        Mockito.verify(recipeRepository, Mockito.times(1)).findAll();
    }
}