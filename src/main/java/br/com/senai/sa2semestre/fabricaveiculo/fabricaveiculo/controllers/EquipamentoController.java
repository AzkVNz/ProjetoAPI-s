/**
 * Controlador REST para gerenciamento de equipamentos.
 */
package br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.controllers;

import br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.entities.Equipamento;
import br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.entities.Manutencao;
import br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.repositories.EquipamentoRepository;
import br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.repositories.ManutencaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para manipulação CRUD de entidades Equipamento.
 */
@RestController
@RequestMapping("/equipamentos")
public class EquipamentoController {

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    @Autowired
    private ManutencaoRepository manutencaoRepository;

    /**
     * Endpoint para recuperar todos os equipamentos cadastrados.
     *
     * @return Lista de todos os equipamentos
     */
    @GetMapping
    public List<Equipamento> getAllEquipamento() {
        return equipamentoRepository.findAll();
    }

    /**
     * Endpoint para recuperar um equipamento específico pelo seu ID.
     *
     * @param id O ID do equipamento a ser recuperado
     * @return ResponseEntity contendo o equipamento encontrado ou status 404 caso não encontrado
     */
    @GetMapping("/{id}")
    public ResponseEntity<Equipamento> getEquipamentoById(@PathVariable Long id) {
        Optional<Equipamento> equipamentoBuscado = equipamentoRepository.findById(id);
        return equipamentoBuscado.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    /**
     * Endpoint para criar um novo equipamento.
     *
     * @param equipamento O equipamento a ser criado
     * @return O equipamento criado
     */
    @PostMapping
    public Equipamento createEquipamento(@RequestBody Equipamento equipamento) {
        return equipamentoRepository.save(equipamento);
    }

    /**
     * Endpoint para atualizar um equipamento existente pelo seu ID.
     *
     * @param id O ID do equipamento a ser atualizado
     * @param equipamentoComDadosAtualizados O objeto contendo os novos dados do equipamento
     * @return ResponseEntity contendo o equipamento atualizado ou status 404 caso não encontrado
     */
    @PutMapping("/{id}")
    public ResponseEntity<Equipamento> uptadeEquipamento(@PathVariable Long id, @RequestBody Equipamento equipamentoComDadosAtualizados) {
        Optional<Equipamento> equipamentoExistente = equipamentoRepository.findById(id);
        if (equipamentoExistente.isPresent()) {
            equipamentoComDadosAtualizados.setIdEquipamento(id);
            return ResponseEntity.ok(equipamentoRepository.save(equipamentoComDadosAtualizados));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Endpoint para excluir um equipamento pelo seu ID, incluindo todas as suas manutenções associadas.
     *
     * @param id O ID do equipamento a ser excluído
     * @return ResponseEntity indicando o resultado da operação de exclusão
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEquipamentoAndManutencoes(@PathVariable Long id) {
        Optional<Equipamento> equipamentoOptional = equipamentoRepository.findById(id);

        if (equipamentoOptional.isPresent()) {
            Equipamento equipamento = equipamentoOptional.get();

            // Excluir todas as manutenções associadas ao equipamento
            for (Manutencao manutencao : equipamento.getListaDeManutencao()) {
                manutencaoRepository.delete(manutencao);
            }

            // Excluir o equipamento após excluir as manutenções associadas
            equipamentoRepository.delete(equipamento);

            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
