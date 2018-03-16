package net.shakya.himal.recipe_project.controllers;

import lombok.extern.slf4j.Slf4j;
import net.shakya.himal.recipe_project.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IngredientController {

    private final RecipeService service;

    public IngredientController(RecipeService service) {
        this.service = service;
    }

    @GetMapping
    @RequestMapping("/recipe/{recipeId}/ingredients/show")
    public String listIngredients(@PathVariable String recipeId, Model model){
        log.debug("Getting ingredient list for recipe id: " + recipeId);

        // use command object to avoid lazy load errors in Thymeleaf
        model.addAttribute("recipe", service.findCommandById(Long.valueOf(recipeId)));

        return "recipe/ingredient/list";
    }
}
