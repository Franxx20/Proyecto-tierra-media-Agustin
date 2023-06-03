package prueba;

public class TierraMedia {

	public static void main(String[] args) {
		GeneradorDeSegurencias gs = new GeneradorDeSegurencias("usuarios", "atracciones", "promociones");
		gs.leerAtraccionesPromocionesYUsuarios();
	}

}
