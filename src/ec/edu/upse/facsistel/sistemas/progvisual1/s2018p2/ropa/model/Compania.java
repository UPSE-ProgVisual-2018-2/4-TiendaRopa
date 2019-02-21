package ec.edu.upse.facsistel.sistemas.progvisual1.s2018p2.ropa.model;

public class Compania {
	
	private String ruc;
	private String nombre;
	private String direccion;
	private String representanteLegal;
	private String email;
	private String telefono;
	
	public Compania(String nombre, String ruc, String direccion) {
		super();
		this.nombre = nombre;
		this.ruc = ruc;
		this.direccion = direccion;
	}

	public Compania(String nombre, String ruc, String direccion, String representanteLegal, String email,
			String telefono) {
		super();
		this.nombre = nombre;
		this.ruc = ruc;
		this.direccion = direccion;
		this.representanteLegal = representanteLegal;
		this.email = email;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getRepresentanteLegal() {
		return representanteLegal;
	}

	public void setRepresentanteLegal(String representanteLegal) {
		this.representanteLegal = representanteLegal;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getRuc() {
		return ruc;
	}

	@Override
	public String toString() {
		return "Compania [nombre=" + nombre + ", ruc=" + ruc + ", direccion=" + direccion + ", email=" + email
				+ ", telefono=" + telefono + "]";
	}
	
	
}
