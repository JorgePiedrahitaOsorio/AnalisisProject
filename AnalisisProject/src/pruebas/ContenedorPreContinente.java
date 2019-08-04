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
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import static pruebas.VistaConstructor.mundoClickeado;

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
    private JButton mundo;
    private boolean colocarIsla;
    private LinkedList<Rectangle> rectangulos;
    private Rectangle aux;
    private Color color;

    protected HashMap<ContenedorNodoIsla, ParametrosIsla> islas;

    public ContenedorPreContinente(int x, int y, int width, int heigth, MouseMotionListener MouseMotion, MouseListener MouseListener) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.heigth = heigth;
        this.colocarIsla = false;
        this.rectangulos = new LinkedList<>();
        this.aux = new Rectangle();
        this.color = Color.GREEN;
        this.islas = new HashMap<>();
        this.addMouseListener(MouseListener);
        this.addMouseMotionListener(MouseMotion);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        aspecto();
        tamaño();
        agregarLayout();
        AgregarFondo();
        AñadirBotonMundo();
    }

    private void tamaño() {
        this.setBounds(x, y, getWidth(), heigth);
    }

    private void agregarLayout() {
        this.setLayout(null);
    }

    private void aspecto() {
        this.setBackground(Color.BLACK);
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
        if (this.colocarIsla) {
            g.setColor(this.color);
            g.drawRect(this.aux.x, this.aux.y, this.aux.width, this.aux.height);
        }
        repaint();
    }

    private void AñadirBotonMundo() {
        ImageIcon icono = new ImageIcon(getClass().getResource("../Imagenes/IconoMundo.png"));
        Icon iconoEscalado = new ImageIcon(icono.getImage().getScaledInstance(80,
                80, Image.SCALE_DEFAULT));
        this.mundo = new JButton(iconoEscalado);
        this.mundo.setBounds(1050, 600, 80, 80);
        this.mundo.setContentAreaFilled(false);
        this.mundo.setBorder(null);
        this.mundo.setVisible(true);
        this.add(mundo);
        this.mundo.addActionListener((java.awt.event.ActionEvent evt) -> {
            AccionBotonMundo(evt);
        });
    }

    private void AccionBotonMundo(java.awt.event.ActionEvent evt) {
        mundoClickeado = true;
    }

    public boolean DibujarRectangulos(int x, int y) {
        if (this.colocarIsla) {
            if (NoColisiona(new Rectangle(x, y, 150, 150))) {
                this.rectangulos.add(new Rectangle(x, y, 150, 150));
                this.setColocarIsla(false);
                return true;
            }
        }
        return false;
    }

    private boolean NoColisiona(Rectangle aux) {
        return this.rectangulos.stream().noneMatch((r) -> r.intersects(aux));
    }

    public void DibujarRectanguloVerdeRojo(int x, int y) {
        if (this.colocarIsla) {
            this.aux = new Rectangle(x, y, 150, 150);
            if (!this.NoColisiona(this.aux)) {
                this.color = Color.RED;
            } else {
                this.color = Color.GREEN;
            }
        }
    }

    /**
     * @param colocarIsla the colocarIsla to set
     */
    public void setColocarIsla(boolean colocarIsla) {
        this.colocarIsla = colocarIsla;
    }

}
