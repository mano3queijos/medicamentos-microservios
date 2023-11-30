package com.example.medicacaoservice.models;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "medicamentos")
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private String nome;
    private String funcionalidade;
    private String possiveisReacoes;
    private LocalDate dataValidade;
    private String codigoMedicamento;





}
