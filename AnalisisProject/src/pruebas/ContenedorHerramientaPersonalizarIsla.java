/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Thebest
 */
public class ContenedorHerramientaPersonalizarIsla extends ContenedorTools {

    private int tamañoTesoro;
    private int esclavosJovenes;
    private int esclavosAdultos;
    private int esclavosViejos;
    private String nombreIsla;
    private ImageIcon imagenFondo;

    public ContenedorHerramientaPersonalizarIsla(int x, int y, int width, int height, ParametrosIsla p) {
        super(x, y, width, height);
        this.tamañoTesoro = p.getTamañoTesoro();
        this.esclavosJovenes = p.getEsclavosJovenes();
        this.esclavosAdultos = p.getEsclavosAdultos();
        this.esclavosViejos = p.getEsclavosViejos();
        this.nombreIsla = p.getNombreIsla();
        this.agregarEtiquetas();
        this.agregarCajasTextos();
        this.AñadirBotonGuardar();
        this.AñadirFondo();

    }

    private void AñadirFondo() {
        this.imagenFondo = new ImageIcon(getClass().getResource("../Imagenes/mapaFondo3.jpg"));
    }

    private void agregarEtiquetas() {

        JLabel aux = new JLabel("Tamaño tesoro");
        aux.setBounds(15, 10, 170, 30);
        this.add(aux);
        aux = new JLabel("Esclavos jovenes");
        aux.setBounds(15, 80, 170, 30);
        this.add(aux);
        aux = new JLabel("Esclavos adultos");
        aux.setBounds(15, 150, 170, 30);
        this.add(aux);
        aux = new JLabel("Esclavos viejos");
        aux.setBounds(15, 220, 170, 30);
        this.add(aux);
        aux = new JLabel("Nombre Isla");
        aux.setBounds(15, 290, 170, 30);
        this.add(aux);

    }

    private void agregarCajasTextos() {

        JTextField aux = new JTextField();
        aux.setBounds(15, 40, 170, 30);
        this.add(aux);
        aux = new JTextField();
        aux.setBounds(15, 110, 170, 30);
        this.add(aux);
        aux = new JTextField();
        aux.setBounds(15, 180, 170, 30);
        this.add(aux);
        aux = new JTextField();
        aux.setBounds(15, 250, 170, 30);
        this.add(aux);
        aux = new JTextField();
        aux.setBounds(15, 320, 170, 30);
        this.add(aux);
    }

    private void AñadirBotonGuardar() {
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setVisible(true);
        btnGuardar.setBounds(40, 390, 100, 40);
        this.add(btnGuardar);
        btnGuardar.addActionListener((java.awt.event.ActionEvent evt) -> {
            Guardar(evt);
        });
    }

    private void Guardar(java.awt.event.ActionEvent evt) {
        System.out.println("WP");
    }

    public ParametrosIsla guardado(int tamañoTesoro, int esclavoJoven, int esclavoAdulto,
            int esclavoViejo, String nombreIsla) {
        return new ParametrosIsla(tamañoTesoro, esclavoJoven, esclavoAdulto, esclavoViejo, nombreIsla);
    }

    @Override
    public void tamaño() {
        this.setBounds(x, y, width, heigth);
    }

    @Override
    public void agregarLayout() {
        this.setLayout(null);
    }

    @Override
    public void iniciarComponentes() {
        aspecto();
        tamaño();
        agregarLayout();
    }

    @Override
    public void aspecto() {
        this.setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.imagenFondo.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
        repaint();
    }

}
