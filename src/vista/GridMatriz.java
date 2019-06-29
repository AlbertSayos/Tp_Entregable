package vista;

import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.scene.*;

public class GridMatriz extends GridPane{
	
	Node nodoSeleccionado;
	
	public GridMatriz(int fil, int colu){

        setAlignment(Pos.CENTER);
        
        for(int fila = 0; fila < fil; fila++) {
            for(int col = 0; col < colu; col++) {                
                add(new Casilla(), col, fila);
            }
        }
        
  
	}
	
	
}
