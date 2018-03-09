package net.shakya.himal.recipe_project.controllers;

import lombok.extern.slf4j.Slf4j;
import net.shakya.himal.recipe_project.domain.Category;
import net.shakya.himal.recipe_project.domain.UnitOfMeasure;
import net.shakya.himal.recipe_project.repositories.CategoryRepository;
import net.shakya.himal.recipe_project.repositories.UnitOfMeasureRepository;
import net.shakya.himal.recipe_project.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Slf4j
@Controller
public class IndexController {

    private final RecipeService service;

    public IndexController(RecipeService service) {
        this.service = service;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model){
        log.debug("Starting Index Page .........");

        model.addAttribute("recipes", service.getRecipe());

        return "index";
    }
}
