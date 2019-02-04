package ec.edu.upse.facsistel.sistemas.progvisual1.s2018p2.ropa.controllers;

import application.Main;
import ec.edu.upse.facsistel.sistemas.progvisual1.s2018p2.ropa.model.Producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class ControllerAdministradorProducto {

	@FXML ListView<Producto> lstProductos;
	
	public ControllerAdministradorProducto() {
		// TODO Auto-generated constructor stub
	}
	
	public void initialize()
	{
		cargarListViewProductos();
	}

	private void cargarListViewProductos() {
		ObservableList<Producto> listaObservableProducto = 
				FXCollections.observableArrayList(Main.listaProductosPrincipal);
		lstProductos.setItems(listaObservableProducto);
	}
	
	public void eliminarProducto()
	{
		System.out.println("Lista Actual");
		System.out.println(Main.listaProductosPrincipal);
		Producto productoAEliminar = lstProductos.getSelectionModel().getSelectedItem();
		//lstProductos.getItems().remove(productoAEliminar);
		Main.listaProductosPrincipal.remove(productoAEliminar);
		System.out.println();
		System.out.println("Lista Nueva");
		System.out.println(Main.listaProductosPrincipal);
		cargarListViewProductos();
	}
	
	public void crearNuevoProducto()
	{
		ControllerHelper.mostrarVista("/ViewProductoEditor.fxml", "Crear Nuevo Producto");
		Stage s = (Stage) lstProductos.getScene().getWindow();
		s.close();
	}

}
