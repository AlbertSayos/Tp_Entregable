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

public class ControladorDeInventario {

    private SelectorDeHerramientas selectorHerramientas;
    private Material[][] materiales;
    private ArrayList<Herramienta> herramientas;
    private InventarioVista inventarioVista;
    private HashMap<Character, String> materialesHash = new HashMap<>();
    private Mesa mesaCrafteo = new Mesa(9);
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
    

    /*public void actualizarVista() {
        System.out.println("Actualizando vista de controlador de inventario");
        this.inventarioVista.limpiar();
        this.mesaCrafteo = new Mesa(9);
        System.out.println("inventarioVista limpio");
        int j = -1;
        for (int i = 0; i < this.materiales.size(); i++) {
            if (i % 9 == 0) {
                j++;
            }
            inventarioVista.agregar(rutaDeMaterial(this.materiales.get(i)), i % 9, j);
            System.out.println("Se agregaron los materiales al inventario vista");
        }

        this.selectorHerramientas.limpiar();
        System.out.println("Selector de herramientas limpio");
        for (int i = 0; i < herramientas.size(); i++) {
            System.out.println("Agregando herramientas al selector");
            //System.out.println("El identificador de la herramienta es: "+herramientas.get(i).getIdentificador());
            this.selectorHerramientas.agregar(rutaDeHerramienta(herramientas.get(i)), i);
        }
        System.out.println("Saliendo de vista de controlador de inventario");
    }
    */
    private String rutaDeHerramienta(Herramienta herramienta) {
    	String ruta = " ";
    	if(herramienta.getClass() == PicoDeMadera.class) ruta = "picoDeMadera.png";
    	if(herramienta.getClass() == PicoDePiedra.class) ruta = "picoDePiedra.png";
    	if(herramienta.getClass() == PicoFino.class) ruta = "picoFino.png";
    	if(herramienta.getClass() == PicoDeMetal.class) ruta = "picoDeMetal.png";
    	if(herramienta.getClass() == HachaDeMadera.class) ruta = "HachaDeMadera.png";
    	if(herramienta.getClass() == HachaDePiedra.class) ruta = "HachaDePiedra.png";
    	if(herramienta.getClass() == HachaDeMetal.class) ruta = "HachaDeMetal.png";
    	
    	return ruta;
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

    private void inicializarHash() {
        this.materialesHash.put('m', "madera");
        this.materialesHash.put('p', "piedra");
        this.materialesHash.put('M', "metal");
        this.materialesHash.put('d', "diamante");
    }

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

    public void actualizarVistaInventario() {
    	
    	Material[][] materiales = this.juego.getJugador().obtenerInventario().materiales();
    	
    	System.out.println("entre");
    	GridPane inventario = this.inventarioVista.gridInventario();
    	
    	System.out.println(inventario.getChildren().size());
    	inventario.getChildren().clear();
    	System.out.println(inventario.getChildren().size());
    	
    	for(int fila = 0; fila < 3; fila++) {
            for(int col = 0; col < 9; col++) {
            	
            	StackPane casilla = this.inventarioVista.crearCasilla();
            	
            	casilla.getChildren().add(this.inventarioVista.getImagen(this.rutaDeMaterial(materiales[col][fila]), 38));
            	
                inventario.add(casilla,  col, fila);;
            }
        }
    	
    	/*for(int i = 0; i < materiales.size(); i++) {
        	StackPane nuevaCasilla = new StackPane();
       
        	System.out.println("waa "+inventario.getChildren().size());
        	nuevaCasilla.getChildren().addAll(this.inventarioVista.getImagen("casilla.png", 38), this.inventarioVista.getImagen(this.rutaDeMaterial(materiales.get(i)), 38));
        	inventario.addColumn(i, nuevaCasilla);
        	
    	}
    	
    	for(int fila = materiales.size(); fila < 27; fila++) {
    		if(fila > 9)
    			inventario.addColumn(fila, this.inventarioVista.crearCasilla());
    		else
        		inventario.addRow(fila, this.inventarioVista.crearCasilla());
        }
        */
    	
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
