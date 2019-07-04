package vista;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import controlador.ControladorSelectorHerramienta;

public class SelectorDeHerramientas extends GridPane {

	ControladorSelectorHerramienta controlador;
	
    public SelectorDeHerramientas() {

        this.setAlignment(Pos.TOP_CENTER);
        for (int i = 0; i < 9; i++)
            this.add(new Casilla(),i , 0);
        
        setOnMouseClicked(e -> {
            int posicion = getPosicion(e);
            
            controlador.cambiarHerramientaEquipada(posicion);

            
        });	
        
    }

    public void agregar(String elemento, int pos) {

        ImageView imageView = new ImageView(new Image((elemento), 38, 0, true, true));
        this.add(imageView, pos, 0);

    }

    public int getPosicion(MouseEvent event) {

        Node nodoClickeado = event.getPickResult().getIntersectedNode();
        return GridPane.getColumnIndex(nodoClickeado.getParent());

    }

    public void limpiar() {

        this.getChildren().clear();
        for (int i = 0; i < 9; i++)
        	this.add(new Casilla(),i , 0);

    }
    
    public ControladorSelectorHerramienta controlador() {
    	return this.controlador;
    }

    public void setControlador(ControladorSelectorHerramienta controlador) {
    	this.controlador = controlador;
    }
}
