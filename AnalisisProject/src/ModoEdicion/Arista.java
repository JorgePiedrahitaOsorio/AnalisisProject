package ModoEdicion;

/**
 * Clase que permite guardar la información respectiva a la arista entre continentes 
 * @author Thebest
 * @version 1.2
 */
public class Arista {

    private int peligrosidad;

   

    /**
     * @return the continenteOrigen
     */
    public ContenedorNodo getContinenteOrigen() {
        return continenteOrigen;
    }

    /**
     * @param continenteOrigen the continenteOrigen to set
     */
    public void setContinenteOrigen(ContenedorNodo continenteOrigen) {
        this.continenteOrigen = continenteOrigen;
    }

    /**
     * @return the continenteDestino
     */
    public ContenedorNodo getContinenteDestino() {
        return continenteDestino;
    }

    /**
     * @param continenteDestino the continenteDestino to set
     */
    public void setContinenteDestino(ContenedorNodo continenteDestino) {
        this.continenteDestino = continenteDestino;
    }

    private ContenedorNodo continenteOrigen;
    private ContenedorNodo continenteDestino;

    /**
     * Constructor que recibe dos ContenedorNodo que hacen alusion a los continentes
     * @param continenteOrigen continente origen de la arista
     * @param continenteDestino continente destino de la arista
     */
    public Arista(ContenedorNodo continenteOrigen, ContenedorNodo continenteDestino) {
        this.continenteOrigen = continenteOrigen;
        this.continenteDestino = continenteDestino;
    }

    /**
     * @return the peligrosidad
     */
    public int getPeligrosidad() {
        return peligrosidad;
    }

    /**
     * @param peligrosidad the peligrosidad to set
     */
    public void setPeligrosidad(int peligrosidad) {
        this.peligrosidad = peligrosidad;
    }

}
