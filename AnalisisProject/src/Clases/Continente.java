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
public class Continente {

    private Point ubicacion;
    private int ancho;
    private int alto;
    private String ruta;
    private ImageIcon imagen;
    private LinkedList<Isla> islas;
    private LinkedList<Mar> mares;
    private int id;

    public Continente(Point ubicacion, int ancho, int alto, String ruta, LinkedList<Isla> islas, LinkedList<Mar> mares) {
        this.ubicacion = ubicacion;
        this.ancho = ancho;
        this.alto = alto;
        this.ruta = ruta;
        this.imagen = new ImageIcon(getClass().getResource(ruta));
        this.islas = islas;
        this.mares = mares;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return this.id;
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

    /**
     * @return the islas
     */
    public LinkedList<Isla> getIslas() {
        return islas;
    }

    /**
     * @param islas the islas to set
     */
    public void setIslas(LinkedList<Isla> islas) {
        this.islas = islas;
    }

    /**
     * @return the maresProfundos
     */
    public LinkedList<Mar> getMares() {
        return mares;
    }

    /**
     * @param mares the mares to set
     */
    public void setMaresProfundos(LinkedList<Mar> mares) {
        this.mares = mares;
    }

    /**
     * @return the ruta
     */
    public String getRuta() {
        return ruta;
    }

    /**
     * @param ruta the ruta to set
     */
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

}
