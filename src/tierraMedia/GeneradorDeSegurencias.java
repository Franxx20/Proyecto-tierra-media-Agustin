package tierraMedia;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.*;

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

    public void generarSugerencias() {

        HashSet<Oferta> ofertasYaSugeridas = new HashSet<Oferta>();
        Scanner sc = new Scanner(System.in);
        boolean tieneDineroYTiempo = true;

        for (Usuario usuario : listaDeUsuarios) {

            listaDeOfertas.sort(new OfertaComparator(usuario.getPreferencia()));
            System.out.println("Bienvenido/a " + usuario.getNombre() + "\n");

            while(tieneDineroYTiempo) {

                tieneDineroYTiempo = false;

                for (Oferta oferta : listaDeOfertas) {

                    boolean yaOfertado = estaOfertada(ofertasYaSugeridas, oferta);

                    double tiempoNecesario = oferta.getTiempo();
                    int dineroNecesario = oferta.getCosto();

                    if(tieneTiempoYDineroYNoOfertada(usuario, yaOfertado, tiempoNecesario, dineroNecesario))
                        tieneDineroYTiempo = true;

                    if(tieneTiempoYDineroYNoOfertada(usuario, yaOfertado, tiempoNecesario, dineroNecesario)
                            && oferta.hayCupo()) {

                        if(ofrecer(oferta, sc))
                            aceptarOferta(ofertasYaSugeridas, usuario, oferta, tiempoNecesario, dineroNecesario);

                    }

                }
            }

            ofertasYaSugeridas.clear();

            usuario.ordenarItenerario(new OfertaComparator(usuario.getPreferencia()));

            System.out.println("Itinerario de " + usuario.getNombre() + "\n");
            System.out.println(usuario.mostrarItinerario());

            tieneDineroYTiempo = true;
        }

        sc.close();

    }

    private boolean ofrecer(Oferta oferta, Scanner sc) {
        String respuesta = new String();
        System.out.println(oferta);
        do{
            System.out.println("Acepta la oferta? S/N\n");
            respuesta = sc.nextLine();

        }while(respuestaValida(respuesta));

        return respuestaAfirmativa(respuesta);
    }

    private boolean tieneTiempoYDineroYNoOfertada(Usuario usuario, boolean yaOfertado, double tiempoNecesario,
                                                  int dineroNecesario) {
        return !yaOfertado &&  tiempoNecesario <= usuario.getTiempoDisponible() && dineroNecesario <= usuario.getDineroDisponible();
    }

    private boolean estaOfertada(HashSet<Oferta> ofertasYaSugeridas, Oferta oferta) {
        boolean yaOfertado = false;
        if(oferta.esPromo()) {
            Promocion promo = (Promocion)oferta;

            for (Oferta atraccion : promo.atracciones) {
                if(ofertasYaSugeridas.contains(atraccion))
                    yaOfertado = true;
            }

        }
        else {
            if(ofertasYaSugeridas.contains(oferta))
                yaOfertado = true;
        }
        return yaOfertado;
    }

    private void aceptarOferta(HashSet<Oferta> ofertasYaSugeridas, Usuario usuario, Oferta oferta,
                               double tiempoNecesario, int dineroNecesario) {

        System.out.println("Acepto la oferta!\n");

        usuario.agregarAItinerario(oferta);

        if(oferta.esPromo()) {
            Promocion promo = (Promocion)oferta;

            for (Oferta atraccion : promo.atracciones) {
                ofertasYaSugeridas.add(atraccion);
            }
        }
        else
            ofertasYaSugeridas.add(oferta);


        oferta.reducirCupo();
        usuario.reducirDinero(dineroNecesario);
        usuario.reducirTiempo(tiempoNecesario);

    }

    private boolean respuestaAfirmativa(String respuesta) {
        return respuesta.equals("S") || respuesta.equals("s");
    }

    private boolean respuestaValida(String respuesta) {
        return !respuesta.equals("S") && !respuesta.equals("N") && !respuesta.equals("s") && !respuesta.equals("n");
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

    public void guardarItinerariosDeUsuarios() {

        for (Usuario u : this.listaDeUsuarios) {
            Archivo archivoSalida = new Archivo(u.getNombre());

            archivoSalida.guardarArchivo(u);
        }

    }



}