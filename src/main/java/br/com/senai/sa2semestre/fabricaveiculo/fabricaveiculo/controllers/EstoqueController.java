/**
 * Controlador REST para gerenciamento de estoques.
 */
package br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.controllers;

import br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.entities.Estoque;
import br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.repositories.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para manipulação CRUD de entidades Estoque.
 */
@RestController
@RequestMapping("/estoques")
public class EstoqueController {

    @Autowired
    private EstoqueRepository estoqueRepository;

    /**
     * Endpoint para recuperar todos os estoques cadastrados.
     *
     * @return Lista de todos os estoques
     */
    @GetMapping
    public List<Estoque> getAllEstoque() {
        return estoqueRepository.findAll();
    }

    /**
     * Endpoint para recuperar um estoque específico pelo seu ID.
     *
     * @param id O ID do estoque a ser recuperado
     * @return ResponseEntity contendo o estoque encontrado ou status 404 caso não encontrado
     */
    @GetMapping("/{id}")
    public ResponseEntity<Estoque> getEstoqueById(@PathVariable Long id) {
        Optional<Estoque> estoqueBuscado = estoqueRepository.findById(id);
        return estoqueBuscado.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    /**
     * Endpoint para criar um novo estoque.
     *
     * @param estoque O estoque a ser criado
     * @return O estoque criado
     */
    @PostMapping
    public Estoque createEstoque(@RequestBody Estoque estoque) {
        return estoqueRepository.save(estoque);
    }

    /**
     * Endpoint para atualizar um estoque existente pelo seu ID.
     *
     * @param id O ID do estoque a ser atualizado
     * @param estoqueAtualizado O objeto contendo os novos dados do estoque
     * @return ResponseEntity contendo o estoque atualizado ou status 404 caso não encontrado
     */
    @PutMapping("/{id}")
    public ResponseEntity<Estoque> uptadeEstoque(@PathVariable Long id, @RequestBody Estoque estoqueAtualizado) {
        Optional<Estoque> estoqueExistente = estoqueRepository.findById(id);
        if (estoqueExistente.isPresent()) {
            estoqueAtualizado.setIdEstoque(id);
            return ResponseEntity.ok(estoqueRepository.save(estoqueAtualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Endpoint para excluir um estoque pelo seu ID.
     *
     * @param id O ID do estoque a ser excluído
     * @return ResponseEntity indicando o resultado da operação de exclusão
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstoque(@PathVariable Long id) {
        Optional<Estoque> estoqueParaDeletar = estoqueRepository.findById(id);
        if (estoqueParaDeletar.isPresent()) {
            estoqueRepository.delete(estoqueParaDeletar.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
