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
    private double distacia;
    private int peso;

    public MarProfundo() {
    }

    public MarProfundo(Continente origen, Continente destino, double distacia, int peso) {
        this.origen = origen;
        this.destino = destino;
        this.distacia = distacia;
        this.peso = peso;
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
     * @return the distacia
     */
    public double getDistacia() {
        return distacia;
    }

    /**
     * @param distacia the distacia to set
     */
    public void setDistacia(double distacia) {
        this.distacia = distacia;
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

}
