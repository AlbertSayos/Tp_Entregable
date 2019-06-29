package modelo.constructores;

import modelo.materiales.*;

import java.util.*;

import modelo.herramientas.*;

public class MesaDeCrafteo{
	
	protected Mesa mesa;
	protected java.util.List<ConstructorDeHerramientas> constructores; 
	protected int cantidad = 9;
	
	public MesaDeCrafteo(){
		mesa = new Mesa(cantidad);
		//constructores = new ConstructorDeHerramientas[cantidad];
	}
	
	public void agregarMaterialEnPosicion(Material unMaterial,int unaPosicion) {
		mesa.agregarMaterialEnPosicion(unMaterial, unaPosicion);
	}
	
	public Herramienta crearHerramienta(){
		for(ConstructorDeHerramientas constructor: ConstructorDeHerramientas.getConstructores()) {
			if(constructor.puedeConstruir(mesa)) {
				return constructor.ConstruirHerramienta();
			}
		}
		return null;
	}
	
	public Material quitarMaterialEnPosicion(int unaPosicion) {
		return mesa.quitarMaterialEnPosicion(unaPosicion);
	}
	
	public List<Material> quitarTodosLosMateriales(){
		List<Material> materiales = new ArrayList<Material>();
		for(int unaPosicion = 0; unaPosicion < cantidad;unaPosicion++) {
			Material unMaterial = this.quitarMaterialEnPosicion(unaPosicion);
			Material otroMaterial = new SinMaterial();
			if(!(unMaterial.esEquivalante(otroMaterial)) ) {
				materiales.add(unMaterial);
			}
		}
		return materiales;
	}
	
	public Material[] getMaterialesEnMesa() {
		return this.mesa.getMateriales();
	}
}