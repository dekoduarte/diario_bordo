package br.com.dgdc.diariobordoapi.domain.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dgdc.diariobordoapi.domain.model.Diario;
import br.com.dgdc.diariobordoapi.domain.repository.IDiarioRepository;
import br.com.dgdc.diariobordoapi.exceptionHandler.ResourceAlreadyExistsException;
import br.com.dgdc.diariobordoapi.exceptionHandler.ResourceNotFoundException;

@Service
@Transactional
public class DiarioService {

	private final String msgDiarioErro = "Não existe diario com o id: ";

	@Autowired
	IDiarioRepository repository;

	public List<Diario> getAll() {
		return repository.findAll();
	}

	public Diario getById(Long id) {
		Optional<Diario> opt = repository.findById(id);

		if (!opt.isPresent())
			throw new ResourceNotFoundException(this.msgDiarioErro, id.toString());

		return repository.save(opt.get());
	}

	public Diario include(Diario diario) {

		if (repository.existsByData(diario.getData_diario())) {
			throw new ResourceAlreadyExistsException("Ja foram cadastras as resposta para a data: ",
					diario.getData_diario().toString());
		}

		return repository.save(diario);
	}

	public Diario update(Diario diario, Long id) {
		Optional<Diario> opt = repository.findById(id);

		if (!opt.isPresent())
			throw new ResourceNotFoundException(this.msgDiarioErro, id.toString());

		diario.setId(id);
		return repository.save(diario);
	}

	public void delete(Long id) {
		Optional<Diario> opt = repository.findById(id);

		if (!opt.isPresent())
			throw new ResourceNotFoundException(this.msgDiarioErro, id.toString());

		repository.delete(opt.get());
	}

}
