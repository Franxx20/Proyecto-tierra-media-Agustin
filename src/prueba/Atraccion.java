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
		return this.cupo > 0;
	}

	@Override
	public void reducirCupo() {
		this.cupo--;
	}

    @Override
    public int getCosto() {
        return this.costo;
    }

    @Override
    public double getTiempo() {
        return this.tiempo;
    }

	@Override
	public TipoDeAtraccion getTipo() {
		return tipo;
	}


}
