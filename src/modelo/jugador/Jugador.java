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
	private int herramientaActualPosicion;
	private Inventario inventario;
	public boolean estaPosicionado;
	public Herramienta herramientaSeleccionada;
	public Material materialSeleccionado;


	public Jugador(){

		this.herramientaEquipada = new HachaDeMadera();
		this.herramientaActualPosicion = 0;
		this.inventario = new Inventario();
		this.posicionActual = new Posicion(0,0);
		this.inventario.agregarHerramienta(new HachaDeMadera());
		this.estaPosicionado = false;
		this.herramientaSeleccionada = new HachaDeMadera();

	}

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
		if (this.herramientaEquipada == null) {
			throw new JugarSinHerramientaEquipadaException();
		}
		
		this.herramientaEquipada.usar(material);
		if(material.estaDestruido())
			this.inventario.agregarMaterial(material);
			
		if(this.herramientaEquipada.estaRota()) {
			this.herramientaEquipada = null;
			this.quitarHerramientaActualDelInventario();
			throw new JugarSinHerramientaEquipadaException();
		}
	}


	public void equipar(Herramienta herramienta) {

		if (this.herramientaEquipada != null) {
			this.inventario.agregarHerramienta(this.herramientaEquipada);
		}

		this.herramientaEquipada = herramienta;
	}
	
	
	public void equiparHerramientaEnPosicion(int pos) {
		this.herramientaActualPosicion = pos;
		this.herramientaEquipada = this.inventario.obtenerHerramientaEnPosicion(pos);
	}


	public int getPosicionColumna() {

		return this.posicionActual.x;

	}


	public int getPosicionFila() {

		return this.posicionActual.y;

	}


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


	public Herramienta quitarHerramientaActualDelInventario() {

		return this.inventario.quitarHerramientaDePosicion(this.herramientaActualPosicion);

	}

	
	public boolean puedeGolpear(Posicion posicion){

        Posicion derecha, izquierda, arriba, abajo;
        derecha = miDerecha();
        izquierda = miIzquierda();
        arriba = miArriba();
        abajo = miAbajo();

        return posicion.equals(derecha) || posicion.equals(izquierda) || posicion.equals(arriba) || posicion.equals(abajo); 

    }

	
	public Herramienta[] getHerramientas() {

		return this.inventario.getHerramientas();

	}


}


