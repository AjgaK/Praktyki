package com.example.projekt_praktyki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class ProjektPraktykiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjektPraktykiApplication.class, args);
    }

}
