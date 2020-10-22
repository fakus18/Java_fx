/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i01pidenombre;

import com.sun.javafx.logging.PlatformLogger.Level;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.System.Logger;

/**
 *
 * @author FP Mañana A
 */
public class GrabarFichero {

    public static void grabarPersona(Persona p) {
        FileWriter fw = null;
        try {
            String linea = p.getNombre()+","+p.getApellido()+","+p.getEdad()+"\n";
            fw = new FileWriter("c:\\TextosEclipse\\personas.txt");
            fw.write(linea);
            fw.close();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(GrabarFichero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(GrabarFichero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
        
    }
}
