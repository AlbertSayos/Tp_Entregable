package modelo.juego;

import modelo.jugador.*;

import java.util.List;

import modelo.constructores.MesaDeCrafteo;
import modelo.excepciones.*;
import modelo.mapas.Mapa;
import modelo.materiales.*;
import modelo.posicion.Posicion;



public class Juego {
	

    public Mapa mapa;
    public Jugador jugador;
    public MovimientosJugador movs;
    protected MesaDeCrafteo mesaDeCrafteo;
    public Juego(){

        iniciar();

    }

    public MovimientosJugador getMovimientos(){ return this.movs;}
    public Jugador getJugador(){return this.jugador;}

    public void iniciar(){

        this.mapa = new Mapa();
        this.jugador = this.cargarJugador();
        this.mesaDeCrafteo = new MesaDeCrafteo();
        cargarTerreno();

    }


    public Jugador cargarJugador(){

        Jugador jugador = new Jugador();
        this.mapa.posicionarJugador(jugador);
        
        this.movs = new MovimientosJugador(jugador);
        		
        return jugador;
       
    }


    public void cargarTerreno(){

        cargarMadera();
        cargarPiedra();
        cargarMetal();
        cargarDiamante();

    }


    public void cargarMadera(){

        for(int i = 0; i <= 11; i++){
            Madera madera = new Madera();
            Posicion posicion = this.mapa.posicionarMaterial(madera);
        }

    }


    public void cargarPiedra(){

        for(int i = 0; i <= 5; i++){
            Piedra piedra = new Piedra();
            Posicion posicion = this.mapa.posicionarMaterial(piedra);
        }

    }


    public void cargarMetal(){

        for(int i = 0; i <= 4; i++){

            Metal metal = new Metal();
            Posicion posicion = this.mapa.posicionarMaterial(metal);

        }

    }


    public void cargarDiamante(){

        Diamante diamante = new Diamante();
        Posicion pos1 = this.mapa.posicionarMaterial(diamante);
        Diamante diamante1 = new Diamante();
        Posicion pos2 = this.mapa.posicionarMaterial(diamante1);


    }




    public Mapa getMapa(){

        return this.mapa;

    }
    
    public boolean jugadorGolpeaEnPosicion(int x, int y) {
    	Posicion posicion = new Posicion(x,y);
    	
    	Material materialObtenido = this.mapa.obtenerObjeto(posicion);
    	if(materialObtenido == null) return true;
    	
    	try{
    		this.jugador.golpearMaterial(materialObtenido, posicion);
    	}
    	catch(JugarSinHerramientaEquipadaException ex) {
    		System.out.println("herramienta rota");
    		return true;
    	}
    	catch (GolpeFueraDeRangoException ex) {
    		System.out.println("Fuerea de rango");
    		return true;
    	}
    	catch(MaterialRotoException ex) {
    		this.mapa.removerMaterialDelMapa(posicion);
    		System.out.println("mateiral roto");
    		return false;
    	}
    	
    	return true;
    }

    public void agregarMaterialDeJugadorALaMesaDeCrafteo(int filaDeInventario, int columnaDeInventario, int posicionDeMesa) {
    	Material unMaterial = this.jugador.quitarMaterialDelInventario(filaDeInventario, columnaDeInventario);
    	mesaDeCrafteo.agregarMaterialEnPosicion(unMaterial, posicionDeMesa);
    }
    
    public void agregarMaterialDeLaMesaDeCrafteoAlJugador(int filaDeInventario, int columnaDeInventario, int posicionDeMesa) {
    	Material unMaterial = this.mesaDeCrafteo.quitarMaterialEnPosicion(posicionDeMesa);
    	this.jugador.agregarMaterialAInventarioEnPosicion(unMaterial, filaDeInventario, columnaDeInventario);
    	
    }
    
    public void agregarTodosLosMaterialesDeLaMesaAlinventario() {
    	List<Material> materiales = this.mesaDeCrafteo.quitarTodosLosMateriales();
    	for(int posicion = 0; posicion < materiales.size();posicion++) {
    		this.jugador.agregarMaterialAlInventario(materiales.get(posicion));
    	}
    }
}