package vista;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Boton extends Button {

    public Boton(String etiqueta) {

        super();
        this.setGraphic(new Label(etiqueta));

    }
}