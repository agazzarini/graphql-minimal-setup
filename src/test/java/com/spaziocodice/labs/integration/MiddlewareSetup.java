package com.spaziocodice.labs.integration;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.containers.wait.strategy.Wait;

import java.io.File;
import java.time.Duration;

@SuppressWarnings("rawtypes")
public class MiddlewareSetup implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    public static DockerComposeContainer SUBSYSTEMS;

    @Override
    public void initialize(ConfigurableApplicationContext context) {
        if (SUBSYSTEMS == null) {
            var dockerCompose = new File(System.getProperty("user.dir"), "src/test/resources/docker/docker-compose.yml");
            SUBSYSTEMS =
                    new DockerComposeContainer(dockerCompose)
                            .withExposedService(
                                    "postgres_1",
                                    5432,
                                    Wait.forListeningPort().withStartupTimeout(Duration.ofMinutes(5)));
            SUBSYSTEMS.start();
        }
   }
}