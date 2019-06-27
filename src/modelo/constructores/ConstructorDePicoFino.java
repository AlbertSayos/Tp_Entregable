package modelo.constructores;

import modelo.materiales.*;
import modelo.herramientas.*;
import modelo.posicion.Posicion;

public class ConstructorDePicoFino extends ConstructorDeHerramientas{

	public ConstructorDePicoFino(){
		int cantidadDeMateriales = 9;
		mesa = new Mesa(cantidadDeMateriales);
		mesa.agregarMaterialEnPosicion(new Metal(), 0);
		mesa.agregarMaterialEnPosicion(new Metal(), 1);
		mesa.agregarMaterialEnPosicion(new Metal(), 2);
		mesa.agregarMaterialEnPosicion(new Piedra(), 3);
		mesa.agregarMaterialEnPosicion(new Madera(), 4);
		mesa.agregarMaterialEnPosicion(new Madera(), 7);
	}

	@Override
	public Herramienta ConstruirHerramienta() {
		return new PicoFino();
	}

}