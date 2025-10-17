package juanCamiloAgudelo.parcial2.repositorio;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import juanCamiloAgudelo.parcial2.Modelo.Inmueble;

import java.util.ArrayList;

/**
 * Repositorio centralizado para gestionar los inmuebles
 * Singleton para garantizar una única instancia en toda la aplicación
 */
public class InmuebleRepository {
   private static InmuebleRepository instancia;
    private ObservableList<Inmueble>inmuebles;

    private InmuebleRepository() {
        inmuebles = FXCollections.observableArrayList();
        cargarDatosEjemplo();
    }

    /**
     * Obtiene la instancia única del juanCamiloAgudelo.parcial2.repositorio
     */
    public static InmuebleRepository getInstancia() {
        if (instancia == null) {
            instancia = new InmuebleRepository();
        }
        return instancia;
    }

    /**
     * Carga algunos inmuebles de ejemplo
     */
    private void cargarDatosEjemplo() {
        inmuebles.add(new Inmueble("Casa","Armenia",3,6,20000));
        inmuebles.add(new Inmueble("Casa","Armenia",5,9,5000));
        inmuebles.add(new Inmueble("Casa","Armenia",1,8,78000));


    }

    /**
     * Obtiene todos los inmuebles
     */
    public ObservableList<Inmueble> getInmuebles() {

        return  inmuebles;
    }

    /**
     * Agrega un nuevo producto
     */
    public void agregarInmueble(Inmueble inmueble) {
        inmuebles.add(inmueble);
    }

    /**
     * Elimina un producto
     */
    public boolean elimarInmueble(Inmueble inmueble) {
        return inmuebles.remove(inmueble);
    }



}

