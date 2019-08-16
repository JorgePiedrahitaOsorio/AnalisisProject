/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModoEdicion;

/**
 *
 * @author Thebest
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
