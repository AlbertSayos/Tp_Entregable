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
	static private int factorColumna = 3;
	static private int factorFila = 9;
	static private Material sinMaterial =new SinMaterial();
	static private Herramienta sinHerramienta = new SinHerramienta();


	public Inventario() {

        this.herramientas = new Herramienta[factorFila];
        this.materiales = new Material[factorFila][factorColumna];

        for(int fila = 0;fila < factorFila;fila++) {
    		for(int columna = 0; columna < factorColumna;columna++) {

    			this.materiales[fila][columna] = new SinMaterial();
    		}
    	}
        for(int posicion = 0; posicion < factorFila;posicion++) {

        	this.herramientas[posicion] = new SinHerramienta();

    	}
    }


    public void agregarHerramientaEnPosicion(Herramienta herramienta,int unaPosicion) {
    	
    	herramientas[unaPosicion] = herramienta;
    }

    
    public void agregarHerramienta(Herramienta herramienta) {

    	for(int posicion = 0; posicion < factorFila;posicion++) {

    			herramientas[posicion] = herramienta;
    			break;
    			
    	}
    }


    public void agregarMaterialEnPosicion(Material material, int posFila, int posColumna) {
    	materiales[posFila][posColumna] = material;

    }

    
    public void agregarMaterial(Material material) {
    	//Material sinMaterial = new SinMaterial();
    	outerloop:
    	for(int columna = 0; columna < factorColumna;columna++) {
    		for(int fila = 0;fila < factorFila;fila++) {	
    			if(sinMaterial.esEquivalante(materiales[fila][columna])) {
    				materiales[fila][columna] = material;
    				break outerloop;
    			}
    		}
    	}
    }

    
    public Material quitarMaterialDePosicion(int posicionFila, int posicionColumna) {
    	Material materialADevolver =  materiales[posicionFila][posicionColumna];
    	if(materialADevolver.esEquivalante(sinMaterial)) {
    		//return null;
    		return new SinMaterial();
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
    
    public Material[][] materiales() {

    	return this.materiales;

    }
    
    public Herramienta[] getHerramientas() {

		return this.herramientas;

    }
    
    public Herramienta obtenerHerramientaEnPosicion(int pos) {

		return herramientas[pos];

    }


}
