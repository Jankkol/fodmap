package com.jankkol.fodmap.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.ResourceSupport;

@EqualsAndHashCode(callSuper = true)
@Data
public class SampleJsonResource extends ResourceSupport {

    private String name;

    private int age;
}

