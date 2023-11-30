package com.br.manu.indicacoesservice.services;

import com.br.manu.indicacoesservice.dtos.IndicacaoDto;
import com.br.manu.indicacoesservice.exceptionns.AppException;
import com.br.manu.indicacoesservice.models.Indicacao;
import com.br.manu.indicacoesservice.repositoris.IndicacaoRepository;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class IndicacaoService {


@Autowired
private ModelMapper modelMapper;

    @Autowired
    private IndicacaoRepository indicacaoRepository;


    public Indicacao createIndicacao(IndicacaoDto indicacaoDto) {


         Indicacao savedIndicacao = modelMapper.map(indicacaoDto, Indicacao.class);
         savedIndicacao.setDataHoraRequisicao(LocalDateTime.now());

        Optional<Indicacao> optionalIndicacao = indicacaoRepository.findMedicamentoByidentificador(savedIndicacao.getIdentificador());
        if (optionalIndicacao.isPresent()) {
            throw new AppException("Indicacao já existente", HttpStatus.CONFLICT);
        }

        return indicacaoRepository.save(savedIndicacao);
    }

//    public Indicacao findMedicamentoByCodigoMedicamento(String codigoMedicamento) {
//        return indicacaoRepository.findMedicamentoByCodigoMedicamento(codigoMedicamento).orElseThrow(() -> new AppException("", HttpStatus.NOT_FOUND));
//    }
//
//
//    public Indicacao put(Indicacao medicamento, Long id) {
//
//        return indicacaoRepository.findById(id).map(updatedMedicamento -> {
//                    updatedMedicamento.setNome(medicamento.getNome());
//                    updatedMedicamento.setFuncionalidade(medicamento.getFuncionalidade());
//                    updatedMedicamento.setPossiveisReacoes(medicamento.getPossiveisReacoes());
//                    updatedMedicamento.setDataValidade(medicamento.getDataValidade());
//                    updatedMedicamento.setCodigoMedicamento(medicamento.getCodigoMedicamento());
//                    indicacaoRepository.save(updatedMedicamento);
//                    return updatedMedicamento;
//                })
//                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
//    }

    public List<Indicacao> findAll() {
        List<Indicacao> indicacaos = indicacaoRepository.findAll();

        if (indicacaos.isEmpty()) {
            throw new AppException("Empty List", HttpStatus.NO_CONTENT);
        }
        return indicacaos;

    }

    public List<Indicacao> findAllByPacienteIdentificadorAndAndDataHoraRequisicaoAndMedicoSolicitante(String medicoSolicitante, String pacienteIdentificador,LocalDateTime dataHoraRequisicao){

        List<Indicacao> indicacaosEspecificas = indicacaoRepository.findAllByPacienteIdentificadorAndAndDataHoraRequisicaoAndMedicoSolicitante(pacienteIdentificador,dataHoraRequisicao,medicoSolicitante);

        if (indicacaosEspecificas.isEmpty()) {
            throw new AppException("Empty List", HttpStatus.NO_CONTENT);
        }
        return indicacaosEspecificas;

    }


}
