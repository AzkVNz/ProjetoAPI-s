/**
 * Controlador para gerenciar operações relacionadas à entidade Producao.
 */
package br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.controllers;

import br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.entities.Producao;
import br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.repositories.ProducaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para manipulação CRUD de entidades Producao.
 */
@RestController
@RequestMapping("/producoes")
public class ProducaoControler {

    @Autowired
    private ProducaoRepository producaoRepository;

    /**
     * Endpoint para recuperar todas as produções cadastradas.
     *
     * @return Lista de todas as produções
     */
    @GetMapping
    public List<Producao> getAllProducao() {
        return producaoRepository.findAll();
    }

    /**
     * Endpoint para recuperar uma produção específica pelo seu ID.
     *
     * @param id O ID da produção a ser recuperada
     * @return ResponseEntity contendo a produção encontrada ou status 404 caso não encontrada
     */
    @GetMapping("/{id}")
    public ResponseEntity<Producao> getProducaoById(@PathVariable Long id) {
        Optional<Producao> producaoBuscado = producaoRepository.findById(id);
        return producaoBuscado.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    /**
     * Endpoint para criar uma nova produção.
     *
     * @param producao A produção a ser criada
     * @return A produção criada
     */
    @PostMapping
    public Producao createProducao(@RequestBody Producao producao) {
        return producaoRepository.save(producao);
    }

    /**
     * Endpoint para atualizar uma produção existente pelo seu ID.
     *
     * @param id O ID da produção a ser atualizada
     * @param producaoAtualizado   O objeto contendo os novos dados da produção
     * @return ResponseEntity contendo a produção atualizada ou status 404 caso não encontrada
     */
    @PutMapping("/{id}")
    public ResponseEntity<Producao> uptadeProducao(@PathVariable Long id, @RequestBody Producao producaoAtualizado) {
        Optional<Producao> producaoExistente = producaoRepository.findById(id);
        if (producaoExistente.isPresent()) {
            producaoAtualizado.setIdProducao(id);
            return ResponseEntity.ok(producaoRepository.save(producaoAtualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Endpoint para excluir uma produção pelo seu ID.
     *
     * @param id O ID da produção a ser excluída
     * @return ResponseEntity indicando o resultado da operação de exclusão
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducao(@PathVariable Long id) {
        Optional<Producao> producaoParaExcluir = producaoRepository.findById(id);
        if (producaoParaExcluir.isPresent()) {
            producaoRepository.delete(producaoParaExcluir.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
