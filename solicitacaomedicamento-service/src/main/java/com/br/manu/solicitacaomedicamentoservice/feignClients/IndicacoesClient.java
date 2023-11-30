package com.br.manu.solicitacaomedicamentoservice.feignClients;

import com.br.manu.solicitacaomedicamentoservice.dtos.IndicacoesDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.List;

@FeignClient(name = "indicacoes", url = "http://localhost:8082/")

public interface IndicacoesClient {


    @GetMapping("/findAllByPacienteIdentificadorAndAndDataHoraRequisicaoAndMedicoSolicitante/{pacienteIdentificador}/{dataHoraRequisicao}/{medicoSolicitante}")
    public ResponseEntity<List<IndicacoesDto>> getAllMedicamentoWithValidadeOk(
            @PathVariable String pacienteIdentificador,
            @PathVariable LocalDateTime dataHoraRequisicao,
            @PathVariable String medicoSolicitante
    );
}
