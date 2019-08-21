package Clases;

/**
 *  Clase abstracta la cual crea esclavos dado su comparecencia en su comportamiento
 * @author JORGE OSORIO
 */
public class Esclavo {

    protected int horasNavegacion;

    public Esclavo() {
    }

    public Esclavo(int horasNavegacion) {
        this.horasNavegacion = horasNavegacion;
    }

    /**
     * @return the horasNavegacion
     */
    public int getHorasNavegacion() {
        return horasNavegacion;
    }

    /**
     * @param horasNavegacion the horasNavegacion to set
     */
    public void setHorasNavegacion(int horasNavegacion) {
        this.horasNavegacion = horasNavegacion;
    }

}
