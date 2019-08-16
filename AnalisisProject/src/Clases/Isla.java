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
public class Isla {

    private Point ubicacion;
    private int ancho;
    private int alto;
    private ImageIcon imagen;
    private int tamañoTesoro;
    private int esclavosJovenes;
    private int esclavosAdultos;
    private int esclavosViejos;
    private String nombreIsla;
    private LinkedList<Estrella> estrellas;

    public Isla(Point ubicacion, int ancho, int alto, ImageIcon imagen, int tamañoTesoro, int esclavosJovenes, int esclavosAdultos, int esclavosViejos, String nombreIsla) {
        this.ubicacion = ubicacion;
        this.ancho = ancho;
        this.alto = alto;
        this.imagen = imagen;
        this.tamañoTesoro = tamañoTesoro;
        this.esclavosJovenes = esclavosJovenes;
        this.esclavosAdultos = esclavosAdultos;
        this.esclavosViejos = esclavosViejos;
        this.nombreIsla = nombreIsla;
        this.estrellas = new LinkedList<>();
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
     * @return the tamañoTesoro
     */
    public int getTamañoTesoro() {
        return tamañoTesoro;
    }

    /**
     * @param tamañoTesoro the tamañoTesoro to set
     */
    public void setTamañoTesoro(int tamañoTesoro) {
        this.tamañoTesoro = tamañoTesoro;
    }

    /**
     * @return the esclavosJovenes
     */
    public int getEsclavosJovenes() {
        return esclavosJovenes;
    }

    /**
     * @param esclavosJovenes the esclavosJovenes to set
     */
    public void setEsclavosJovenes(int esclavosJovenes) {
        this.esclavosJovenes = esclavosJovenes;
    }

    /**
     * @return the esclavosAdultos
     */
    public int getEsclavosAdultos() {
        return esclavosAdultos;
    }

    /**
     * @param esclavosAdultos the esclavosAdultos to set
     */
    public void setEsclavosAdultos(int esclavosAdultos) {
        this.esclavosAdultos = esclavosAdultos;
    }

    /**
     * @return the esclavosViejos
     */
    public int getEsclavosViejos() {
        return esclavosViejos;
    }

    /**
     * @param esclavosViejos the esclavosViejos to set
     */
    public void setEsclavosViejos(int esclavosViejos) {
        this.esclavosViejos = esclavosViejos;
    }

    /**
     * @return the nombreIsla
     */
    public String getNombreIsla() {
        return nombreIsla;
    }

    /**
     * @param nombreIsla the nombreIsla to set
     */
    public void setNombreIsla(String nombreIsla) {
        this.nombreIsla = nombreIsla;
    }

    /**
     * @return the estrellas
     */
    public LinkedList<Estrella> getEstrellas() {
        return estrellas;
    }

    /**
     * @param estrellas the estrellas to set
     */
    public void setEstrellas(LinkedList<Estrella> estrellas) {
        this.estrellas = estrellas;
    }

}
