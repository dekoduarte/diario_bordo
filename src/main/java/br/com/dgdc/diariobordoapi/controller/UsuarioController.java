package br.com.dgdc.diariobordoapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dgdc.diariobordoapi.domain.model.Usuario;
import br.com.dgdc.diariobordoapi.domain.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	UsuarioService service;

	@GetMapping
	public ResponseEntity<List<Usuario>> listarTodos() {
		return ResponseEntity.ok().body(this.service.getAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> listarPorID(@PathVariable long id) {
		return ResponseEntity.ok().body(this.service.getById(id));
	}

	@PostMapping
	public ResponseEntity<Usuario> incluir(@Valid @RequestBody Usuario usuario) {
		Usuario c = service.include(usuario);
		return ResponseEntity.ok().body(c);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Usuario> alterar(@Valid @RequestBody Usuario usuario, @PathVariable long id) {
		return ResponseEntity.ok().body(service.update(usuario, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletar(@PathVariable long id) {
		service.delete(id);
		return ResponseEntity.ok().body("Usuario " + id + " excluido com sucesso.");
	}
}
