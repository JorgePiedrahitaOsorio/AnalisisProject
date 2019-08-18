/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModoEdicion;

import Clases.Isla;
import Clases.Mar;
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
import static ModoEdicion.VistaConstructor.mundoClickeado;
import static ModoEdicion.VistaConstructor.banderaGuardar;
import java.awt.Point;

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

    protected LinkedList<AristaIsla> marProfundo;

    public ContenedorPreContinente(int x, int y, int width, int heigth, MouseMotionListener MouseMotion, MouseListener MouseListener) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.heigth = heigth;
        this.colocarIsla = false;
        this.rectangulos = new LinkedList<>();
        this.marProfundo = new LinkedList<>();
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

    public LinkedList<Isla> getIslas() {
        LinkedList<Isla> isla = new LinkedList<>();
        this.islas.keySet().forEach((contenedor) -> {
            ParametrosIsla parametros = this.islas.get(contenedor);
            isla.add(new Isla(new Point(contenedor.getX(), contenedor.getY()), contenedor.getWidth(), contenedor.getHeight(),
                    contenedor.getUrl(), parametros.getTamañoTesoro(), parametros.getEsclavosJovenes(),
                    parametros.getEsclavosAdultos(), parametros.getEsclavosViejos(), parametros.getNombreIsla()));
        });
        return isla;
    }

    public LinkedList<Mar> getMar() {
        LinkedList<Mar> mares = new LinkedList<>();
        this.marProfundo.forEach((arista) -> {
            Isla isla1 = getIsla(arista.getOrigen().getX(), arista.getOrigen().getY());
            Isla isla2 = getIsla(arista.getDestino().getX(), arista.getDestino().getY());
            int distancia = distancia(arista.getOrigen().getX(), arista.getOrigen().getY(), arista.getDestino().getX(), arista.getDestino().getY());
            System.out.println(distancia);
            mares.add(new Mar(isla1, isla2, arista.getPeligrosidad(), distancia));
        });
        return mares;
    }

    private int distancia(int x1, int x2, int y1, int y2) {
        return (int) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
    
    

    private Isla getIsla(int x, int y) {
        LinkedList<Isla> islasbuscar = this.getIslas();
        for (Isla isla : islasbuscar) {
            if (isla.getUbicacion().equals(new Point(x, y))) {
                return isla;
            }
        }
        return null;
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

    private void dibujarAristas(ContenedorNodoIsla origen, ContenedorNodoIsla destino, Graphics g) {
        g.setColor(Color.WHITE);
        g.drawLine(origen.getX() + origen.getWidth() / 2, origen.getY() + origen.getHeight() / 2,
                destino.getX() + destino.getWidth() / 2, destino.getY() + destino.getHeight() / 2);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        g.drawImage(this.imagenFondo.getImage(), 0, 0, this.width, this.heigth, null);
        if (this.colocarIsla) {
            g.setColor(this.color);
            g.drawRect(this.aux.x, this.aux.y, this.aux.width, this.aux.height);
        }
        this.marProfundo.forEach((marAux) -> {
            dibujarAristas(marAux.getOrigen(), marAux.getDestino(), g);
        });

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

    public void CambiarParametrizacion(ContenedorNodoIsla contenedor, ParametrosIsla parametros) {
        this.islas.remove(contenedor);
        this.islas.put(contenedor, parametros);
        banderaGuardar = false;
    }

}
