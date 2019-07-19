/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Point;

/**
 *
 * @author JORGE OSORIO
 */
public class MarProfundo {

    private Point origen;
    private Point destino;
    private double distacia;
    private int peso;

    public MarProfundo() {
    }

    public MarProfundo(Point origen, Point destino, double distacia, int peso) {
        this.origen = origen;
        this.destino = destino;
        this.distacia = distacia;
        this.peso = peso;
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

    /**
     * @return the origen
     */
    public Point getOrigen() {
        return origen;
    }

    /**
     * @param origen the origen to set
     */
    public void setOrigen(Point origen) {
        this.origen = origen;
    }

    /**
     * @return the destino
     */
    public Point getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(Point destino) {
        this.destino = destino;
    }

}
