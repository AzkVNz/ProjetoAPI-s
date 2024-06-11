package br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.controllers;

import br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.entities.Veiculo;
import br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.Vector;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @GetMapping
    public List<Veiculo> getAllVeiculo() {
        return veiculoRepository.findAll();
    }

    @GetMapping("/{chassi}")
    public ResponseEntity<Veiculo> getPecaById(@PathVariable String chassi) {
        Optional<Veiculo> veiculoBuscado = veiculoRepository.findById(chassi);
        return veiculoBuscado.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    @PostMapping
    public Veiculo createVeiculo(@RequestBody Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

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
