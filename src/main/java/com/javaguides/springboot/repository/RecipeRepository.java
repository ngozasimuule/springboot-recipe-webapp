package com.javaguides.springboot.repository;

import com.javaguides.springboot.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Optional<Recipe> findByUrl(String url);

    @Query("SELECT r from Recipe r WHERE " +
    " r.name LIKE CONCAT('%', :query, '%') OR " +
    "r.shortDescriptionIngredients LIKE CONCAT('%', :query, '%')")
    List<Recipe> searchRecipes(String query);
}
