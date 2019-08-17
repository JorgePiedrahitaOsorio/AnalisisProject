/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModoEdicion;

import Clases.Continente;
import Clases.Isla;
import Clases.MarProfundo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.ImageIcon;

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

    protected HashMap<ContenedorNodo, ContenedorPreContinente> islas;

    protected LinkedList<Arista> marProfundo;

    public ContenedorPremapa(int x, int y, int width, int heigth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.heigth = heigth;
        this.rectangulos = new LinkedList<>();
        this.ColocarContinente = false;
        this.color = Color.GREEN;
        this.islas = new HashMap<>();
        this.marProfundo = new LinkedList<>();
        iniciarComponentes();
    }
    
    public LinkedList<Continente> getContinentes(){
        LinkedList<Continente> continentes = new LinkedList<>();
        this.islas.keySet().forEach((contenedor) -> {
            ContenedorPreContinente cP = this.islas.get(contenedor);
            continentes.add(new Continente(contenedor.getLocation(), contenedor.getWidth(), contenedor.getHeight(), 
                    new ImageIcon(getClass().getResource(contenedor.getUrl())), cP.getIslas(), cP.getMar()));
        });
        return continentes;
    }
    
    public LinkedList<MarProfundo> getMares(){
        LinkedList<MarProfundo> mares = new LinkedList<>();
        this.marProfundo.forEach((arista) -> {
            Continente c1 = this.getContinente(arista.getContinenteOrigen().getX(), arista.getContinenteOrigen().getY());
            Continente c2 = this.getContinente(arista.getContinenteDestino().getX(), arista.getContinenteDestino().getY());
            mares.add(new MarProfundo(c1, c2, HEIGHT, WIDTH));
        });
        return mares;
    }
    
    private Continente getContinente(int x, int y){
        LinkedList<Continente> continentebuscar = this.getContinentes();
        for (Continente continente : continentebuscar) {
            if (continente.getUbicacion().equals(new Point(x, y))) {
                return continente;
            }
        }
        return null;
    }
    
    
    private void dibujarAristas(ContenedorNodo origen, ContenedorNodo destino, Graphics g) {
        g.setColor(Color.WHITE);
        g.drawLine(origen.getX() + origen.getWidth() / 2, origen.getY() + origen.getHeight() / 2,
                destino.getX() + destino.getWidth() / 2, destino.getY() + destino.getHeight() / 2);
    }

    private void iniciarComponentes() {
        aspecto();
        tamaño();
        agregarLayout();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(imgFondo, 0, 0, this.width, this.heigth - 45, null);

        if (ColocarContinente) {
            g.setColor(color);
            g.drawRect(aux.x, aux.y, aux.width, aux.height);
        }
        this.marProfundo.forEach((marAux) -> {
            dibujarAristas(marAux.getContinenteOrigen(), marAux.getContinenteDestino(), g);
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
            this.imgFondo = new ImageIcon(getClass().getResource("../Imagenes/mapaFondo1.png")).getImage();
        } catch (Exception e) {
            System.out.println("No cargo Fondo");
        }

    }

    public boolean DibujarRectangulos(int x, int y) {
        if (ColocarContinente) {
            if (NoColisiona(new Rectangle(x, y, 150, 150))) {
                this.rectangulos.add(new Rectangle(x, y, 150, 150));
                this.ColocarContinente = false;
                return true;
            }
        }
        return false;
    }
    
    

    public void DibujarRectanguloVerdeRojo(int x, int y) {
        if (ColocarContinente) {
            aux = new Rectangle(x, y, 150, 150);
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