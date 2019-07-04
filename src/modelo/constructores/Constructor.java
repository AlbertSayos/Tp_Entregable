package modelo.constructores;

import java.util.HashMap;


public class Constructor {

    private HashMap<String, ConstructorDeHerramientas> recetas = new HashMap<String, ConstructorDeHerramientas>();
    private static String RECETA_HACHA_DE_MADERA = "mm-mm--m-";
    private static String RECETA_HACHA_DE_PIEDRA = "pp-pm--m-";
    private static String RECETA_HACHA_DE_METAL = "MM-Mm--m-";
    private static String RECETA_PICO_DE_MADERA = "mmm-m--m-";
    private static String RECETA_PICO_DE_PIEDRA = "ppp-m--m-";
    private static String RECETA_PICO_DE_METAL = "MMM-m--m-";
    private static String RECETA_PICO_FICO = "MMMpm--m-";

    public Constructor() {

        this.agregarReceta(RECETA_HACHA_DE_MADERA, new ConstructorDeHachaDeMadera());
        this.agregarReceta(RECETA_HACHA_DE_PIEDRA, new ConstructorDeHachaDePiedra());
        this.agregarReceta(RECETA_HACHA_DE_METAL, new ConstructorDeHachaDeMetal());
        this.agregarReceta(RECETA_PICO_DE_MADERA, new ConstructorDePicoDeMadera());
        this.agregarReceta(RECETA_PICO_DE_PIEDRA, new ConstructorDePicoDePiedra());
        this.agregarReceta(RECETA_PICO_DE_METAL, new ConstructorDePicoDeMetal());
        this.agregarReceta(RECETA_PICO_FICO, new ConstructorDePicoFino());

    }

    public boolean puedoCraftear(String receta) {
        return this.recetas.containsKey(receta);
    }

    public void agregarReceta(String receta, ConstructorDeHerramientas constructor) {
        this.recetas.put(receta, constructor);
    }
/*

    public Herramienta craftear(String receta) {

        if (this.puedoCraftear(receta)) {
            return this.recetas.get(receta).construir();
        }
        throw new DispocisionNoExisteException();
    }*/
}