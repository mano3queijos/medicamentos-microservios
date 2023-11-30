package com.example.medicacaoservice.controllers;

import com.example.medicacaoservice.models.Medicamento;
import com.example.medicacaoservice.services.MedicamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/medicamento")
@RestController
public class MedicamnetoController {

    @Autowired
    MedicamentoService medicamentoService;


    @PostMapping("/register")
    public ResponseEntity<Medicamento> register(@RequestBody Medicamento medicamento) {
        Medicamento medicamentoDto = medicamentoService.createMedicamento(medicamento);
        return ResponseEntity.created(URI.create("/address" + medicamentoDto.getId())).body(medicamentoDto);
    }

    @GetMapping("/findMedicamentoByCodigoMedicamento/{codigoMedicamento}")
    public ResponseEntity<List<Medicamento>> findMedicamentoByCodigoMedicamento(@PathVariable String codigoMedicamento) {
        return ResponseEntity.ok(medicamentoService.findMedicamentoByCodigoMedicamento(codigoMedicamento));

    }

    @PutMapping("/updateMedicamento/{medicamentoId}")
    public ResponseEntity<Medicamento> update(@PathVariable Long medicamentoId, @RequestBody Medicamento medicamento) {
        Medicamento medicamentoDto = medicamentoService.put(medicamento, medicamentoId);
        return ResponseEntity.ok().location(URI.create("/updateMedicamento/" + medicamentoDto.getId())).body(medicamentoDto);
    }

    @GetMapping("/getAllMedicamentos")
    public ResponseEntity<List<Medicamento>> getAllMedicamentos() {
        return ResponseEntity.ok(medicamentoService.findAll());
    }

    @GetMapping("/getAllMedicamentoWithValidadeOk")
    public ResponseEntity<List<Medicamento>> getAllMedicamentoWithValidadeOk() {
        return ResponseEntity.ok(medicamentoService.findAllByDataValidade());
    }

}
