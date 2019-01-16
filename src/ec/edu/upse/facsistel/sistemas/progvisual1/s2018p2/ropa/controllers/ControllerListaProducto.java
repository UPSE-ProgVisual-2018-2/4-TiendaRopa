package ec.edu.upse.facsistel.sistemas.progvisual1.s2018p2.ropa.controllers;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

public class ControllerListaProducto {

	@FXML TilePane tileProductos;
	@FXML ComboBox<String> cmbTemporada;
	
	public void initialize()
	{
		cargarComboTemporada();
		cargarProductos();
	}
	
	private void cargarComboTemporada() {
		
		List<String> listaTemporadas = new ArrayList<String>();
		listaTemporadas.add("Invierno");
		listaTemporadas.add("Verano");
		ObservableList<String> listaObservableTemporadas = FXCollections.observableArrayList(listaTemporadas);
		cmbTemporada.setItems(listaObservableTemporadas);
	}

	public void cargarProductos()
	{
		//Creamos unos productos
		
		VBox producto1 = crearProducto("/kpop-mujer3.jpg", "Lleve lleve, su camiseta KPOP.", "1");
		VBox producto2 = crearProducto("/unicornia.jpeg", "Lleve lleve, su unicornia.", "5");
		VBox producto3 = crearProducto("/chaqueta-hombre.jpg", "Pilas con su chaqueta antigua. Lleve.", "8");
		VBox producto4 = crearProducto("/camisa-hombre.jpg", "Lleve la dominguera, gris como su futuro.", "9");
		
		tileProductos.getChildren().add(producto1);
		tileProductos.getChildren().add(producto2);
		tileProductos.getChildren().add(producto3);
		tileProductos.getChildren().add(producto4);
	}
	
	public VBox crearProducto(String urlImagen, String descripcionProducto, String precioProducto)
	{
		VBox tileProducto = new VBox(2);
		String imagenProductoURL = urlImagen;
		ImageView imgProducto = new ImageView(imagenProductoURL);
		imgProducto.setFitWidth(200);
		imgProducto.setFitHeight(260);
		imgProducto.setPreserveRatio(true);
		Label lblDescripcionProducto = new Label(descripcionProducto);
		Label lblPrecio = new Label("$ " + precioProducto);
		
		Spinner spnCantidad = new Spinner<>(0, 20, 1);
		
		Button btnComprar = new Button("Comprar");
		
		tileProducto.getChildren().addAll(imgProducto, lblDescripcionProducto, lblPrecio, spnCantidad, btnComprar);
		
//		tileProducto.getChildren().add(imgProducto);
//		tileProducto.getChildren().add(lblDescripcionProducto);
//		tileProducto.getChildren().add(lblPrecio);
//		tileProducto.getChildren().add(btnComprar);
		
		return tileProducto;
	}
}
