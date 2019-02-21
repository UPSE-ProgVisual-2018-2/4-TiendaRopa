package ec.edu.upse.facsistel.sistemas.progvisual1.s2018p2.ropa.model;

import java.time.LocalDate;

import application.Main;

public class Factura {
	
	public static long ultimoNumeroFactura;
	//Campos blablabla
	private LocalDate fechaEmision;
	private long numero;
	private Compania compania;
	
	public Factura() {
		fechaEmision = LocalDate.now();
		numero = ultimoNumeroFactura+1;
		ultimoNumeroFactura++;
		compania = Main.compania;
	}

	public void generarPDF(Carrito c)
	{
		class PDFGenerator{
			private String cabecera;
			private String contenido;
			private String pie;
			
			public PDFGenerator(String cabecera, String pie){
				this.cabecera = cabecera;
				this.pie = pie;
			}
			
			public void generarPDF(String contenido)
			{
				cabecera = compania.getNombre() +"\n"+ compania.getRuc()  + "\t\t"+ compania.getDireccion();
				System.out.println(numero);
				System.out.println(cabecera);
				System.out.println(contenido);
				pie = compania.getEmail() + "\n" + compania.getTelefono();
				System.out.println(pie);
			}
			
		}
		
		PDFGenerator generadorPDF = new PDFGenerator(compania.getNombre(), 
				compania.getDireccion() + compania.getTelefono());
		generadorPDF.generarPDF(c.toString());
	}
	
	
}
