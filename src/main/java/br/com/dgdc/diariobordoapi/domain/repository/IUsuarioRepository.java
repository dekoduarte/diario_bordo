package br.com.dgdc.diariobordoapi.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.dgdc.diariobordoapi.domain.model.Usuario;

@ResponseStatus
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
	public boolean existsByEmail(String email);
	public Optional<Usuario> findByEmail(String email);
}
