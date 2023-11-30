package com.br.manu.solicitacaomedicamentoservice.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MedicamentoDto {

    private  Long id;
    private String nome;
    private String funcionalidade;
    private String possiveisReacoes;
    private LocalDate dataValidade;
    private String codigoMedicamento;

}
