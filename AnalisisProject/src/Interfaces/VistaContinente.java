/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Clases.Estrella;
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
    private LinkedList<Estrella> estrellas;

    public VistaContinente(int x, int y, int width, int height, LinkedList<Isla> islas, LinkedList<Mar> mares) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.islas = islas;
        this.mares = mares;
        this.estrellas = new LinkedList<>();
        caracteristicasVisuales();
        colocarContinentes();
        colocarEstrellas();
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

    private void colocarEstrellas() {
        for (Isla isla : this.islas) {
            for (int i = 0; i < isla.getNumeroDeEstrellas(); i++) {
                switch (isla.getNumeroDeEstrellas()) {
                    case 0:
                        break;
                    case 1:
                        this.estrellas.add(new Estrella(isla.getUbicacion().x - 65, isla.getUbicacion().y, 20, 20));
                        break;
                    case 2:
                        if (i == 0) {
                            this.estrellas.add(new Estrella(isla.getUbicacion().x - 65, isla.getUbicacion().y - 30, 20, 20));
                        } else {
                            this.estrellas.add(new Estrella(isla.getUbicacion().x - 65, isla.getUbicacion().y + 20, 20, 20));
                        }
                        break;
                    default:
                        switch (i) {
                            case 0:
                                this.estrellas.add(new Estrella(isla.getUbicacion().x - 65, isla.getUbicacion().y - 30, 20, 20));
                                break;
                            case 1:
                                this.estrellas.add(new Estrella(isla.getUbicacion().x - 65, isla.getUbicacion().y - 10, 20, 20));
                                break;
                            default:
                                this.estrellas.add(new Estrella(isla.getUbicacion().x - 65, isla.getUbicacion().y + 30, 20, 20));
                                break;
                        }
                        break;
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.mares.forEach((m) -> {
            colocarMares(g, m.getOrigen(), m.getDestino());
        });
        this.estrellas.forEach((estrella) -> {
            dibujarEstrella(g, estrella);
        });
        repaint();
    }

    private void dibujarEstrella(Graphics g, Estrella estrella) {
        g.drawImage(estrella.getImagen().getImage(), estrella.getX(), estrella.getY(), estrella.getAncho(), estrella.getAlto(), this);
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
