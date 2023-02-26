package com.spaziocodice.labs.api;

import com.spaziocodice.labs.domain.Bass;
import com.spaziocodice.labs.domain.repository.BassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ShopController {

    // In a real context there should be a service that mediates and adds logic
    // between the resolver and the repository.
    @Autowired
    BassRepository bassRepository;

    @QueryMapping
    public Iterable<Bass> instruments(@Argument Integer offset, @Argument Integer pageSize) {
        // For simplicity, input parameters are not used, here.
        return bassRepository.findAll();
    }
}
