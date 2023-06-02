package prueba;

import java.util.List;

public class PromocionPorcentual extends Promocion {

	public PromocionPorcentual(List<Oferta> atracciones, int porcentaje) {
		super(atracciones, porcentaje);
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected int calcularCosto() {
		return this.costoOriginal - this.costoOriginal * this.valor / 100;
	}

	@Override
	public double getTiempo() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
