/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Thebest
 */
public class Grafo {
    private LinkedList<AristaGrafo> listaAristas;
    private HashMap<Nodo,LinkedList<Tupla>> listaAdyacencias;
    private LinkedList<Nodo> listaNodos;
    
    public Grafo(){
        this.listaAristas = new LinkedList<>();
        this.listaAdyacencias = new HashMap<>();
    }
    
    public void llenarAdyacencias(){
        for (Nodo n : this.listaNodos) {
            this.listaAdyacencias.put(n,buscarAdyacencias(n));
        }
    }
    
    private LinkedList<Tupla> buscarAdyacencias(Nodo n){
        LinkedList<Tupla> aux = new LinkedList<>();
        for (AristaGrafo a : this.listaAristas) {
            if(a.origen.equals(n)){
                aux.add(new Tupla(a.destino,a.peso));
            }else if(a.destino.equals(n)){
                aux.add(new Tupla(a.origen,a.peso));
            }
        }
        return aux;
    }
    
    public void addAristaGrafo(AristaGrafo a){
        this.listaAristas.add(a);
    }
    
    public void traerNodos(LinkedList<Nodo> list){
        this.listaNodos = list;
    }
    
    
}
