package com.javaguides.springboot.service;

import com.javaguides.springboot.dto.RecipeDto;

import java.util.List;

public interface RecipeService {
    List<RecipeDto> findAllRecipes();

    void createRecipe(RecipeDto recipeDto);

    RecipeDto findRecipeById(Long recipeId);

    void updateRecipe(RecipeDto recipeDto);

    void deleteRecipe(Long recipeId);

    RecipeDto findRecipeByUrl(String recipeUrl);

    List<RecipeDto> searchRecipes(String query);
}
