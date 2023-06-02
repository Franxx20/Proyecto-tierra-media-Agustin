package prueba;

import java.util.List;
import java.util.LinkedList;

public class Usuario {
	@SuppressWarnings("unused")
	private String nombre;
	TipoDeAtraccion preferencia;
	@SuppressWarnings("unused")
	private int tiempoDisponible;
	@SuppressWarnings("unused")
	private double dineroDisponible;
	@SuppressWarnings("unused")
	private List<Oferta> itenerario;
	
	
	public Usuario(String nombre, TipoDeAtraccion preferencia, int tiempoDisponible, double dineroDisponible) {
		this.nombre = nombre;
		this.preferencia = preferencia;
		this.tiempoDisponible = tiempoDisponible;
		this.dineroDisponible = dineroDisponible;
		this.itenerario = new LinkedList<Oferta>();
	}
	
	
}
