package br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.controllers;

import br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.entities.Producao;
import br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.repositories.ProducaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/producao")
public class ProducaoControler {

    @Autowired
    private ProducaoRepository producaoRepository;

    @GetMapping
    public List<Producao> getAllProducao() {
        return producaoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producao> getProducaoById(@PathVariable Long id) {
        Optional<Producao> producaoBuscado = producaoRepository.findById(id);
        return producaoBuscado.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    @PostMapping
    public Producao createProducao(@RequestBody Producao producao) {
        return producaoRepository.save(producao);
    }

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
