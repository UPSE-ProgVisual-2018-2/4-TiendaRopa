package ec.edu.upse.facsistel.sistemas.progvisual1.s2018p2.ropa.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import ec.edu.upse.facsistel.sistemas.progvisual1.s2018p2.ropa.model.Producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class ControllerCarrito {

	@FXML ListView<Producto> lstProductosAComprar;
	
	private List<Producto> listaProductosCarrito = new ArrayList<Producto>();
	
	public ControllerCarrito() {
		// TODO Auto-generated constructor stub
	}
	
	public void initialize()
	{
		//mockearCarritoCompras();
		listaProductosCarrito = ControllerListaProducto.listaProductosCarrito;
		cargarListViewProductos(listaProductosCarrito);
	}
	
	private void mockearCarritoCompras()
	{
		List<Producto> listaCompras = new ArrayList<Producto>();
		Producto p1 = new Producto(1, "Blusa Hippie", 12);
		Producto p2 = new Producto(2, "Jean StudioF", 30);
		Producto p3	= new Producto(3, "Camiseta de Emelec que parece del Macara", 5);
		
		listaCompras.add(p1);
		listaCompras.add(p2);
		listaCompras.add(p3);
	
		cargarListViewProductos(listaCompras);
	}

	private void cargarListViewProductos(List<Producto> listaCompras) {
		ObservableList<Producto> listaComprasObservable = FXCollections.observableArrayList(listaCompras);
		lstProductosAComprar.setItems(listaComprasObservable);
	}

}
