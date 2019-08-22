package Grafo;

import java.util.HashMap;
import java.util.LinkedList;

/**
 *clase que se encarga de la construccion de grafo 
 * @author William Vasquez y Jorge Osorio
 * @version 1.2
 */
public class Grafo {
    private LinkedList<AristaGrafo> listaAristas;
    private HashMap<Nodo,LinkedList<Tupla>> listaAdyacencias;
    private LinkedList<Nodo> listaNodos;
    
    /**
     * metodo qeu se encarga de la inicializacion del grafo
     */
    public Grafo(){
        this.listaAristas = new LinkedList<>();
        this.listaAdyacencias = new HashMap<>();
    }
    
    /**
     * metodo que se encarga de llenar las listas de adyacencias
     */
    public void llenarAdyacencias(){
        System.out.println("tamaño: " + this.listaAristas.size());
        eliminarAristasRepetidas();
        for (Nodo n : this.listaNodos) {
            this.listaAdyacencias.put(n,buscarAdyacencias(n));
        }
        imprimirListaDeAdyacencias();
    }
    
    /**
     * metodo que se encarga de buscar las adyacencias para cada nodo
     * @param n el nodo del cual se buscaran las adayacencias
     * @return 
     */
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
    
    /**
     * metodo que se encarga de agregar aristas a la lista de aristas
     * @param a objeto de tipo aristagrafo
     */
    public void addAristaGrafo(AristaGrafo a){
        this.listaAristas.add(a);
    }
    
    /**
     * metodo que se encarga de traer la lista de nodos
     * @param list lista de nodos encontrados
     */
    public void traerNodos(LinkedList<Nodo> list){
        this.listaNodos = list;
    }
    
    /**
     * metodo que se encraga de imprimir la lista de adyacencias
     */
    private void imprimirListaDeAdyacencias(){
        for (Nodo n : this.listaAdyacencias.keySet()) {
            System.out.print("Raiz: " + n.toString() + "-> " + n.idContinente +"->" + n.getIsDoor());
            for(Tupla i : this.listaAdyacencias.get(n)){
                System.out.print(" peso: " + i.peso + " nodo: " + i.adyacente.toString());
            }
            System.out.println("");
        }
        
        for (AristaGrafo a: this.listaAristas) {
            System.out.println("n " + a.origen + " n2 " + a.destino + " p " + a.peso);
        }
    }
    
    private void eliminarAristasRepetidas(){
        LinkedList<AristaGrafo> aux = new LinkedList<>();
        for (AristaGrafo a : this.listaAristas) {
            if(!containsArista(a,aux)){
                aux.add(a);
            }
        }
        this.listaAristas = aux;
    }
   
    private boolean containsArista(AristaGrafo b,LinkedList<AristaGrafo> aux){
        for (AristaGrafo a : aux) {
            if(a.origen.equals(b.origen) && b.destino.equals(b.destino) && a.peso == b.peso){
                return true;
            }
        }
        return false;
    }
    
    
}
