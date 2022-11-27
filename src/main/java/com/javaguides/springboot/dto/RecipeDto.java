package com.javaguides.springboot.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    @NotEmpty
    private String name;
    private String url;
    @NotEmpty
    private String content;
    @NotEmpty
    private String shortDescriptionIngredients;
    private String instructions;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
