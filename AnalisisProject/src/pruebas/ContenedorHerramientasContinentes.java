/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

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
    public void iniciarComponentes() {
        aspecto();
        tamaño();
        agregarLayout();
        crearContinentes();
    }

    private void crearContinentes() {
        for (int i = 1; i < 7; i++) {
            agregarContinente("../Imagenes/continente" + i + ".png", 80, 20 * i
                    + (80 * (i - 1)), 80, 80);
        }
    }

    private void agregarContinente(String url, int x, int y, int width, int height) {
        ContenedorImagen contenedorImagen = new ContenedorImagen(url);
        contenedorImagen.setBounds(x, y, width, height);
        this.add(contenedorImagen);
    }

    @Override
    public void aspecto() {
        this.setBackground(Color.black);
    }
}
