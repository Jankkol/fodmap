package com.jankkol.fodmap.domain.ingredient;

import com.jankkol.fodmap.dto.IngredientResource;

import java.util.List;
import java.util.Optional;

public interface IngredientSLO {

    void storeIngredient(IngredientResource ingredientResource);

    List<Ingredient> findAll();

    void deleteIngredient(Long id);

    Optional<Ingredient> getIngredient(Long id);
}
