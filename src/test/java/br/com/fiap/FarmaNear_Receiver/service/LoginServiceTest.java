package br.com.fiap.FarmaNear_Receiver.service;

import br.com.fiap.FarmaNear_Receiver.controller.dto.LoginDTO;
import br.com.fiap.FarmaNear_Receiver.controller.dto.UserDTO;
import br.com.fiap.FarmaNear_Receiver.infra.security.TokenService;
import br.com.fiap.FarmaNear_Receiver.model.RoleEnum;
import br.com.fiap.FarmaNear_Receiver.model.User;
import br.com.fiap.FarmaNear_Receiver.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LoginServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private TokenService tokenService;

    @InjectMocks
    private LoginService loginService;

    private BCryptPasswordEncoder encoder;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        encoder = new BCryptPasswordEncoder();
    }

    @Test
    void shouldLoginSuccessfully() {
        // Arrange
        String login = "testUser";
        String password = "password123";
        String encodedPassword = encoder.encode(password);
        User user = new User(login, "Test User", encodedPassword, RoleEnum.PATIENT);

        when(userRepository.findByLogin(login)).thenReturn(Optional.of(user));
        when(tokenService.generateToken(login)).thenReturn("mockedToken");

        LoginDTO loginDTO = new LoginDTO(login, password, "name", RoleEnum.PATIENT);

        // Act
        UserDTO result = loginService.login(loginDTO);

        // Assert
        assertNotNull(result);
        assertEquals("mockedToken", result.authToken());
        assertEquals("Test User", result.name());
        assertEquals(RoleEnum.PATIENT, result.role());

        verify(userRepository, times(1)).findByLogin(login);
        verify(tokenService, times(1)).generateToken(login);
    }

    @Test
    void shouldThrowExceptionWhenUserNotFound() {
        // Arrange
        String login = "nonExistentUser";
        String password = "password123";

        when(userRepository.findByLogin(login)).thenReturn(Optional.empty());

        LoginDTO loginDTO = new LoginDTO(login, password, "name", RoleEnum.PATIENT);

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> loginService.login(loginDTO));
        assertEquals("User not found", exception.getMessage());

        verify(userRepository, times(1)).findByLogin(login);
        verifyNoInteractions(tokenService);
    }

    @Test
    void shouldThrowExceptionWhenPasswordIsIncorrect() {
        // Arrange
        String login = "testUser";
        String password = "wrongPassword";
        String encodedPassword = encoder.encode("correctPassword");
        User user = new User(login, "Test User", encodedPassword, RoleEnum.PATIENT);

        when(userRepository.findByLogin(login)).thenReturn(Optional.of(user));

        LoginDTO loginDTO = new LoginDTO(login, password, "name", RoleEnum.PATIENT);

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> loginService.login(loginDTO));
        assertEquals("Wrong password", exception.getMessage());

        verify(userRepository, times(1)).findByLogin(login);
        verifyNoInteractions(tokenService);
    }
}