package prueba;

import java.util.List;

public class PromocionAbsoluta extends Promocion {
	
	public PromocionAbsoluta(List<Oferta> atracciones, int precioADescontar) {
		super(atracciones, precioADescontar);
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
		return this.costoOriginal - this.valor;
	}

	@Override
	public double getTiempo() {
		// TODO Auto-generated method stub
		return 0;
	}
}
