package br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.repositories;

import br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.entities.Qualidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QualidadeRepository extends JpaRepository<Qualidade, Long> {
}
