package br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.repositories;

import br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.entities.VeiculoPeca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoPecaRepository extends JpaRepository <VeiculoPeca, Long> {
}
