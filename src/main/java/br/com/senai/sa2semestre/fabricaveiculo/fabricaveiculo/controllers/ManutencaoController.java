package br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.controllers;

import br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.entities.Manutencao;
import br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.repositories.EquipamentoRepository;
import br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.repositories.ManutencaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controlador REST para gerenciamento de manutencoes.
 */

@RestController
@RequestMapping("/manutencoes")
public class ManutencaoController {

    @Autowired
    private ManutencaoRepository manutencaoRepository;


    @GetMapping
    public List<Manutencao> getAllManutencao(){
        return manutencaoRepository.findAll();

}

}
