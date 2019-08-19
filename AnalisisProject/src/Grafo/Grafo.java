/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import java.util.LinkedList;

/**
 *
 * @author Thebest
 */
public class Grafo {
    private LinkedList<AristaGrafo> listaAristas;
    
    public Grafo(){
        this.listaAristas = new LinkedList<>();
    }
    
    public void addAristaGrafo(AristaGrafo a){
        this.listaAristas.add(a);
    }
}
