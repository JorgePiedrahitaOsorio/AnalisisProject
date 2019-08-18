/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Thebest
 */
public class ContenedorContinente extends JLabel {

    private int x, y, width, height;
    private String url;

    public ContenedorContinente(int x, int y, int width, int height, String url) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.url = url;
        caracteristicasVisuales();
    }

    private void caracteristicasVisuales() {
        this.setBounds(x, y, width,height);
        this.setOpaque(false);
        agregarImagenFondo();
    }

    private void agregarImagenFondo() {
        try {
            ImageIcon imgIcon = new ImageIcon(getClass().getResource(this.url));
            Icon iconoEscalado = new ImageIcon(imgIcon.getImage().getScaledInstance(this.getWidth(),
                    this.getHeight(), Image.SCALE_DEFAULT));
            this.setIcon(iconoEscalado);
        } catch (Exception e) {
            System.out.println("No agrego Fondo");
        }
    }

}
