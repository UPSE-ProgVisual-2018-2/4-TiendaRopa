package ec.edu.upse.facsistel.sistemas.progvisual1.s2018p2.ropa.model;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Carrito {

	public static long TOTAL_GLOBAL_CARRITOS = 0;
	private long id;
	private Cliente c;
	private List<ObjetoCarrito2> listaObjetosCarrito = new ArrayList<ObjetoCarrito2>();
	private SimpleDoubleProperty total = new SimpleDoubleProperty();

	private class Envio {
		private String direccion;
		
	}
	
 	public static class ObjetoCarrito2{
		private Producto p;
		private SimpleStringProperty nombre;
		private SimpleDoubleProperty precio;
		private SimpleIntegerProperty cantidad;
		private SimpleDoubleProperty monto;
		
		public ObjetoCarrito2(Producto p, Integer cantidad) {
			super();
			this.p = p;
			this.cantidad = new SimpleIntegerProperty(cantidad);
			this.nombre = new SimpleStringProperty(p.getNombre());
			this.precio = new SimpleDoubleProperty(p.getPrecio());
			this.monto = new SimpleDoubleProperty();
			NumberBinding multiplicacionPrecioCantidad = Bindings.multiply(this.getCantidadProperty(), this.getPrecioProperty());
			this.getMontoProperty().bind(multiplicacionPrecioCantidad);
		}
		
		public Producto getP() {
			return p;
		}
		
		public void setP(Producto p) {
			this.p = p;
		}

		public String getNombre() {
			return nombre.get();
		}
		
		public SimpleStringProperty getNombreProperty() {
			return nombre;
		}

		public void setNombre(SimpleStringProperty nombre) {
			this.nombre = nombre;
		}

		public Double getPrecio() {
			return precio.get();
		}
		
		public SimpleDoubleProperty getPrecioProperty() {
			return precio;
		}

		public void setPrecio(SimpleDoubleProperty precio) {
			this.precio = precio;
		}

		public int getCantidad() {
			return cantidad.get();
		}
		
		public SimpleIntegerProperty getCantidadProperty() {
			return cantidad;
		}

		public void setCantidad(SimpleIntegerProperty cantidad) {
			System.out.println("Cantidad Seteada a: " + cantidad.get());
			this.cantidad = cantidad;
		}


		public double getMonto() {
			return monto.get();
		}
		
		public SimpleDoubleProperty getMontoProperty() {
			return monto;
		}

		public void setMonto(SimpleDoubleProperty monto) {
			System.out.println("Monto Seteado a: " + monto.get());
			this.monto = monto;
		}

		@Override
		public String toString() {
			return "ObjetoCarrito [p=" + p + ", cantidad=" + cantidad + "]";
		}
		
		public long metodo()
		{
			return TOTAL_GLOBAL_CARRITOS;
		}

	}
	
	public Carrito(long id) {
		super();
		this.id = id;
	}

	public Carrito(long id, List<ObjetoCarrito2> listaObjetosCarrito) {
		super();
		this.id = id;
		this.listaObjetosCarrito = listaObjetosCarrito;
	}

	public SimpleDoubleProperty calcularTotal()
	{
		Double totalCalculado = 0.0;
		for(ObjetoCarrito2 o: listaObjetosCarrito)
		{
			totalCalculado = Double.sum(totalCalculado, o.getMonto());
		}
		this.total = new SimpleDoubleProperty(totalCalculado);
		return this.total;	
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<ObjetoCarrito2> getListaObjetosCarrito() {
		return listaObjetosCarrito;
	}

	public void setListaObjetosCarrito(List<ObjetoCarrito2> listaObjetosCarrito) {
		this.listaObjetosCarrito = listaObjetosCarrito;
	}

	public double getTotal() {
		return total.get();
	}

	public SimpleDoubleProperty getTotalProperty() {
		return total;
	}

	@Override
	public String toString() {
		return "Carrito [id=" + id + ", listaObjetosCarrito=" + listaObjetosCarrito + "]";
	}



}
