package com.krugger.prueba;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.krugger.prueba.model.Usuario;
import com.krugger.prueba.repository.RolRepository;
import com.krugger.prueba.repository.UsuarioRepository;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@SpringBootApplication
@SecurityScheme(name = "seguridad", 
		type = SecuritySchemeType.HTTP, 
		scheme = "basic", 
		in = SecuritySchemeIn.HEADER)
public class PruebaApplication implements ApplicationRunner{
	

	@Autowired
	private RolRepository rolrepo;

	@Autowired
	private UsuarioRepository repousuario;
	
	@Autowired
	private PasswordEncoder encoder;
	
	private static final Logger LOG = LoggerFactory.getLogger(PruebaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PruebaApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Usuario generico = new Usuario();
		
		
		if (repousuario.findByUsuario("admin") == null) {
			
			
			generico.setUsuario("admin");
			generico.setClave(encoder.encode("admin"));
			generico.setRol(rolrepo.findrol("admin"));
			repousuario.save(generico);
			LOG.info("Usuario Registrado Correctamente ");
		} else {
			LOG.info("Usuario ya Registrado ");
		}
		
	}

}
