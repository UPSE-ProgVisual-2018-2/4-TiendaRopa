package ec.edu.upse.facsistel.sistemas.progvisual1.s2018p2.ropa.controllers;

import java.util.ArrayList;
import java.util.List;

import application.Main;
import ec.edu.upse.facsistel.sistemas.progvisual1.s2018p2.ropa.model.Producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ControllerListaProducto {

	@FXML TilePane tileProductos;
	@FXML ComboBox<String> cmbTemporada;

	public static List<Producto> listaProductosCarrito = new ArrayList<Producto>();

	public void initialize()
	{
		cargarComboTemporada();
		listaProductosCarrito = Main.listaProductosPrincipal;
		cargarProductosDesdeClaseProducto();

	}

	private void cargarComboTemporada() {

		List<String> listaTemporadas = new ArrayList<String>();
		listaTemporadas.add("Invierno");
		listaTemporadas.add("Verano");
		ObservableList<String> listaObservableTemporadas = FXCollections.observableArrayList(listaTemporadas);
		cmbTemporada.setItems(listaObservableTemporadas);
	}

	//	public void cargarProductos()
	//	{
	//		//Creamos unos productos
	//		
	//		VBox producto1 = crearProducto("/kpop-mujer3.jpg", "Lleve lleve, su camiseta KPOP.", "1");
	//		VBox producto2 = crearProducto("/unicornia.jpeg", "Lleve lleve, su unicornia.", "5");
	//		VBox producto3 = crearProducto("/chaqueta-hombre.jpg", "Pilas con su chaqueta antigua. Lleve.", "8");
	//		VBox producto4 = crearProducto("/camisa-hombre.jpg", "Lleve la dominguera, gris como su futuro.", "9");
	//		
	//		tileProductos.getChildren().add(producto1);
	//		tileProductos.getChildren().add(producto2);
	//		tileProductos.getChildren().add(producto3);
	//		tileProductos.getChildren().add(producto4);
	//	}

	public void cargarProductosDesdeClaseProducto()
	{
		//		Producto p1 = new Producto(1, 10, "Camisa", "Camisa de hombre casual.", "/camisa-hombre.jpg");
		//		Producto p2 = new Producto(2, 30, "Chaqueta Masculina", "Una chaqueta muy masculina, para que no duden de ti.", "/chaqueta-hombre.jpg");
		//		Producto p3 = new Producto(3, 15, "Traje de Unicornio", "El traje de unicornio que te llevara al mundo arcoiris.", "/unicornia.jpeg");
		//		VBox producto1 = crearTileProductoDesdeClaseProducto(p1);
		//		VBox producto2 = crearTileProductoDesdeClaseProducto(p2);
		//		VBox producto3 = crearTileProductoDesdeClaseProducto(p3);

		for(Producto p: listaProductosCarrito)
		{
			System.out.println("Producto antes de Crear Tile Pane: " + p);
			VBox productoTile = crearTileProductoDesdeClaseProducto(p);
			tileProductos.getChildren().add(productoTile);
		}
		//		
		//		tileProductos.getChildren().add(producto1);
		//		tileProductos.getChildren().add(producto2);
		//		tileProductos.getChildren().add(producto3);

	}

	public VBox crearProducto(String urlImagen, String nombreProducto, String descripcionProducto, String precioProducto)
	{
		VBox tileProducto = new VBox(2);
		String imagenProductoURL = urlImagen;
		ImageView imgProducto = new ImageView(imagenProductoURL);
		imgProducto.setFitWidth(200);
		imgProducto.setFitHeight(260);
		imgProducto.setPreserveRatio(true);
		Label lblNombreProducto = new Label(nombreProducto);
		Label lblDescripcionProducto = new Label(descripcionProducto);
		Label lblPrecio = new Label("$ " + precioProducto);

		Spinner spnCantidad = new Spinner<>(0, 20, 1);

		Button btnComprar = new Button("Comprar");


		tileProducto.getChildren().addAll(imgProducto, lblNombreProducto, lblDescripcionProducto, lblPrecio, spnCantidad, btnComprar);

		return tileProducto;
	}

	public VBox crearProducto(Producto p)
	{
		VBox tileProducto = new VBox(2);
		String imagenProductoURL = p.getUrlImagen();
		ImageView imgProducto;
		
		if(imagenProductoURL==null || imagenProductoURL.isEmpty() || imagenProductoURL.equals(""))
		{
			imgProducto = new ImageView("/noPhotoFound.png");
		}else {

			imgProducto = new ImageView(imagenProductoURL);

		}
		imgProducto.setFitWidth(200);
		imgProducto.setFitHeight(260);
		imgProducto.setPreserveRatio(true);
		
		Label lblNombreProducto = new Label(p.getNombre());
		Label lblDescripcionProducto = new Label(p.getDescripcion());
		Label lblPrecio = new Label("$ " + p.getPrecio());

		Spinner<Integer> spnCantidad = new Spinner<Integer>(0, 20, 1);

		Button btnComprar = new Button("Comprar");

		btnComprar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				int cantidad = spnCantidad.getValue();
				while(cantidad > 0)
				{
					listaProductosCarrito.add(p);
					cantidad--;
				}

				System.out.println("La lista de productos en el carrito es: " + listaProductosCarrito);
			}
		});

		tileProducto.getChildren().addAll(imgProducto, lblNombreProducto, lblDescripcionProducto, lblPrecio, spnCantidad, btnComprar);

		return tileProducto;
	}

	private VBox crearTileProductoDesdeClaseProducto(Producto p)
	{
		return crearProducto(p);
	}

	public void irAVistaCarrito()
	{
		//Validamos

		//Cargamos la nueva pantalla
		ControllerHelper.mostrarVista("/ViewCarrito.fxml", "Carrito de Compras");
		Stage s = (Stage) tileProductos.getScene().getWindow();
		s.close();
	}
}
