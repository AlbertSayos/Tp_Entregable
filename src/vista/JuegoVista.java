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


    public JuegoVista(Escenario escenario, SelectorDeHerramientas selectorHerramientas) {


        main = new BorderPane();
        this.mapa = new GridPane();
        mapa.setAlignment(Pos.CENTER);
        this.mapa.setStyle("-fx-background-image: url('pasto.png')");
        HBox menu = new HBox();
        menu.setAlignment(Pos.CENTER);
        Boton btnInventario = new Boton("Inventario - [E]");
        Boton btnMenu = new Boton("Menu - [ESC]");
        btnInventario.setOnAction(e ->{escenario.mostrar("inventario"); this.controlador.actualizarInventario();});
        btnMenu.setOnAction(e -> escenario.mostrar("entrada"));
        menu.getChildren().addAll(btnMenu, btnInventario);
        menu.setStyle("-fx-background-image: url('pasto.png')");
        main.setStyle("-fx-background-image: url('pasto.png')");
        main.setTop(menu);
        main.setCenter(mapa);
        main.setBottom(selectorHerramientas);
        MoverJugadorEventHandler jugadorEventH = new MoverJugadorEventHandler(this, this.mapa);
        main.setOnKeyPressed(jugadorEventH);
        main.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.E) {
                escenario.mostrar("inventario");
            }
            if (event.getCode() == KeyCode.ESCAPE) {
                escenario.mostrar("entrada");
            }
            if (event.getCode() == KeyCode.W) {
                controlador.moverArriba(mapa);
            }
            if (event.getCode() == KeyCode.A) {
                controlador.moverIzquierda(mapa);
            }
            if (event.getCode() == KeyCode.S) {
                controlador.moverAbajo(mapa);
            }
            if (event.getCode() == KeyCode.D) {
                controlador.moverDerecha(mapa);
            }
            
        });

        ClickMaterialJuegoEventHandler clickMaterialH = new ClickMaterialJuegoEventHandler(this, this.mapa);
        mapa.setOnMouseClicked(clickMaterialH);
    }


    public Pane getPane() {
        return this.main;
    }


    public void agregarElemento(String nombreImagen, int fila, int col) {

        System.out.println("La imagen que se esta agregando en mapa es: "+nombreImagen);
        ImageView img = new ImageView(new Image(nombreImagen, 46, 0, true, true));
        mapa.add(img, col, fila);


    }


    public void setControlador(ControladorDelJuego controlador) {
        this.controlador = controlador;
    }
    
    public ControladorDelJuego controlador(){
    	return this.controlador;
    }

}
