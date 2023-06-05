package Repositorio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dominio.Mensaje;
import dominio.Usuario;

public class MensajeRepositorio {
	
	private List<Mensaje> mensajes = new ArrayList<Mensaje>();
	private UsuarioRepositorio usuario = new UsuarioRepositorio();
	
	public MensajeRepositorio() {
		Usuario Allisson = usuario.userId(1);
		Usuario Julio = usuario.userId(2);
		Usuario Rosa = usuario.userId(3);

		
		//Bryan//
		mensajes.add(new Mensaje(1, Julio, Allisson, LocalDateTime.of(2022, 11, 16, 12, 30), "Ya viste q mandaron tarea de estadistica"));
		mensajes.add(new Mensaje(2, Allisson, Julio, LocalDateTime.of(2022, 11, 16, 12, 30), "TLj no tienen nada que hacer"));
		
		mensajes.add(new Mensaje(3, Allisson, Rosa, LocalDateTime.of(2022, 11, 16, 12, 30), "Reparte estadistica"));
		mensajes.add(new Mensaje(4, Rosa, Allisson, LocalDateTime.of(2022, 11, 16, 12, 30), "voy pilas"));

		//Danny//
		mensajes.add(new Mensaje(5, Julio, Rosa, LocalDateTime.of(2022, 11, 16, 12, 30), "no me digas hay mas tarea"));
		mensajes.add(new Mensaje(6, Rosa, Julio, LocalDateTime.of(2022, 11, 16, 12, 30), "Sip y talleres"));
		
		mensajes.add(new Mensaje(7, Julio, Allisson, LocalDateTime.of(2022, 11, 16, 12, 30), "jajajajaja ojala no se de cuenta rosita"));
		mensajes.add(new Mensaje(8, Allisson, Julio, LocalDateTime.of(2022, 11, 16, 12, 30), "jajaj yamismo nos reparte los temas"));
	

		//David//
		mensajes.add(new Mensaje(9, Rosa, Allisson, LocalDateTime.of(2022, 11, 16, 12, 30), "voy a repartir los temas justo cuando julio se este durmiendo "));
		mensajes.add(new Mensaje(10, Allisson, Rosa, LocalDateTime.of(2022, 11, 16, 12, 30), "A eso de las 3 mas o menos "));
		
		mensajes.add(new Mensaje(11, Julio, Rosa, LocalDateTime.of(2022, 11, 16, 12, 30), "mañana hago voy a dormir"));
		mensajes.add(new Mensaje(12, Rosa, Julio, LocalDateTime.of(2022, 11, 16, 12, 30), "para mañana hay mas tarea"));


		
	}
	
	public List<Mensaje> getMensajes(){
		return mensajes;
	}
	
	public List<Mensaje> conversaciones(int usuario1, int usuario2) {
		List<Mensaje> resultado = new ArrayList<Mensaje>();
		for(Mensaje msj: mensajes) {
			if((msj.getUsuario1().getId() == usuario1 && msj.getUsuario2().getId() == usuario2) || (
					msj.getUsuario1().getId() == usuario2 && msj.getUsuario2().getId() == usuario1))
				resultado.add(msj);
		}
		return resultado;		
	}
	
	public Mensaje getUltimoMsj(int usuario1, int usuario2) {
		List<Mensaje> resultado = conversaciones(usuario1, usuario2);
		
		if(resultado.size() == 0)
			return null;
		return resultado.get(resultado.size()-1);		
	}
	
	public void addMensajes(Mensaje mensaje) {
		mensajes.add(mensaje);		
	}

}
