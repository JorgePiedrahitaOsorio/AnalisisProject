/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Clases.Continente;
import Clases.MarProfundo;
import java.awt.Color;
import java.awt.Image;
import java.util.LinkedList;
import javax.swing.ImageIcon;

/**
 *
 * @author Thebest
 */
public class VistaMundo extends javax.swing.JPanel {
    
    private int x,y,width,height;
    private LinkedList<Continente> continentes;
    private LinkedList<MarProfundo> maresProfundos;
    private Image imgFondo;
    
    public VistaMundo(int x, int y, int width, int height, LinkedList<Continente>
            continentes, LinkedList<MarProfundo> maresProfundos){
        this.x = x ;
        this.y = y;
        this.width = width;
        this.height = height;
        this.continentes = continentes;
        this.maresProfundos = maresProfundos;
        caracteristicasVisuales();
        colocarContinentes();
    }
    
    private void caracteristicasVisuales()
    {
        this.setBounds(x, y, width,height);
        this.setLayout(null);
        this.setBackground(new Color(0,205,199));
    }
    
    private void colocarContinentes(){
        for(Continente c : continentes){
            this.add(new ContenedorContinente(c.getUbicacion().x,c.getUbicacion().y,c.getAncho(),
                    c.getAlto(),c.getImagen()));
        }
    }
    
    private void colorcarMaresProfundos(){
        
    }
    
}
