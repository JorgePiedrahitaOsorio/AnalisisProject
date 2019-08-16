/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModoEdicion;

import static ModoEdicion.VistaConstructor.estadoEdicionIsla;

import java.awt.Color;

/**
 *
 * @author Thebest
 */
public final class ContenedorHerramientasIsla extends ContenedorTools {

    public ContenedorHerramientasIsla(int x, int y, int width, int heigth) {
        super(x, y, width, heigth);
        iniciarComponentes();
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
    public final void iniciarComponentes() {
        aspecto();
        tamaño();
        agregarLayout();
        crearIsla();
    }

    private void crearIsla() {
        agregarIsla("../Imagenes/isla1.png", 50, 20, 100, 100);
        agregarIsla("../Imagenes/isla2.gif", 50, 140, 100, 100);
        agregarIsla("../Imagenes/isla4.png", 50, 260, 100, 100);
    }

    private void agregarIsla(String url, int x, int y, int width, int height) {
        ContenedorImagen contenedorImagen = new ContenedorImagen(url, x, y, width, height);
        contenedorImagen.addActionListener((java.awt.event.ActionEvent evt) -> {
            AñadirBotonAction(evt);
        });
        this.add(contenedorImagen);
    }

    @Override
    public void aspecto() {
        this.setBackground(Color.BLACK);
    }

    public void AñadirBotonAction(java.awt.event.ActionEvent evt) {
        estadoEdicionIsla = true;
    }

}
