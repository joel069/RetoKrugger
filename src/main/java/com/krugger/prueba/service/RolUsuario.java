package com.krugger.prueba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.krugger.prueba.model.Usuario;
import com.krugger.prueba.repository.UsuarioRepository;


@Service
public class RolUsuario implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository repousuario;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario u = repousuario.findByUsuario(username);
		String r = u.getRol().getNombre().toUpperCase();
		return org.springframework.security.core.userdetails.User.withUsername(username)
				.password(u.getClave()).roles(r).build();
	}
	
	
}
