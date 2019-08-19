/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Clases.Continente;
import Clases.MarProfundo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import static javax.swing.border.BevelBorder.RAISED;

/**
 *
 * @author Thebest
 */
public class VistaMundo extends javax.swing.JPanel {

    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private final LinkedList<Continente> continentes;
    private final LinkedList<MarProfundo> maresProfundos;
    private Image imgFondo;
    private JButton barcoSearch;
    private final HashMap<String, String> rutasImagenes;

    public VistaMundo(int x, int y, int width, int height, LinkedList<Continente> continentes, LinkedList<MarProfundo> maresProfundos) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.continentes = continentes;
        this.maresProfundos = maresProfundos;
        this.rutasImagenes = new HashMap<>();
        llenarRutasHashMap();
        caracteristicasVisuales();
        colocarContinentes();
        AñadirBotonSearchBarco();
    }

    private void caracteristicasVisuales() {
        this.setBounds(getX(), getY(), getWidth(), getHeight());
        this.setLayout(null);
        this.setBackground(new Color(0, 205, 199));
        
    }

    private void colocarContinentes() {
        continentes.forEach((c) -> {
            this.add(new ContenedorContinente(c.getUbicacion().x, c.getUbicacion().y, c.getAncho(),
                    c.getAlto(), rutaImagencontinente(c.getRuta())));
        });
    }

    private String rutaImagencontinente(String rutaSepia) {
        return this.rutasImagenes.get(rutaSepia);
    }

    private void llenarRutasHashMap() {
        for (int i = 1; i <= 6; i++) {
            this.rutasImagenes.put("../Imagenes/Sepiacontinente" + String.valueOf(i) + ".png", "../Imagenes/continente" + String.valueOf(i) + ".png");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.maresProfundos.forEach((m) -> {
            colocarMaresProfundos(g, m.getOrigen(), m.getDestino());
        });
        repaint();
    }

    private void colocarMaresProfundos(Graphics g, Continente origen, Continente destino) {
        if (origen.getUbicacion().x < destino.getUbicacion().x) {
            g.drawLine(origen.getUbicacion().x + origen.getAncho() / 2,
                    origen.getUbicacion().y + origen.getAlto() / 2, destino.getUbicacion().x
                    + destino.getAncho() / 2, destino.getUbicacion().y + destino.getAlto() / 2);
        } else {
            g.drawLine(destino.getUbicacion().x + destino.getAncho() / 2,
                    destino.getUbicacion().y + destino.getAlto() / 2, origen.getUbicacion().x
                    + origen.getAncho() / 2, origen.getUbicacion().y + origen.getAlto() / 2);
        }
    }

    private void AñadirBotonSearchBarco() {
        ImageIcon icono = new ImageIcon(getClass().getResource("../Imagenes/barcoSearch.png"));
        Icon iconoEscalado = new ImageIcon(icono.getImage().getScaledInstance(110,
                110, Image.SCALE_DEFAULT));
        this.barcoSearch = new JButton(iconoEscalado);
        this.barcoSearch.setBounds(1050, 600, 100, 100);
        this.barcoSearch.setContentAreaFilled(false);
        this.barcoSearch.setBorder(BorderFactory.createBevelBorder(RAISED));
        this.barcoSearch.setVisible(true);
        this.add(barcoSearch);
        this.barcoSearch.addActionListener((java.awt.event.ActionEvent evt) -> {
            barcoSearchAction(evt);
        });
    }

    private void barcoSearchAction(java.awt.event.ActionEvent evt) {
        System.out.println("No estoy Implementado, IMPLEMENTAME!!!");
    }

    /**
     * @return the x
     */
    @Override
    public int getX() {
        return x;
    }

    /**
     * @return the y
     */
    @Override
    public int getY() {
        return y;
    }

    /**
     * @return the width
     */
    @Override
    public int getWidth() {
        return width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

}
