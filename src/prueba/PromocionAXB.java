package prueba;

import java.util.List;

public class PromocionAXB extends Promocion{

	public PromocionAXB(List<Oferta> atracciones, int lugarADescontar) {
		super(atracciones, lugarADescontar);
	}

	@Override
	protected int calcularCosto() {
		if(this.valor < 1 || this.valor > this.atracciones.size()) {
			throw new RuntimeException();
		}
		Oferta a = this.atracciones.get(this.valor-1);
		return this.costoOriginal - a.costo;
	}

}
