package com.example.spring4.unit;

import com.example.spring4.domain.dto.security.LoginRequest;
import com.example.spring4.domain.entity.User;
import com.example.spring4.repository.UserRepository;
import com.example.spring4.service.TokenService;
import com.example.spring4.service.UserService;
import com.example.spring4.service.impl.AuthServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.same;

/**
 * @author dkotov
 * @since 17.02.2022
 */

@ExtendWith(MockitoExtension.class)
public class AuthServiceImplTest {
    @InjectMocks
    private AuthServiceImpl authServiceImpl;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private UserService userService;
    @Mock
    private TokenService tokenService;
    @Mock
    private UserRepository userRepository;

    @BeforeAll
    public static void beforeClass() {
    }

    @BeforeEach
    public void beforeEach() {

    }

    @Test
    public void testUserNotFoundByEmail() {
        String username = "username";
        LoginRequest loginRequest = LoginRequest.builder().username(username).build();
        Mockito.when(userRepository.findByEmail(username)).thenReturn(Optional.empty());
        try {
            authServiceImpl.login(loginRequest);
            fail("");
        } catch (RuntimeException e) {
            Assertions.assertEquals("User not found", e.getMessage());
        }
    }

    @Test
    public void testMatchPasswordTrue() {
        String username = "username";
        LoginRequest loginRequest = LoginRequest.builder()
                .username(username)
                .password("password1")
                .build();
        User user = new User();
        user.setPassword("password");
        String exceptedToken = "exceptedToken";
        Mockito.when(userRepository.findByEmail(username)).thenReturn(Optional.of(user));
        Mockito.when(passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())).thenReturn(true);
        Mockito.when(tokenService.generateToken(user)).thenReturn(exceptedToken);
        String result = authServiceImpl.login(loginRequest);
        Mockito.verify(tokenService, Mockito.times(1)).generateToken(same(user));
        Assertions.assertEquals(exceptedToken, result);
    }

    @Test
    public void testMatchPasswordFalse() {
        String username = "username";
        LoginRequest loginRequest = LoginRequest.builder()
                .username(username)
                .password("password1")
                .build();
        User user = new User();
        user.setPassword("password");
        Mockito.when(userRepository.findByEmail(username)).thenReturn(Optional.of(user));
        Mockito.when(passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())).thenReturn(false);
        Assertions.assertThrows(RuntimeException.class, () -> authServiceImpl.login(loginRequest));
        Mockito.verify(tokenService, Mockito.times(0)).generateToken(same(user));
    }
}
