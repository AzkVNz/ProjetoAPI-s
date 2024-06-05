package br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.controllers;

import br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.entities.Peca;
import br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.repositories.PecaRepository;
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

    @GetMapping
    public List<Peca> getAllPeca() {
        return pecaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Peca> getPecaById(@PathVariable Long id) {
        Optional<Peca> pecaBuscada = pecaRepository.findById(id);
        return pecaBuscada.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    @PostMapping
    public Peca createPeca(@RequestBody Peca peca) {
        return pecaRepository.save(peca);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Peca> uptadePeca(@PathVariable Long id, @RequestBody Peca pecaAtualizada) {
        Optional<Peca> pecaExistente = pecaRepository.findById(id);
        if (pecaExistente.isPresent()) {
            pecaAtualizada.setIdPecas(id);
            return ResponseEntity.ok(pecaRepository.save(pecaAtualizada));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePeca(@PathVariable Long id) {
        Optional<Peca> pecaParaExluir = pecaRepository.findById(id);
        if (pecaParaExluir.isPresent()) {
            pecaRepository.delete(pecaParaExluir.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
