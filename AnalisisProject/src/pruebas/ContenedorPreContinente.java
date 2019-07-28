/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Thebest
 */
public class ContenedorPreContinente extends javax.swing.JPanel {

    private final int x;
    private final int y;
    private final int width;
    private final int heigth;
    private ImageIcon imagenFondo;

    public ContenedorPreContinente(int x, int y, int width, int heigth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.heigth = heigth;
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        aspecto();
        tamaño();
        agregarLayout();
        AgregarFondo();
    }

    private void tamaño() {
        this.setBounds(x, y, getWidth(), heigth);
    }

    private void agregarLayout() {
        this.setLayout(null);
    }

    private void aspecto() {
        this.setBackground(Color.white);
    }

    private void AgregarFondo() {
        try {
            this.imagenFondo = new ImageIcon(getClass().getResource("../Imagenes/mapaFondo3.jpg"));
        } catch (Exception e) {
            System.out.println("No Cargo Fondo, Error: " + e);
        }

    }

    /**
     * @return the width
     */
    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        g.drawImage(this.imagenFondo.getImage(), 0, 0, this.width, this.heigth, null);
        repaint();
    }

}
