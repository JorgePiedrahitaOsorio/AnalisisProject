/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModoEdicion;


/**
 *
 * @author Thebest
 */
public abstract class ContenedorTools extends javax.swing.JPanel{
    public int x, y, width, heigth;

    public ContenedorTools(int x, int y, int width, int heigth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.heigth = heigth;
        iniciarComponentes();
    }

    public abstract void tamaño();
    
    public abstract void agregarLayout();

    public abstract void iniciarComponentes();

    public abstract void aspecto();
}