package ec.edu.pucem.facturacion.dominio;

public class Producto {
	private String nombre;
	private float precio;
	
	
	public Producto(){
		
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public float getPrecio() {
		return precio;
	}


	public void setPrecio(String precio) {
		this.precio = Float.parseFloat(precio);
	}
	
	@Override
    public String toString() {
        return nombre; // Mostrar nombre del producto en el JComboBox
    }
}
	