package com.br.manu.solicitacaomedicamentoservice.models;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Data
@Table(name = "solocitacoes")
public class Solocitacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String medicoIdentificador;
    private String medicamentoIndentificador;
    private LocalDateTime dataHoraIdentificadora;
    private String pacienteIdentificador;


}
