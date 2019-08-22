package Clases;

/**
 * clase que almacena la informacion logica de las aristas entre islas
 * @author William Vasquez y Jorge Osorio
 */
public class Mar {
    private Isla origen;
    private Isla destino;
    private int peligrosidad;
    private int peso;
    private int distancia;
    
    /**
     * constructor que instancia una objeto de tipo mar
     * @param origen isla origen de la arista
     * @param destino isla detsino de la arista
     * @param peligrosidad porcentaje de peligrosidad que tiene el hacer uso de la arista
     * @param distancia distacia entre la isla de origen y la destino
     */
    public Mar(Isla origen, Isla destino, int peligrosidad, int distancia){
        this.origen = origen;
        this.destino = destino;
        this.peligrosidad = peligrosidad;
        this.distancia = peligrosidad;
        this.peso = this.peligrosidad;
    }

    /**
     * @return the origen
     */
    public Isla getOrigen() {
        return origen;
    }

    /**
     * @param origen the origen to set
     */
    public void setOrigen(Isla origen) {
        this.origen = origen;
    }

    /**
     * @return the destino
     */
    public Isla getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(Isla destino) {
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
