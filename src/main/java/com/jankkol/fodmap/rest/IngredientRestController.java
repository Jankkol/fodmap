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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/ingredient")
public class IngredientRestController {

    private final static Logger LOG = LoggerFactory.getLogger(IngredientRestController.class);

    private IngredientSLO ingredientSLO;

    @Autowired
    public IngredientRestController(IngredientSLO ingredientSLO) {
        this.ingredientSLO = ingredientSLO;
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    public HttpEntity<?> deleteIngredient(
            @RequestParam(value = "id") Long id) {
        ingredientSLO.deleteIngredient(id);
        return new ResponseEntity<>(ingredientSLO.findAll(), HttpStatus.OK);
    }


    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public HttpEntity<?> addIngredient(
            @RequestParam(value = "name", defaultValue = "Carrot") String name) {
        IngredientResource ingredientResource = new IngredientResource();
        ingredientResource.setName(name);
        ingredientSLO.storeIngredient(ingredientResource);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public HttpEntity<?> getAllIngredients() {
        return new ResponseEntity<>(ingredientSLO.findAll(), HttpStatus.OK);
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public HttpEntity<?> getIngredient(@RequestParam(value = "id") Long id) {
        return new ResponseEntity<>(ingredientSLO.getIngredient(id), HttpStatus.OK);
    }
}
