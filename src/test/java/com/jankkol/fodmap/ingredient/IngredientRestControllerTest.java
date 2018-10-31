package com.jankkol.fodmap.ingredient;

import com.jankkol.fodmap.base.BaseIntegrationTest;
import com.jankkol.fodmap.domain.ingredient.Ingredient;
import com.jankkol.fodmap.domain.ingredient.IngredientRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
public class IngredientRestControllerTest extends BaseIntegrationTest {

    private static final String BASE_URL = "/ingredient";


    @Autowired
    private IngredientRepository ingredientRepository;

    @Before
    public void setup() {
        Ingredient ingredient = new Ingredient();
        ingredient.setName("Apple");
        ingredientRepository.save(ingredient);
        Ingredient ingredient1 = new Ingredient();
        ingredient1.setName("Cranberry");
        ingredientRepository.save(ingredient1);
        Ingredient ingredient2 = new Ingredient();
        ingredient2.setName("Tomato");
        ingredientRepository.save(ingredient2);
    }

    @After
    public void cleanUp() {
        ingredientRepository.deleteAll();
    }

    @Test
    public void addIngredientTest() throws Exception {
        Ingredient ingredient = new Ingredient();
        ingredient.setName("potato");
        ingredientRepository.save(ingredient);
        mockMvc.perform(put(BASE_URL)).andDo(print());

        Ingredient byName = ingredientRepository.findByName("potato");
        assertThat(byName, isNotNull());
    }

    @Test
    public void deleteIngredientTest() throws Exception {
        //WHEN
        int ingredients = ingredientRepository.findAll().size();
        Ingredient byName = ingredientRepository.findByName("Apple");
        mockMvc.perform(delete(BASE_URL).param("id", String.valueOf(byName.getId()))).andDo(print());

        //THEN
        int ingredientAfterDelete = ingredientRepository.findAll().size();
        Optional<Ingredient> ingredient = ingredientRepository.findById(2L);
        assertThat(ingredientAfterDelete, is(ingredients - 1));
        assertThat(ingredient.isPresent(), is(false));

    }

    @Test
    public void getAllIngredientTest() throws Exception {
        mockMvc.perform(get(BASE_URL + "/all")).andDo(print());
    }

    @Test
    public void getIngredientTest() throws Exception {
        mockMvc.perform(get(BASE_URL)).andDo(print());
    }
}
