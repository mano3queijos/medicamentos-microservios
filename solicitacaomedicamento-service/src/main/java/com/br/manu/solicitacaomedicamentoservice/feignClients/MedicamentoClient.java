package com.br.manu.solicitacaomedicamentoservice.feignClients;

import com.br.manu.solicitacaomedicamentoservice.dtos.MedicamentoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "medicamento", url = "http://localhost:8082/")

public interface MedicamentoClient {

    @GetMapping("/findMedicamentoByCodigoMedicamento/{codigoMedicamento}")
    public ResponseEntity<List<MedicamentoDto>> findMedicamentoByCodigoMedicamento(@PathVariable String codigoMedicamento);
}
