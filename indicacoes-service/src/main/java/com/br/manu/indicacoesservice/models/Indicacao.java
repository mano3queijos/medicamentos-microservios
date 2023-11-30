package com.br.manu.indicacoesservice.models;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "indicacoes")
public class Indicacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    private String indicacoesMedicas;
    private String medicoSolicitante;
    private String pacienteIdentificador;
    private String identificador;
    private LocalDateTime dataHoraRequisicao;








}
