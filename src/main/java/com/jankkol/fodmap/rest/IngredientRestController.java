package com.jankkol.fodmap.rest;

import com.jankkol.fodmap.domain.ingredient.IngredientSLO;
import com.jankkol.fodmap.dto.IngredientResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IngredientRestController {

    private final static Logger LOG = LoggerFactory.getLogger(IngredientRestController.class);

    private IngredientSLO ingredientSLO;

    @Autowired
    public IngredientRestController(IngredientSLO ingredientSLO) {
        this.ingredientSLO = ingredientSLO;
    }

    @RequestMapping(path = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<IngredientResource> printHello(
            @RequestParam(value = "name", defaultValue = "Carrot") String name) {
        LOG.info("Print hello world");
        IngredientResource ingredientResource = new IngredientResource();
        ingredientResource.setName(name);
        ingredientSLO.storeIngredient(ingredientResource);
        return new ResponseEntity<>(ingredientResource, HttpStatus.OK);
    }
}
