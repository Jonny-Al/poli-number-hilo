package com.poli.hilos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@Configuration
@EnableAsync
public class HilosApplication {

    public static void main(String[] args) {
        SpringApplication.run(HilosApplication.class, args);
    }

}
