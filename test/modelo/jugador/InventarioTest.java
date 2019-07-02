package modelo.jugador;

import modelo.materiales.*;
import modelo.herramientas.*;
import modelo.posicion.*;
import org.junit.Test;

import junit.framework.Assert;

import java.util.ArrayList;

public class InventarioTest {


    @Test
    public void inventarioContains(){

        ArrayList<Material> materiales = new ArrayList<Material>();
        Madera madera = new Madera();
        Metal metal = new Metal();
        Piedra piedra = new Piedra();
        Diamante diamante = new Diamante();
        materiales.add(madera);
        materiales.add(piedra);
        materiales.add(metal);
        materiales.add(diamante);
        System.out.println(materiales.contains(madera));


    }
    
    

}
