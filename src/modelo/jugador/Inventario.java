package modelo.jugador;

import modelo.herramientas.Herramienta;
import modelo.herramientas.SinHerramienta;
import modelo.materiales.Material;
import modelo.materiales.SinMaterial;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.ArrayList;

public class Inventario {
	protected Herramienta[] herramientas;
	protected Material[][] materiales;
	static private int factorColumna = 9;
	static private int factorFila = 3;
	static private Material sinMaterial =new SinMaterial();
	static private Herramienta sinHerramienta = new SinHerramienta();
	
	public Inventario() {
        this.herramientas = new Herramienta[factorColumna];
        this.materiales = new Material[factorFila][factorColumna];
        for(int fila = 0;fila < factorFila;fila++) {
    		for(int columna = 0; columna < factorColumna;columna++) {
    			this.materiales[fila][columna] = new SinMaterial();
    		}
    	}
        for(int posicion = 0; posicion < factorColumna;posicion++) {
        	this.herramientas[posicion] = new SinHerramienta();
    	}
    }


    public void agregarHerramientaEnPosicion(Herramienta herramienta,int unaPosicion) {
    	
    	herramientas[unaPosicion] = herramienta;
    }
    
    public void agregarHerramienta(Herramienta herramienta) {
    	for(int posicion = 0; posicion < factorColumna;posicion++) {
    		if(herramientas[posicion].esEquivalente(sinHerramienta)) {
    			herramientas[posicion] = herramienta;
    		}
    			
    	}
    }

    public void agregarMaterialEnPosicion(Material material, int posFila, int posColumna) {
    	materiales[posFila][posColumna] = material;
    }
    
    public void agregarMaterial(Material material) {
    	//Material sinMaterial = new SinMaterial();
    	for(int fila = 0;fila < factorFila;fila++) {
    		for(int columna = 0; columna < factorColumna;columna++) {
    			if(sinMaterial.esEquivalante(materiales[fila][columna])) {
    				materiales[fila][columna] = material;
    				break;
    			}
    		}
    	}
    }
    
    public Material quitarMaterialDePosicion(int posicionFila, int posicionColumna) {
    	Material materialADevolver =  materiales[posicionFila][posicionColumna];
    	if(materialADevolver.esEquivalante(sinMaterial)) {
    		return null;
    	}
    	materiales[posicionFila][posicionColumna] = new SinMaterial();
    	return materialADevolver;
    }
    
    public Herramienta quitarHerramientaDePosicion(int posicion) {
    	Herramienta herramientaADevolver =  herramientas[posicion];
    	if(herramientaADevolver.esEquivalente(sinHerramienta)) {
    		return null;
    	}
    	herramientas[posicion] = new SinHerramienta();
    	return herramientaADevolver;
    }
/*
    public boolean contieneHerramienta(Herramienta herramienta) {

    }


    public boolean contieneMaterial(Material material) {

    }


    public Material seleccionarMaterial(int posicion) {

    }


    public Herramienta seleccionarHerramienta(int posicion) {

    }


    public ArrayList<Herramienta> getHerramientas(){

    }


    public ArrayList<Material> getMateriales() {
     
    }
//inventario que estaba antes	

    private ArrayList<Herramienta> herramientas;
    private ArrayList<Material> materiales;
    private int posicionHerramientaSeleccionada;


    public Inventario() {
        this.herramientas = new ArrayList<Herramienta>();
        this.materiales = new ArrayList<Material>();
        this.posicionHerramientaSeleccionada = 0;

    }


    public void agregarHerramienta(Herramienta herramienta) {
        this.herramientas.add(herramienta);
    }


    public void agregarMaterial(Material material) {
        this.materiales.add(material);
    }


    public boolean contieneHerramienta(Herramienta herramienta) {

        return this.herramientas.contains(herramienta);

    }


    public boolean contieneMaterial(Material material) {

       return materiales.contains(material);

    }


    public Material seleccionarMaterial(int posicion) {
        //No se puede acceder a un indice fuera del tamanio de materiales.
        return materiales.get(posicion);

    }


    public Herramienta seleccionarHerramienta(int posicion) {
        //No se puede acceder a un indice fuera del tamanio de herramientas.
        this.posicionHerramientaSeleccionada = posicion;
        return herramientas.get(posicion);

    }


    public ArrayList<Herramienta> getHerramientas(){

        return this.herramientas;

    }


    public ArrayList<Material> getMateriales() {
        return materiales;
    }
*/

}
