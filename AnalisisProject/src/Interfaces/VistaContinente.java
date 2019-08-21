package Interfaces;

import Clases.Estrella;
import Clases.Isla;
import Clases.Mar;
import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import javax.swing.JPanel;

/**
 * clase que es el lienzo para dibujar a los nodos o islas que hacen parte de un
 * continente
 * @author William Vasquez y Jorge Osorio
 * @version 1.0
 */
public class VistaContinente extends JPanel {

    private int x, y, width, height;
    private LinkedList<Isla> islas;
    private LinkedList<Mar> mares;
    private LinkedList<Estrella> estrellas;

    /**
     * constructor que recibe ademas de los parametros basico para la contruccion 
     * del lienzo, tambien recibe una lista de islas y de mares
     * @param x posicion en x del lienzo en la vista
     * @param y posicion en y del lienzo en la vista
     * @param width ancho del lienzo
     * @param height alto del lienzo
     * @param islas lista de islas tomadas tras la serializacion
     * @param mares lista de mares tomados tras la serializacion
     */
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

    /**
     * metodo que implemente las caracteristicas visuales basicas del lienzo
     */
    private void caracteristicasVisuales() {
        this.setBounds(x, y, width, height);
        this.setLayout(null);
        this.setBackground(new Color(0, 205, 199));
    }

    /**
     * metodo que se encarga de colocar las islas en el lienzo
     */
    private void colocarContinentes() {
        for (Isla i : this.islas) {
            this.add(new ContenedorIsla(i.getUbicacion().x, i.getUbicacion().y,
                    i.getAncho(), i.getAlto(), i.getRuta()));
        }
    }

    /**
     * metodo que se encarga de colocar las estrellas para cada isla en el lienzo
     */
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

    /**
     * sobreescritura del metodo paintcomponent propio de java
     * @param g instacia del objeto graphics
     */
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

    /**
     * metodo que se encarga de dibujar la estrella de en el lienzo
     * @param g instancia de la clase graphics 
     * @param estrella estrella la cual va hacer dibujada en el lienzo
     */
    private void dibujarEstrella(Graphics g, Estrella estrella) {
        g.drawImage(estrella.getImagen().getImage(), estrella.getX(), estrella.getY(), estrella.getAncho(), estrella.getAlto(), this);
    }

    /**
     * metodo que se encarga de dibujar las aristas de los mares en el lienzo
     * @param g instacia d ela clase graphics de java
     * @param origen isla origen 
     * @param destino isla destino
     */
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
