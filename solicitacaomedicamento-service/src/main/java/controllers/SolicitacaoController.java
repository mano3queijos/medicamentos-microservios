package controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RequiredArgsConstructor
@RequestMapping("/medicamento")
@RestController
public class SolicitacaoController {

    @Autowired
    MedicamentoService medicamentoService;


    @PostMapping("/register")
    public ResponseEntity<Medicamento> register(@RequestBody Medicamento medicamento) {
        Medicamento medicamentTod = medicamentoService.createMedicamento(medicamento);
        return ResponseEntity.created(URI.create("/address" + medicamentTod.getId())).body(medicamentTod);
    }

    @GetMapping("/getMedicamentoByiD/{cpf}")
    public ResponseEntity<Medicamento> getMedicamentoByiD(@PathVariable String cpf) {
        Medicamento medicamentTod = medicamentoService.getMedicamentoByiD(cpf);
        return ResponseEntity.created(URI.create("/address" + medicamentTod.getId())).body(medicamentTod);
    }

}
