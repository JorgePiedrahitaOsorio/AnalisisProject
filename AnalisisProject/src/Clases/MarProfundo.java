package Clases;

/**
 * clase que guarda la informacion logica de la arista entre continentes
 * @author William Vasquez y Jorge Osorio
 * @version 1.1
 */
public class MarProfundo {

    private Continente origen;
    private Continente destino;
    private int peligrosidad;
    private int peso;
    private int distancia;
    
    /**
     * Cosntructor que instancia un objeto marprofundo
     * @param origen contiene el continente origen de la arista
     * @param destino contiene el continente destino de la arista
     * @param peligrosidad porcentaje de peligrosidad de la ruta
     * @param distancia distancia entre el continente origen y continente destino
     */
    public MarProfundo(Continente origen, Continente destino, int peligrosidad, int distancia){
        this.origen = origen;
        this.destino = destino;
        this.peligrosidad = peligrosidad;
        this.distancia = peligrosidad;
        this.peso =  this.peligrosidad;
    }

    /**
     * @return the origen
     */
    public Continente getOrigen() {
        return origen;
    }

    /**
     * @param origen the origen to set
     */
    public void setOrigen(Continente origen) {
        this.origen = origen;
    }

    /**
     * @return the destino
     */
    public Continente getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(Continente destino) {
        this.destino = destino;
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

    /**
     * @return the peso
     */
    public int getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }

    /**
     * @return the distancia
     */
    public int getDistancia() {
        return distancia;
    }

    /**
     * @param distancia the distancia to set
     */
    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

}
