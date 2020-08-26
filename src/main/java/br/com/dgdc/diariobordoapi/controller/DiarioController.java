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

import br.com.dgdc.diariobordoapi.domain.model.Diario;
import br.com.dgdc.diariobordoapi.domain.service.DiarioService;

@RestController
@RequestMapping("diarios")
public class DiarioController {
	
	@Autowired
	DiarioService service;
	
	@GetMapping
	public ResponseEntity<List<Diario>> listarTodos() {
		return ResponseEntity.ok().body(this.service.getAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Diario> listarPorID(@PathVariable long id) {
		return ResponseEntity.ok().body(this.service.getById(id));
	}

	@PostMapping
	public ResponseEntity<Diario> incluir(@Valid @RequestBody Diario diario) {
		Diario c = service.include(diario);
		return ResponseEntity.ok().body(c);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Diario> alterar(@Valid @RequestBody Diario diario, @PathVariable long id) {
		return ResponseEntity.ok().body(service.update(diario, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletar(@PathVariable long id) {
		service.delete(id);
		return ResponseEntity.ok().body("Usuario " + id + " excluido com sucesso.");
	}
}
