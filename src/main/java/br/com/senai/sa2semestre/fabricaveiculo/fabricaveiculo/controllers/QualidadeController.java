/**
 * Controller para gerenciar operações relacionadas à entidade Qualidade.
 */
package br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.controllers;

import br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.entities.Qualidade;
import br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.repositories.QualidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para manipulação CRUD de entidades Qualidade.
 */
@RestController
@RequestMapping("/qualidades")
public class QualidadeController {

    @Autowired
    private QualidadeRepository qualidadeRepository;

    /**
     * Endpoint para recuperar todas as qualidades cadastradas.
     *
     * @return Lista de todas as qualidades
     */
    @GetMapping
    public List<Qualidade> getAllQualiade() {
        return qualidadeRepository.findAll();
    }

    /**
     * Endpoint para recuperar uma qualidade específica pelo seu ID.
     *
     * @param id O ID da qualidade a ser recuperada
     * @return ResponseEntity contendo a qualidade encontrada ou status 404 caso não encontrada
     */
    @GetMapping("/{id}")
    public ResponseEntity<Qualidade> getQualidadeById(@PathVariable Long id) {
        Optional<Qualidade> qualidadeBuscada = qualidadeRepository.findById(id);
        return qualidadeBuscada.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    /**
     * Endpoint para criar uma nova qualidade.
     *
     * @param qualidade A qualidade a ser criada
     * @return A qualidade criada
     */
    @PostMapping
    public Qualidade createQualidade(@RequestBody Qualidade qualidade) {
        return qualidadeRepository.save(qualidade);
    }

    /**
     * Endpoint para atualizar uma qualidade existente pelo seu ID.
     *
     * @param id O ID da qualidade a ser atualizada
     * @param qualidadeComDadosAtualizados O objeto contendo os novos dados da qualidade
     * @return ResponseEntity contendo a qualidade atualizada ou status 404 caso não encontrada
     */
    @PutMapping("/{id}")
    public ResponseEntity<Qualidade> uptadeQualidade(@PathVariable Long id, @RequestBody Qualidade qualidadeComDadosAtualizados) {
        Optional<Qualidade> qualidadeExistente = qualidadeRepository.findById(id);
        if (qualidadeExistente.isPresent()) {
            qualidadeComDadosAtualizados.setIdInspecao(id);
            return ResponseEntity.ok(qualidadeRepository.save(qualidadeComDadosAtualizados));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Endpoint para excluir uma qualidade pelo seu ID.
     *
     * @param id O ID da qualidade a ser excluída
     * @return ResponseEntity indicando o resultado da operação de exclusão
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePeca(@PathVariable Long id) {
        Optional<Qualidade> qualidadeParaExcluir = qualidadeRepository.findById(id);
        if (qualidadeParaExcluir.isPresent()) {
            qualidadeRepository.delete(qualidadeParaExcluir.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
