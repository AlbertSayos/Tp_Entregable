package controlador;

import javafx.scene.layout.*;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import modelo.jugador.*;
import modelo.herramientas.*;
import vista.SelectorDeHerramientas;
import vista.*;


public class ControladorSelectorHerramienta {


	Jugador jugador;
	SelectorDeHerramientas selector;


	public ControladorSelectorHerramienta(Jugador jugador, SelectorDeHerramientas selector){
		this.jugador = jugador;
		this.selector = selector;
		selector.setControlador(this);
		
	}
	
	public void actualizarSelectorHerramienta() {

		Herramienta[] herramientas = this.jugador.getHerramientas();
		selector.getChildren().clear();
		
		for(int i = 0; i< herramientas.length; i++ ) {
			StackPane casilla = new Casilla();
			casilla.getChildren().add(new ImageView(new Image((herramientas[i].getClass().getSimpleName()+".png"), 38, 0, true, true)));
			selector.add(casilla, i, 0);
		}
	}
	
	public void cambiarHerramientaEquipada(int pos) {
		jugador.equiparHerramientaEnPosicion(pos);
	}
	
	public void seleccionarHerramienta() {
		
	}
	
	public void agregarNuevaHerramienta() {
		this.jugador.agregarHerramientaAlInventario(new PicoDePiedra());
	}
	
}
