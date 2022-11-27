package com.javaguides.springboot.mapper;

import com.javaguides.springboot.dto.RecipeDto;
import com.javaguides.springboot.entity.Recipe;

public class RecipeMapper {

    //map Recipe entity to RecipeDto
    public static RecipeDto mapToRecipeDto(Recipe recipe){
      return RecipeDto.builder()
                .id(recipe.getId())
                .url(recipe.getUrl())
                .content(recipe.getContent())
                .shortDescriptionIngredients(recipe.getShortDescriptionIngredients())
                .instructions(recipe.getInstructions())
                .createdOn(recipe.getCreatedOn())
                .updatedOn(recipe.getUpdatedOn())
                .build();
    }

    // map Recipedto to Recipe entity
    public static Recipe mapToRecipe(RecipeDto recipeDto) {
        return Recipe.builder()
                .id(recipeDto.getId())
                .url(recipeDto.getUrl())
                .content(recipeDto.getContent())
                .shortDescriptionIngredients(recipeDto.getShortDescriptionIngredients())
                .instructions(recipeDto.getInstructions())
                .createdOn(recipeDto.getCreatedOn())
                .updatedOn(recipeDto.getUpdatedOn())
                .build();

    }

    }

