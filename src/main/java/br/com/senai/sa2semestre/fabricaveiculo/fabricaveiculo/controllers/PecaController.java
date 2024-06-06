package br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.controllers;

import br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.entities.Pecas;
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
    public List<Pecas> getAllPeca() {
        return pecaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pecas> getPecaById(@PathVariable Long id) {
        Optional<Pecas> pecaBuscada = pecaRepository.findById(id);
        return pecaBuscada.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    @PostMapping
    public Pecas createPeca(@RequestBody Pecas pecas) {
        return pecaRepository.save(pecas);
    }

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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePeca(@PathVariable Long id) {
        Optional<Pecas> pecaParaExluir = pecaRepository.findById(id);
        if (pecaParaExluir.isPresent()) {
            pecaRepository.delete(pecaParaExluir.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
