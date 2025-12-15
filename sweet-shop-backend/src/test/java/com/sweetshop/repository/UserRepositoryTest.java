package com.sweetshop.repository;

import com.sweetshop.model.Role;
import com.sweetshop.model.User;
import com.sweetshop.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void shouldFindUserByUsername() {
        User user = User.builder()
                .username("testuser")
                .email("test@example.com")
                .password("password")
                .role("USER")
                .build();

        entityManager.persistAndFlush(user);

        Optional<User> found = userRepository.findByUsername("testuser");

        assertThat(found).isPresent();
        assertThat(found.get().getUsername()).isEqualTo("testuser");
    }
}
