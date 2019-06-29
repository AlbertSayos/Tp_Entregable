package vista;

import controlador.*;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;


public class JuegoVista {

    private GridPane mapa;
    private ControladorDelJuego controlador;
    private BorderPane main;
    private InventarioVista inventario;

    public JuegoVista(Escenario escenario, SelectorDeHerramientas selectorHerramientas, InventarioVista inventario) {

    	this.inventario = inventario ;
    	
        main = new BorderPane();
        this.mapa = new GridPane();
        mapa.setAlignment(Pos.CENTER);

        this.mapa.setStyle("-fx-background-image: url('fondo1.png')");

        HBox menu = new HBox();
        menu.setAlignment(Pos.CENTER);
        
        //BOTON INVENTARIO
        Boton btnInventario = new Boton("Inventario - [E]");
        btnInventario.setOnAction(e ->{escenario.mostrar("inventario"); this.inventario.controlador().actualizarVistaInventario();});
        
        Boton btnMenu = new Boton("Menu - [ESC]");
        btnMenu.setOnAction(e -> escenario.mostrar("entrada"));
        menu.getChildren().addAll(btnMenu, btnInventario);

        menu.setStyle("-fx-background-image: url('fondo1.png')");
       
        main.setStyle("-fx-background-image: url('fondo1.png')");
        // Main game

        main.setTop(menu);
        main.setCenter(mapa);
        main.setBottom(selectorHerramientas);
        MoverJugadorEventHandler jugadorEventH = new MoverJugadorEventHandler(this, this.mapa, escenario);
        main.setOnKeyPressed(jugadorEventH);
  
        

        ClickMaterialJuegoEventHandler clickMaterialH = new ClickMaterialJuegoEventHandler(this, this.mapa);
        mapa.setOnMouseClicked(clickMaterialH);
    }


    public Pane getPane() {
        return this.main;
    }


    public void agregarElemento(String nombreImagen, int fila, int col) {

        //System.out.println("La imagen que se esta agregando en mapa es: "+nombreImagen);
        ImageView img = new ImageView(new Image(nombreImagen, 46, 0, true, true));
        mapa.add(img, col, fila);


    }


    public void setControlador(ControladorDelJuego controlador) {
        this.controlador = controlador;
    }
    
    public InventarioVista inventario() {
    	return this.inventario;
    }
    
    public ControladorDelJuego controlador(){
    	return this.controlador;
    }

}
