/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModoEdicion;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 * @author TheBest (William)
 * @author JORGE OSORIO
 */
public class PanelVistaSeleccion extends javax.swing.JPanel {

    private ImageIcon imgFondo;

    /**
     * La clase PanelVistaSeleccion que hereda de la clase Jpanel, se encarga de
     * pintar una imagen, esta imagen sera el fondo que se utilizara en la clase
     * VistaModoSimualacionSeleccion
     */
    public PanelVistaSeleccion() {
        initComponents();
        this.setBackground(Color.WHITE);
        colocarImgFondo();
    }

    /**
     * El metodo colocarImgFondo, es invocado en el constructor de la clase
     * actual. Instancia la variable imgFondo, que contendra una imagen con la
     * ruta estatica proporcionada dentro de dicho metodo. Cuenta ademas con un
     * try catch, el cual al momento de presentar alguna excepcion, mostrara un
     * mensaje por pantalla indicando que el fondo de esta clase no pudo ser
     * colocado ademas de cual fue la excepcion que provoco lo anterior
     */
    private void colocarImgFondo() {
        try {
            this.imgFondo = new ImageIcon(getClass().getResource("../Imagenes/BannerInicio.jpg"));
        } catch (Exception e) {
            System.out.println("Fondo Panel Vista Seleccion no pudo ser colocado : " + e);
        }
    }

    /**
     * Metodo paintComponent propio de la clase JPanel, permite pintar la imagen
     * cargada a travea del metodo colocarImgFondo, ademas de repintar
     * constantemente la pantalla para refrescar los cambios generados
     *
     * @param g Propio de java y su libreria Graphics,se encarga de pintar la
     * imagen, a partir del metodo propio drawImage que recibe como parametro la
     * imagen que se desea dibujar su posicion en x, y ademas de un ancho y alto
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.imgFondo.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
