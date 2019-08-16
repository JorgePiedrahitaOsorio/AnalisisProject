/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author JORGE OSORIO
 */
public class MarProfundo {

    private Continente origen;
    private Continente destino;
    private int peligrosidad;
    private int peso;
    private int distancia;
    
    public MarProfundo(Continente origen, Continente destino, int peligrosidad, int distancia){
        this.origen = origen;
        this.destino = destino;
        this.peligrosidad = peligrosidad;
        this.distancia = distancia;
        this.peso = this.distancia + this.peligrosidad;
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
