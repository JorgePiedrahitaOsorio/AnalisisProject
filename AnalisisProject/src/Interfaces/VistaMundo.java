/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Clases.Continente;
import Clases.Isla;
import Clases.Mar;
import Clases.MarProfundo;
import Grafo.Grafo;
import Grafo.Nodo;
import Grafo.AristaGrafo;
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

    private Grafo grafo;
    private HashMap<Integer, LinkedList<Nodo>> gruposContinentes;
    private int idContinente;

    private Isla islaActual;
    private int continenactual;

    public VistaMundo(int x, int y, int width, int height, LinkedList<Continente> continentes, LinkedList<MarProfundo> maresProfundos) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.continentes = continentes;
        this.maresProfundos = maresProfundos;
        this.rutasImagenes = new HashMap<>();
        this.idContinente = 1;
        this.grafo = new Grafo();
        this.gruposContinentes = new HashMap<>();
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
        corregirReferenciasMaresProfundos();
        corregirReferenciasMares();
        continentes.forEach((c) -> {
            this.add(new ContenedorContinente(c.getUbicacion().x, c.getUbicacion().y, c.getAncho(),
                    c.getAlto(), rutaImagencontinente(c.getRuta())));
            c.setId(idContinente);
            idContinente++;
            crearNodos(c);
        });
        idContinente = 0;
        crearAristasDesdeMaresProfundo();
        grafo.traerNodos(enviarListNodos());
        grafo.llenarAdyacencias();
    }

    private LinkedList<Nodo> enviarListNodos() {
        LinkedList<Nodo> aux = new LinkedList<>();
        for (int i : this.gruposContinentes.keySet()) {
            for (Nodo j : this.gruposContinentes.get(i)) {
                aux.add(j);
            }
        }
        return aux;
    }

    private void crearNodos(Continente c) {
        LinkedList<Nodo> aux = new LinkedList<>();
        for (Isla i : c.getIslas()) {
            aux.add(new Nodo(i, c.getId()));
        }
        this.gruposContinentes.put(c.getId(), aux);
        crearAristas(aux, c);
        generarNodoPuerta(aux);
    }

    private void crearAristas(LinkedList<Nodo> nodos, Continente c) {
        for (Mar m : c.getMares()) {
            Nodo[] aux = buscarNodos(m.getOrigen(), m.getDestino(), nodos);
            this.grafo.addAristaGrafo(new AristaGrafo(aux[0], aux[1], m.getPeso()));
        }
    }

    private void corregirReferenciasMaresProfundos() {
        for (Continente c : this.continentes) {
            for (MarProfundo m : this.maresProfundos) {
                if (m.getOrigen().getUbicacion().x == c.getUbicacion().x
                        && m.getOrigen().getUbicacion().y == c.getUbicacion().y) {
                    m.setOrigen(c);
                } else if (m.getDestino().getUbicacion().x == c.getUbicacion().x
                        && m.getDestino().getUbicacion().y == c.getUbicacion().y) {
                    m.setDestino(c);
                }
            }
        }
    }
    
    private void corregirReferenciasMares(){
        for (Continente c : this.continentes) {
            for (Isla i : c.getIslas()) {
                for (Mar m : c.getMares()) {
                    if(m.getOrigen().getUbicacion().x == i.getUbicacion().x &&
                            m.getOrigen().getUbicacion().y == i.getUbicacion().y){
                        m.setOrigen(i);
                    }else if(m.getDestino().getUbicacion().x == i.getUbicacion().x &&
                            m.getDestino().getUbicacion().y == i.getUbicacion().y){
                        m.setDestino(i);
                    }
                }
            }
        }
    }

    private void crearAristasDesdeMaresProfundo() {
        for (int i : this.gruposContinentes.keySet()) {
        }
        for (MarProfundo m : this.maresProfundos) {
            grafo.addAristaGrafo(new AristaGrafo(BuscarNodoPuerta(m.getOrigen().getId()),
                    BuscarNodoPuerta(m.getDestino().getId()), m.getPeso()));
        }
    }

    private Nodo[] buscarNodos(Isla i1, Isla i2, LinkedList<Nodo> nodos) {
        Nodo[] aux = new Nodo[2];
        for (Nodo i : nodos) {
            if (i.isla.equals(i1)) {
                aux[0] = i;
            } else if (i.isla.equals(i2)) {
                aux[1] = i;
            }
        }
        return aux;
    }

    private Nodo BuscarNodoPuerta(int c) {
        for (Nodo i : this.gruposContinentes.get(c)) {
            System.out.println(i.getIsDoor());
            if (i.getIsDoor()) {
                return i;
            }
        }
        return null;
    }

    private void generarNodoPuerta(LinkedList<Nodo> nodos) {
        int num = -100;
        try {
            num = (int) (Math.random() * nodos.size() - 1);
            nodos.get(num).trueIsDoor();
        } catch (Exception e) {
        }

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
