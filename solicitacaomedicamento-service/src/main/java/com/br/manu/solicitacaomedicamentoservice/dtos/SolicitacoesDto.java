package com.br.manu.solicitacaomedicamentoservice.dtos;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class SolicitacoesDto {

    private Long id;
    private String medicoIdentificador;
    private String pacienteIdentificador;
    private String medicamentoIndentificador;
    private LocalDateTime dataHoraIdentificadora;
    private List<IndicacoesDto> indicacoesDto;
    private List<MedicamentoDto> medicamentoDto;
}
