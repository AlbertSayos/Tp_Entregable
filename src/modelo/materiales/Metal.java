package modelo.materiales;

import modelo.herramientas.*;

public class Metal extends Material {

	public Metal() {
		this.durabilidad = 50;
		this.identidad = "3";
	
	}
	

	public void recibeGolpeDe(Herramienta unaHerramienta) {
		unaHerramienta.golpear(this);
	}

	@Override
	public Character getIdentificador() {
		return 'M';
	}


}
