package com.jankkol.fodmap.ingredient;

import com.jankkol.fodmap.FodmapApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = FodmapApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:db-test.properties")
public class IngredientRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void initTest() throws Exception {
        this.mockMvc.perform(get("/test")).andDo(print());
    }
}
