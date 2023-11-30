package com.br.manu.indicacoesservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IndicacaoConfig {


    @Bean
    public ModelMapper modelMapper()
    {
        return new ModelMapper();
    }

}
