package com.br.manu.solicitacaomedicamentoservice.services;

import com.br.manu.solicitacaomedicamentoservice.dtos.IndicacoesDto;
import com.br.manu.solicitacaomedicamentoservice.dtos.MedicamentoDto;
import com.br.manu.solicitacaomedicamentoservice.dtos.SolicitacoesDto;
import com.br.manu.solicitacaomedicamentoservice.exceptions.AppException;
import com.br.manu.solicitacaomedicamentoservice.feignClients.IndicacoesClient;
import com.br.manu.solicitacaomedicamentoservice.feignClients.MedicamentoClient;
import com.br.manu.solicitacaomedicamentoservice.models.Solocitacoes;
import com.br.manu.solicitacaomedicamentoservice.repositories.SolicitacoesRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MedicamentoService {


    @Autowired
    private MedicamentoClient medicamentoClient;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private IndicacoesClient indicacoesClient;

    @Autowired
    private SolicitacoesRepository solicitacoesRepository;


    public Solocitacoes createSolicitacao(Solocitacoes solocitacoesDto) {

        return solicitacoesRepository.save(solocitacoesDto);

    }

    public SolicitacoesDto getSolicitacoesMedicamentosByMedicoByPacienteByDataHora(SolicitacoesDto solocitacoes) {


        ResponseEntity<List<MedicamentoDto>> medicamentoDtoResponseEntity = medicamentoClient.findMedicamentoByCodigoMedicamento(solocitacoes.getMedicamentoIndentificador());

        List<MedicamentoDto> medicamentoDto = medicamentoDtoResponseEntity.getBody();

        ResponseEntity<List<IndicacoesDto>> indicacoesDtoResponseEntity = indicacoesClient.getAllMedicamentoWithValidadeOk(solocitacoes.getPacienteIdentificador(), solocitacoes.getDataHoraIdentificadora(), solocitacoes.getMedicamentoIndentificador()
        );
        List<IndicacoesDto> indicacoesDto = indicacoesDtoResponseEntity.getBody();


        solocitacoes.setMedicamentoDto(medicamentoDto);
        solocitacoes.setIndicacoesDto(indicacoesDto);

        return solocitacoes;

    }




//    public Solocitacoes put(Medicamento medicamento, Long id) {
//
//        return solicitacoesRepository.findById(id).map(updatedMedicamento -> {
//                    updatedMedicamento.setNome(medicamento.getNome());
//                    updatedMedicamento.setFuncionalidade(medicamento.getFuncionalidade());
//                    updatedMedicamento.setPossiveisReacoes(medicamento.getPossiveisReacoes());
//                    updatedMedicamento.setDataValidade(medicamento.getDataValidade());
//
//                    solicitacoesRepository.save(updatedMedicamento);
//                    return updatedMedicamento;
//                })
//                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
//    }

//    public List<Solocitacoes> getAll() {
//
//        List<Solocitacoes> Medicamento = solicitacoesRepository.findAll();
////acho que retorna uma liosta vazia se não encontrar ninguem
//        return Medicamento.stream()
//                .collect(Collectors.toList());
//    }

    public Solocitacoes getById(Long id) {
        return solicitacoesRepository.findById(id).orElseThrow(() -> new AppException("", HttpStatus.NOT_FOUND));
    }

}
