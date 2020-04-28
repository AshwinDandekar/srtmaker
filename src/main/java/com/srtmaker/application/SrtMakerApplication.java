package com.srtmaker.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.srtmaker"})
public class SrtMakerApplication {
    public static void main(String[] args)
    {
        SpringApplication.run(SrtMakerApplication.class, args);
    }
}
