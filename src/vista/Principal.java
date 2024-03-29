package vista;

import controlador.Escenario;
import controlador.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import modelo.juego.Juego;
import modelo.jugador.Jugador; 
import javafx.scene.media.*;
import java.net.URL;

public class Principal extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    public void start(Stage primaryStage) {
        loadMainMenu(primaryStage);
        

    }

    
    public void loadMainMenu(Stage primaryStage) {
    	
        try {

            Juego juego = new Juego();
            Jugador jugador = juego.getJugador();
            
            BorderPane panel = new BorderPane();
            panel.setPadding(new Insets(20, 0, 20, 20));
            Boton comenzar = new Boton("Comenzar");
            Boton creditos = new Boton("Creditos");
            Boton salir = new Boton("Salir");
            comenzar.setMaxWidth(Double.MAX_VALUE);
            creditos.setMaxWidth(Double.MAX_VALUE);
            salir.setMaxWidth(Double.MAX_VALUE);
            VBox botonera = new VBox();
            botonera.setAlignment(Pos.CENTER);
            botonera.setSpacing(10);
            botonera.setPadding(new Insets(0, 25, 15, 25));
            botonera.getChildren().addAll(comenzar, creditos, salir);
            panel.setCenter(botonera);
            Scene escena = new Scene(panel, 1000, 700);
            primaryStage.setTitle("ALGOCRAFT");
            primaryStage.setScene(escena);

            Escenario escenario = new Escenario(escena);
            
            SelectorDeHerramientas selectorHerramientas = new SelectorDeHerramientas();
            ControladorSelectorHerramienta controladorSelector = new ControladorSelectorHerramienta(jugador, selectorHerramientas);
            
            InventarioVista inventarioVista = new InventarioVista(escenario, selectorHerramientas);
            ControladorDeInventario controladorInventario = new ControladorDeInventario(juego, inventarioVista);
            
            
            JuegoVista juegoVista = new JuegoVista(escenario, selectorHerramientas, inventarioVista);
            
            
            ControladorDelJuego controladorJuego = new ControladorDelJuego(juegoVista, juego) ;
            
            
            CreditosVista creditosVista = new CreditosVista(escenario);
            escenario.set("entrada", panel);
            escenario.set("inventario", inventarioVista.getPane());
            escenario.set("juego", juegoVista.getPane());
            escenario.set("creditos", creditosVista.getPane());
            comenzar.setOnAction(e -> { escenario.mostrar("juego"); });
            creditos.setOnAction(e -> { escenario.mostrar("creditos"); });

            panel.setStyle("-fx-background-image: url('entrada4.jpg')");

            salir.setOnAction(e -> { System.exit(0); });

            controladorJuego.actualizarVista();

            
            //ControladorDeInventario controladorDeInventario = new ControladorDeInventario(jugador.getInventario(), inventarioVista, selectorHerramientas);
            //controladorDeInventario.actualizarVista();
            //ControladorDelJuego controladorJuego = new ControladorDelJuego(juegoVista, juego, controladorDeInventario);
            //controladorJuego.actualizarVista();

            selectorHerramientas.agregar(jugador.getHerramientaEquipada().getClass().getSimpleName()+".png", 0);
           
            //empezarMusicaFondo();
            
            primaryStage.show();
        }

        catch (Exception e) {
            Alert error = new Alert(Alert.AlertType.INFORMATION);
            error.setTitle("ERROR");
            error.setHeaderText("Algo salio mal en tiempo de ejecucion...");
            error.setContentText("Tipo de error: " + e);
            error.initStyle(StageStyle.UTILITY);
            error.showAndWait();
            System.exit(0);

        }

        
    }
    
    public void empezarMusicaFondo() {
    	final URL resource = this.getClass().getResource("/inicio_juego.mp3");
    	System.out.println(resource);
    	System.out.println(resource.toString());
    	AudioClip cancion = new AudioClip(resource.toString());
    	cancion.play();
    	
    }
}