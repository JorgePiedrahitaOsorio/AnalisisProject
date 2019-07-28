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
public final class ContenedorHerramientasIsla extends ContenedorTools {
    
    public ContenedorHerramientasIsla(int x, int y, int width, int heigth){
        super(x,y,width,heigth);
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
    
    private void crearIsla(){
        for (int i = 1; i < 5; i++) {
            agregarIsla("../Imagenes/continente"+String.valueOf(i)+".png",50, 20 * i
                    + (100 * (i - 1)), 100, 100);
        }
    }
    
    private void agregarIsla(String url, int x, int y, int width, int height){
        ContenedorImagen contenedorImagen = new ContenedorImagen(url,x, y, width, height);
        this.add(contenedorImagen);
    }

    @Override
    public void aspecto() {
        this.setBackground(Color.black);
    }
    
}
