package application;
	
import java.util.ArrayList;
import java.util.List;

import ec.edu.upse.facsistel.sistemas.progvisual1.s2018p2.ropa.model.Carrito;
import ec.edu.upse.facsistel.sistemas.progvisual1.s2018p2.ropa.model.Carrito.Envio;
import ec.edu.upse.facsistel.sistemas.progvisual1.s2018p2.ropa.model.Compania;
import ec.edu.upse.facsistel.sistemas.progvisual1.s2018p2.ropa.model.Producto;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	public static List<Producto> listaProductosPrincipal = new ArrayList<Producto>();
	public static Compania compania = new Compania("Novedades GAIBOR", "2400000012", "Barrio 9 de Octubre S/N", "Juan Gaibor", "0912345678", "gaibor@gaibor.com");
	
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

		//ObjetoCarrito o1 = new ObjetoCarrito(null, 1);
		Carrito.ObjetoCarrito2 o1 = new Carrito.ObjetoCarrito2(listaProductosPrincipal.get(1), 4);
		Carrito.ObjetoCarrito2 o2 = new Carrito.ObjetoCarrito2(listaProductosPrincipal.get(0), 3);
		
		Carrito c = new Carrito(123);
		c.getListaObjetosCarrito().add(o1);
		c.getListaObjetosCarrito().add(o2);
		c.facturar();
		Carrito.Envio e = c.new Envio(231, "Juan", "09111111", "La principal y la que cruza", "Salinas", "Ecuador", "EC240111");
		e.setCourrier(e.getTramacoExpress());
		
		launch(args);
		
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
