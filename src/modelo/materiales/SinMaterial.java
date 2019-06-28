package modelo.materiales;

import modelo.herramientas.*;

public class SinMaterial extends Material{
	
	public SinMaterial() {
		this.durabilidad = 0;
		this.identidad = "0";
	}

	@Override
	public void recibeGolpeDe(Herramienta unaHerramienta) {
	}

	@Override
	public Character getIdentificador() {
		return 'v';
	}

	@Override
	public void golpear(Golpe golpe) {

	}
}