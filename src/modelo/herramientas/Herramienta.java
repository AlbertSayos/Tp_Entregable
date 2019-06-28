package modelo.herramientas;

import modelo.materiales.*;
import modelo.excepciones.*;


public abstract class Herramienta {


    protected float durabilidad;
    protected int fuerza;
    protected float factorDeDesgaste;
    public String identificador;


    public String getIdentificador(){return this.identificador;}

    public abstract void desgastarse();

    public int getFuerza(){

        return this.fuerza;

    }

    public float getDurabilidad(){
        return this.durabilidad;

    }
    
    public void usar(Material unMaterial) {
        unMaterial.recibeGolpeDe(this);
        if(unMaterial.estaDestruido()) throw new MaterialRotoException();

    }

	public abstract void golpear(Madera unaMadera);
	
	public abstract void golpear(Piedra unaPiedra);
	
	public abstract void golpear(Metal unaMaetal);
	
	public abstract void golpear(Diamante unaDiamante);

    public boolean esEquivalente(Herramienta otraHerramienta){

        return this.getClass() == otraHerramienta.getClass();

    }
    
    public boolean estaRota() {
    	return (durabilidad <=0.0);
    }
    
}