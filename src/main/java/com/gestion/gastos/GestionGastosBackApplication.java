package com.gestion.gastos;

import com.gestion.gastos.entidades.Rol;
import com.gestion.gastos.entidades.Usuario;
import com.gestion.gastos.entidades.UsuarioRol;
import com.gestion.gastos.excepciones.UsuarioFoundException;
import com.gestion.gastos.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class GestionGastosBackApplication implements CommandLineRunner {

	@Autowired
	private UsuarioServicio usuarioServicio;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(GestionGastosBackApplication.class, args);
	}

	//Creación de usuarios al momento de iniciar el aplicativo
	@Override
	public void run(String... args) throws Exception {
		try{
			Usuario usuario = new Usuario();
			usuario.setNombre("Cesar");
			usuario.setApellido("Mesa");
			usuario.setEdad(23);
			usuario.setUsername("cesarm02");
			usuario.setPassword(passwordEncoder.encode("12345"));
			usuario.setEmail("cesar@hotmail.com");
			usuario.setTelefono("123");
			usuario.setPerfil("foto.png");

			Rol rol = new Rol();
			rol.setNombre("Admin");
			rol.setRolId(1L);

			Set<UsuarioRol> usuarioRols = new HashSet<>();
			UsuarioRol usuarioRol = new UsuarioRol();
			usuarioRol.setRol(rol);
			usuarioRol.setUsuario(usuario);
			usuarioRols.add(usuarioRol);

			Usuario usuarioExiste = usuarioServicio.obtenerUsuario(usuario.getUsername());
			if(usuarioExiste!= null)
				usuarioServicio.eliminarUsuario(usuarioExiste.getId());

			Usuario usuarioGuardado = usuarioServicio.guardarUsuario(usuario, usuarioRols);
			System.out.println(usuarioGuardado.getUsername());
		}catch (UsuarioFoundException e){
			e.printStackTrace();
		}

	}
}
