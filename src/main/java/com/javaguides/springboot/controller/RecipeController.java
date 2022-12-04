package com.javaguides.springboot.controller;

import com.javaguides.springboot.dto.RecipeDto;
import com.javaguides.springboot.service.RecipeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    // create handler method, GET request and return model and view
    @GetMapping("/admin/recipes")
    public String recipe(Model model){
        List<RecipeDto> recipes = recipeService.findAllRecipes();
        model.addAttribute("recipes", recipes);
        return "/admin/recipes";

    }

    // handler method to handle new recipe request
    @GetMapping("admin/recipes/newrecipe")
    public String newRecipeForm(Model model){
        RecipeDto recipeDto = new RecipeDto();
        model.addAttribute("recipe", recipeDto);
        return "admin/create_recipe";
    }

    // handler method to handle form submit request
    @PostMapping("/admin/recipes")
    public String createRecipe(@Valid @ModelAttribute("recipe") RecipeDto recipeDto,
                               BindingResult result,
                               Model model){
        if(result.hasErrors()){
            model.addAttribute("recipe", recipeDto);
            return "admin/create_recipe";


        }

        recipeDto.setUrl(getUrl(recipeDto.getName()));
        recipeService.createRecipe(recipeDto);
        return "redirect:/admin/recipes";
    }

    //handler method to handle edit recipe requests
    @GetMapping("/admin/recipes/{recipeId}/edit")
    public String editRecipeForm(@PathVariable("recipeId") Long recipeId,
                                 Model model) {

        RecipeDto recipeDto = recipeService.findRecipeById(recipeId);
        model.addAttribute("recipe", recipeDto);
        return "admin/edit_recipe";

    }

    //handler method to handle edit recipe form submit request
    @PostMapping("/admin/recipes/{recipeId}")
    public String updateRecipe(@PathVariable("recipeId") Long recipeId,
                              @Valid @ModelAttribute("recipe") RecipeDto recipe,
                                BindingResult result,
                               Model model){

        if(result.hasErrors()){
            model.addAttribute("recipe", recipe);
            return "admin/edit_recipe";
        }

        recipe.setId(recipeId);
        recipeService.updateRecipe(recipe);
        return "redirect:/admin/recipes";

    }


    //handler method to handle delete recipe request
    @GetMapping("/admin/recipes/{recipeId}/delete")
    public String deleteRecipe(@PathVariable("recipeId") Long recipeId){
        recipeService.deleteRecipe(recipeId);
        return "redirect:/admin/recipes";
    }

    //handler method to handle view recipe request
    @GetMapping("/admin/recipes/{recipeUrl}/view")
    public String viewRecipe(@PathVariable("recipeUrl") String recipeUrl,
                   Model model ){
        RecipeDto recipeDto = recipeService.findRecipeByUrl(recipeUrl);
        model.addAttribute("recipe", recipeDto);
        return "admin/view_recipe";

    }


    //handler method to search recipe request
    //localhost:8080/admin/recipes/search?query=java
    @GetMapping("/admin/recipes/search")
    public String searchRecipes(@RequestParam(value = "query") String query,
                                Model model){
        List<RecipeDto> recipes = recipeService.searchRecipes(query);
        model.addAttribute("recipes", recipes);
        return "admin/recipes";

    }
    private static String getUrl(String recipeName){
        //OOPS Concepts Explained in Java
        // oop-concepts-explained-in-java
        String name = recipeName.trim().toLowerCase();
        String url = name.replaceAll("\\s+","-");
        url = url.replaceAll("[^A-Za-z0-9]","-");
        return url;


    }

}
