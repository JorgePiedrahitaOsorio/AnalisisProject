/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.LinkedList;
import javax.swing.ImageIcon;

/**
 *
 * @author JORGE OSORIO
 */
public class Estrella implements Runnable {

    private int x;
    private int y;
    private int ancho;
    private int alto;
    private LinkedList<String> rutas;
    private ImageIcon imagen;
    private Thread hilo;
    Tesoro tesoro;
    LinkedList<Esclavo> esclavos;

    public Estrella() {
    }

    public Estrella(int x, int y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.rutas = new LinkedList<>();
        this.RutasImagenEstrella();
        this.imagen = new ImageIcon(getClass().getResource(this.rutas.getFirst()));
        this.hilo = new Thread(this);
        this.Start();
    }

    private void Start() {
        this.hilo.start();
    }

    private void RutasImagenEstrella() {
        this.rutas.add("../Imagenes/estrella1.png");
        this.rutas.add("../Imagenes/estrella2.png");
        this.rutas.add("../Imagenes/estrella3.png");
        this.rutas.add("../Imagenes/estrella4.png");
        this.rutas.add("../Imagenes/estrella5.png");
        this.rutas.add("../Imagenes/estrella6.png");
    }

    @Override
    public void run() {
        int i = 1;
        while (true) {
            try {
                if (i == 5) {
                    i = 0;
                }
                this.imagen.setImage(new ImageIcon(getClass().getResource(this.rutas.get(i))).getImage());
                i++;
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                System.out.println("Excepcion en clase Estrella, error: " + ex);
            }
        }
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
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

    /**
     * @return the hilo
     */
    public Thread getHilo() {
        return hilo;
    }

    /**
     * @param hilo the hilo to set
     */
    public void setHilo(Thread hilo) {
        this.hilo = hilo;
    }

}
