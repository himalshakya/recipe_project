package net.shakya.himal.recipe_project.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryTest {

    Category category;

    @Before
    public void setUp(){
        category = new Category();
    }

    @Test
    public void getId() {
        final long TEST_VALUE = 41l;
        category.setId(TEST_VALUE);
        assertEquals(TEST_VALUE, category.getId());
    }

    @Test
    public void getName() {
    }

    @Test
    public void getRecipes() {
    }
}