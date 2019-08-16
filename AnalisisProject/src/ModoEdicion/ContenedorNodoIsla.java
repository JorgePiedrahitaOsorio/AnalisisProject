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
import static ModoEdicion.VistaConstructor.estadoEdicionMarIsla;
import static ModoEdicion.VistaConstructor.referenciaContinenteIsla1;
import static ModoEdicion.VistaConstructor.referenciaContinenteIsla2;
import static ModoEdicion.VistaConstructor.banderaDibujarMarIsla;
import static ModoEdicion.VistaConstructor.estadoEdicion;
import static ModoEdicion.VistaConstructor.estadoParametrizacionIsla;
import static ModoEdicion.VistaConstructor.referenciaIsla;

/**
 *
 * @author Thebest
 */
public class ContenedorNodoIsla extends javax.swing.JButton {

    private String url;
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    public static VistaPersonalizarIsla vista;
    public static boolean abrir;

    public ContenedorNodoIsla(String url, int x, int y, int width, int height) {
        this.url = url;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        abrir = true;
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
        estadoEdicion = false;
        
        if (estadoEdicionMarIsla) {
            dibujarBorde();
            if (referenciaContinenteIsla1 == null) {
                referenciaContinenteIsla1 = this;
            } else {
                referenciaContinenteIsla2 = this;
                banderaDibujarMarIsla = true;
            }
        } else {
            referenciaIsla = this;
            estadoParametrizacionIsla = true;
            if (abrir) {
                vista = new VistaPersonalizarIsla();
                vista.setVisible(true);
            }
        }
    }

    private void dibujarBorde() {
        this.setBorderPainted(true);
    }

    public void desDibujarBorde() {
        this.setBorderPainted(false);
    }

    private void decoracion() {
        this.setBorderPainted(false);
        this.setContentAreaFilled(false);
    }

}
