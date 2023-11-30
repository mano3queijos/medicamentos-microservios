package com.br.manu.solicitacaomedicamentoservice.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class IndicacoesDto {

    private  Long id;
    private String indicacoesMedicas;
    private String medicoSolicitante;
    private String pacienteIdentificador;
    private String identificador;
    private LocalDateTime dataHoraRequisicao;


}
