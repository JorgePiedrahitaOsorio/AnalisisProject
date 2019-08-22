package Grafo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * clase que se encarga de la construccion de grafo
 *
 * @author William Vasquez y Jorge Osorio
 * @version 1.2
 */
public class Grafo {

    private LinkedList<AristaGrafo> listaAristas;
    private HashMap<Nodo, LinkedList<Tupla>> listaAdyacencias;
    private LinkedList<Nodo> listaNodos;

    /**
     * metodo qeu se encarga de la inicializacion del grafo
     */
    public Grafo() {
        this.listaAristas = new LinkedList<>();
        this.listaAdyacencias = new HashMap<>();
    }

    /**
     * metodo que se encarga de llenar las listas de adyacencias
     */
    public void llenarAdyacencias() {
        System.out.println("tamaño: " + this.listaAristas.size());
        eliminarAristasRepetidas();
        for (Nodo n : this.listaNodos) {
            this.listaAdyacencias.put(n, buscarAdyacencias(n));
        }
        imprimirListaDeAdyacencias();
        System.out.println("tam:" + this.listaNodos.size());
        algoritmo(this.listaNodos.getFirst());
    }

    /**
     * metodo que se encarga de buscar las adyacencias para cada nodo
     *
     * @param n el nodo del cual se buscaran las adayacencias
     * @return
     */
    private LinkedList<Tupla> buscarAdyacencias(Nodo n) {
        LinkedList<Tupla> aux = new LinkedList<>();
        for (AristaGrafo a : this.listaAristas) {
            if (a.origen.equals(n)) {
                aux.add(new Tupla(a.destino, a.peso));
            } else if (a.destino.equals(n)) {
                aux.add(new Tupla(a.origen, a.peso));
            }
        }
        return aux;
    }

    /**
     * metodo que se encarga de agregar aristas a la lista de aristas
     *
     * @param a objeto de tipo aristagrafo
     */
    public void addAristaGrafo(AristaGrafo a) {
        this.listaAristas.add(a);
    }

    /**
     * metodo que se encarga de traer la lista de nodos
     *
     * @param list lista de nodos encontrados
     */
    public void traerNodos(LinkedList<Nodo> list) {
        this.listaNodos = list;
    }

    /**
     * metodo que se encraga de imprimir la lista de adyacencias
     */
    private void imprimirListaDeAdyacencias() {
        for (Nodo n : this.listaAdyacencias.keySet()) {
            System.out.print("Raiz: " + n.toString() + "-> " + n.idContinente + "->" + n.getIsDoor());
            for (Tupla i : this.listaAdyacencias.get(n)) {
                System.out.print(" peso: " + i.peso + " nodo: " + i.adyacente.toString());
            }
            System.out.println("");
        }

        for (AristaGrafo a : this.listaAristas) {
            System.out.println("n " + a.origen + " n2 " + a.destino + " p " + a.peso);
        }
    }

    private void eliminarAristasRepetidas() {
        LinkedList<AristaGrafo> aux = new LinkedList<>();
        for (AristaGrafo a : this.listaAristas) {
            if (!containsArista(a, aux)) {
                aux.add(a);
            }
        }
        this.listaAristas = aux;
    }

    private boolean containsArista(AristaGrafo b, LinkedList<AristaGrafo> aux) {
        for (AristaGrafo a : aux) {
            if (a.origen.equals(b.origen) && b.destino.equals(b.destino) && a.peso == b.peso) {
                return true;
            }
        }
        return false;
    }

    //-----Implementacion metodos Dijkstra
    int distancias[];
    boolean visitados[] ;
    int previo[] ;
    LinkedList<Nodo> cola = new LinkedList<>();
    LinkedList<Nodo> camino = new LinkedList<>();

    public void algoritmo(Nodo origen) {
        System.out.println("tam:" + this.listaNodos.size());
        visitados = new boolean[this.listaNodos.size()];
        distancias= new int[this.listaNodos.size()];
        previo = new int[this.listaNodos.size()];
        for (int i = 0; i < this.listaNodos.size(); i++) {
            distancias[i] = Integer.MAX_VALUE;
            visitados[i] = false;
            previo[i] = -1;
        }

        int actual, adyacente;
        cola.add(origen);
        this.distancias[indiceVisitado(origen)] = 0;
        while (!cola.isEmpty()) {
            Nodo u = cola.removeFirst();
            actual = indiceVisitado(u);
            if (visitados[actual]) {
                continue;
            }
            visitados[actual] = true;
            for (int q = 0; q < this.listaAdyacencias.get(u).size(); q++) {
                Tupla ady = this.listaAdyacencias.get(u).get(q);
                adyacente = indiceVisitado(ady.adyacente);
                if(!this.visitados[adyacente]){
                    relajacion(u,ady);
                }
            }
        }
          for (int i = 0; i < this.distancias.length; i++) {
            System.out.print("- " + this.distancias[i]);
        }
          System.out.println("");
          for (int i = 0; i < this.distancias.length; i++) {
            System.out.print("- " + this.previo[i]);
        }
          System.out.println("");
        imprimirCamino(this.listaNodos.getLast(),this.camino);
        this.camino.addFirst(origen);
    }

    private int indiceVisitado(Nodo u) {
        for (int i = 0; i < this.listaNodos.size(); i++) {
            if (u.equals(this.listaNodos.get(i))) {
                return i;
            }
        }
        return -1;
    }

    private void relajacion(Nodo actual, Tupla adyacente) {
        if (this.distancias[indiceVisitado(actual)] + adyacente.peso < this.distancias[indiceVisitado(adyacente.adyacente)]){
            this.distancias[indiceVisitado(adyacente.adyacente)] = this.distancias[indiceVisitado(actual)] + adyacente.peso;
            previo[indiceVisitado(adyacente.adyacente)] = indiceVisitado(actual);
            this.cola.addLast(adyacente.adyacente);
        }
    }

    private void imprimirCamino(Nodo destino,LinkedList<Nodo> nodos){
        if(previo[indiceVisitado(destino)] != -1){
            nodos.addFirst(destino);
            System.out.println( previo[indiceVisitado(destino)]+" - "+ this.listaNodos.get(previo[indiceVisitado(destino)]));
            imprimirCamino(this.listaNodos.get(previo[indiceVisitado(destino)]),nodos);
        }
    }
    
    
}
