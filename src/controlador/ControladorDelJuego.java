package controlador;

import javafx.scene.layout.*;
import javafx.scene.*;
import javafx.scene.input.MouseEvent;
import modelo.juego.Juego;
import modelo.posicion.Posicion;
import vista.JuegoVista;
import modelo.materiales.*;


public class ControladorDelJuego {

    private Juego juego;
    private JuegoVista juegoVista;
    private ControladorDeInventario controladorDeInventario;


    public ControladorDelJuego(JuegoVista juegoVista, Juego  juego, ControladorDeInventario controladorDeInventario) {

        this.controladorDeInventario = controladorDeInventario;
        this.juego = juego;
        this.juegoVista = juegoVista;
        juegoVista.setControlador(this);

    }
    
    public void actualizarInventario() {
    	this.controladorDeInventario.actualizarVista();
    }


    public void actualizarVista() {
    	Posicion posJugador = juego.getJugador().miPosicion();

        for(int row = 0; row < juego.getMapa().getFilas() ; row++)
        {
            for(int col = 0; col < juego.getMapa().getColumnas(); col++)
            {
                Posicion posicion = new Posicion(row,col);
                Material objeto = juego.getMapa().obtenerObjeto(posicion);
                
                String nombreImagen = "vacio.png";
                if(objeto.getClass() == Madera.class)
                	nombreImagen = "madera.png";
                if(objeto.getClass() == Diamante.class)
                	nombreImagen = "diamante.png";
                if(objeto.getClass() == Metal.class)
                	nombreImagen = "metal.png";
                if(objeto.getClass() == Piedra.class)
                	nombreImagen = "piedra.png";
                
                if(!posJugador.equals(posicion)) juegoVista.agregarElemento(nombreImagen, col, row);
            }
        }
        
        juegoVista.agregarElemento("jugador.png", juego.getJugador().getPosicionFila(), juego.getJugador().getPosicionColumna());
        
    }


    public void moverArriba(GridPane mapa){
    	
    	eliminarPosicionDeLavista(mapa);
    	this.juego.getMovimientos().moverJugadorArriba(this.juego.mapa);
    	this.eliminarPosicionDeLavista(mapa);
	    this.juegoVista.agregarElemento("jugador.png", this.juego.getJugador().getPosicionFila(), this.juego.getJugador().getPosicionColumna());	

   
    }


    public void moverAbajo(GridPane mapa){
    	
    	eliminarPosicionDeLavista(mapa);    	
    	this.juego.getMovimientos().moverJugadorAbajo(this.juego.mapa) ;
    	this.eliminarPosicionDeLavista(mapa);
	    this.juegoVista.agregarElemento("jugador.png", this.juego.getJugador().getPosicionFila(), this.juego.getJugador().getPosicionColumna());	


    }


    public void moverDerecha(GridPane mapa){
    	
    	eliminarPosicionDeLavista(mapa);
    	this.juego.getMovimientos().moverJugadorDerecha(this.juego.mapa);
    	this.eliminarPosicionDeLavista(mapa);
    	this.juegoVista.agregarElemento("jugador.png", this.juego.getJugador().getPosicionFila(), this.juego.getJugador().getPosicionColumna());	
    	
    	    
    }
    

    public void moverIzquierda(GridPane mapa){
    	
    	eliminarPosicionDeLavista(mapa);	    
    	this.juego.getMovimientos().moverJugadorIzquierda(this.juego.mapa);
    	this.eliminarPosicionDeLavista(mapa);
    	this.juegoVista.agregarElemento("jugador.png", this.juego.getJugador().getPosicionFila(), this.juego.getJugador().getPosicionColumna());	

    	
    }
    
    private void eliminarPosicionDeLavista(GridPane mapa) {
   		
	    Node jugadorNode =  getNodeFromGridPane(mapa,  this.juego.getJugador().getPosicionColumna(), this.juego.getJugador().getPosicionFila());    	
	    mapa.getChildren().remove(jugadorNode);
	    
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
    		//System.out.println(this.juego.jugador.getHerramientaEquipada().getDurabilidad());
    		if(!this.juego.jugadorGolpeaEnPosicion(colIndex, rowIndex)){
    			mapa.getChildren().remove(nodoClickeado);    			
    			this.actualizarInventario();
    		}
    	
    		
    		
    	}
    	
    	
    }
    

}
