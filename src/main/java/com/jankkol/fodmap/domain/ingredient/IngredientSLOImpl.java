package com.jankkol.fodmap.domain.ingredient;

import com.jankkol.fodmap.dto.IngredientResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IngredientSLOImpl implements IngredientSLO {

    private IngredientRepository ingredientRepository;

    @Autowired
    public IngredientSLOImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void storeIngredient(IngredientResource ingredientResource) {
        ingredientRepository.save(ingredientResource);
    }
}
