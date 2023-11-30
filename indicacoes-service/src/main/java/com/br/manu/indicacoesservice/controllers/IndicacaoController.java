package com.br.manu.indicacoesservice.controllers;

import com.br.manu.indicacoesservice.dtos.IndicacaoDto;
import com.br.manu.indicacoesservice.models.Indicacao;
import com.br.manu.indicacoesservice.services.IndicacaoService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/indicacao")
@RestController
public class IndicacaoController {

    @Autowired
    IndicacaoService medicamentoService;


    @PostMapping("/register")
    public ResponseEntity<Indicacao> register(@RequestBody IndicacaoDto medicamentoDto) {
        Indicacao medicamento = medicamentoService.createIndicacao(medicamentoDto);
        return ResponseEntity.created(URI.create("/address" + medicamento.getId())).body(medicamento);
    }

    @GetMapping("/getAllIndicacoes")
    public ResponseEntity<List<Indicacao>> getAllMedicamentos(){
        return ResponseEntity.ok(medicamentoService.findAll());
    }

    @GetMapping("/findAllByPacienteIdentificadorAndAndDataHoraRequisicaoAndMedicoSolicitante/{pacienteIdentificador}/{dataHoraRequisicao}/{medicoSolicitante}")
    public ResponseEntity<List<Indicacao>> getAllMedicamentoWithValidadeOk(
            @PathVariable String pacienteIdentificador,
            @PathVariable LocalDateTime dataHoraRequisicao,
            @PathVariable String medicoSolicitante
    ){
        return ResponseEntity.ok(medicamentoService.findAllByPacienteIdentificadorAndAndDataHoraRequisicaoAndMedicoSolicitante(medicoSolicitante, pacienteIdentificador, dataHoraRequisicao));

    }

}
