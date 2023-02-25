package com.spaziocodice.labs.graphql;

import com.spaziocodice.labs.domain.Bass;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ShopController {
    @QueryMapping
    public List<Bass> instruments(@Argument Integer offset, @Argument Integer pageSize) {

        // In a real context, this would probably use a BassRepository.
        return List.of(
                new Bass("Fender", "Jazz", 1, false, 4),
                new Bass("Fender", "Precision", 2, false, 4),
                new Bass("Laurus", "Quasar Extraharmonic", 3, true, 5));
    }
}
