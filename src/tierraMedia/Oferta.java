package tierraMedia;

public abstract class Oferta {
	protected TipoDeAtraccion tipo;
	protected int costo;
	protected double tiempo;

	protected Oferta() {

	}

	protected Oferta(TipoDeAtraccion tipo, int costo, double tiempo) {
		this.tipo = tipo;
		this.costo = costo;
		this.tiempo = tiempo;
	}

	public abstract String getNombre();

	public abstract boolean hayCupo();

	public abstract void reducirCupo();

	public abstract int getCosto();

	public abstract double getTiempo();

	public boolean esPromo() {
		return false;
	}

	public abstract TipoDeAtraccion getTipo();
}
