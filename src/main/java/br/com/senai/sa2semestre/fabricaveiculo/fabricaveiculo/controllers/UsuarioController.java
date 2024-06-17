/**
 * Controller para gerenciar operações relacionadas aos usuários (entidades Usuario).
 */
package br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.controllers;

import br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.entities.Usuario;
import br.com.senai.sa2semestre.fabricaveiculo.fabricaveiculo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para manipulação CRUD de entidades Usuario.
 */
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Endpoint para recuperar todos os usuários.
     *
     * @return Lista de todos os usuários cadastrados
     */
    @GetMapping
    public List<Usuario> gettAllUsuario() {
        return usuarioRepository.findAll();
    }

    /**
     * Endpoint para recuperar um usuário específico pelo seu ID.
     *
     * @param id O ID do usuário a ser recuperado
     * @return ResponseEntity contendo o usuário encontrado ou status 404 caso não encontrado
     */
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        Optional<Usuario> usuarioBuscado = usuarioRepository.findById(id);
        return usuarioBuscado.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    /**
     * Endpoint para criar um novo usuário.
     *
     * @param usuario O usuário a ser criado
     * @return O usuário criado
     */
    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    /**
     * Endpoint para atualizar um usuário existente pelo seu ID.
     *
     * @param id O ID do usuário a ser atualizado
     * @param usuarioComDadosAtualizados O objeto contendo os novos dados do usuário
     * @return ResponseEntity contendo o usuário atualizado ou status 404 caso não encontrado
     */
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> uptadeUsuario(@PathVariable Long id, @RequestBody Usuario usuarioComDadosAtualizados) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);
        if (usuarioExistente.isPresent()) {
            usuarioComDadosAtualizados.setIdUsuario(id);
            return ResponseEntity.ok(usuarioRepository.save(usuarioComDadosAtualizados));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Endpoint para excluir um usuário pelo seu ID.
     *
     * @param id O ID do usuário a ser excluído
     * @return ResponseEntity indicando o resultado da operação de exclusão
     */
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        Optional<Usuario> usuarioParaExcluir = usuarioRepository.findById(id);
        if (usuarioParaExcluir.isPresent()) {
            usuarioRepository.delete(usuarioParaExcluir.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
