package com.jankkol.fodmap.rest;

import com.jankkol.fodmap.dto.SampleJsonResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleRestController {

    private final static Logger LOG = LoggerFactory.getLogger(SampleRestController.class);

    @RequestMapping(path = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<SampleJsonResource> printHello(
            @RequestParam(value = "name", defaultValue = "Janek") String name) {
        LOG.info("Print hello world");
        SampleJsonResource sampleJsonResource = new SampleJsonResource();
        sampleJsonResource.setName(name);
        sampleJsonResource.setAge(26);
        return new ResponseEntity<>(sampleJsonResource, HttpStatus.OK);
    }
}
