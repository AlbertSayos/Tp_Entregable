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

    public InventarioVista(Escenario escenario, SelectorDeHerramientas selector) {

    	this.selector = selector;
    			
    	//CREACION INVENTARIO VISTA PRINCIPAL
        inventarioVista = new BorderPane();
        inventarioVista.setId("background");
        this.establecerFondo("crafteo.png");
        
        //CREACION CONTENEDOR VERTICAL Q IRA DENTRO DE LA VISTA PRINCIPAL
        //DE inventarioVista 
        VBox contenedorVertical = new VBox();
        
        contenedorVertical.setAlignment(Pos.CENTER);
        contenedorVertical.setId("contenedorVertical-casillas");
        Label titulo1 = new Label("Crafting");
        titulo1.setId("titulo-inventario");
        
        //CONTENEDOR INVENTARIO
        
        VBox contenedorInventario = new VBox();
        
        this.inventario = new GridMatriz(3, 9);       
        Label titulo2 = new Label("Inventario");
        titulo2.setId("titulo-inventario");
        contenedorInventario.getChildren().addAll(this.inventario, titulo2);
        
        // CONTENEDOR MESA CRAFTEO
        HBox contenedorMesaDeCrafteo = crearContenedorDeMesaCrafteo();	
        
        //SE AÑADEN LAS COSAS A CONTENEDEDOR VERTICAL 
        contenedorVertical.getChildren().addAll(titulo1, contenedorMesaDeCrafteo, titulo2, contenedorInventario);

        // TOP
        HBox menu = new HBox();
        menu.setAlignment(Pos.CENTER);
        Boton cerrar = new Boton("Cerrar - [E]");
        
        cerrar.setOnAction(e -> { escenario.mostrar("juego"); ; });
        menu.getChildren().addAll(cerrar);

        //SET DEL CONTENEDOR MAYOR
        inventarioVista.setTop(menu);
        inventarioVista.setCenter(contenedorVertical);
        
        inventarioVista.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.E) { escenario.mostrar("juego"); }
        });

    }

    public void establecerFondo(String fondo){
    	this.inventarioVista.setStyle("-fx-background-image: url('"+fondo+"')");
    }


    public Node nodoSeleccionado() {
    	return this.seleccionado;
    }
    

    private HBox crearContenedorDeMesaCrafteo() {

        HBox contenedor = new HBox(10);
        
        contenedor.setAlignment(Pos.CENTER);
        this.mesaCraft = new GridMatriz(3, 3);
        ImageView flecha = getImagen("flecha.png", 50);
        ImageView resultado = getImagen("casilla.png", 70);

        Boton crear = new Boton("Crear");
        crear.setOnAction(e -> {
        	this.selector.controlador().agregarNuevaHerramienta();
            this.selector.controlador().actualizarSelectorHerramienta();
        });
        
        this.mesaCraft.setOnMouseClicked(e -> {
            
        	System.out.println("ON MOUSE CLICK MESA");
        	if(this.seleccionado != null) {
        		this.controlador.colocarNodoSobreMesaCrafteo(e.getPickResult().getIntersectedNode());
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
    
    /*  
    private void agregarElemento(GridPane inventario, String elemento, int fila, int columna) {

        System.out.println("En inventario vista agregarElemento recibe como elemento: "+elemento);
        if (elemento == null) return;
        StackPane stack = new StackPane();
        Image itemImage = new Image(elemento, 38, 0, true, true);
        ImageView imageView = new ImageView(itemImage);
        imageView.setId(String.valueOf(elemento.charAt(0)));
        stack.getChildren().add(imageView);
        inventario.add(stack, fila, columna);
        stack.setId("casilla");
        imageView.setOnMouseClicked(e -> { this.seleccionado = e.getPickResult().getIntersectedNode(); });
        stack.setOnMouseReleased(e -> {
            if (this.seleccionado != null) {
                stack.getChildren().clear();
                stack.getChildren().add(this.seleccionado);
                this.seleccionado = null;
            }
        });
    }
    
    /*
   public void agregar(String elemento, int fila, int columna) {
        this.agregarElemento(this.inventario, elemento, fila, columna);
    }


    public void limpiar() {

        this.inventario.getChildren().clear();
        for(int fila = 0; fila < 3; fila++) {
            for(int col = 0; col < 9; col++) {
                agregarCasilla(this.inventario, col, fila);
            }
        }
        System.out.println("****LIMPIO MESA ***");
        this.mesa = this.crearMesa();
    }
*/


  

}