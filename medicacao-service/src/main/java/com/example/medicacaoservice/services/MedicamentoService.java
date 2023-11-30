package com.example.medicacaoservice.services;

import com.example.medicacaoservice.exceptionns.AppException;
import com.example.medicacaoservice.models.Medicamento;
import com.example.medicacaoservice.repositoris.MedicamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MedicamentoService {

    @Autowired
    private MedicamentoRepository medicamentoRepository;


    public Medicamento createMedicamento(Medicamento medicamento) {


     Optional<Medicamento> optionalMedicament = medicamentoRepository.findMedicamentoByCodigoMedicamento(medicamento.getCodigoMedicamento());
        if (optionalMedicament.isPresent()) {
            throw new AppException("Remedio já existente", HttpStatus.CONFLICT);
        }

        return medicamentoRepository.save(medicamento);
    }

    public Medicamento findMedicamentoByCodigoMedicamento(String codigoMedicamento) {
        return medicamentoRepository.findMedicamentoByCodigoMedicamento(codigoMedicamento).orElseThrow(() -> new AppException("", HttpStatus.NOT_FOUND));
    }


    public Medicamento put(Medicamento medicamento, Long id) {

        return medicamentoRepository.findById(id).map(updatedMedicamento -> {
                    updatedMedicamento.setNome(medicamento.getNome());
                    updatedMedicamento.setFuncionalidade(medicamento.getFuncionalidade());
                    updatedMedicamento.setPossiveisReacoes(medicamento.getPossiveisReacoes());
                    updatedMedicamento.setDataValidade(medicamento.getDataValidade());
                    updatedMedicamento.setCodigoMedicamento(medicamento.getCodigoMedicamento());
                    medicamentoRepository.save(updatedMedicamento);
                    return updatedMedicamento;
                })
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
    }

    public List<Medicamento> findAll() {
        List<Medicamento> medicamentos = medicamentoRepository.findAll();

        if (medicamentos.isEmpty()) {
            throw new AppException("Empty List", HttpStatus.NO_CONTENT);
        }
        return medicamentos;

    }

    public List<Medicamento> findAllByDataValidade() {

        List<Medicamento> analisarMedicamentos = medicamentoRepository.findAll();
        List<Medicamento> medicamentosDataValidadeOk = new ArrayList<>();



        LocalDate dataAtual = LocalDate.now();

        for (Medicamento medicamento : analisarMedicamentos
        ) {
      System.out.println(medicamento
              );
        }

        for (Medicamento medicamento : analisarMedicamentos
        ) {

            if (medicamento.getDataValidade() != null && dataAtual.isBefore(medicamento.getDataValidade())) {
                System.out.println(dataAtual + " é antes de " + medicamento.getDataValidade());
            }

            if (medicamento.getDataValidade() != null &&  dataAtual.isBefore(medicamento.getDataValidade())) {
                    medicamentosDataValidadeOk.add(medicamento);
                }
            }

        return medicamentosDataValidadeOk;
    }

    public Medicamento getById(Long id) {
        return medicamentoRepository.findById(id).orElseThrow(() -> new AppException("", HttpStatus.NOT_FOUND));
    }

}
