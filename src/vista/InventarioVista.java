package vista;

import javafx.scene.*;
import controlador.Escenario;
import controlador.ControladorDeInventario;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;

public class InventarioVista {

    private BorderPane inventarioVista;
    private Node seleccionado = null;
    private GridMatriz inventario;
    private GridPane mesaCraft;
    private ControladorDeInventario controlador;
    private SelectorDeHerramientas selector;
    private Casilla casillaResultado;
    
    public InventarioVista(Escenario escenario, SelectorDeHerramientas selector) {

    	this.selector = selector;
    	inventarioVista = new BorderPane();
        inventarioVista.setId("background");
        this.establecerFondo("crafteo.png");
        
        VBox contenedorVertical = new VBox();
        contenedorVertical.setAlignment(Pos.CENTER);
        contenedorVertical.setId("contenedorVertical-casillas");
        Label titulo1 = new Label("Crafting");
        titulo1.setId("titulo-inventario");
        

        VBox contenedorInventario = new VBox();
        this.inventario = new GridMatriz(3, 9);
        this.inventario.setOnMouseClicked(e -> {
        	Node nodoSeleccionado = e.getPickResult().getIntersectedNode();
        	this.seleccionado = nodoSeleccionado.getParent();
        });
        
        Label titulo2 = new Label("Inventario");
        titulo2.setId("titulo-inventario");
        contenedorInventario.getChildren().addAll(this.inventario, titulo2);
        
        HBox contenedorMesaDeCrafteo = crearContenedorDeMesaCrafteo();
        
        contenedorVertical.getChildren().addAll(titulo1, contenedorMesaDeCrafteo, titulo2, contenedorInventario);

        HBox menu = new HBox();
        menu.setAlignment(Pos.CENTER);
        Boton cerrar = new Boton("Cerrar - [E]");
        
        cerrar.setOnAction(e -> { escenario.mostrar("juego");
        	this.controlador.actualizarVistaInventario();
        	this.controlador.quitarMaterialesDeLaMesa();
        	this.controlador.actualizarMesaCrafteo();
        	this.controlador.actualizarCasilleroRes(casillaResultado);;});
        
        menu.getChildren().addAll(cerrar);

        inventarioVista.setTop(menu);
        inventarioVista.setCenter(contenedorVertical);
        
        inventarioVista.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.E) { escenario.mostrar("juego"); 
            this.selector.controlador().actualizarSelectorHerramienta();
            this.controlador.quitarMaterialesDeLaMesa();
            this.controlador.actualizarMesaCrafteo();
            this.controlador.actualizarCasilleroRes(casillaResultado);;}
        });

    }

    public void establecerFondo(String fondo){

    	this.inventarioVista.setStyle("-fx-background-image: url('"+fondo+"')");

    }
    

    private HBox crearContenedorDeMesaCrafteo() {

        HBox contenedor = new HBox(10);
        
        contenedor.setAlignment(Pos.CENTER);
        this.mesaCraft = new GridMatriz(3, 3);
        ImageView flecha = getImagen("flecha.png", 50);
        Casilla resultado = new Casilla(70);
        this.casillaResultado = resultado;
        
        Boton crear = new Boton("Crear");
        crear.setOnAction(e -> {
            this.controlador.crearHerramienta(resultado);
        	this.selector.controlador().actualizarSelectorHerramienta();
        	
        });
        
        this.mesaCraft.setOnMouseClicked(e -> {
            
        	if(this.seleccionado != null) {
        		int x = this.inventario.getColumnIndex(this.seleccionado);
        		int y = this.inventario.getRowIndex(this.seleccionado);
        		Node nodoMesaCraft = e.getPickResult().getIntersectedNode().getParent();
        		int posicionDeMesa = this.mesaCraft.getChildren().indexOf(nodoMesaCraft);
        		this.controlador.moverMaterialAMesaCrafteo(x, y, posicionDeMesa);
        		this.controlador.actualizarVistaInventario();
        		this.seleccionado = null;
        	}
        
        });
        
        contenedor.getChildren().addAll(this.mesaCraft, flecha,crear , resultado);

        return contenedor;
    }

  



    public ImageView getImagen(String nombre, int tamanio) {

        return new ImageView(new Image((nombre), tamanio, 0, true, true));

    }


    public void setControlador(ControladorDeInventario controladorDeInventario) {

        this.controlador = controladorDeInventario;

    }
    
    public void agregarNodoAMesaCraft(Node nodoABorrar, Node nodoNuevo) {

    	int col= GridPane.getColumnIndex(nodoABorrar);
    	int row = GridPane.getRowIndex(nodoABorrar);
    	this.mesaCraft.getChildren().remove(nodoABorrar);
    	this.mesaCraft.add(nodoNuevo, col, row);
    	
    }
    
    public GridPane gridInventario() {
    	return this.inventario;
    }
    
    public GridPane gridMesaCraft() {
    	return this.mesaCraft;
    }
    
    public ControladorDeInventario controlador() {
    	return this.controlador;
    }
    
    public Pane getPane() {
        return this.inventarioVista;
    }
  

}