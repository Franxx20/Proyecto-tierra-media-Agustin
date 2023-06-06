package tierraMedia;

import java.util.List;
import java.util.Objects;

public abstract class Promocion extends Oferta {

	protected List<Atraccion> atracciones;
	protected int costoOriginal;
	protected int valor;

	protected Promocion(List<Atraccion> atracciones, int valor) {
		super();
		this.valor = valor;
		this.atracciones = atracciones;
		this.costoOriginal = calcularCostoOriginal();
		this.costo = calcularCosto();
		this.tiempo = calcularTiempo();
		this.tipo = calcularTipoDeAtraccion();
	}

	protected abstract int calcularCosto();

	private int calcularCostoOriginal() {
		int costoTotal = 0;
		for (Atraccion a : this.atracciones) {
			costoTotal += a.getCosto();
		}
		return costoTotal;
	}

	private double calcularTiempo() {
		double tiempoTotal = 0;
		for (Atraccion a : this.atracciones) {
			tiempoTotal += a.getTiempo();
		}
		return tiempoTotal;
	}

	private TipoDeAtraccion calcularTipoDeAtraccion() {
		return this.atracciones.get(0).tipo;
	}

	@Override
	public boolean esPromo() {
		return true;
	}

	@Override
	public TipoDeAtraccion getTipo() {
		return this.atracciones.get(0).getTipo();
	}

	public void reducirCupo() {
		for (Atraccion a : this.atracciones) {
			a.reducirCupo();
		}
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
	public boolean hayCupo() {
		boolean ban = true;
		for (Atraccion a : this.atracciones) {
			if (!a.hayCupo())
				ban = false;
		}
		return ban;
	}

	@Override
	public String getNombre() {
		return this.atracciones.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(atracciones, costoOriginal, valor);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Promocion other = (Promocion) obj;
		return Objects.equals(atracciones, other.atracciones) && costoOriginal == other.costoOriginal
				&& valor == other.valor;
	}

	@Override
	public String toString() {
		return "Promocion [atracciones=" + atracciones + ", costoOriginal=" + costoOriginal + ", valor=" + valor + "]\n";
	}

}
