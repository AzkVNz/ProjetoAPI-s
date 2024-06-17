/**
 * Controlador REST para gerenciamento de manutenções.
 */
package br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.controllers;

import br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.entities.Manutencao;
import br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.repositories.ManutencaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para manipulação CRUD de entidades Manutencao.
 */
@RestController
@RequestMapping("/manutencoes")
public class ManutencaoController {

    @Autowired
    private ManutencaoRepository manutencaoRepository;

    /**
     * Endpoint para recuperar todas as manutenções cadastradas.
     *
     * @return Lista de todas as manutenções
     */
    @GetMapping
    public List<Manutencao> getAllManutencao() {
        return manutencaoRepository.findAll();
    }

    /**
     * Endpoint para recuperar uma manutenção específica pelo seu ID.
     *
     * @param id O ID da manutenção a ser recuperada
     * @return ResponseEntity contendo a manutenção encontrada ou status 404 caso não encontrada
     */
    @GetMapping("/{id}")
    public ResponseEntity<Manutencao> getManutencaoById(@PathVariable Long id) {
        Optional<Manutencao> manutencaoBuscado = manutencaoRepository.findById(id);
        return manutencaoBuscado.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    /**
     * Endpoint para criar uma nova manutenção.
     *
     * @param manutencao A manutenção a ser criada
     * @return A manutenção criada
     */
    @PostMapping
    public Manutencao createManutencao(@RequestBody Manutencao manutencao) {
        return manutencaoRepository.save(manutencao);
    }

    /**
     * Endpoint para atualizar uma manutenção existente pelo seu ID.
     *
     * @param id O ID da manutenção a ser atualizada
     * @param manutencaoComDadosAtualizados O objeto contendo os novos dados da manutenção
     * @return ResponseEntity contendo a manutenção atualizada ou status 404 caso não encontrada
     */
    @PutMapping("/{id}")
    public ResponseEntity<Manutencao> uptadeManutencao(@PathVariable Long id, @RequestBody Manutencao manutencaoComDadosAtualizados) {
        Optional<Manutencao> manutencaoExistente = manutencaoRepository.findById(id);
        if (manutencaoExistente.isPresent()) {
            manutencaoComDadosAtualizados.setiDManutencao(id);
            return ResponseEntity.ok(manutencaoRepository.save(manutencaoComDadosAtualizados));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Endpoint para excluir uma manutenção pelo seu ID.
     *
     * @param id O ID da manutenção a ser excluída
     * @return ResponseEntity indicando o resultado da operação de exclusão
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteManutencao(@PathVariable Long id) {
        Optional<Manutencao> manutencaoParaDeletar = manutencaoRepository.findById(id);
        if (manutencaoParaDeletar.isPresent()) {
            manutencaoRepository.delete(manutencaoParaDeletar.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
