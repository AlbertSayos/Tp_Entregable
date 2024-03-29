package modelo.constructores;

import modelo.materiales.*;

public class Mesa {

	
	protected Material[] mesa;
	private int cantidad;


	public Mesa(int unaCantidad) {

		cantidad = unaCantidad;
		mesa = new Material[cantidad];
		for(int i = 0; i < cantidad;i++) {
			mesa[i] = new SinMaterial();
		}

	}


	public Material agregarMaterialEnPosicion(Material unMaterial,int unaPosicion) {

		if(mesa[unaPosicion].getClass() == SinMaterial.class) {
			mesa[unaPosicion] = unMaterial;
			return new SinMaterial();
		}

		return unMaterial;
	}


	public boolean esEquivalente(Mesa otraMesa) {

		for(int i = 0; i  < cantidad; i++) {
			if(!(this.mesa[i].esEquivalante(otraMesa.mesa[i]))) {
				return false;
			}
		}
		return true;
	}


	public Material quitarMaterialEnPosicion(int unaPosicion) {

		Material materialADevolver = mesa[unaPosicion];
		mesa[unaPosicion] = new SinMaterial();
		return materialADevolver;
	}


	public Material[] getMateriales() {

		return this.mesa;

	}
	
}
