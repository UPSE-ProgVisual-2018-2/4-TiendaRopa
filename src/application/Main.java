package application;
	
import java.util.ArrayList;
import java.util.List;

import ec.edu.upse.facsistel.sistemas.progvisual1.s2018p2.ropa.model.Carrito;
import ec.edu.upse.facsistel.sistemas.progvisual1.s2018p2.ropa.model.Producto;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	public static List<Producto> listaProductosPrincipal = new ArrayList<Producto>();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/ViewAdministradorProducto.fxml"));
			Scene scene = new Scene(root,640,360);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		crearProductos();
		launch(args);
		
		//ObjetoCarrito o1 = new ObjetoCarrito(null, 1);
		Carrito.ObjetoCarrito2 o2 = new Carrito.ObjetoCarrito2(null, 1);
	}
	
	public static void crearProductos()
	{
		Producto p1 = new Producto(1, 10, "Camisa", "Camisa de hombre casual.", "/camisa-hombre.jpg");
		Producto p2 = new Producto(2, 30, "Chaqueta Masculina", "Una chaqueta muy masculina, para que no duden de ti.", "/chaqueta-hombre.jpg");
		Producto p3 = new Producto(3, 15, "Traje de Unicornio", "El traje de unicornio que te llevara al mundo arcoiris.", "/unicornia.jpeg");
		listaProductosPrincipal.add(p1);
		listaProductosPrincipal.add(p2);
		listaProductosPrincipal.add(p3);
	}
}
