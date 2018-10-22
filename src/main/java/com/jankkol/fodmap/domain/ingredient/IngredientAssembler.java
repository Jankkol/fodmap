package com.jankkol.fodmap.domain.ingredient;

import com.jankkol.fodmap.dto.IngredientResource;

public class IngredientAssembler {

    public static Ingredient toEntity(IngredientResource ingredientResource){
        Ingredient ingredient = new Ingredient();
        ingredient.setName(ingredientResource.getName());
        return ingredient;
    }
}
