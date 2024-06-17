/**
 * Classe controladora para gerenciar operações relacionadas a entidades Veiculo.
 */
package br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.controllers;

import br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.entities.Veiculo;
import br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para lidar com operações CRUD para entidades Veiculo.
 */
@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;

    /**
     * Recupera todos os Veiculos.
     *
     * @return Lista de entidades Veiculo
     */
    @GetMapping
    public List<Veiculo> getAllVeiculo() {
        return veiculoRepository.findAll();
    }

    /**
     * Recupera um Veiculo pelo seu chassi.
     *
     * @param chassi O chassi do Veiculo a ser recuperado
     * @return ResponseEntity contendo o Veiculo encontrado
     */
    @GetMapping("/{chassi}")
    public ResponseEntity<Veiculo> getPecaById(@PathVariable String chassi) {
        Optional<Veiculo> veiculoBuscado = veiculoRepository.findById(chassi);
        return veiculoBuscado.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    /**
     * Cria um novo Veiculo.
     *
     * @param veiculo O Veiculo a ser criado
     * @return O Veiculo criado
     */
    @PostMapping
    public Veiculo createVeiculo(@RequestBody Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    /**
     * Atualiza um Veiculo existente pelo seu chassi.
     *
     * @param chassi O chassi do Veiculo a ser atualizado
     * @param veiculoComDadosAtualizados Os novos dados para o Veiculo
     * @return ResponseEntity contendo o Veiculo atualizado
     */
    @PutMapping("/{chassi}")
    public ResponseEntity<Veiculo> uptadeVeiculo(@PathVariable String chassi, @RequestBody Veiculo veiculoComDadosAtualizados) {
        Optional<Veiculo> veiculoExistente = veiculoRepository.findById(chassi);
        if (veiculoExistente.isPresent()) {
            veiculoComDadosAtualizados.setChassi(chassi);
            return ResponseEntity.ok(veiculoRepository.save(veiculoComDadosAtualizados));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Exclui um Veiculo pelo seu chassi.
     *
     * @param chassi O chassi do Veiculo a ser excluído
     * @return ResponseEntity indicando o resultado da operação de exclusão
     */
    @DeleteMapping("/{chassi}")
    public ResponseEntity<Veiculo> deleVeiculo(@PathVariable String chassi) {
        Optional<Veiculo> veiculoParaExcluir = veiculoRepository.findById(chassi);
        if (veiculoParaExcluir.isPresent()) {
            veiculoRepository.delete(veiculoParaExcluir.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
