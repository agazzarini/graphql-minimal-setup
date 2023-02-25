package com.spaziocodice.labs.integration;

import com.spaziocodice.labs.ElectricBassShop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.HttpGraphQlTester;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = ElectricBassShop.class)
@ContextConfiguration(initializers = MiddlewareSetup.class)
@AutoConfigureMockMvc
@AutoConfigureGraphQlTester
@ActiveProfiles("it")
public abstract class IntegrationTestCaseSuperLayer {

    @Autowired
    protected HttpGraphQlTester tester;

    @Autowired
    protected MockMvc mvc;
}