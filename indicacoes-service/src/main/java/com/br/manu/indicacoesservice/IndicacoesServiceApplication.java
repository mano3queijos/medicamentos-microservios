package com.br.manu.indicacoesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class IndicacoesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IndicacoesServiceApplication.class, args);
	}

}
