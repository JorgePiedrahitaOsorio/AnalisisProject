package ModoEdicion;

/**
 * Esta clase nos permite guardar la información de las aristas entre islas creadas 
 * en la construcción
 * @author William Vasquez y jorge Osorio
 * @version 1.2
 */
public class AristaIsla {

    private int peligrosidad;

    
    /**
     * @return the origen
     */
    public ContenedorNodoIsla getOrigen() {
        return origen;
    }

    /**
     * @param origen the origen to set
     */
    public void setOrigen(ContenedorNodoIsla origen) {
        this.origen = origen;
    }

    /**
     * @return the destino
     */
    public ContenedorNodoIsla getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(ContenedorNodoIsla destino) {
        this.destino = destino;
    }
  
    private ContenedorNodoIsla origen;
    private ContenedorNodoIsla destino;
    
    /**
     * Contructor que recibe dos ContenedorNodoIsla que hace alusion a las islas
     * @param origen isla origen de la arista
     * @param destino isla destino de la arista
     */
    public AristaIsla(ContenedorNodoIsla origen , ContenedorNodoIsla destino){
        this.origen = origen;
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
    
}
