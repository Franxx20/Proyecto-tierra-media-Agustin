package tierraMedia;

import java.util.List;
import java.util.LinkedList;

public class Usuario {
	private final String nombre;
	final TipoDeAtraccion preferencia;
	private int tiempoDisponible;
	private double dineroDisponible;
	private List<Oferta> itinerario;

	public Usuario(String nombre, TipoDeAtraccion preferencia, int tiempoDisponible, double dineroDisponible) {
		this.nombre = nombre;
		this.preferencia = preferencia;
		this.tiempoDisponible = tiempoDisponible;
		this.dineroDisponible = dineroDisponible;
		this.itinerario = new LinkedList<>();
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", preferencia=" + preferencia + ", itinerario= " + itinerario +"]\n";
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

	public List<Oferta> getItinerario() {
		return itinerario;
	}

	public void agregarAItinerario(Oferta oferta) {
		this.itinerario.add(oferta);
	}

	public double getTiempoTotal() {
		double tiempoTotal = 0;

		for (Oferta oferta : itinerario) {
			tiempoTotal += oferta.getTiempo();
		}

		return tiempoTotal;
	}

	public int getCostoTotal() {
		int costoTotal = 0;

		for (Oferta oferta : itinerario) {
			costoTotal += oferta.getCosto();
		}

		return costoTotal;
	}

	public void reducirTiempo(double tiempo) {
		this.tiempoDisponible -= tiempo;
	}

	public void reducirDinero(int dinero) {
		this.dineroDisponible -= dinero;
	}

}
