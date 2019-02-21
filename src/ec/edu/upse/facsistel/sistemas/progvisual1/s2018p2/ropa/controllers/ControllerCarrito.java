package ec.edu.upse.facsistel.sistemas.progvisual1.s2018p2.ropa.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import ec.edu.upse.facsistel.sistemas.progvisual1.s2018p2.ropa.model.Carrito;
import ec.edu.upse.facsistel.sistemas.progvisual1.s2018p2.ropa.model.Producto;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.converter.NumberStringConverter;

public class ControllerCarrito {

	@FXML ListView<Producto> lstProductosAComprar;
	@FXML TableView<Carrito.ObjetoCarrito2> tblCarrito;
	@FXML TableColumn<Carrito.ObjetoCarrito2, String> tblColNombre;
	@FXML TableColumn<Carrito.ObjetoCarrito2, Number> tblColPrecioUnitario;
	@FXML TableColumn<Carrito.ObjetoCarrito2, Number> tblColCantidad;
	@FXML TableColumn<Carrito.ObjetoCarrito2, SimpleDoubleProperty> tblColMonto;
	@FXML Label lblTotal;
	@FXML Button btnIrAEnvio;
	
	private List<Producto> listaProductosCarrito = new ArrayList<Producto>();
	
	public ControllerCarrito() {
		// TODO Auto-generated constructor stub
	}
	
	public void initialize()
	{
		//mockearCarritoCompras();
		listaProductosCarrito = ControllerListaProducto.listaProductosCarrito;
		cargarListViewProductos(listaProductosCarrito);
		Map<Producto, Integer> mapConsolidadoListaCarrito = consolidarListaProductosCarrito(listaProductosCarrito);
		Carrito c = construirCarrito(mapConsolidadoListaCarrito);
		cargarTableCarrito(c);
		
		btnIrAEnvio.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				ControllerHelper.mostrarVista("/ViewDireccion.fxml", "Envio");
				Stage s = (Stage) btnIrAEnvio.getScene().getWindow();
				s.close();
			}
			
		});
	}


	private Carrito construirCarrito(Map<Producto, Integer> mapConsolidadoListaCarrito) {
		Carrito c = new Carrito(1);
		List<Carrito.ObjetoCarrito2> listaObjetosCarrito = new ArrayList<Carrito.ObjetoCarrito2>();
		for(Producto p: mapConsolidadoListaCarrito.keySet())
		{
			Carrito.ObjetoCarrito2 objetoCarrito = new Carrito.ObjetoCarrito2(p, mapConsolidadoListaCarrito.get(p));
			listaObjetosCarrito.add(objetoCarrito);
		}
		System.out.println();
		System.out.println("Lista Objetos Carrito ***");
		System.out.println(listaObjetosCarrito);
		c.setListaObjetosCarrito(listaObjetosCarrito);
		return c;
	}

	private Map<Producto, Integer> consolidarListaProductosCarrito(List<Producto> listaProductosCarrito) {
		Map<Producto, Integer> mapConsolidadoListaCarrito = new HashMap<Producto, Integer>();
		
		System.out.println("*****MAP CONSOLIDADO CARRITO******");
		for(Producto p: listaProductosCarrito)
		{
			if(mapConsolidadoListaCarrito.containsKey(p))
			{
				Integer conteoActualProducto = mapConsolidadoListaCarrito.get(p);
				Integer conteoNuevoProducto = conteoActualProducto + 1;
				mapConsolidadoListaCarrito.put(p, conteoNuevoProducto);
				System.out.println("Map tiene cantidad " + conteoNuevoProducto + " del objeto " + p);
			}else {
				mapConsolidadoListaCarrito.put(p, 1);
				System.out.println("Map tiene cantidad " + 1 + " del objeto " + p);
			}
		}
		
		System.out.println(mapConsolidadoListaCarrito);
		return mapConsolidadoListaCarrito;
	}

	private void cargarTableCarrito(Carrito c)
	{
		ObservableList<Carrito.ObjetoCarrito2> listaComprasObservable = 
				FXCollections.observableArrayList(c.getListaObjetosCarrito());
		tblColNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		tblColCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
		tblColPrecioUnitario.setCellValueFactory(new PropertyValueFactory<>("precio"));
		tblColMonto.setCellValueFactory(new PropertyValueFactory<>("monto"));
		
		tblColCantidad.setCellFactory(TextFieldTableCell.<Carrito.ObjetoCarrito2, Number>forTableColumn(new NumberStringConverter()));
		tblColCantidad.setOnEditCommit(
                new EventHandler<CellEditEvent<Carrito.ObjetoCarrito2, Number>>() {
                    @Override
                    public void handle(CellEditEvent<Carrito.ObjetoCarrito2, Number> t) {
                    	Carrito.ObjetoCarrito2 o = ((Carrito.ObjetoCarrito2) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        );
                        o.setCantidad(new SimpleIntegerProperty(t.getNewValue().intValue()));
//                        o.setMonto(new SimpleDoubleProperty(o.getCantidad()*o.getPrecio()));
//                        System.out.println("Monto es " + o.getMontoProperty());
                        
                    }
                }
        );
		
		tblCarrito.setItems(listaComprasObservable);
		
		calcularTotal(c);
	}
	
	private void calcularTotal(Carrito c) {
		SimpleDoubleProperty total = c.calcularTotal();
		lblTotal.setText(Double.toString(total.get()));
		
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
