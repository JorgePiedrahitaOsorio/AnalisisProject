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
 *
 * @author JORGE OSORIO
 */
public class Serializador {

    File archivo;
    BufferedReader buffer;
    BufferedWriter writer;
    FileReader reader;
    LinkedList<String> archivoRead;

    public Serializador() {
    }
    
    public void ReadArchivo() {
        String linea;
        try {
            this.reader = new FileReader(this.archivo);
            this.buffer = new BufferedReader(this.reader);
            while ((linea = this.buffer.readLine()) != null) {
                //archivoRead.add(linea);
                this.ReadJSON(linea);
            }
        } catch (IOException e) {
        }
    }

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

    public void WriteJSON(Mundo mundo) {
         WriteArchivo(new Gson().toJson(mundo));
    }

    public void ReadJSON(String JSON) {
        Gson gson = new Gson();
        Object[] objetos = gson.fromJson(JSON, Object[].class);
        for (Object obj : objetos) {
           System.out.println(obj.toString());
        }
    }
    /**
     * Serializar clase mundo Esta contiene lista de continentes y mares
     */

}
