package prueba;

public class Atraccion extends Oferta {
	private String nombre;
	private int cupo;
	
	public Atraccion(String nombre, int costo, double tiempo, int cupo, TipoDeAtraccion tipo) {
		super(tipo, costo, tiempo);
		this.nombre = nombre;
		this.cupo = cupo;
	}

	@Override
	public String toString() {
		return "Atraccion [nombre=" + this.nombre + ", costo=" + this.costo + ", tiempoRequerido=" + this.tiempo + ", cupo="+ cupo + ", tipo=" + this.tipo + "]";
	}
	
	
	
	@Override
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public boolean hayCupo() {

		return this.cupo > 0;
	}

	@Override
	public void reducirCupo() {
		this.cupo--;
		
	}

	@Override
	public double getCosto() {
		return this.costo;
	}

	@Override
	public double getTiempo() {
		return this.tiempo;
	}
	
	
	
	
}
