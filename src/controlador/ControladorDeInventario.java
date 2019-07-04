package controlador;


import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import modelo.juego.*;
import modelo.herramientas.*;
import modelo.materiales.*;
import vista.InventarioVista;
import vista.*;

public class ControladorDeInventario {

    private InventarioVista inventarioVista;
    private Juego juego;

    public ControladorDeInventario(Juego juego, InventarioVista inventarioVista) {
    	
        this.juego = juego;
        this.inventarioVista = inventarioVista;
        inventarioVista.setControlador(this);

    }
    

    private String rutaDeHerramienta(Herramienta herramienta) {

    	return herramienta.getClass().getSimpleName()+".png";

    }
    
    private String rutaDeMaterial(Material material) {

    	return material.getClass().getSimpleName()+".png";

    }



    public void actualizarVistaInventario() {
    	
    	Material[][] materiales = this.juego.getJugador().obtenerInventario().materiales();
    	GridPane inventario = this.inventarioVista.gridInventario();
    	inventario.getChildren().clear();
     	
    	for(int fila = 0; fila < 3; fila++) {
            for(int col = 0; col < 9; col++) {
            	
            	StackPane casilla = new Casilla();
            	casilla.getChildren().add(this.inventarioVista.getImagen(this.rutaDeMaterial(materiales[col][fila]), 38));
                inventario.add(casilla,  col, fila);
            }
        }
    	
    }
    
    public void moverMaterialAMesaCrafteo(int filaDeInventario, int columnaDeInventario, int posicionDeMesa) {

    	juego.agregarMaterialDeJugadorALaMesaDeCrafteo(filaDeInventario, columnaDeInventario, posicionDeMesa);
    	actualizarMesaCrafteo();
    	
    }


    public void actualizarMesaCrafteo() {

    	Material[] materiales = this.juego.getMaterialesDeMesa();
    	int indice = 0;
    	this.inventarioVista.gridMesaCraft().getChildren().clear();

    	for(int fila = 0; fila < 3; fila++) {
    		for(int col= 0; col < 3; col++) {
    			StackPane casilla = new Casilla();
    			casilla.getChildren().add(this.inventarioVista.getImagen(this.rutaDeMaterial(materiales[indice]), 38));         	
    			this.inventarioVista.gridMesaCraft().add(casilla, col, fila); 
    			indice++;
    		}
    	}
    	
    }
    
    public void actualizarCasilleroRes(Casilla casillaResultado) {

    	casillaResultado.getChildren().clear();
    	casillaResultado.getChildren().add(new Casilla(70));

    }


    public void crearHerramienta(Casilla casillaResultado) {

    	Herramienta herramientaNueva = juego.crearHerramienta();
    	casillaResultado.getChildren().add(this.inventarioVista.getImagen(rutaDeHerramienta(herramientaNueva), 48));
    	actualizarMesaCrafteo();

    }

    
    public void quitarMaterialesDeLaMesa(){

    	juego.agregarTodosLosMaterialesDeLaMesaAlinventario();

    }

}
