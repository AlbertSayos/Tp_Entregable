package controlador;

import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import modelo.juego.Juego;
import modelo.posicion.Posicion;
import vista.JuegoVista;
import modelo.materiales.*;
import controlador.*;


public class ControladorDelJuego {

    private Juego juego;
    private JuegoVista juegoVista;
    private int jugadorPosX, jugadorPosY;
    private ControladorDeInventario controladorDeInventario;


    public ControladorDelJuego(JuegoVista juegoVista, Juego  juego, ControladorDeInventario controladorDeInventario) {

        this.controladorDeInventario = controladorDeInventario;
        this.juego = juego;
        //this.juego.iniciar();
        this.juegoVista = juegoVista;
        juegoVista.setControlador(this);
        this.jugadorPosX = 0;
        this.jugadorPosY = 0;

    }


    public void actualizarVista() {

        for(int row = 0; row < juego.getMapa().getFilas() ; row++)
        {
            for(int col = 0; col < juego.getMapa().getColumnas(); col++)
            {
                Posicion posicion = new Posicion(row,col);
                Material objeto = juego.getMapa().obtenerObjeto(posicion);
                String nombreImagen = objeto.getRutaImagen();
                //System.out.println(nombreImagen);
                juegoVista.agregarElemento(nombreImagen, col, row);
            }
        }
    }


    public void moverArriba(GridPane mapa){
    	
    	if(!this.juego.getMovimientos().moverJugadorArriba(this.juego.mapa)){
    		
    		return;
    	}
    	
    	Node jugadorNode =  getNodeFromGridPane(mapa, this.jugadorPosX, this.jugadorPosY);
    	Node siguiente = getNodeFromGridPane(mapa, this.jugadorPosX, this.jugadorPosY-1);
    	
    	mapa.getChildren().remove(jugadorNode);
    	mapa.getChildren().remove(siguiente);
    	
    	//this.juegoVista.agregarElemento("negro.png", this.jugadorPosX, this.jugadorPosY);
    	
    	this.jugadorPosY --;
    	mapa.add(jugadorNode, this.jugadorPosX, this.jugadorPosY);
   
    }


    public void moverAbajo(GridPane mapa){
    	
    	if(!this.juego.getMovimientos().moverJugadorAbajo(this.juego.mapa)){
    		
    		return;
    	}
    	
    	Node jugadorNode =  getNodeFromGridPane(mapa, this.jugadorPosX, this.jugadorPosY);
    	Node siguiente = getNodeFromGridPane(mapa, this.jugadorPosX, this.jugadorPosY+1);
    	
    	mapa.getChildren().remove(jugadorNode);
    	mapa.getChildren().remove(siguiente);
    	
    	//this.juegoVista.agregarElemento("negro.png", this.jugadorPosX, this.jugadorPosY);
    	
    	this.jugadorPosY++ ;
    	mapa.add(jugadorNode, this.jugadorPosX, this.jugadorPosY);

    }


    public void moverDerecha(GridPane mapa){
    	
    	if(!this.juego.getMovimientos().moverJugadorDerecha(this.juego.mapa)) return;
    		
	    Node jugadorNode =  getNodeFromGridPane(mapa, this.jugadorPosX, this.jugadorPosY);
	    Node siguiente = getNodeFromGridPane(mapa, this.jugadorPosX+1, this.jugadorPosY);
	        	
	    mapa.getChildren().remove(jugadorNode);
	    mapa.getChildren().remove(siguiente);
	        	
	    //this.juegoVista.agregarElemento("negro.png", this.jugadorPosX, this.jugadorPosY);
	    
	    this.jugadorPosX ++;
	        	
	    mapa.add(jugadorNode, this.jugadorPosX, this.jugadorPosY);
	    		
    	
    	    
    }
    

    public void moverIzquierda(GridPane mapa){

    	if(!this.juego.getMovimientos().moverJugadorIzquierda(this.juego.mapa)) return;
        	
    	Node jugadorNode =  getNodeFromGridPane(mapa, this.jugadorPosX, this.jugadorPosY);
        Node siguiente = getNodeFromGridPane(mapa, this.jugadorPosX-1, this.jugadorPosY);
        
       	mapa.getChildren().remove(jugadorNode);
       	mapa.getChildren().remove(siguiente);
        
       	//this.juegoVista.agregarElemento("negro.png", this.jugadorPosX, this.jugadorPosY);       	
       	
       	this.jugadorPosX --;
       	mapa.add(jugadorNode, this.jugadorPosX, this.jugadorPosY);    		
    	
    }

    
    private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }


    public void golpearMaterial(GridPane mapa, MouseEvent event){
    	
    	Node nodoClickeado = event.getPickResult().getIntersectedNode();
    	   
    	if (nodoClickeado!= mapa) {
    		int colIndex = GridPane.getColumnIndex(nodoClickeado);
    		int rowIndex = GridPane.getRowIndex(nodoClickeado);
    		System.out.println("Mouse clicked cell: " + colIndex + " And: " + rowIndex);
    		System.out.println(this.juego.jugador.getHerramientaEquipada().getDurabilidad());
    		if(!this.juego.jugadorGolpeaEnPosicion(colIndex, rowIndex)){
    			mapa.getChildren().remove(nodoClickeado);    			
    		}
    	
    		
    	}
    	
    	
    }
    

}
