package com.javaguides.springboot.service.impl;

import com.javaguides.springboot.dto.RecipeDto;
import com.javaguides.springboot.entity.Recipe;
import com.javaguides.springboot.mapper.RecipeMapper;
import com.javaguides.springboot.repository.RecipeRepository;
import com.javaguides.springboot.service.RecipeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<RecipeDto> findAllRecipes() {
        List<Recipe> recipes = recipeRepository.findAll();
        return recipes.stream().map(RecipeMapper::mapToRecipeDto)
                .collect(Collectors.toList());
    }

    @Override
    public void createRecipe(RecipeDto recipeDto) {
        Recipe recipe = RecipeMapper.mapToRecipe(recipeDto);
        recipeRepository.save(recipe);
    }

    @Override
    public RecipeDto findRecipeById(Long recipeId) {
        Recipe recipe = recipeRepository.findById(recipeId).get();
        return RecipeMapper.mapToRecipeDto(recipe);
    }

}
