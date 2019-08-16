/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModoEdicion;

import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import static ModoEdicion.VistaConstructor.urlElemento;
import static ModoEdicion.VistaConstructor.estadoEdicion;
import static ModoEdicion.VistaConstructor.estadoEdicionIsla;

/**
 *
 * @author Thebest
 */
public class ContenedorImagen extends javax.swing.JButton {

    private String url;
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private String url2;

    public ContenedorImagen(String url, int x, int y, int width, int height) {
        this.url = url;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        initComponents();
    }

    private void initComponents() {
        tamaño();
        dibujarFondo();
        this.addActionListener((ActionEvent e) -> {
            accionClick(e);
        });
        decoracion();
    }

    private void tamaño() {
        this.setBounds(x, y, width, height);
    }

    private void dibujarFondo() {
        ImageIcon imgIcon = new ImageIcon(getClass().getResource(url));
        Icon iconoEscalado = new ImageIcon(imgIcon.getImage().getScaledInstance(this.getWidth(),
                this.getHeight(), Image.SCALE_DEFAULT));
        this.setIcon(iconoEscalado);
    }

    private void accionClick(ActionEvent e) {
        if (estadoEdicionIsla) {
            estadoEdicion = false;
            urlElemento = this.url;
        } else {
            urlElemento = "../Imagenes/Sepiacontinente" + this.url2;
            estadoEdicionIsla = false;
            estadoEdicion = true;
        }
    }

    public void mover(int x, int y) {
        this.setBounds(x, y, this.width, this.height);
    }

    public void setUrl(String url) {
        this.url = url;
        dibujarFondo();
    }

    public void eliminarEventoClick() {
        this.removeActionListener(actionListener);
    }

    private void decoracion() {
        this.setBorder(null);
        this.setContentAreaFilled(false);
    }

    /**
     * @param url2 the url2 to set
     */
    public void setUrl2(String url2) {
        this.url2 = url2;
    }
}
