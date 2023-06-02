package prueba;

import java.util.List;
import java.util.Scanner;
import java.util.Locale;
import java.util.Map;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class Archivo {
	private String nombre;
	
	public Archivo(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Usuario> leerArchivoUsuario() {	
		List<Usuario> listaDeUsuarios = new ArrayList<Usuario>();
		
		try (Scanner scanner = new Scanner(new File("archivos/in/" + this.nombre + ".in"))){
			scanner.useLocale(Locale.ENGLISH);
			while(scanner.hasNextLine()) {
				listaDeUsuarios.add(new Usuario(scanner.next().replace('-', ' '), 
						TipoDeAtraccion.valueOf(scanner.next().toUpperCase()), scanner.nextInt(), scanner.nextDouble()));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return listaDeUsuarios;
	}
	
	public Map<String, Atraccion> leerArchivoAtraccion() {
		Map<String, Atraccion> mapaDeAtracciones = new HashMap<>();
		
		try(Scanner scanner = new Scanner(new File("archivos/in/" + this.nombre + ".in"))){
			scanner.useLocale(Locale.ENGLISH);
			while(scanner.hasNextLine()) {
				String nombre = scanner.next().replace('-', ' ');
				mapaDeAtracciones.put(nombre, new Atraccion(nombre, scanner.nextInt(),
	                    scanner.nextDouble(), scanner.nextInt(), TipoDeAtraccion.valueOf(scanner.next().toUpperCase())));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return mapaDeAtracciones;
	}
	
	
	public List<Promocion> leerArchivoPromocion(Map<String, Atraccion>  atraccion) {
		List<Promocion> listaDePromociones = new ArrayList<Promocion>();
		
		
		try (Scanner scanner = new Scanner(new File("archivos/in/" + this.nombre + ".in"))){
			scanner.useLocale(Locale.ENGLISH);
			while(scanner.hasNextLine()) {
				String[] campos = scanner.nextLine().split(" ");
				int j = 0;
				TipoDePromocion tipo = TipoDePromocion.valueOf(campos[j++]);
				int valor = Integer.parseInt(campos[j++]);
				List<Oferta> atraccionPromo  = new ArrayList<Oferta>();
				while(j < campos.length) {
					String nombre = campos[j++].replace('-', ' ');
					atraccionPromo.add(atraccion.get(nombre));
				}
				if(tipo == TipoDePromocion.ABS) {
					listaDePromociones.add(new PromocionAbsoluta(atraccionPromo, valor));
				} else if(tipo == TipoDePromocion.PER) {
					listaDePromociones.add(new PromocionPorcentual(atraccionPromo, valor));
				} else {
					listaDePromociones.add(new PromocionAXB(atraccionPromo, valor));
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return listaDePromociones;
	}
}
