/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
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
    Rectangle aux;
    Color color;
    
    protected HashMap <JButton,ContenedorPreContinente> islas;

    public ContenedorPremapa(int x, int y, int width, int heigth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.heigth = heigth;
        this.rectangulos = new LinkedList<>();
        this.ColocarContinente = false;
        this.color = Color.GREEN;
        this.islas =  new HashMap<>();
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

        if (ColocarContinente) {
            g.setColor(color);
            g.drawRect(aux.x, aux.y, aux.width, aux.height);
        }
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
        g.drawImage(imgFondo, 0, 0, this.width, this.heigth - 50,null);
        this.setOpaque(false);
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

    /**
     * @return the width
     */
    @Override
    public int getWidth() {
        return width;
    }

}
