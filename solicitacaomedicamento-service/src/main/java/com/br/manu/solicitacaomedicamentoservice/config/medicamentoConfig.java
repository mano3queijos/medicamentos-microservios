package com.br.manu.solicitacaomedicamentoservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class medicamentoConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
