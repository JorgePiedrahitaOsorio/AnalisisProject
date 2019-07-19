/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Point;
import java.util.LinkedList;
import javax.swing.ImageIcon;


/**
 *
 * @author JORGE OSORIO
 */
public class Esclavo implements Runnable{
    private Point ubicacion;
    private int ancho;
    private int alto;
    private LinkedList<String> rutas;
    private ImageIcon imagen;
    Thread hilo;
    int horas_vida;

    public Esclavo() {
    }

    public Esclavo(Point ubicacion, int ancho, int alto) {
        this.ubicacion = ubicacion;
        this.ancho = ancho;
        this.alto = alto;
        this.rutas = new LinkedList<>();
        this.hilo = new Thread(this);
        this.Start();
    } 
    
    private void Start(){
        this.hilo.start();
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {            
            
        }
    }

    /**
     * @return the ubicacion
     */
    public Point getUbicacion() {
        return ubicacion;
    }

    /**
     * @param ubicacion the ubicacion to set
     */
    public void setUbicacion(Point ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * @return the ancho
     */
    public int getAncho() {
        return ancho;
    }

    /**
     * @param ancho the ancho to set
     */
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    /**
     * @return the alto
     */
    public int getAlto() {
        return alto;
    }

    /**
     * @param alto the alto to set
     */
    public void setAlto(int alto) {
        this.alto = alto;
    }

    /**
     * @return the rutas
     */
    public LinkedList<String> getRutas() {
        return rutas;
    }

    /**
     * @param rutas the rutas to set
     */
    public void setRutas(LinkedList<String> rutas) {
        this.rutas = rutas;
    }

    /**
     * @return the imagen
     */
    public ImageIcon getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }
}
