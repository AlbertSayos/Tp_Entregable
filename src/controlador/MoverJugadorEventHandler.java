package controlador;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import vista.*;

public class MoverJugadorEventHandler implements EventHandler<KeyEvent>{

    JuegoVista juegoVista;
    GridPane mapa;
    Escenario escenario;

    public MoverJugadorEventHandler(JuegoVista juegoVista, GridPane mapa, Escenario escenario) {
        this.juegoVista = juegoVista;
        this.mapa = mapa;
        this.escenario = escenario;
    }


    @Override
    public void handle(KeyEvent event) {
    	if (event.getCode() == KeyCode.E) {
    		this.juegoVista.inventario().controlador().actualizarVistaInventario();
            escenario.mostrar("inventario");
        }
        if(event.getCode() == KeyCode.W) {
            this.juegoVista.controlador().moverArriba(mapa);
        }
        if( event.getCode() == KeyCode.S) {
            this.juegoVista.controlador().moverAbajo(mapa);
        }
        if (event.getCode() == KeyCode.D) {
            this.juegoVista.controlador().moverDerecha(mapa);
        }
        if (event.getCode() == KeyCode.A) {
            this.juegoVista.controlador().moverIzquierda(mapa);
        }
        if (event.getCode() == KeyCode.ESCAPE) {
            escenario.mostrar("entrada");
        }
        //event.consume();

    }
}