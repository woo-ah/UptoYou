package com.example.uptoyou_game3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class UptoYouGame3Application {

    public static void main(String[] args) {
        SpringApplication.run(UptoYouGame3Application.class, args);
    }

}
