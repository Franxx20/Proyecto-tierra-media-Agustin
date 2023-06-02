package prueba;

import java.util.List;

public class PromocionAbsoluta extends Promocion {
	
	public PromocionAbsoluta(List<Oferta> atracciones, int precioADescontar) {
		super(atracciones, precioADescontar);
	}

	@Override
	protected int calcularCosto() {
		return this.costoOriginal - this.valor;
	}


}
