package Repositorio;

import java.util.ArrayList;
import java.util.List;

import dominio.Usuario;

public class UsuarioRepositorio {

private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public UsuarioRepositorio() {
		usuarios.add(new Usuario(1, "Allisson", "Huilca", "Allisson1", "https://i.pinimg.com/474x/85/fb/3b/85fb3b4a8b902c2e6aa65b3b806c3673.jpg", "12345", "En linea"));
		usuarios.add(new Usuario(2, "Julio", "Guzmán", "yulius17", "https://images.genius.com/a7c1bf57702a8f1242d69e4ae57ed44c.640x640x1.jpg", "1234", "En linea"));
		usuarios.add(new Usuario(3, "Rosa", "Bajaña", "Rosa3", "https://i.pinimg.com/736x/7d/6e/a8/7d6ea8bf0d482a0713009e857e547270.jpg", "123", "Desconectado"));
	
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public Usuario userId(int id) {
		for(Usuario user: usuarios) {
			if(user.getId() == id)
				return user;
		}
		return null;
	}
	
	public Usuario userName(String username) {
		for(Usuario user: usuarios) {
			if(user.getUsername().equals(username))
				return user;
		}
		return null;
	}
	
	public Usuario password(String username, String clave) {
		for(Usuario user: usuarios) {
			if(user.getUsername().equals(username) && user.getClave().equals(clave))
				return user;
		}
		return null;
	}
	
}
