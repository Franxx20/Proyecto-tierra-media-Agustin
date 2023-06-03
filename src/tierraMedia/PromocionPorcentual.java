package tierraMedia;

import java.util.List;

public class PromocionPorcentual extends Promocion {

	public PromocionPorcentual(List<Oferta> atracciones, int porcentaje) {
		super(atracciones, porcentaje);
	}

	protected int calcularCosto() {
		return this.costoOriginal - this.costoOriginal * this.valor / 100;
	}
}
