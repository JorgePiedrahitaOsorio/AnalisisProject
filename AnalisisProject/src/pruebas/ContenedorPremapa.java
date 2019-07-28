/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import Clases.MarProfundo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Thebest
 */
public class ContenedorPremapa extends javax.swing.JPanel {

    private final int x;
    private final int y;
    private final int width;
    private final int heigth;
    private Image imgFondo;
    boolean ColocarContinente;
    LinkedList<Rectangle> rectangulos;
    MarProfundo mar;
    LinkedList<MarProfundo> mares;
    Rectangle aux;
    Color color;

    protected HashMap<JButton, ContenedorPreContinente> islas;

    public ContenedorPremapa(int x, int y, int width, int heigth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.heigth = heigth;
        this.rectangulos = new LinkedList<>();
        this.mares = new LinkedList<>();
        this.ColocarContinente = false;
        this.mar = new MarProfundo();
        this.color = Color.GREEN;
        this.islas = new HashMap<>();
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        aspecto();
        tamaño();
        agregarLayout();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imgFondo, 0, 0, this.width , this.heigth, null);
        if (ColocarContinente) {
            g.setColor(color);
            g.drawRect(aux.x, aux.y, aux.width, aux.height);
        }
        mares.forEach((m) -> {
            g.drawLine(m.getOrigen().x, m.getOrigen().y, m.getDestino().x, m.getDestino().x);
        });
        repaint();
    }

    private boolean NoColisiona(Rectangle aux) {
        return this.rectangulos.stream().noneMatch((r) -> (r.intersects(aux)));
    }

    private void tamaño() {
        this.setBounds(x, y, getWidth(), heigth);
    }

    private void agregarLayout() {
        this.setLayout(null);
    }

    private void aspecto() {
        this.setBackground(Color.white);
        AgregarFondo();
    }

    private void AgregarFondo() {
        try {
            this.imgFondo = new ImageIcon(getClass().getResource("../Imagenes/mapaFondo1.jpg")).getImage();
        } catch (Exception e) {
            System.out.println("No cargo Fondo");
        }

    }

    @Override
    public void paint(Graphics g) {

        //this.setOpaque(false);
        super.paint(g);
    }

    public boolean DibujarRectangulos(int x, int y) {
        if (ColocarContinente) {
            if (NoColisiona(new Rectangle(x, y, 100, 100))) {
                this.rectangulos.add(new Rectangle(x, y, 100, 100));
                this.ColocarContinente = false;
                return true;
            }
        }
        return false;
    }

    public void DibujarRectanguloVerdeRojo(int x, int y) {
        if (ColocarContinente) {
            aux = new Rectangle(x, y, 102, 102);
            if (!NoColisiona(aux)) {
                this.color = Color.RED;
            } else {
                this.color = Color.GREEN;
            }
        }
    }

    public void DibujarLineas(int x, int y) {
        if (NoColisiona(new Rectangle(x, y, 10, 10))) {
            if (this.mar.puesto == false) {
                this.mar.setOrigen(new Point(x, y));
                this.mar.puesto = true;
            } else if (this.mar.puesto == true) {
                this.mar.setDestino(new Point(x, y));
                this.mares.add(mar);
                this.mar.puesto = false;
            }

        }
    }

    /**
     * @return the width
     */
    @Override
    public int getWidth() {
        return width;
    }

}
