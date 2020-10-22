package i02treeview;

import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ClasePrincipal extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) throws Exception {

        /*ARBOL 1*/
        TreeItem<String> gerencia = new TreeItem<>("Gerencia");
        gerencia.setExpanded(false);

        TreeItem<String> jefe_1 = new TreeItem<>("Javier");
        TreeItem<String> jefe_2 = new TreeItem<>("Juan");
        TreeItem<String> jefe_3 = new TreeItem<>("Jose");
        gerencia.getChildren().add(jefe_1);
        gerencia.getChildren().add(jefe_2);
        gerencia.getChildren().add(jefe_3);

        TreeView<String> tree_1 = new TreeView<>(gerencia);

        /*ARBOL 2*/
        TreeItem<String> administracion = new TreeItem<>("Administracion");
        administracion.setExpanded(true);

        TreeItem<String> administracion_1 = new TreeItem<>("Pedro");
        TreeItem<String> administracion_2 = new TreeItem<>("Paloma");
        TreeItem<String> administracion_3 = new TreeItem<>("Pilar");
        administracion.getChildren().add(administracion_1);
        administracion.getChildren().add(administracion_2);
        administracion.getChildren().add(administracion_3);

        TreeView<String> tree_2 = new TreeView<>(administracion);

        /*SUB-ARBOL JOSE-GERENCIA*/
        TreeItem<String> sub_arbol_jose_1 = new TreeItem<>("Puesto 1");
        TreeItem<String> sub_arbol_jose_2 = new TreeItem<>("Puesto 2");
        TreeItem<String> sub_arbol_jose_3 = new TreeItem<>("Puesto 3");

        administracion_1.getChildren().add(sub_arbol_jose_1);
        administracion_1.getChildren().add(sub_arbol_jose_2);
        administracion_1.getChildren().add(sub_arbol_jose_3);

        /*SUB-ARBOL PUESTO 1*/
        TreeItem<String> sub_puesto_1 = new TreeItem<>("Turno mañana");
        TreeItem<String> sub_puesto_2 = new TreeItem<>("Turno tarde");

        sub_arbol_jose_1.getChildren().add(sub_puesto_1);
        sub_arbol_jose_1.getChildren().add(sub_puesto_2);

        //Se puede pedir a una base de datos o un csv o Array y meter nombre de varias personas.
        ArrayList<String> personas = new ArrayList();
        String nombre_1 = "Roberto";
        String nombre_2 = "Ruben";
        String nombre_3 = "Remiro";
        personas.add(nombre_1);
        personas.add(nombre_2);
        personas.add(nombre_1);

        for (String x : personas) {
            TreeItem<String> item = new TreeItem(x);
            /*Puesto 2*/
            sub_arbol_jose_2.getChildren().add(item);
        }
        
        /*Leido CSV*/
        ArrayList<String> array_txt = LeerFichero.leerTxt();
        for (String x : array_txt) {
            TreeItem<String> item = new TreeItem(x);
            /*Puesto 3*/
            sub_arbol_jose_3.getChildren().add(item);
        }

        /*PANTALLA*/
        VBox v = new VBox(30);
        v.getChildren().addAll(tree_1, tree_2);
        Scene escena = new Scene(v, 300, 600);
        window.setScene(escena);
        window.show();

    }

}
