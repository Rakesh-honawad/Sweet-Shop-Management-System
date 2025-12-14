package com.sweetshop.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @Test
    void shouldCreateUserWithAllFields() {
        // Given
        User user = new User();
        user.setEmail("test@example.com");
        user.setUsername("testuser");
        user.setPassword("hashedpassword");
        user.setRole("USER");

        // Then
        assertThat(user.getEmail()).isEqualTo("test@example.com");
        assertThat(user.getUsername()).isEqualTo("testuser");
        assertThat(user.getRole()).isEqualTo("USER");
    }
}
