package com.javaguides.springboot.controller;

import com.javaguides.springboot.dto.RecipeDto;
import com.javaguides.springboot.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ClientController {

    private RecipeService recipeService;

    public ClientController(RecipeService recipeService) {

        this.recipeService = recipeService;
    }

    // handler method to handle http://localhost:8080/
    @GetMapping("/")
    public String viewClientRecipes(Model model){
        List<RecipeDto> recipesResponse =  recipeService.findAllRecipes();
        model.addAttribute("recipesResponse", recipesResponse);
        return "client/view_recipes";

    }

    // handler method to handle view recipe request
    @GetMapping("/recipe/{recipeUrl}")
    private String showRecipe(@PathVariable("recipeUrl") String recipeUrl,
                               Model model){
        RecipeDto recipe = recipeService.findRecipeByUrl(recipeUrl);
        model.addAttribute("recipe", recipe);
        return "client/client_recipe";

    }


    // handler method to handle client recipe search request
    // http://localhost:8080/page/search?query=java
    @GetMapping("/page/search")
    public  String searchRecipes(@RequestParam(value = "query") String query,
                                 Model model){
        List<RecipeDto> recipesResponse = recipeService.searchRecipes(query);
        model.addAttribute("recipesResponse", recipesResponse);
        return "client/view_recipes";


    }

}
