package vista;

import controlador.*;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;



public class JuegoVista {

    private GridPane mapa;
    private ControladorDelJuego controlador;
    private BorderPane main;


    public JuegoVista(Escenario escenario, SelectorDeHerramientas selectorHerramientas) {
        main = new BorderPane();
        main.setId("juego-escena");

        this.mapa = new GridPane();
        mapa.setAlignment(Pos.CENTER);

        this.mapa.setStyle("-fx-background-image: url('fondo.png')");

        // Top menu
        HBox menu = new HBox();
        menu.setAlignment(Pos.CENTER);
        Boton btnInventario = new Boton("Inventario - [E]");
        Boton btnMenu = new Boton("Menu - [ESC]");
        btnInventario.setOnAction(e -> escenario.mostrar("inventario"));
        btnMenu.setOnAction(e -> escenario.mostrar("entrada"));
        menu.getChildren().addAll(btnMenu, btnInventario);

        // Botones para moverse
        VBox flechasMover = new VBox();
        flechasMover.setAlignment(Pos.BOTTOM_CENTER);
        HBox flechasMoverAbajo = new HBox();
        Boton btnMoverIzquierda = new Boton("A");
        Boton btnMoverDerecha = new Boton("D");
        Boton btnMoverAbajo = new Boton("S");
        flechasMoverAbajo.getChildren().addAll(btnMoverIzquierda,btnMoverAbajo,btnMoverDerecha);
        Boton btnMoverArriba = new Boton("W");
        flechasMover.getChildren().addAll(btnMoverArriba, flechasMoverAbajo);

        // Botones para golpear
        VBox flechasGolpear = new VBox();
        flechasGolpear.setAlignment(Pos.BOTTOM_CENTER);
        HBox flechasGolpearAbajo = new HBox();
        Boton btnGolpearIzquierda = new Boton("◄");
        Boton btnGolpearDerecha = new Boton("►");
        Boton btnGolpearAbajo = new Boton("▼");
        flechasGolpearAbajo.getChildren().addAll(btnGolpearIzquierda,btnGolpearAbajo,btnGolpearDerecha);
        Boton btnGolpearArriba = new Boton("▲");
        flechasGolpear.getChildren().addAll(btnGolpearArriba, flechasGolpearAbajo);

        // Main game
        main.setTop(menu);
        main.setCenter(mapa);
        main.setLeft(flechasMover);
        main.setRight(flechasGolpear);
        main.setBottom(selectorHerramientas);

        // Mouse
        btnMoverIzquierda.setOnAction( e -> controlador.moverIzquierda(mapa));
        btnMoverDerecha.setOnAction( e -> controlador.moverDerecha(mapa));
        btnMoverAbajo.setOnAction( e -> controlador.moverAbajo(mapa));
        btnMoverArriba.setOnAction( e -> controlador.moverArriba(mapa));
/*
        btnGolpearIzquierda.setOnAction( e -> controlador.golpearIzquierda());
        btnGolpearDerecha.setOnAction( e -> controlador.golpearDerecha());
        btnGolpearAbajo.setOnAction( e -> controlador.golpearAbajo());
        btnGolpearArriba.setOnAction( e -> controlador.golpearArriba());
*/
        // Teclado
        MoverJugadorEventHandler jugadorEventH = new MoverJugadorEventHandler(this, this.mapa);
        main.setOnKeyPressed(jugadorEventH);
        /*main.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.E) {
                escenario.activate("inventario");
            }
            if (event.getCode() == KeyCode.ESCAPE) {
                escenario.activate("main");
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
        */
    }


    public Pane getPane() {
        return this.main;
    }


    public void agregarElemento(String nombreImagen, int fila, int col) {
        //System.out.println("La imagen que se esta agregando en mapa es: "+nombreImagen);
        ImageView img = new ImageView(new Image(nombreImagen, 32, 0, true, true));
        mapa.add(img, col, fila);


    }


    public void setControlador(ControladorDelJuego controlador) {
        this.controlador = controlador;
    }
    
    public ControladorDelJuego controlador(){
    	return this.controlador;
    }

}
