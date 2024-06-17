/**
 * Controlador para gerenciar operações relacionadas à entidade Pecas.
 */
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

/**
 * Controlador REST para manipulação CRUD de entidades Pecas.
 */
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

    /**
     * Endpoint para recuperar todas as peças cadastradas.
     *
     * @return Lista de todas as peças
     */
    @GetMapping
    public List<Pecas> getAllPeca() {
        return pecaRepository.findAll();
    }

    /**
     * Endpoint para recuperar uma peça específica pelo seu ID.
     *
     * @param id O ID da peça a ser recuperada
     * @return ResponseEntity contendo a peça encontrada ou status 404 caso não encontrada
     */
    @GetMapping("/{id}")
    public ResponseEntity<Pecas> getPecaById(@PathVariable Long id) {
        Optional<Pecas> pecaBuscada = pecaRepository.findById(id);
        return pecaBuscada.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    /**
     * Endpoint para criar uma nova peça.
     *
     * @param pecas A peça a ser criada
     * @return A peça criada
     */
    @PostMapping
    public Pecas createPeca(@RequestBody Pecas pecas) {
        return pecaRepository.save(pecas);
    }

    /**
     * Endpoint para atualizar uma peça existente pelo seu ID.
     *
     * @param id O ID da peça a ser atualizada
     * @param pecasAtualizada   O objeto contendo os novos dados da peça
     * @return ResponseEntity contendo a peça atualizada ou status 404 caso não encontrada
     */
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

    /**
     * Endpoint para excluir uma peça pelo seu ID.
     *
     * @param id O ID da peça a ser excluída
     * @return ResponseEntity indicando o resultado da operação de exclusão
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePeca(@PathVariable Long id) {
        Optional<Pecas> pecaParaExcluir = pecaRepository.findById(id);

        if (pecaParaExcluir.isPresent()) {
            Pecas pecas = pecaParaExcluir.get();

            // Excluir todos os estoques associados à peça
            for (Estoque estoque : pecas.getListaDeEstoque()) {
                estoqueRepository.delete(estoque);
            }

            // Excluir todas as produções associadas à peça
            for (Producao producao : pecas.getListaDeProducao()) {
                producaoRepository.delete(producao);
            }

            // Excluir a peça após excluir os estoques e produções associadas
            pecaRepository.delete(pecas);

            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
