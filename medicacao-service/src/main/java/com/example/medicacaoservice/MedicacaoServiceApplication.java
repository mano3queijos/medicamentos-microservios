package com.example.medicacaoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MedicacaoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicacaoServiceApplication.class, args);
    }

}
