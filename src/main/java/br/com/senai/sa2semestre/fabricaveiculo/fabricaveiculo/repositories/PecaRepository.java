package br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.repositories;

import br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.entities.Pecas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PecaRepository extends JpaRepository<Pecas, Long> {
}
