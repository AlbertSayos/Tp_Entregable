package modelo.materiales;

import modelo.excepciones.MaterialRotoException;
import modelo.herramientas.*;

public class Madera extends Material{
	
	public Madera(){
		this.durabilidad = 10;
		this.identidad = "1";
		//this.imagen = "Madera.png";
	}

	
	public void recibeGolpeDe(Herramienta unaHerramienta) {

		unaHerramienta.golpear(this);
		
	}

	public String getIdentidad(){

		return this.identidad;

	}

	@Override
	public Character getIdentificador() {
		return 'm';
	}



}
