package Clases;

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

public class ArchivoJSON {

    File archivo;
    BufferedReader buffer;
    BufferedWriter writer;
    FileReader reader;
    LinkedList<String> archivoRead;

    public ArchivoJSON() {
    }

    public ArchivoJSON(File archivo) {
        this.archivo = archivo;
        this.archivoRead = new LinkedList<>();
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

    public void WriteArchivo(String contenido) {
        String ruta = "../mapa1.txt";
        File file = new File(ruta);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            writer = new BufferedWriter(fw);
            writer.write(contenido);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(ArchivoJSON.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void WriteJSON(LinkedList elementos) {
         WriteArchivo(new Gson().toJson(elementos));
    }

    public void ReadJSON(String JSON) {
        Gson gson = new Gson();
        Object[] objetos = gson.fromJson(JSON, Object[].class);
        for (Object obj : objetos) {
           System.out.println(obj.toString());
        }
    }
}
