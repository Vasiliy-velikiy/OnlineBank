package com.example.spring4.integration;

import com.example.spring4.domain.dto.security.SignUpRequest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.BEFORE_CLASS;

/**
 * @author dkotov
 * @since 17.02.2022
 */
@ActiveProfiles("TEST")
@AutoConfigureWebTestClient
@DirtiesContext(classMode = BEFORE_CLASS)
@SpringBootTest(
        webEnvironment = RANDOM_PORT,
        properties = {
                "spring.datasource.url=jdbc:tc:postgresql:9.6-alpine:///test",
                "spring.session.datasource.jdbc-url=jdbc:tc:postgresql:9.6-alpine:///test",
                "spring.datasource.driver-class-name=org.testcontainers.jdbc.ContainerDatabaseDriver"
        }
)
public abstract class AbstractTest {

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    protected WebTestClient webTestClient;

    protected String token;

    protected <T> T getClassPathResourceAsObject(String path, TypeReference<T> reference) {
        try {
            InputStream resource = new ClassPathResource(path).getInputStream();
            return objectMapper.readValue(resource, reference);
        } catch (IOException e) {
            throw new IllegalStateException();
        }
    }

    @BeforeEach
    public void setUp() {
        token = webTestClient.post()
                .uri(uriBuilder -> uriBuilder.path("/auth/sign-up").build())
                .bodyValue(SignUpRequest.builder().username("user").password("password").build())
                .exchange()
                .returnResult(String.class)
                .getResponseBody()
                .blockFirst();
        webTestClient = webTestClient.mutate()
                .defaultHeaders(httpHeaders -> httpHeaders.add("AUTHORIZATION", token))
                .build();
    }
}
