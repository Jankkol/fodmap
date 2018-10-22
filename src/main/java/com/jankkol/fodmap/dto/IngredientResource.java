package com.jankkol.fodmap.dto;

import com.jankkol.fodmap.domain.ingredient.Ingredient;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class IngredientResource extends Ingredient {
}
