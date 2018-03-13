package net.shakya.himal.recipe_project.controllers;


import lombok.extern.slf4j.Slf4j;
import net.shakya.himal.recipe_project.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class RecipeController {

    private final RecipeService service;

    public RecipeController(RecipeService service) {
        this.service = service;
    }

    @RequestMapping("/recipe/show/{id}")
    public String showById(@PathVariable String id, Model model){

        log.debug("Recipe found is:");
        log.debug("---->  " + service.findById(new Long(id)));

        model.addAttribute("recipe", service.findById(new Long(id)));

        return "recipe/show";
    }
}
