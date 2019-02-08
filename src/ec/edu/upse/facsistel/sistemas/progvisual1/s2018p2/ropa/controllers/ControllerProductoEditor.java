package ec.edu.upse.facsistel.sistemas.progvisual1.s2018p2.ropa.controllers;

import application.Main;
import ec.edu.upse.facsistel.sistemas.progvisual1.s2018p2.ropa.model.Producto;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerProductoEditor implements VistaCargable {

	@FXML TextField txtId;
	@FXML TextField txtNombre;
	@FXML TextArea txtDescripcion ;
	@FXML TextField txtPrecio;
	@FXML TextField txtUrl;
	
	private boolean formularioModificacion = false;
	private Producto productoAModificar;
	
	public ControllerProductoEditor() {
		// TODO Auto-generated constructor stub
	}

	public void guardar()
	{
		Long id = Long.valueOf(txtId.getText());
		String nombre = txtNombre.getText();
		String descripcion = txtDescripcion.getText();
		Double precio = Double.valueOf(txtPrecio.getText());
		String url = txtUrl.getText();
		Producto p;
		if(!formularioModificacion)
		{
			p = new Producto(id, nombre, precio);
			p.setUrlImagen(url);
			p.setDescripcion(descripcion);
			Main.listaProductosPrincipal.add(p);
		}else {
			productoAModificar.setNombre(nombre);
			productoAModificar.setDescripcion(descripcion);
			productoAModificar.setPrecio(precio);
			productoAModificar.setUrlImagen(url);
		}
		
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

	@Override
	public void cargarVistaConObjeto(Object o) {
		
		if(o!=null & o.getClass()==Producto.class)
		{
			Producto p = (Producto) o;
			cargarProductoEnVista(p);
			formularioModificacion=true;
			productoAModificar = p;
			txtId.setDisable(true);
		}else {
			System.err.println("Error, objeto nulo o no conversible a Producto");
		}
		
	}

	public void cargarProductoEnVista(Producto p) {
		txtId.setText(Long.toString(p.getId()));
		txtNombre.setText(p.getNombre());
		txtDescripcion.setText(p.getDescripcion());
		txtPrecio.setText(Double.toString(p.getPrecio()));
		txtUrl.setText(p.getUrlImagen());
	}
	
}
