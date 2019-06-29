package controlador;


import modelo.constructores.Mesa;
import modelo.juego.*;
import modelo.herramientas.*;
import modelo.materiales.*;
import vista.InventarioVista;
import vista.SelectorDeHerramientas;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.scene.layout.*;
import javafx.scene.*;
import vista.*;

public class ControladorDeInventario {

    private InventarioVista inventarioVista;
    private Juego juego;

    public ControladorDeInventario(Juego juego, InventarioVista inventarioVista) {
    	
        System.out.println("Iniciando constructor de Controlador de inventario");
        this.juego = juego;        
        this.inventarioVista = inventarioVista;
        //inicializarHash();
        
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
    	
    	System.out.println("entre");
    	GridPane inventario = this.inventarioVista.gridInventario();

    	inventario.getChildren().clear();
     	
    	for(int fila = 0; fila < 3; fila++) {
            for(int col = 0; col < 9; col++) {
            	
            	StackPane casilla = new Casilla();
            	System.out.println(this.rutaDeMaterial(materiales[col][fila]));
            	casilla.getChildren().add(this.inventarioVista.getImagen(this.rutaDeMaterial(materiales[col][fila]), 38));         	
                inventario.add(casilla,  col, fila);;
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
    			System.out.println(this.rutaDeMaterial(materiales[col+fila]));
    			
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
    
    public void quitarMaterialesDeLaMesa() {
    	juego.agregarTodosLosMaterialesDeLaMesaAlinventario();
    }
    
    /*public void colocarNodoSobreMesaCrafteo(Node nodoDeMesaCrafteo) {
    	if(this.inventarioVista.nodoSeleccionado() != null) {
    		this.inventarioVista.agregarNodoAMesaCraft(nodoDeMesaCrafteo, this.inventarioVista.nodoSeleccionado());
    		System.out.println("Nodo cambiado");
    	}
    }
    */
   
    
    /*
    public void agregarAMesaCrafteo(char identificador, int pos){
        Material[] materiales = new Material[4];
        materiales[0] = new Madera();
        materiales[1] = new Metal();
        materiales[2] = new Piedra();
        materiales[3] = new Diamante();
        Material material = null;
        int index = 0;
        while (material == null || index < 4){
            if (identificador == materiales[index].getIdentificador()){
                material = materiales[index];
            }
            index++;
        }
        mesaCrafteo.agregarMaterialEnPosicion(material,pos);
    }
    */
}
