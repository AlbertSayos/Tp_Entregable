package modelo.herramientas;

import modelo.materiales.*;

public class PicoFino extends Pico{


	public PicoFino(){
		
		this.durabilidad = 1000;
		this.fuerza = 20;
		this.factorDeDesgaste = 0.1f;
		
	}
	

	@Override
	public void desgastarse() {
		durabilidad -= durabilidad*factorDeDesgaste;
		//if(durabilidad <0) durabilidad = 0; // ENTONCES SE ROMPE LA HERRAMIENTA
											// FALTA IMPLEMENTAR ESO
	}



	public void golpear(Madera unaMadera) { }

	public void golpear(Piedra unaPiedra) {
		unaPiedra.reducirDurabilidad(fuerza);
	}
	
	public void golpear(Metal unMetal) { }

	public void golpear(Diamante unDiamante) {

		unDiamante.reducirDurabilidad(this.getFuerza());
		this.desgastarse();

	}
}
