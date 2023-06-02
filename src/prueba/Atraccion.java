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
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public boolean hayCupo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void reducirCupo() {
		// TODO Auto-generated method stub
		
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
