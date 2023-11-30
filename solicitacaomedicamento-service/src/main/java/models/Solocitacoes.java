package models;


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
    private  Long id;

private String pacienteCpf;
private String pacienteNome;
private String medicoSolicitante;
private String justificativa;
private LocalDateTime dataHoraAtual = LocalDateTime.now();
    @ElementCollection
    @CollectionTable(name = "indicacoes_list", joinColumns = @JoinColumn(name = "solocitacao_id"))
    @Column(name = "indicacao")
private List<String> indicacoesList;




}
