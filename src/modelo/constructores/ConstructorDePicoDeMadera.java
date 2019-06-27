package modelo.constructores;

import modelo.materiales.*;
import modelo.herramientas.*;
import modelo.posicion.Posicion;

public class ConstructorDePicoDeMadera extends ConstructorDeHerramientas{

	public ConstructorDePicoDeMadera(){
		int cantidadDeMateriales = 9;
		mesa = new Mesa(cantidadDeMateriales);
		mesa.agregarMaterialEnPosicion(new Madera(), 0);
		mesa.agregarMaterialEnPosicion(new Madera(), 1);
		mesa.agregarMaterialEnPosicion(new Madera(), 2);
		mesa.agregarMaterialEnPosicion(new Madera(), 4);
		mesa.agregarMaterialEnPosicion(new Madera(), 7);
	}

	@Override
	public Herramienta ConstruirHerramienta() {
		return new PicoDeMadera();
	}

}