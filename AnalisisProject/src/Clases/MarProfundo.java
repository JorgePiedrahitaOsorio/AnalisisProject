/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Graphics;
import java.awt.Point;


/**
 *
 * @author JORGE OSORIO
 */
public class MarProfundo {
    private Point origen;
    private Point destino;
    private int distacia;
    private int peso;
    public boolean puesto;

    public MarProfundo() {
    }

    public MarProfundo(Point origen, Point destino, int distacia, int peso) {
        this.origen = origen;
        this.destino = destino;
        this.distacia = distacia;
        this.peso = peso;
        this.puesto = false;
    }
    
    public void Dibujar(Graphics g){
        g.drawLine(this.origen.x, this.origen.y, this.destino.x, this.destino.y);
    }

    
    /**
     * @return the distacia
     */
    public int getDistacia() {
        return distacia;
    }

    /**
     * @param distacia the distacia to set
     */
    public void setDistacia(int distacia) {
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
