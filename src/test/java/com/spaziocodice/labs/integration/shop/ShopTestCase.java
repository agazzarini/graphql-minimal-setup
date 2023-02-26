package com.spaziocodice.labs.integration.shop;

import com.spaziocodice.labs.domain.Bass;
import com.spaziocodice.labs.integration.IntegrationTestCaseSuperLayer;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static java.util.Optional.of;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class ShopTestCase extends IntegrationTestCaseSuperLayer {
    @Test
    void findSomeBasses() {
        String query =
                "query {" +
                "  instruments {" +
                "      id" +
                "      brand" +
                "      model" +
                "      fretless" +
                "      strings" +
                "  }" +
                "}";
        var basses =
                tester.document(query)
                        .execute()
                        .path("data.instruments[*]")
                        .entityList(Bass.class)
                        .get();
        assertThat(basses).asList().hasSize(3);

        // Not so robust/complete as test...
        var fenderJazz =
                of(basses.iterator())
                        .map(Iterator::next)
                        .map(Bass.class::cast)
                        .orElseThrow();
        assertThat(fenderJazz.getStrings()).isEqualTo(4);
        assertThat(fenderJazz.getModel()).isEqualTo("Jazz Vintage 62");
        assertThat(fenderJazz.getBrand()).isEqualTo("Fender");
        assertThat(fenderJazz.isFretless()).isFalse();
    }
}
