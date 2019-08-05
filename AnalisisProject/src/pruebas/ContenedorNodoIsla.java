/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import static pruebas.VistaConstructor.estadoEdicionMarIsla;
import static pruebas.VistaConstructor.referenciaContinenteIsla1;
import static pruebas.VistaConstructor.referenciaContinenteIsla2;
import static pruebas.VistaConstructor.banderaDibujarMarIsla;
import static pruebas.VistaConstructor.estadoEdicion;
import static pruebas.VistaConstructor.estadoParametrizacionIsla;
import static pruebas.VistaConstructor.referenciaIsla;

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
