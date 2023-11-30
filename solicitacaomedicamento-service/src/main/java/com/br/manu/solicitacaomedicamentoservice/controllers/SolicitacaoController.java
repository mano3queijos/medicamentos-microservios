package com.br.manu.solicitacaomedicamentoservice.controllers;


import com.br.manu.solicitacaomedicamentoservice.dtos.SolicitacoesDto;
import com.br.manu.solicitacaomedicamentoservice.models.Solocitacoes;
import com.br.manu.solicitacaomedicamentoservice.services.MedicamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@RequestMapping("/solicitacoes")
@RestController
public class SolicitacaoController {

    @Autowired
    MedicamentoService medicamentoService;


    @PostMapping("/register")
    public ResponseEntity<Solocitacoes> register(@RequestBody Solocitacoes solocitacoes) {
        Solocitacoes solicitacoesDto = medicamentoService.createSolicitacao(solocitacoes);
        return ResponseEntity.created(URI.create("/address" + solicitacoesDto.getId())).body(solicitacoesDto);
    }

    @GetMapping("/getSolicitacoesMedicamentosByMedicoByPacienteByDataHora/{medicoIdentificador}/{pacienteIdentificador}/{dataHoraIdentificador}/{remedioIdentificador}")
    public ResponseEntity<SolicitacoesDto> getMedicamentoByiD(
            @PathVariable String medicoIdentificador,
            @PathVariable LocalDateTime dataHoraIdentificador,
            @PathVariable String pacienteIdentificador,
            @PathVariable String remedioIdentificador

    ) {
        SolicitacoesDto solicitacoesDto = new SolicitacoesDto();
        solicitacoesDto.setMedicamentoIndentificador(remedioIdentificador);
        solicitacoesDto.setDataHoraIdentificadora(dataHoraIdentificador);
        solicitacoesDto.setPacienteIdentificador(pacienteIdentificador);
        solicitacoesDto.setMedicoIdentificador(medicoIdentificador);

        SolicitacoesDto medicamentTod = medicamentoService.getSolicitacoesMedicamentosByMedicoByPacienteByDataHora(solicitacoesDto);
        return ResponseEntity.ok(medicamentTod);
    }

}
