package ec.edu.upse.facsistel.sistemas.progvisual1.s2018p2.ropa.model;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleDoubleProperty;

public class Carrito {

	private long id;
	private List<ObjetoCarrito> listaObjetosCarrito = new ArrayList<ObjetoCarrito>();
	private SimpleDoubleProperty total = new SimpleDoubleProperty();
	
	public Carrito(long id) {
		super();
		this.id = id;
	}
	
	public Carrito(long id, List<ObjetoCarrito> listaObjetosCarrito) {
		super();
		this.id = id;
		this.listaObjetosCarrito = listaObjetosCarrito;
	}
	
	public SimpleDoubleProperty calcularTotal()
	{
		Double totalCalculado = 0.0;
		for(ObjetoCarrito o: listaObjetosCarrito)
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

	public List<ObjetoCarrito> getListaObjetosCarrito() {
		return listaObjetosCarrito;
	}

	public void setListaObjetosCarrito(List<ObjetoCarrito> listaObjetosCarrito) {
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
