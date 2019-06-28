package modelo.materiales;

import modelo.herramientas.Golpe;
import modelo.excepciones.MaterialRotoException;
import modelo.herramientas.*;

public class Diamante extends Material{
	
	public Diamante(){

		durabilidad = 100;
		identidad = "4";
		

	}


	public void recibeGolpeDe(Herramienta unaHerramienta) {

		unaHerramienta.golpear(this);
		if(this.estaDestruido()) throw new MaterialRotoException();

	}

	@Override
	public Character getIdentificador() {
		return 'd';
	}

	@Override
	public void golpear(Golpe golpe) {

	}

}
