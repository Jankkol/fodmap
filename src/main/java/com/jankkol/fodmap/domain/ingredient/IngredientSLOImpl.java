package com.jankkol.fodmap.domain.ingredient;

import com.jankkol.fodmap.dto.IngredientResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class IngredientSLOImpl implements IngredientSLO {

    private IngredientRepository ingredientRepository;

    @Autowired
    public IngredientSLOImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void storeIngredient(IngredientResource ingredientResource) {
        ingredientRepository.save(IngredientAssembler.toEntity(ingredientResource));
    }

    @Override
    public List<Ingredient> findAll() {
        return ingredientRepository.findAll().stream().map(IngredientAssembler::toDto).collect(Collectors.toList());
    }

    @Override
    public void deleteIngredient(Long id) {
        ingredientRepository.deleteById(id);
    }

    @Override
    public Optional<Ingredient> getIngredient(Long id) {
        return ingredientRepository.findById(id);
    }
}
