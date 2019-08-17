/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModoEdicion;

import Clases.Continente;
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

    public void ReadArchivo(String ruta) {
        String linea;
        this.archivo = new File(ruta);
        try {
            this.reader = new FileReader(this.archivo);
            this.buffer = new BufferedReader(this.reader);
            while ((linea = this.buffer.readLine()) != null) {
                this.ReadJSON(linea);
            }
        } catch (IOException e) {
            System.out.println("Se putio");
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
        Mundo mundo = gson.fromJson(JSON, Mundo.class);

        mundo.getNodos().forEach((cont) -> {
            System.out.println(cont.getUbicacion());
        });
    }
}
