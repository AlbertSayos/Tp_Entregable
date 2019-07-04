package modelo.materiales;

import modelo.excepciones.MaterialRotoException;
import modelo.herramientas.*;
import modelo.jugador.Objeto;
import modelo.posicion.*;


public abstract class Material implements Objeto {

	//Atributos:
	protected String identidad;
	protected int durabilidad;
	protected Posicion posicion;
	public String imagen;


	//Metodos:
	public abstract void recibeGolpeDe(Herramienta unaHerramienta);

	public boolean esEquivalante(Material otroMaterial) {
		return this.getIdentidad() == otroMaterial.getIdentidad();
	}

	public int getDurabilidad(){
		return durabilidad;
	}

	public void reducirDurabilidad(int fuerza){ 
		this.durabilidad -=fuerza; 
	}

	public String getIdentidad() {
		return identidad;
	}

	public Posicion getPosicion(){ return this.posicion; }

	public String getRutaImagen(){ return this.imagen; }

    public abstract Character getIdentificador();

    public boolean estaDestruido() {
    	return (durabilidad <=0);
    }
    
}
