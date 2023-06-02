package prueba;

import java.util.List;

public class PromocionAXB extends Promocion{

	public PromocionAXB(List<Oferta> atracciones, int lugarADescontar) {
		super(atracciones, lugarADescontar);
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
		if(this.valor < 1 || this.valor > this.atracciones.size()) {
			throw new RuntimeException();
		}
		Oferta a = this.atracciones.get(this.valor-1);
		return this.costoOriginal - a.costo;
	}

	@Override
	public double getTiempo() {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
