package modelo.materiales;

import modelo.herramientas.*;

public class Diamante extends Material{
	
	public Diamante(){

		durabilidad = 100;
		identidad = "4";
		

	}


	public void recibeGolpeDe(Herramienta unaHerramienta) {

		unaHerramienta.golpear(this);
		

	}

	@Override
	public Character getIdentificador() {
		return 'd';
	}




}
