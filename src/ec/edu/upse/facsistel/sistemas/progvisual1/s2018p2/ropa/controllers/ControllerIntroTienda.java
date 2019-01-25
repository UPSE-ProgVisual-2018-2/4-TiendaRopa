package ec.edu.upse.facsistel.sistemas.progvisual1.s2018p2.ropa.controllers;

import java.io.File;
import java.net.MalformedURLException;

import javafx.fxml.FXML;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class ControllerIntroTienda {

	@FXML MediaView mediaTienda; 

	//Media Player global
	MediaPlayer mp;

	public ControllerIntroTienda() {

	}

	public void initialize()
	{
		//		hacerVentanaEstatica();
		//cargarVideoPromocionalOnline();
		cargarVideoPromocionalLocal();
	}

	private void cargarVideoPromocionalLocal() {
		File f = new File("resources/videos/fashionIntro.mp4");
		Media media;
		try {
			media = new Media(f.toURI().toURL().toString());
			mp = new MediaPlayer(media);
			mediaTienda.setMediaPlayer(mp);
			mp.play();
			mp.setAutoPlay(true);
			//Esta linea es para que toque para siempre
			mp.setCycleCount(MediaPlayer.INDEFINITE);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//	private void hacerVentanaEstatica() {
	//		Stage s = (Stage) mediaTienda.getScene().getWindow();
	//		s.setResizable(false);
	//	}

	private void cargarVideoPromocionalOnline() {

		Media media = new Media("https://gcs-vimeo.akamaized.net/exp=1547854732~acl=%2A%2F644267110.mp4%2A~hmac=6f018270e3105d385ee81006175b879c1ae2172f16d0fd00429ea40462f7f035/vimeo-prod-skyfire-std-us/01/3606/7/193033143/644267110.mp4");
		mp = new MediaPlayer(media);
		mediaTienda.setMediaPlayer(mp);
		mp.play();
		mp.setAutoPlay(true);
	}

	public void play()
	{
		mp.play();
	}

	public void stop()
	{
		mp.stop();
	}

	public void pause()
	{
		mp.pause();
	}

	public void login()
	{
		//Validamos
		
		//Cargamos la nueva pantalla
		ControllerHelper.mostrarVista("/ViewListaProductos.fxml", "Lista de Productos");
		Stage s = (Stage) mediaTienda.getScene().getWindow();
		s.close();
	}
}
