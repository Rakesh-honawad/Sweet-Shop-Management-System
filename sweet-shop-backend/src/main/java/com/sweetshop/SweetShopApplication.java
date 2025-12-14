package com.sweetshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.sweetshop.repository")
public class SweetShopApplication {
    public static void main(String[] args) {
        SpringApplication.run(SweetShopApplication.class, args);
    }
}
