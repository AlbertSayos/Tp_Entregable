package controlador;


import javafx.event.EventHandler;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import vista.*;

public class ClickMaterialJuegoEventHandler implements EventHandler<MouseEvent>{
	
	JuegoVista juegoVista;
	GridPane mapa;
	
	public ClickMaterialJuegoEventHandler(JuegoVista juegoVista, GridPane mapa) {
		this.juegoVista = juegoVista;
		this.mapa = mapa;
	}
	
	
	@Override
	public void handle(MouseEvent event) {

        this.juegoVista.controlador().golpearMaterial(mapa, event);
		
	}
}