package controlador;


import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import java.util.HashMap;

public class Escenario {
    private HashMap<String, Pane> escenas = new HashMap<>();
    private Scene main;


    public Escenario(Scene main) {
        this.main = main;
    }


    public void set(String nombre, Pane pane){
        escenas.put(nombre, pane);
    }


    public void mostrar(String nombre){
        main.setRoot(escenas.get(nombre));
    }


}
