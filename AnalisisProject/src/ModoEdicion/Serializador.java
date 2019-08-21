/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModoEdicion;

import Clases.Mundo;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author TheBest (William)
 * @author JORGE OSORIO
 */
public class Serializador {

    File archivo;
    BufferedReader buffer;
    BufferedWriter writer;
    FileReader reader;
    LinkedList<String> archivoRead;

    /**
     * Constructor por defecto de la clase Serializador, no es necesario
     * inicializar ninguna variable para que sea exitosa la creacion de esta
     * clase
     */
    public Serializador() {
    }

    /**
     * Metodo que se encarga de leer el archivo donde se encuentra almacenado el
     * mapa. Por primer medida se genera un nuevo archivo con la ruta enviada
     * por el usuario, una vez es obtenido el archivo, por medio de las
     * variables reader y buffer el archivo es leido linea por linea, dichas
     * lineas seran posteriormente la entrada de datos del metodo ReadJSON
     *
     * @param ruta este parametro indica la ubicacion del archivo mapa que el
     * usuario ha seleccionado para ser cargado
     * @return un objeto de tipo Mundo, en este tipo de objeto se contiene toda
     * la informacion de los continentes, mares e islas que se crearon durante
     * el modo de edicion y que fueron almacenados por el usuairo
     */
    public Mundo ReadArchivo(String ruta) {
        String linea;
        this.archivo = new File(ruta);
        try {
            this.reader = new FileReader(this.archivo);
            this.buffer = new BufferedReader(this.reader);
            if ((linea = this.buffer.readLine()) != null) {
                return this.ReadJSON(linea);
            }
        } catch (IOException e) {
            System.out.println("Error de lectura del mapa");
        }
        return null;
    }

    /**
     * El metodo WriteArchivo, permite escribir un archivo de tipo txt, en este
     * se almacena la informacion del mapa generado por el usuario en el modo
     * edicion. Este metodo es invocado al momento de simular o al momento de
     * seleccionar la opcion guardar directamente.
     *
     * @param contenido este parametro trae la informacion en formato JSON del
     * mapa que se ha decidido guardar
     */
    private void WriteArchivo(String contenido) {
        String ruta = "../mapa1.txt";
        this.archivo = new File(ruta);
        try {
            if (!this.archivo.exists()) {
                this.archivo.createNewFile();
            }
            FileWriter fw = new FileWriter(this.archivo);
            writer = new BufferedWriter(fw);
            writer.write(contenido);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(Serializador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Haciendo uso de la libreria Gson este metodo instancia el metodo
     * WriteArchivo, con el resultado obtenido de la serializacion generada por
     * la libreria
     *
     * @param mundo el objeto mundo el cual va a ser serialiado
     */
    public void WriteJSON(Mundo mundo) {
        WriteArchivo(new Gson().toJson(mundo));
    }

    /**
     * *
     * El metodo ReadJSON hace uso de la libreria Gson para deserializar la
     * informacion contenida en un archivo JSON. Esta deserializacion da como
     * resultado la creacion de un objeto de tipo mundo, en este se contiene la
     * informacion de continentes, islas y mares
     *
     * @param JSON es obtenido a partir de la lectura del archivo txt por medio
     * del metodo ReadArchivo
     * @return un objeto de tipo Mundo, previamente generado y despues
     * serializado
     */
    public Mundo ReadJSON(String JSON) {
        Gson gson = new Gson();
        return gson.fromJson(JSON, Mundo.class);
    }
}
