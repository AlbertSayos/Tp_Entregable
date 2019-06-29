package controlador;


import modelo.constructores.Mesa;
import modelo.juego.*;
import modelo.herramientas.*;
import modelo.jugador.Inventario;
import modelo.materiales.*;
import vista.InventarioVista;
import vista.SelectorDeHerramientas;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.scene.layout.*;
import javafx.scene.*;
import vista.*;

public class ControladorDeInventario {

    private SelectorDeHerramientas selectorHerramientas;
    private ArrayList<Herramienta> herramientas;
    private InventarioVista inventarioVista;
    private HashMap<Character, String> materialesHash = new HashMap<>();
    private Juego juego;

    public ControladorDeInventario(Juego juego, InventarioVista inventarioVista) {
    	
        System.out.println("Iniciando constructor de Controlador de inventario");
        this.juego = juego;        
        //this.materiales = inventario.getMateriales();
        //this.herramientas = inventario.getHerramientas();
        this.selectorHerramientas = selectorHerramientas;
        this.inventarioVista = inventarioVista;
        //inicializarHash();
        
        inventarioVista.setControlador(this);
    }
    

    private String rutaDeHerramienta(Herramienta herramienta) {

    	return herramienta.getClass().getSimpleName()+".png";
    }
    
    private String rutaDeMaterial(Material material) {
    	String ruta = " ";
    	if(material.getClass() == Madera.class) ruta = "madera.png";
    	if(material.getClass() == Metal.class) ruta = "metal.png";
    	if(material.getClass() == Piedra.class) ruta = "piedra.png";
    	if(material.getClass() == Diamante.class) ruta = "diamante.png";
    	if(material.getClass() == SinMaterial.class) ruta = "vacio.png";
    	
    	return ruta;
    }

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

    public void actualizarVistaInventario() {
    	
    	Material[][] materiales = this.juego.getJugador().obtenerInventario().materiales();
    	
    	System.out.println("entre");
    	GridPane inventario = this.inventarioVista.gridInventario();

    	inventario.getChildren().clear();
     	
    	for(int fila = 0; fila < 3; fila++) {
            for(int col = 0; col < 9; col++) {
            	
            	StackPane casilla = new Casilla();
            	
            	casilla.getChildren().add(this.inventarioVista.getImagen(this.rutaDeMaterial(materiales[col][fila]), 38));         	
                inventario.add(casilla,  col, fila);;
            }
        }
    	
    }
    
    public void moverMaterialAMesaCrafteo() {
    	
    	
    }
    
    public void colocarNodoSobreMesaCrafteo(Node nodoDeMesaCrafteo) {
    	if(this.inventarioVista.nodoSeleccionado() != null) {
    		this.inventarioVista.agregarNodoAMesaCraft(nodoDeMesaCrafteo, this.inventarioVista.nodoSeleccionado());
    		System.out.println("Nodo cambiado");
    	}
    }
    
    public Herramienta crearHerramienta() {
        //return mesaCrafteo.construir();
    	return null;
    }
}
