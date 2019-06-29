package modelo.jugador;
import modelo.constructores.Mesa;
import modelo.excepciones.*;
import modelo.materiales.*;
import modelo.herramientas.*;
import modelo.posicion.*;
import modelo.mapas.*;

public class Jugador {
	
	public Herramienta herramientaEquipada;
	public String imagen;
	public Posicion posicionActual;
	private Mesa mesaDeCrafteo;
	private Inventario inventario;
	public boolean estaPosicionado;
	public Herramienta herramientaSeleccionada;
	//public Mapa mapa;
	public Material materialSeleccionado;



	public Herramienta getHerramientaEquipada() {
		return herramientaEquipada;
	}


	public void moverAUnaPosicion(Posicion nuevaPosicion) {

		this.posicionActual = nuevaPosicion;
		
	}


	public Posicion miPosicion() {

		return posicionActual;
	}

    public Posicion miArriba() {

    	return this.posicionActual.getPosicionArriba();

    }


	public Posicion miDerecha() {
		return this.posicionActual.getPosicionDerecha();

	}


	public Posicion miIzquierda() {

		return this.posicionActual.getPosicionIzquierda();
	}


	public Posicion miAbajo() {

		return this.posicionActual.getPosicionAbajo();
		

	}


	public void setHerramientaEquipada(Herramienta nuevaHerramienta){

		this.herramientaEquipada = nuevaHerramienta;

	}


    public Inventario obtenerInventario() {

		return this.inventario;
    }


	public void golpearMaterial(Material material, Posicion unaPosicion) {

		if(!puedeGolpear(unaPosicion)) throw new GolpeFueraDeRangoException();
		try {
			if (this.herramientaEquipada == null) {
				throw new JugarSinHerramientaEquipadaException();
			}
			this.herramientaEquipada.usar(material);
		} catch (MaterialRotoException ex) {
			this.inventario.agregarMaterial(material);
			
			throw ex;
		}
		if(this.herramientaEquipada.estaRota()) {
			this.herramientaEquipada = null;
			throw new JugarSinHerramientaEquipadaException();
		}
	}


	public void equipar(Herramienta herramienta) {

		if (this.herramientaEquipada != null) {
			this.inventario.agregarHerramienta(this.herramientaEquipada);
		}

		this.herramientaEquipada = herramienta;
	}
/*
    public Inventario getInventario() {

		return this.inventario;

    }
*/
	public Jugador(){

		this.herramientaEquipada = new HachaDeMadera();
		this.mesaDeCrafteo = new Mesa(9);
		this.inventario = new Inventario();
		this.posicionActual = new Posicion(0,0);
		this.inventario.agregarHerramienta(new HachaDeMadera());
		this.estaPosicionado = false;
		this.herramientaSeleccionada = new HachaDeMadera();

	}

/*
	public boolean inventarioContieneHerramienta(Herramienta herramienta) {

		return this.inventario.contieneHerramienta(herramienta);

	}


	public boolean inventarioContieneMaterial(Material material) {

		return this.inventario.contieneMaterial(material);
	}
*/


	public int getPosicionColumna() {

		return this.posicionActual.x;

	}


	public int getPosicionFila() {

		return this.posicionActual.y;

	}

/*
	public void seleccionarMaterial(int posicion) {

		this.materialSeleccionado = this.inventario.seleccionarMaterial(posicion);

	}


	public void cambiarHerramienta(int posicion) {

		this.herramientaEquipada = this.inventario.seleccionarHerramienta(posicion);

	}*/


	public void agregarMaterialAInventarioEnPosicion(Material material,int fila, int columna) {

		this.inventario.agregarMaterialEnPosicion(material,fila,columna);
	}


	public void agregarHerramientaAInventarioEnPosicion(Herramienta herramienta,int posicion) {

		this.inventario.agregarHerramientaEnPosicion(herramienta,posicion);

	}
	
	public void agregarMaterialAlInventario(Material material) {
		this.inventario.agregarMaterial(material);
	}
	
	public void agregarHerramientaAlInventario(Herramienta herramienta) {
		this.inventario.agregarHerramienta(herramienta);
	}
	
	public Material quitarMaterialDelInventario(int posicionFila ,int posicionColumna) {
		return this.inventario.quitarMaterialDePosicion(posicionFila, posicionColumna);
	}
	
	public Herramienta quitarHerramientaDelInventario(int posicion) {
		return this.inventario.quitarHerramientaDePosicion(posicion);
	}

	public boolean puedeGolpear(Posicion posicion){

        Posicion derecha, izquierda, arriba, abajo;

        derecha = miDerecha();
        izquierda = miIzquierda();
        arriba = miArriba();
        abajo = miAbajo();

        return posicion.equals(derecha) || posicion.equals(izquierda) || posicion.equals(arriba) || posicion.equals(abajo); 

    }


}


