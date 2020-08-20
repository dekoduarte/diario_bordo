package br.com.dgdc.diariobordoapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.dgdc.diariobordoapi.domain.model.Usuario;

@ResponseStatus
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

}
