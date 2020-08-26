package br.com.dgdc.diariobordoapi.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dgdc.diariobordoapi.domain.model.Usuario;
import br.com.dgdc.diariobordoapi.domain.repository.IUsuarioRepository;
import br.com.dgdc.diariobordoapi.exceptionHandler.ResourceAlreadyExistsException;
import br.com.dgdc.diariobordoapi.exceptionHandler.ResourceNotFoundException;

@Service
public class UsuarioService {

	private final String msgUsuarioErro = "Não existe usuario com o id: ";

	@Autowired
	IUsuarioRepository repository;

	public List<Usuario> getAll() {
		return repository.findAll();
	}

	public Usuario getById(Long id) {
		Optional<Usuario> opt = repository.findById(id);

		if (!opt.isPresent())
			throw new ResourceNotFoundException(this.msgUsuarioErro, id.toString());

		return repository.save(opt.get());
	}

	public Usuario include(Usuario usuario) {

		if (repository.existsByEmail(usuario.getEmail())) {
			throw new ResourceAlreadyExistsException("Ja existe um usuario cadastrado com o email: ",
					usuario.getEmail());
		}

		return repository.save(usuario);
	}

	public Usuario update(Usuario usuario, Long id) {
		Optional<Usuario> opt = repository.findById(id);

		opt.ifPresentOrElse(o -> this.validaUsuario(o, usuario), () -> {
			throw new ResourceNotFoundException(this.msgUsuarioErro, id.toString());
		});

		usuario.setId(id);
		return repository.save(usuario);
	}

	public void delete(Long id) {
		Optional<Usuario> opt = repository.findById(id);

		if (!opt.isPresent())
			throw new ResourceNotFoundException(this.msgUsuarioErro, id.toString());

		repository.delete(opt.get());
	}

	private void validaUsuario(Usuario antigo, Usuario novo) {
		String emailAntigo = antigo.getEmail();
		String emailNovo = novo.getEmail();

		if (!emailNovo.equalsIgnoreCase(emailAntigo) && repository.existsByEmail(emailNovo)) {
			throw new ResourceAlreadyExistsException("Esse email pertence a outro usuario: ", emailNovo);
		}
	}

}
