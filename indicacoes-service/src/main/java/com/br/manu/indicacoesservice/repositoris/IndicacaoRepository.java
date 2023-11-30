package com.br.manu.indicacoesservice.repositoris;

import com.br.manu.indicacoesservice.models.Indicacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface IndicacaoRepository extends JpaRepository<Indicacao, String> {


    Optional<Indicacao> findMedicamentoByidentificador(@Param("identificador") String identificador);
    List<Indicacao> findAllByPacienteIdentificadorAndAndDataHoraRequisicaoAndMedicoSolicitante(
            @Param("pacienteIdentificador") String pacienteIdentificador,
            @Param("dataHoraRequisicao") LocalDateTime dataHoraRequisicao,
            @Param("medicoSolicitante")String medicoSolicitante

    );



}
