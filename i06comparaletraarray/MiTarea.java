package i06comparaletraarray;

import java.util.ArrayList;
import javafx.concurrent.Task;

public class MiTarea extends Task< ArrayList<Contacto>> {

    private String nombre_buscado;

    public MiTarea(String nombew_buscado) {
        this.nombre_buscado = nombew_buscado;
    }

    @Override
    protected ArrayList<Contacto> call() throws Exception {

        ArrayList<Contacto> lista_contactos = AccesoDatos.buscarContacto(nombre_buscado);
        updateMessage("Buscado: " + lista_contactos);

        return lista_contactos;
    };

}
