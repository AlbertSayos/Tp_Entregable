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
	public Mapa mapa;
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


	public String getImagen() {

		return this.imagen;

	}


    public Posicion moverArriba() {

    	this.posicionActual = posicionActual.getPosicionArriba();
    	return this.posicionActual;

    }


	public Posicion miDerecha() {


		//this.posicionActual = posicionActual.getPosicionDerecha();
		return this.posicionActual.getPosicionDerecha();

	}


	public Posicion miIzquierda() {

		return this.posicionActual.getPosicionIzquierda();
	}


	public Posicion moverAbajo() {

		this.posicionActual = posicionActual.getPosicionAbajo();
		return this.posicionActual;

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
			if(this.herramientaEquipada.estaRota()) {
				this.herramientaEquipada = null;
			}
			throw ex;
		}
	}


	public void equipar(Herramienta herramienta) {

		if (this.herramientaEquipada != null) {
			this.inventario.agregarHerramienta(this.herramientaEquipada);
		}

		this.herramientaEquipada = herramienta;
	}

    public Inventario getInventario() {

		return this.inventario;

    }

	public Jugador(){

		this.herramientaEquipada = new HachaDeMadera();
		this.mesaDeCrafteo = new Mesa(9);
		this.inventario = new Inventario();
		this.posicionActual = new Posicion(0,0);
		this.inventario.agregarHerramienta(new HachaDeMadera());
		this.estaPosicionado = false;
		this.herramientaSeleccionada = new HachaDeMadera();
		this.imagen = "jugador.png";

	}


	public boolean inventarioContieneHerramienta(Herramienta herramienta) {

		return this.inventario.contieneHerramienta(herramienta);

	}


	public boolean inventarioContieneMaterial(Material material) {

		return this.inventario.contieneMaterial(material);
	}



	public int getPosicionColumna() {

		return this.posicionActual.x;

	}


	public int getPosicionFila() {

		return this.posicionActual.y;

	}


	public void seleccionarMaterial(int posicion) {

		this.materialSeleccionado = this.inventario.seleccionarMaterial(posicion);

	}


	public void seleccionarHerramienta(int posicion) {

		this.herramientaSeleccionada = this.inventario.seleccionarHerramienta(posicion);

	}


	public void agregarMaterialAInventario(Material material) {

		this.inventario.agregarMaterial(material);
	}


	public void agregarHerramientaAInventario(Herramienta herramienta) {

		this.inventario.agregarHerramienta(herramienta);

	}


	public boolean puedeGolpear(Posicion posicion){

        Posicion derecha, izquierda;

        derecha = miDerecha();
        izquierda = miIzquierda();

        return posicion.equals(derecha) || posicion.equals(izquierda); 

    }


}


