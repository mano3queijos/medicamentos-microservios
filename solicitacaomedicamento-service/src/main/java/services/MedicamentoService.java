package services;

import com.example.medicacaoservice.exceptionns.AppException;
import com.example.medicacaoservice.models.Medicamento;
import com.example.medicacaoservice.repositoris.MdeicamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service

public class MedicamentoService {

    @Autowired
    private MdeicamentoRepository meMdeicamentoRepository;


    public Medicamento createMedicamento(Medicamento medicamento) {
        return meMdeicamentoRepository.save(medicamento);
    }

    public Medicamento getMedicamentoByiD(String cpf) {
        return meMdeicamentoRepository.findMedicamentoByCpfPaciente(cpf).orElseThrow(() -> new AppException("", HttpStatus.NOT_FOUND));
    }

    public Medicamento put(Medicamento medicamento, Long id) {

        return meMdeicamentoRepository.findById(id).map(updatedMedicamento -> {
                    updatedMedicamento.setNome(medicamento.getNome());
                    updatedMedicamento.setFuncionalidade(medicamento.getFuncionalidade());
                    updatedMedicamento.setPossiveisReacoes(medicamento.getPossiveisReacoes());
                    updatedMedicamento.setDataValidade(medicamento.getDataValidade());

                    meMdeicamentoRepository.save(updatedMedicamento);
                    return updatedMedicamento;
                })
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
    }

    public List<Medicamento> getAll() {

        List<Medicamento> Medicamento = meMdeicamentoRepository.findAll();
//acho que retorna uma liosta vazia se não encontrar ninguem
        return Medicamento.stream()
                .collect(Collectors.toList());
    }

    public Medicamento getById(Long id) {
        return meMdeicamentoRepository.findById(id).orElseThrow(() -> new AppException("", HttpStatus.NOT_FOUND));
    }

}
