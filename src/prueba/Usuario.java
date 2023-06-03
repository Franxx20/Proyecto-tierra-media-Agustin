package prueba;

import java.util.List;
import java.util.LinkedList;

public class Usuario {
	private String nombre;
	TipoDeAtraccion preferencia;
	private int tiempoDisponible;
	private double dineroDisponible;
	private List<Oferta> itenerario;

	public Usuario(String nombre, TipoDeAtraccion preferencia, int tiempoDisponible, double dineroDisponible) {
		this.nombre = nombre;
		this.preferencia = preferencia;
		this.tiempoDisponible = tiempoDisponible;
		this.dineroDisponible = dineroDisponible;
		this.itenerario = new LinkedList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public TipoDeAtraccion getPreferencia() {
		return preferencia;
	}

	public int getTiempoDisponible() {
		return tiempoDisponible;
	}

	public double getDineroDisponible() {
		return dineroDisponible;
	}

	public List<Oferta> getItenerario() {
		return itenerario;
	}

}
