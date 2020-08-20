package br.com.dgdc.diariobordoapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.dgdc.diariobordoapi.domain.model.Usuario;
import br.com.dgdc.diariobordoapi.service.UsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	UsuarioService service;
	
	@GetMapping("/usuario")
	public List<Usuario> listaUsuario(){
		return service.getAll();
	}
	
	@PostMapping("/usuario")
	public Usuario insereUsuario(@RequestBody Usuario usuario) {
		return service.create(usuario);
	}
	
	@PutMapping("/usuario/{id}")
	public Usuario alteraUsuario(@RequestBody Usuario usuario, @PathVariable long id) {
		return service.update(usuario, id);
	}
	
}
