package br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.controllers;

import br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.entities.*;
import br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.repositories.EstoqueRepository;
import br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.repositories.PecaRepository;
import br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.repositories.ProducaoRepository;
import br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.repositories.QualidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pecas")
public class PecaController {

    @Autowired
    private PecaRepository pecaRepository;

    @Autowired
    private QualidadeRepository qualidadeRepository;

    @Autowired
    private ProducaoRepository producaoRepository;

    @Autowired
    private EstoqueRepository estoqueRepository;

    @GetMapping
    public List<Pecas> getAllPeca() {
        return pecaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pecas> getPecaById(@PathVariable Long id) {
        Optional<Pecas> pecaBuscada = pecaRepository.findById(id);
        return pecaBuscada.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    @PostMapping
    public Pecas createPeca(@RequestBody Pecas pecas) {
        return pecaRepository.save(pecas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pecas> uptadePeca(@PathVariable Long id, @RequestBody Pecas pecasAtualizada) {
        Optional<Pecas> pecaExistente = pecaRepository.findById(id);
        if (pecaExistente.isPresent()) {
            pecasAtualizada.setIdPecas(id);
            return ResponseEntity.ok(pecaRepository.save(pecasAtualizada));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePeca(@PathVariable Long id) {
        Optional<Pecas> pecaParaExcluir = pecaRepository.findById(id);

        if (pecaParaExcluir.isPresent()) {
            Pecas pecas = pecaParaExcluir.get();

            // Excluir todos os estoques associadas ao equipamento
            for (Estoque estoque : pecas.getListaDeEstoque()) {
                estoqueRepository.delete(estoque);
            }

            for (Producao producao : pecas.getListaDeProducao()) {
                producaoRepository.delete(producao);
            }

            // Excluir a peca após excluir as manutenções associadas
            pecaRepository.delete(pecas);

            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}