package vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class Casilla extends StackPane{

	public Casilla(){
		
        setId("casilla");
        
        ImageView imageView = new ImageView(new Image(("casilla.png"), 48, 0, true, true));
        getChildren().add(imageView);    
	}
}
