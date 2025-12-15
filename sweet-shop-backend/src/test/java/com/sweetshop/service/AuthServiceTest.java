package com.sweetshop.service;

import com.sweetshop.dto.AuthResponse;
import com.sweetshop.dto.LoginRequest;
import com.sweetshop.dto.RegisterRequest;
import com.sweetshop.model.User;
import com.sweetshop.repository.UserRepository;
import com.sweetshop.security.JwtTokenProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class AuthServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private JwtTokenProvider jwtTokenProvider;

    @InjectMocks
    private AuthService authService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegister() {
        RegisterRequest request = new RegisterRequest("testuser", "test@example.com", "password123");
        
        // Create proper UserDetails for Authentication
        UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
                .username("testuser")
                .password("encodedPassword")
                .authorities(new ArrayList<>())
                .build();
        
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities());
        
        User user = User.builder()
                .username("testuser")
                .email("test@example.com")
                .password("encodedPassword")
                .role("USER")
                .build();

        when(passwordEncoder.encode(request.getPassword())).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class))).thenReturn(user);
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
                .thenReturn(authentication);
        when(jwtTokenProvider.generateToken(authentication)).thenReturn("mock-jwt-token");

        AuthResponse result = authService.register(request);

        assertThat(result).isNotNull();
        assertThat(result.getUsername()).isEqualTo("testuser");
        assertThat(result.getToken()).isNotNull();
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    public void testLogin() {
        LoginRequest request = new LoginRequest("testuser", "password123");
        
        // Create proper UserDetails for Authentication
        UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
                .username("testuser")
                .password("encodedPassword")
                .authorities(new ArrayList<>())
                .build();
        
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities());
        
        User user = User.builder()
                .username("testuser")
                .email("test@example.com")
                .password("encodedPassword")
                .role("USER")
                .build();

        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
                .thenReturn(authentication);
        when(jwtTokenProvider.generateToken(authentication)).thenReturn("mock-jwt-token");
        when(userRepository.findByUsername("testuser")).thenReturn(Optional.of(user));

        AuthResponse response = authService.login(request);

        assertThat(response).isNotNull();
        assertThat(response.getToken()).isEqualTo("mock-jwt-token");
        assertThat(response.getUsername()).isEqualTo("testuser");
        verify(authenticationManager, times(1)).authenticate(any());
    }
}
