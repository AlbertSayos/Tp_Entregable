package modelo.herramientas;

import modelo.materiales.Material;

public class HachaDePiedra extends Hacha {
	
	public HachaDePiedra() {
		this.durabilidad = 200.0f;
		this.fuerza = 5;
		this.factorDeDesgaste = 1;
	}

	@Override
	public String getRutaImagen() {
		return "hachaDePiedra.png";
	}

	@Override
	public void desgastar(int danio) {

	}

	@Override
	public void usarContra(Material materialARecolectar) {

	}

}
