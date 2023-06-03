package prueba;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GeneradorDeSegurencias {

    private final String nombreArchivoUsuarios;
    private final String nombreArchivoAtracciones;
    private final String nombreArchivoPromociones;
    private List<Oferta> listaDeOfertas;
    private List<Usuario> listaDeUsuarios;

    public GeneradorDeSegurencias(String archivoUsuarios, String archivoAtracciones, String archivoPromociones) {
        this.nombreArchivoUsuarios = archivoUsuarios;
        this.nombreArchivoAtracciones = archivoAtracciones;
        this.nombreArchivoPromociones = archivoPromociones;
    }

    public void generarSugerencias(String archivoUsuarios, String archivoAtracciones, String archivoPromociones) {
        // TODO
    }

    public void leerAtraccionesPromocionesYUsuarios() {
        Archivo archivoUsuarios = new Archivo(this.nombreArchivoUsuarios);
        Archivo archivoAtracciones = new Archivo(this.nombreArchivoAtracciones);
        Archivo archivoPromociones = new Archivo(this.nombreArchivoPromociones);

        this.listaDeUsuarios = archivoUsuarios.leerArchivoUsuario();
        Map<String, Atraccion> mapaAtracciones = archivoAtracciones.leerArchivoAtraccion();
        List<Promocion> listaDePromociones = archivoPromociones.leerArchivoPromocion(mapaAtracciones);

        this.listaDeOfertas = new LinkedList<>();
        this.listaDeOfertas.addAll(listaDePromociones);
        this.listaDeOfertas.addAll(mapaAtracciones.values());


    }


}
