/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModoEdicion;

import java.awt.Color;

/**
 *
 * @author Thebest
 */
public class ContenedorHerramientasContinentes extends ContenedorTools {

    public ContenedorHerramientasContinentes(int x, int y, int width, int heigth) {
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
        crearContinentes();
    }

    private void crearContinentes() {
        for (int i = 1; i < 7; i++) {
            agregarContinente("../Imagenes/continente" + String.valueOf(i) + ".png", String.valueOf(i) + ".png", 50, 20 * i
                    + (100 * (i - 1)), 100, 100);
            //agregarContinente(String.valueOf(i) + ".png", 50, 20 * i + (100 * (i - 1)), 100, 100);
        }
    }

    private void agregarContinente(String url, String url2, int x, int y, int width, int height) {
        ContenedorImagen contenedorImagen = new ContenedorImagen(url, x, y, width, height);
        contenedorImagen.setUrl2(url2);
        this.add(contenedorImagen);
    }

    @Override
    public void aspecto() {
        this.setBackground(Color.black);
    }
}