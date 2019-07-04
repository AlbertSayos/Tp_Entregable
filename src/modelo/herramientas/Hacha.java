package modelo.herramientas;

import modelo.materiales.*;

public abstract class Hacha extends Herramienta{

	
	
	@Override
	public void desgastarse() {

		durabilidad -= fuerza*factorDeDesgaste;

	}


	public void golpear(Madera unaMadera) {

		unaMadera.reducirDurabilidad(this.getFuerza());
		this.desgastarse();

	}
	
	public void golpear(Piedra unaPiedra) {

		this.desgastarse();

	}
	
	public void golpear(Metal unaMaetal) {

		this.desgastarse();

	}
	
	public void golpear(Diamante unaDiamante){

		this.desgastarse();

	}
	
}
