package ec.edu.upse.facsistel.sistemas.progvisual1.s2018p2.ropa.model;

public class Cliente {
	
	private String cedula;
	private String nombre;
	private String direccion;
	private String email;
	private String telefono;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(String cedula, String nombre, String direccion, String email, String telefono) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.direccion = direccion;
		this.email = email;
		this.telefono = telefono;
	}

	public Cliente(String cedula, String nombre) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
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

	public String getCedula() {
		return cedula;
	}

	@Override
	public String toString() {
		return "Cliente [cedula=" + cedula + ", nombre=" + nombre + ", direccion=" + direccion + ", email=" + email
				+ ", telefono=" + telefono + "]";
	}
	
	

}
