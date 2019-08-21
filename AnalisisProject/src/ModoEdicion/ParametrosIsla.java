/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModoEdicion;

/**
 *
 * @author Thebest (William)
 * @author JORGE OSORIO
 */
public class ParametrosIsla {

    /**
     * @return the tamañoTesoro
     */
    public int getTamañoTesoro() {
        return tamañoTesoro;
    }

    /**
     * @param tamañoTesoro the tamañoTesoro to set
     */
    public void setTamañoTesoro(int tamañoTesoro) {
        this.tamañoTesoro = tamañoTesoro;
    }

    /**
     * @return the esclavosJovenes
     */
    public int getEsclavosJovenes() {
        return esclavosJovenes;
    }

    /**
     * @param esclavosJovenes the esclavosJovenes to set
     */
    public void setEsclavosJovenes(int esclavosJovenes) {
        this.esclavosJovenes = esclavosJovenes;
    }

    /**
     * @return the esclavosAdultos
     */
    public int getEsclavosAdultos() {
        return esclavosAdultos;
    }

    /**
     * @param esclavosAdultos the esclavosAdultos to set
     */
    public void setEsclavosAdultos(int esclavosAdultos) {
        this.esclavosAdultos = esclavosAdultos;
    }

    /**
     * @return the esclavosViejos
     */
    public int getEsclavosViejos() {
        return esclavosViejos;
    }

    /**
     * @param esclavosViejos the esclavosViejos to set
     */
    public void setEsclavosViejos(int esclavosViejos) {
        this.esclavosViejos = esclavosViejos;
    }

    /**
     * @return the nombreIsla
     */
    public String getNombreIsla() {
        return nombreIsla;
    }

    /**
     * @param nombreIsla the nombreIsla to set
     */
    public void setNombreIsla(String nombreIsla) {
        this.nombreIsla = nombreIsla;
    }

    private int tamañoTesoro;
    private int esclavosJovenes;
    private int esclavosAdultos;
    private int esclavosViejos;
    private String nombreIsla;

    /**
     * La clase Parametros isla contendra toda la informacion de la isla
     * ingresada por el usuario en el modo de edicion
     *
     * @param tamañoTesoro indica la cantidad de monedas que contendra el tesoro
     * de la isla
     * @param esclavosJovenes indica la cantidad de esclavosJovenes que
     * contendra la isla
     * @param esclavosAdultos indica la cantidad de esclavosAdultos que
     * contendra la isla
     * @param esclavosViejos indica la cantidad de esclavosViejos que contendra
     * la isla
     * @param nombreIsla indica el nombre que tendra la isla
     */
    public ParametrosIsla(int tamañoTesoro, int esclavosJovenes, int esclavosAdultos,
            int esclavosViejos, String nombreIsla) {

        this.tamañoTesoro = tamañoTesoro;
        this.esclavosJovenes = esclavosJovenes;
        this.esclavosAdultos = esclavosAdultos;
        this.esclavosViejos = esclavosViejos;
        this.nombreIsla = nombreIsla;
    }

    /**
     * El constructor por defecto de la clase ParametrosIsla incializa las
     * variables de la clase en 0, para el caso de las variables enteras y como
     * vacio las varibles de tipo texto, esto con el fin de permitir al usuario
     * no llenar ningun campo al momento de la parametrizacion
     */
    public ParametrosIsla() {
        this.tamañoTesoro = 0;
        this.esclavosJovenes = 0;
        this.esclavosViejos = 0;
        this.esclavosAdultos = 0;
        this.nombreIsla = "";
    }
}
