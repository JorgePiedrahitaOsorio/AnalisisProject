package ModoEdicion;

import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import static ModoEdicion.VistaConstructor.referenciaContinente;
import static ModoEdicion.VistaConstructor.continenteClickeado;
import static ModoEdicion.VistaConstructor.estadoEdicionMar;
import static ModoEdicion.VistaConstructor.referenciaContinente1;
import static ModoEdicion.VistaConstructor.referenciaContinente2;
import static ModoEdicion.VistaConstructor.banderaDibujarMar;
import static ModoEdicion.VistaConstructor.estadoEdicion;
import static ModoEdicion.VistaConstructor.modoMoverContinente;
import static ModoEdicion.VistaConstructor.referenciaMoverContinente;
import static ModoEdicion.VistaConstructor.modoOn;
import static ModoEdicion.VistaConstructor.eliminarContinente;
import static ModoEdicion.VistaConstructor.referenciaContinenteEliminar;


/**
 * clase que simula a los continente permitiendo su ubicacion y dibujo sobre el 
 * lienzo contenedorpremapa
 * @author William Vasquez y Jorge Osorio
 * @version 1.7
 */
public class ContenedorNodo extends javax.swing.JButton {

    private final String url;
    private final int x;
    private final int y;
    private final int width;
    private final int height;

    /**
     * constructor con los parametros necesarios para la construccion y ubicacion 
     * del boton sobre el lienzo
     * @param url cadena que representa la ruta de la imagen del fondo del boton
     * @param x posicion en x del boton sobre el lienzo
     * @param y posicion en y del boton sobre el lienzo
     * @param width ancho del oton 
     * @param height alto del boton 
     */
    public ContenedorNodo(String url, int x, int y, int width, int height) {
        this.url = url;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        initComponents();
    }

    /**
     * metodo que hace llamado para el diseño del boton
     */
    private void initComponents() {
        tamaño();
        dibujarFondo();
        this.addActionListener((ActionEvent e) -> {
            accionClick(e);
        });
        decoracion();
    }

    /**
     * metodo que define el tamaño del boton
     */
    private void tamaño() {
        this.setBounds(x, y, width, height);
    }

    /**
     * metodo que dibuja el fondo del boton
     */
    private void dibujarFondo() {
        ImageIcon imgIcon = new ImageIcon(getClass().getResource(getUrl()));
        Icon iconoEscalado = new ImageIcon(imgIcon.getImage().getScaledInstance(this.getWidth(),
                this.getHeight(), Image.SCALE_DEFAULT));
        this.setIcon(iconoEscalado);
    }

    /**
     * metodo que realiza las accione del boton tras el click segun las circustancias
     * @param e implementacion del object actionevent de java
     */
    private void accionClick(ActionEvent e) {
        estadoEdicion = false;
        if (estadoEdicionMar) {
            dibujarBorde();
            if (referenciaContinente1 == null) {
                referenciaContinente1 = this;
            } else {
                referenciaContinente2 = this;
                banderaDibujarMar = true;
            }
        }else if(modoMoverContinente){
            referenciaMoverContinente = this;
            modoOn = true;
        }else if(eliminarContinente){
            referenciaContinenteEliminar = this;
        }
        else {
            referenciaContinente = this;
            continenteClickeado = true;
        }

    }

    /**
     * metodo que dibuja el borde del boton
     */
    private void dibujarBorde() {
        this.setBorderPainted(true);
    }

    /**
     * metodo que desdibuja el borde del boton
     */
    public void desDibujarBorde() {
        this.setBorderPainted(false);
    }

    /**
     * metodo que limpia la decoracion del boton
     */
    private void decoracion() {
        this.setBorderPainted(false);
        this.setContentAreaFilled(false);
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

}
