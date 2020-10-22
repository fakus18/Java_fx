/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i01pidenombre;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ClasePrincipal extends Application {

    Persona p = null;

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage window) throws Exception {

        VBox v = new VBox(30);

        Label etiqueta_nombre = new Label("Nombre: ");
        Label etiqueta_apellido = new Label("Apellido: ");
        Label etiqueta_edad = new Label("Edad: ");

        TextField campo_nombre = new TextField();
        TextField campo_apellido = new TextField();
        TextField campo_edad = new TextField();

        Button btn = new Button("Enviar");

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                String nombre = campo_nombre.getText();
                String apellido = campo_apellido.getText();
                String edad = campo_edad.getText();
                p = new Persona(nombre, apellido, edad);
                GrabarFichero.grabarPersona(p);
            }
        });

        v.getChildren().addAll(etiqueta_nombre, campo_nombre, etiqueta_apellido, campo_apellido, etiqueta_edad, campo_edad, btn);
        Scene escena = new Scene(v, 300, 600);
        window.setScene(escena);
        window.show();
    }

}
