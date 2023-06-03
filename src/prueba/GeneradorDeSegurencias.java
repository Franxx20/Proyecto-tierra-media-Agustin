package prueba;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GeneradorDeSegurencias {
		@SuppressWarnings("unused")
		private List<Usuario> listaDeUsuarios;
		private List<Oferta> listaDeOfertas;
		private String archivoUsuarios;
		private String archivoAtracciones;
		private String archivoPromociones;
		
		public GeneradorDeSegurencias(String archivoUsuarios, String archivoAtracciones, String archivoPromociones) {
			this.archivoUsuarios = archivoUsuarios;
			this.archivoAtracciones = archivoAtracciones;
			this.archivoPromociones = archivoPromociones;
		}
		
		public void generarSugerencias(String archivoUsuarios, String archivoAtracciones, String archivoPromociones) {
			
		}
		
		public void leerAtraccionesPromocionesYUsuarios() {
			Archivo archivoUsuarios = new Archivo(this.archivoUsuarios);
			Archivo archivoAtracciones = new Archivo(this.archivoAtracciones);
			Archivo archivoPromociones = new Archivo(this.archivoPromociones);
			
			this.listaDeUsuarios = archivoUsuarios.leerArchivoUsuario();
			Map<String, Atraccion> mapaAtracciones = archivoAtracciones.leerArchivoAtraccion();
			List<Promocion> listaDePromociones = archivoPromociones.leerArchivoPromocion(mapaAtracciones);
			
			this.listaDeOfertas = new LinkedList<>();
			listaDeOfertas.addAll(listaDePromociones);
			listaDeOfertas.addAll(mapaAtracciones.values());
		}
		
}
