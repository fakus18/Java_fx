/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i06comparaletraarray;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FP Mañana A
 */
public class AccesoDatos {

    static String ruta = "C:\\TextosEclipse\\agenda_2.csv";

    public static ArrayList<Contacto> buscarContacto(String nombre_buscado) {

        ArrayList<Contacto> lista_contactos = new ArrayList<Contacto>();

        try {
            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while (linea != null) {
                String[] datos = linea.split(";");
                String nombre = datos[0];
                String apellido = datos[1];
                Contacto c = new Contacto(nombre, apellido);

                if (nombre.toUpperCase().contains(nombre_buscado.toUpperCase())) {
                    System.out.println("Añado a la lista: " + c);
                    lista_contactos.add(c);
                }

                linea = br.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista_contactos;
    }
}
