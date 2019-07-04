package vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class Casilla extends StackPane{

    private static String IMAGEN_CASILLA = "casilla.png";

	public Casilla(){
		
        setId("casilla");
        
        ImageView imageView = new ImageView(new Image((IMAGEN_CASILLA), 48, 0, true, true));
        getChildren().add(imageView);    
	}
	
	public Casilla(int tam){
		
        setId("casilla");
        
        ImageView imageView = new ImageView(new Image((IMAGEN_CASILLA), 70, 0, true, true));
        getChildren().add(imageView);    
	}
}
