package com.sweetshop.repository;

import com.sweetshop.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void shouldSaveUser() {
        User user = new User();
        user.setEmail("test@example.com");
        user.setUsername("testuser");
        user.setPassword("hashedpassword");
        user.setRole("USER");

        User savedUser = userRepository.save(user);

        assertThat(savedUser.getId()).isNotNull();
        assertThat(savedUser.getEmail()).isEqualTo("test@example.com");
    }

    @Test
    void shouldFindUserByEmail() {
        User user = new User();
        user.setEmail("find@example.com");
        user.setUsername("finduser");
        user.setPassword("hashedpassword");
        user.setRole("USER");
        userRepository.save(user);

        Optional<User> found = userRepository.findByEmail("find@example.com");

        assertThat(found).isPresent();
        assertThat(found.get().getUsername()).isEqualTo("finduser");
    }
}