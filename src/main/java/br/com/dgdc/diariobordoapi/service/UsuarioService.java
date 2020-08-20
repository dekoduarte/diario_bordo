package br.com.dgdc.diariobordoapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dgdc.diariobordoapi.domain.model.Usuario;
import br.com.dgdc.diariobordoapi.domain.repository.IUsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	IUsuarioRepository repository;

	public List<Usuario> getAll() {
		return repository.findAll();
	}

	public Usuario getById(Long id) {
		Optional<Usuario> usuario = repository.findById(id);

		if (usuario.isPresent()) {
			return usuario.get();
		} else {
			throw new RuntimeException("Nao foi encontrado usuario com o id: " + id);
		}
	}

	public Usuario create(Usuario usuario) {
		return repository.save(usuario);
	}

	public Usuario update(Usuario usuario, long id) {
		Optional<Usuario> usuarioBanco = this.repository.findById(id);

		if (usuario != null) {
			if (usuarioBanco.isPresent()) {
				Usuario usuarioAlterado = usuarioBanco.get();
				
				if (!usuario.getNome().equalsIgnoreCase(""))
					usuarioAlterado.setNome(usuario.getNome());

				if (!usuario.getEmail().equalsIgnoreCase(""))
					usuarioAlterado.setEmail(usuario.getEmail());

				if (!usuario.getSenha().equalsIgnoreCase(""))
					usuarioAlterado.setSenha(usuario.getSenha());

				return this.repository.save(usuarioAlterado);
			} else {
				throw new RuntimeException("Nao foi encontrado usuario com o id: " + usuario.getId());
			}
		} else {
			throw new NullPointerException("Objeto usuario vazio");
		}
	}

}
