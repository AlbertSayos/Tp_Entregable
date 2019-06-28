package controlador;


import modelo.constructores.Mesa;
import modelo.herramientas.*;
import modelo.jugador.Inventario;
import modelo.materiales.*;
import vista.InventarioVista;
import vista.SelectorDeHerramientas;
import java.util.ArrayList;
import java.util.HashMap;


public class ControladorDeInventario {

    private SelectorDeHerramientas selectorHerramientas;
    private ArrayList<Material> materiales;
    private ArrayList<Herramienta> herramientas;
    private InventarioVista inventarioVista;
    private HashMap<Character, String> materialesHash = new HashMap<>();
    private Mesa mesaCrafteo = new Mesa(9);

    public ControladorDeInventario(Inventario inventario, InventarioVista inventarioVista, SelectorDeHerramientas selectorHerramientas) {
        System.out.println("Iniciando constructor de Controlador de inventario");
        this.materiales = inventario.getMateriales();
        this.herramientas = inventario.getHerramientas();
        this.selectorHerramientas = selectorHerramientas;
        this.inventarioVista = inventarioVista;
        inicializarHash();
        inventarioVista.setControlador(this);
    }

    public void actualizarVista() {
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

    public Herramienta crearHerramienta() {
        //return mesaCrafteo.construir();
    	return null;
    }
}
