package ec.edu.upse.facsistel.sistemas.progvisual1.s2018p2.ropa.controllers;

import java.io.IOException;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControllerHelper {

	private static String pathPorDefecto = "/ViewIntroTienda.fxml";
	
	public ControllerHelper() {
		// TODO Auto-generated constructor stub
	}

	public static void mostrarVista(String uriVista, String titulo, Object o)
	{
		if(uriVista==null || uriVista.trim().equals(""))
		{
			uriVista= pathPorDefecto;
		}
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource(uriVista));
		try {
			Parent page = loader.load();
			Stage stage = new Stage();
			stage.setTitle(titulo);
			Scene scene = new Scene(page, 400, 400);
			stage.setScene(scene);
			if(o!= null)
			{
				VistaCargable controller = (VistaCargable) loader.getController();
				controller.cargarVistaConObjeto(o);
			}
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void mostrarVista(String uriVista, String titulo)
	{
		mostrarVista(uriVista, titulo, null);
	}
	
	public static void mostrarVistaModifacion(String uriVista, String titulo, Object o)
	{
		mostrarVista(uriVista, titulo, o);
	}
}
