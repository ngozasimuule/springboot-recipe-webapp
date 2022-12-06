package com.javaguides.springboot.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecipeDto {
    private Long id;
    @NotEmpty(message = "Recipe Name should not be empty")
    private String name;
    private String url;
    @NotEmpty(message = "Instructions should not be empty")
    private String instructions;
    @NotEmpty(message = "short Description Ingredients should not be empty")
    private String shortDescriptionIngredients;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
