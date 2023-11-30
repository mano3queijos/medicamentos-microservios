package com.br.manu.solicitacaomedicamentoservice.repositories;


import com.br.manu.solicitacaomedicamentoservice.models.Solocitacoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SolicitacoesRepository extends JpaRepository<Solocitacoes, Long> {


    List<Solocitacoes> getAllByMedicoIdentificadorAndDAndDataHoraIdentificadoraAndAndPacienteIdentificador(@Param("medicoIdentificador") String medicoIdentificador,
                                                                                                           @Param("dataHoraIdentificadora") LocalDateTime dataHoraIdentificadora,
                                                                                                           @Param("pacienteIdentificador") String pacienteIdentificador);


}
