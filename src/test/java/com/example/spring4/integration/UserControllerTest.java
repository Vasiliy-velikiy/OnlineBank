package com.example.spring4.integration;

import com.example.spring4.domain.dto.UserCreateDto;
import com.example.spring4.domain.dto.UserDto;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author dkotov
 * @since 17.02.2022
 */
public class UserControllerTest extends AbstractTest {
    @Test
    public void testCreateUser() {
        UserCreateDto request = getClassPathResourceAsObject("/request/user/create_user.json", new TypeReference<>() {
        });
        UserDto excepted = getClassPathResourceAsObject("/excepted/user/created_user.json", new TypeReference<>() {
        });
        webTestClient
                .post()
                .uri(uriBuilder -> uriBuilder.path("/users").build())
                .bodyValue(request)
                .exchange()
                .expectStatus().isOk()
                .expectBody(UserDto.class)
                .value(result -> assertThat(result)
                        .as("")
                        .usingRecursiveComparison()
                        .ignoringFields("id")
                        .isEqualTo(excepted)
                );
    }
}
