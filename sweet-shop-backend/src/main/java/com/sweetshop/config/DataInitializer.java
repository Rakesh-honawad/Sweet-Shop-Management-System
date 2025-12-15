package com.sweetshop.config;

import com.sweetshop.model.User;
import com.sweetshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Create default admin if not exists
        if (userRepository.findByUsername("admin").isEmpty()) {
            User admin = User.builder()
                    .username("admin")
                    .email("admin@sweetshop.com")
                    .password(passwordEncoder.encode("admin123"))
                    .role("ADMIN")
                    .build();
            userRepository.save(admin);
            System.out.println("✅ Default admin user created: username=admin, password=admin123");
        }
    }
}
