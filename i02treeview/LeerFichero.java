package i02treeview;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LeerFichero {

    public static ArrayList<String> leerTxt() {
        ArrayList<String> leido = new ArrayList<>();
        try {
            String ruta = "C:\\TextosEclipse\\arbol.txt";
            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while (linea != null) {
                leido.add(linea);
                linea = br.readLine();
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(LeerFichero.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LeerFichero.class.getName()).log(Level.SEVERE, null, ex);
        }
        return leido;
    }

}
