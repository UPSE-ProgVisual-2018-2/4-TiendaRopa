package ec.edu.upse.facsistel.sistemas.progvisual1.s2018p2.ropa.controllers;

import application.Main;
import ec.edu.upse.facsistel.sistemas.progvisual1.s2018p2.ropa.model.Producto;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerProductoEditor {

	@FXML TextField txtId;
	@FXML TextField txtNombre;
	@FXML TextArea txtDescripcion ;
	@FXML TextField txtPrecio;
	@FXML TextField txtUrl;
	
	public ControllerProductoEditor() {
		// TODO Auto-generated constructor stub
	}

	public void guardar()
	{
		Long id = Long.valueOf(txtId.getText());
		String nombre = txtNombre.getText();
		Double precio = Double.valueOf(txtPrecio.getText());
		Producto p = new Producto(id, nombre, precio);
		Main.listaProductosPrincipal.add(p);
		llamarViewAdministadorProductoPrincipal();
	}

	public void cancelar()
	{
		llamarViewAdministadorProductoPrincipal();
	}
	
	private void llamarViewAdministadorProductoPrincipal() {
		ControllerHelper.mostrarVista("/ViewAdministradorProducto.fxml", "Administrador de Productos");
		Stage s = (Stage) txtNombre.getScene().getWindow();
		s.close();
	}
	
}
