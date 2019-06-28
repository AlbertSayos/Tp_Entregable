package modelo.herramientas;

import modelo.materiales.*;

public class PicoDePiedra extends Pico{
	
	public PicoDePiedra(){
		
		this.durabilidad = 200f;
		this.fuerza = 4;
		this.factorDeDesgaste = 2f/3f;

	}
	
	public void golpear(Piedra unaPiedra) {

		unaPiedra.reducirDurabilidad(this.getFuerza());
		this.desgastarse();

	}
	
	public void golpear(Metal unMetal) {

		unMetal.reducirDurabilidad(this.getFuerza());
		this.desgastarse();

	}
	
	public void golpear(Diamante unaDiamante) {

		this.desgastarse();

	}

}
