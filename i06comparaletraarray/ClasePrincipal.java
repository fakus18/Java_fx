package i06comparaletraarray;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ClasePrincipal extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        TextField tf = new TextField();
        Label lb = new Label();
        EventHandler<KeyEvent> oyente = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
                System.out.println("Pone: " + tf.getText());
                MiTarea tarea = new MiTarea(tf.getText());
                lb.textProperty().bind(tarea.messageProperty());
                Thread hilo = new Thread(tarea);
                hilo.setDaemon(true);
                hilo.start();
                tarea.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                    @Override
                    public void handle(WorkerStateEvent t) {
                        ArrayList<Contacto> lista_personas = tarea.getValue();                        
                    }
                });
            }
        };

        tf.setOnKeyReleased(oyente);
        VBox v = new VBox(20);
        v.getChildren().addAll(tf, lb);
        Scene s = new Scene(v, 300, 300);
        stage.setScene(s);
        stage.show();

    }

}
