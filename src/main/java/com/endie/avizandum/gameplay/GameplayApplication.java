package com.endie.avizandum.gameplay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.endie.avizandum.gameplay.repository")
@EntityScan(basePackages = {"com.endie.avizandum.gameplay.model"})
public class GameplayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameplayApplication.class, args);
    }

}
