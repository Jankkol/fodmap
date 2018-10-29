package com.jankkol.fodmap.domain.ingredient;

import com.jankkol.fodmap.dto.IngredientResource;

import java.util.List;

public interface IngredientSLO {

    void storeIngredient(IngredientResource ingredientResource);

    List<Ingredient> findAll();

    void deleteIngredient(Long id);

    Ingredient getIngredient(Long id);
}
