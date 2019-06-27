package modelo.herramientas;


import modelo.materiales.Material;

public class HachaDeMetal extends Hacha  {
	
	public HachaDeMetal() {
		this.durabilidad = 400f;
		this.fuerza = 10;
		this.factorDeDesgaste = 0.5f;
	}


	@Override
	public String getRutaImagen() {
		return "hachaDeMetal.png";
	}

	@Override
	public void desgastar(int danio) {

	}

	@Override
	public void usarContra(Material materialARecolectar) {

	}


}