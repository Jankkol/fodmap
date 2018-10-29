package com.jankkol.fodmap.ingredient;

import com.jankkol.fodmap.base.BaseIntegrationTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
public class IngredientRestControllerTest extends BaseIntegrationTest {

    private static final String BASE_URL = "/ingredient";

    @Test
    public void addIngredientTest() throws Exception {
        mockMvc.perform(put(BASE_URL)).andDo(print());
    }

    @Test
    public void deleteIngredientTest() throws Exception {
        mockMvc.perform(delete(BASE_URL)).andDo(print());
    }

    @Test
    public void getAllIngredientTest() throws Exception {
        mockMvc.perform(get(BASE_URL)).andDo(print());
    }

    @Test
    public void getIngredientTest() throws Exception {
        mockMvc.perform(get(BASE_URL + "/all")).andDo(print());
    }
}
