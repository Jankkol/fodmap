package com.jankkol.fodmap.domain.ingredient;


import com.jankkol.fodmap.domain.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends BaseRepository<Ingredient, Long> {
}
