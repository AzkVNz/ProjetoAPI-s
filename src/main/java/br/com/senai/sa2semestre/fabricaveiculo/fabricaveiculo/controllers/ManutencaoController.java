package br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.controllers;

import br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.entities.Manutencao;
import br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.repositories.EquipamentoRepository;
import br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.repositories.ManutencaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para gerenciamento de manutencoes.
 */

@RestController
@RequestMapping("/manutencoes")
public class ManutencaoController {

    @Autowired
    private ManutencaoRepository manutencaoRepository;


    @GetMapping
    public List<Manutencao> getAllManutencao() {
        return manutencaoRepository.findAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Manutencao> getManutencaoById(@PathVariable Long id) {
        Optional<Manutencao> manutencaoBuscado = manutencaoRepository.findById(id);
        return manutencaoBuscado.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    @PostMapping
    Manutencao createManutencao(@RequestBody Manutencao manutencao) {
        return manutencaoRepository.save(manutencao);
    }

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
