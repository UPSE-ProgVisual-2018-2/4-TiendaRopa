package ec.edu.upse.facsistel.sistemas.progvisual1.s2018p2.ropa.model;

public class Producto {
	protected long id;
	protected double precio;
	protected String nombre;
	protected String marca;
	protected String descripcion;
	protected Genero generoObjetivo;
	protected String urlImagen;
	public static final double TASAIMPUESTO = 0.12;
	
	public Producto(long id, String nombre, double precio) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.generoObjetivo = Genero.NINGUNO;
	}
	
	

	public Producto(long id, double precio, String nombre, String descripcion, String urlImagen) {
		super();
		this.id = id;
		this.precio = precio;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.urlImagen = urlImagen;
	}



	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Genero getGeneroObjetivo() {
		return generoObjetivo;
	}

	public void setGeneroObjetivo(Genero generoObjetivo) {
		this.generoObjetivo = generoObjetivo;
	}

	public long getId() {
		return id;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	@Override
	public String toString() {
		return  "ID: " + id + " - " + nombre;
	}

	
}
