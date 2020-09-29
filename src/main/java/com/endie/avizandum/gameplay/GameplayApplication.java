package com.endie.avizandum.gameplay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.endie.avizandum.gameplay"})
public class GameplayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameplayApplication.class, args);
    }

}
