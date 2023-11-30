package com.br.manu.solicitacaomedicamentoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SolicitacaomedicamentoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SolicitacaomedicamentoServiceApplication.class, args);
    }

}
