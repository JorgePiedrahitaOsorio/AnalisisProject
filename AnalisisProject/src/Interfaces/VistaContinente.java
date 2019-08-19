/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Clases.Isla;
import Clases.Mar;
import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import javax.swing.JPanel;

/**
 *
 * @author Thebest
 */
public class VistaContinente extends JPanel {

    private int x, y, width, height;
    private LinkedList<Isla> islas;
    private LinkedList<Mar> mares;

    public VistaContinente(int x, int y, int width, int height, LinkedList<Isla> islas, LinkedList<Mar> mares) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.islas = islas;
        this.mares = mares;
        caracteristicasVisuales();
        colocarContinentes();
    }

    private void caracteristicasVisuales() {
        this.setBounds(x, y, width, height);
        this.setLayout(null);
        this.setBackground(new Color(0, 205, 199));
    }

    private void colocarContinentes() {
        for (Isla i : this.islas) {
            this.add(new ContenedorIsla(i.getUbicacion().x, i.getUbicacion().y,
                    i.getAncho(), i.getAlto(), i.getRuta()));
        }
    }
    
     @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.mares.forEach((m) -> {
            colocarMares(g,m.getOrigen(),m.getDestino());
        });
        repaint();
    }

    private void colocarMares(Graphics g, Isla origen, Isla destino) {
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

}
