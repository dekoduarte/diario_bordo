package br.com.dgdc.diariobordoapi.domain.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dgdc.diariobordoapi.domain.model.Diario;

public interface IDiarioRepository extends JpaRepository<Diario, Long> {
	public boolean existsByData_diario(Date data);

}
