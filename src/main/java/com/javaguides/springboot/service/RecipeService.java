package com.javaguides.springboot.service;

import com.javaguides.springboot.dto.RecipeDto;

import java.util.List;

public interface RecipeService {
    List<RecipeDto> findAllRecipes();

    void createRecipe(RecipeDto recipeDto);

    RecipeDto findRecipeById(Long recipeId);
}
