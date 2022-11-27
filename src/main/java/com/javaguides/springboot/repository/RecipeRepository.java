package com.javaguides.springboot.repository;

import com.javaguides.springboot.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Optional<Recipe> findByUrl(String url);
}
