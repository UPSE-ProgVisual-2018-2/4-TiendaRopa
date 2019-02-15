package ec.edu.upse.facsistel.sistemas.progvisual1.s2018p2.ropa.model;

import java.time.LocalDate;
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
	private Envio envio;

	
	public class Envio {
		private int codigoGuia;
		private String destinatario;
		private String telefonoDestinatario;
		private String direccion;
		private String ciudad;
		private String pais = "Ecuador";
		private String codigoPostal;
		private LocalDate fechaEnvio = LocalDate.now(), fechaEstimadaLlegada; 
		private double peso;
		private double longitudCentimetros, altoCentimetros, anchoCentimetros;
		private double precioEnvio = 3.0;
		private CompaniaEnvio courrier = getCorreosDelEcuador();
		
		public final CompaniaEnvio ServiEntrega = new CompaniaEnvio("Servientrega");
		public final CompaniaEnvio CorreosDelEcuador = new CompaniaEnvio("Correos del Ecuador");
		public final CompaniaEnvio TramacoExpress = new CompaniaEnvio("Tramaco Express");
		
		public class CompaniaEnvio{
			private String nombreCompania;
			
			CompaniaEnvio(String nombreCompania)
			{
				this.nombreCompania = nombreCompania;
			}
		}

		
		
		public Envio(int codigoGuia, LocalDate fechaEnvio) {
			this.codigoGuia = codigoGuia;
			this.fechaEnvio = fechaEnvio;
			this.direccion = c.getDireccion();
			this.destinatario = c.getNombre();
			this.telefonoDestinatario = c.getTelefono();
		}


		public Envio(int codigoGuia, String destinatario, String telefonoDestinatario, String direccion, String ciudad,
				String pais, String codigoPostal) {
			this.codigoGuia = codigoGuia;
			this.destinatario = destinatario;
			this.telefonoDestinatario = telefonoDestinatario;
			this.direccion = direccion;
			this.ciudad = ciudad;
			this.pais = pais;
			this.codigoPostal = codigoPostal;
			this.courrier = courrier;
		}


		public int getCodigoGuia() {
			return codigoGuia;
		}

		public void setCodigoGuia(int codigoGuia) {
			this.codigoGuia = codigoGuia;
		}

		public String getDestinatario() {
			return destinatario;
		}

		public void setDestinatario(String destinatario) {
			this.destinatario = destinatario;
		}

		public String getTelefonoDestinatario() {
			return telefonoDestinatario;
		}

		public void setTelefonoDestinatario(String telefonoDestinatario) {
			this.telefonoDestinatario = telefonoDestinatario;
		}

		public String getDireccion() {
			return direccion;
		}

		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}

		public String getCiudad() {
			return ciudad;
		}

		public void setCiudad(String ciudad) {
			this.ciudad = ciudad;
		}

		public String getPais() {
			return pais;
		}

		public void setPais(String pais) {
			this.pais = pais;
		}

		public String getCodigoPostal() {
			return codigoPostal;
		}

		public void setCodigoPostal(String codigoPostal) {
			this.codigoPostal = codigoPostal;
		}

		public LocalDate getFechaEnvio() {
			return fechaEnvio;
		}

		public void setFechaEnvio(LocalDate fechaEnvio) {
			this.fechaEnvio = fechaEnvio;
		}

		public LocalDate getFechaEstimadaLlegada() {
			return fechaEstimadaLlegada;
		}

		public void setFechaEstimadaLlegada(LocalDate fechaEstimadaLlegada) {
			this.fechaEstimadaLlegada = fechaEstimadaLlegada;
		}

		public double getPeso() {
			return peso;
		}

		public void setPeso(double peso) {
			this.peso = peso;
		}

		public double getLongitudCentimetros() {
			return longitudCentimetros;
		}

		public void setLongitudCentimetros(double longitudCentimetros) {
			this.longitudCentimetros = longitudCentimetros;
		}

		public double getAltoCentimetros() {
			return altoCentimetros;
		}

		public void setAltoCentimetros(double altoCentimetros) {
			this.altoCentimetros = altoCentimetros;
		}

		public double getAnchoCentimetros() {
			return anchoCentimetros;
		}

		public void setAnchoCentimetros(double anchoCentimetros) {
			this.anchoCentimetros = anchoCentimetros;
		}

		public double getPrecioEnvio() {
			return precioEnvio;
		}

		public void setPrecioEnvio(double precioEnvio) {
			this.precioEnvio = precioEnvio;
		}

		public CompaniaEnvio getCourrier() {
			return courrier;
		}

		public void setCourrier(CompaniaEnvio courrier) {
			this.courrier = courrier;
		}

		public CompaniaEnvio getServiEntrega() {
			return ServiEntrega;
		}

		public CompaniaEnvio getCorreosDelEcuador() {
			return CorreosDelEcuador;
		}

		public CompaniaEnvio getTramacoExpress() {
			return TramacoExpress;
		}


		@Override
		public String toString() {
			return "Envio [codigoGuia=" + codigoGuia + ", destinatario=" + destinatario + ", telefonoDestinatario="
					+ telefonoDestinatario + ", direccion=" + direccion + ", ciudad=" + ciudad + ", pais=" + pais
					+ ", codigoPostal=" + codigoPostal + ", fechaEnvio=" + fechaEnvio + ", courrier=" + courrier + "]";
		}
		
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
	
	public void enviarCarrito()
	{
		envio = new Envio(1234123, LocalDate.now().plusDays(1));
	}

	public Cliente getC() {
		return c;
	}

	public void setC(Cliente c) {
		this.c = c;
	}

	public Envio getEnvio() {
		return envio;
	}

	@Override
	public String toString() {
		return "Carrito [id=" + id + ", listaObjetosCarrito=" + listaObjetosCarrito + "]";
	}



}
