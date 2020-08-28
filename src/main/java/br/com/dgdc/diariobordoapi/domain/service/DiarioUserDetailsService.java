package br.com.dgdc.diariobordoapi.domain.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.dgdc.diariobordoapi.domain.model.DiarioUserDetails;
import br.com.dgdc.diariobordoapi.domain.model.Usuario;
import br.com.dgdc.diariobordoapi.domain.repository.IUsuarioRepository;

@Service
public class DiarioUserDetailsService implements UserDetailsService {

	@Autowired
	IUsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Usuario> user = repository.findByEmail(email);

		user.orElseThrow(() -> new UsernameNotFoundException("Email não cadastrado no sistema:" + email));

		return user.map(DiarioUserDetails::new).get();
	}

}
