package br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.repositories;

import br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.entities.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {
}
