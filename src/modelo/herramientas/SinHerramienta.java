package modelo.herramientas;

import modelo.materiales.*;

public class SinHerramienta extends Herramienta{

	public SinHerramienta(){
		
		this.durabilidad = 0;
		this.fuerza = 0;
		this.factorDeDesgaste = 0f;
		this.identidad = "sinHerramienta";
		
	}
	
	@Override
	public void desgastarse() {				
	}

	@Override
	public void golpear(Madera unaMadera) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void golpear(Piedra unaPiedra) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void golpear(Metal unaMaetal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void golpear(Diamante unaDiamante) {
		// TODO Auto-generated method stub
		
	}
}