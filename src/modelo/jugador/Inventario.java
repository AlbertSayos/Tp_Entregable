package modelo.jugador;

import modelo.herramientas.Herramienta;
import modelo.materiales.Material;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.ArrayList;

public class Inventario {

    private ArrayList<Herramienta> herramientas;
    private ArrayList<Material> materiales;
    private int posicionHerramientaSeleccionada;


    public Inventario() {
        this.herramientas = new ArrayList<Herramienta>();
        this.materiales = new ArrayList<Material>();
        this.posicionHerramientaSeleccionada = 0;

    }


    public void agregarHerramienta(Herramienta herramienta) {
        this.herramientas.add(herramienta);
    }


    public void agregarMaterial(Material material) {
        this.materiales.add(material);
    }


    public boolean contieneHerramienta(Herramienta herramienta) {

        return this.herramientas.contains(herramienta);

    }


    public boolean contieneMaterial(Material material) {

       return materiales.contains(material);

    }


    public Material seleccionarMaterial(int posicion) {
        //No se puede acceder a un indice fuera del tamaño de materiales.
        return materiales.get(posicion);

    }


    public Herramienta seleccionarHerramienta(int posicion) {
        //No se puede acceder a un indice fuera del tamaño de herramientas.
        this.posicionHerramientaSeleccionada = posicion;
        return herramientas.get(posicion);

    }


    public ArrayList<Herramienta> getHerramientas(){

        return this.herramientas;

    }


    public ArrayList<Material> getMateriales() {
        return materiales;
    }


}
