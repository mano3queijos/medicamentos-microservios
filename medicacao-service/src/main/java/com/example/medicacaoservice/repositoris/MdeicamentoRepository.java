package com.example.medicacaoservice.repositoris;

import com.example.medicacaoservice.models.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MdeicamentoRepository extends JpaRepository<Medicamento, Long> {


    Optional<Medicamento> findMedicamentoByCpfPaciente(@Param("cpfPaciente") String cpf);



}
