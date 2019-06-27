package modelo.materiales;

import javafx.scene.image.Image;
import modelo.herramientas.Golpe;
import modelo.herramientas.Hacha;
import modelo.herramientas.Herramienta;
import modelo.herramientas.Pico;

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

	@Override
	public void golpear(Golpe golpe) {

	}
}
