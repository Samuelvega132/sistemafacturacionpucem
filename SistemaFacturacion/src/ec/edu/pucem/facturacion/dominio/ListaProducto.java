package ec.edu.pucem.facturacion.dominio;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class ListaProducto {
    private List<Producto> datosProductos;

    public ListaProducto() {
        this.datosProductos = new ArrayList<>();
    }

    public List<Producto> getListaProductos() {
        return datosProductos;
    }

    public void agregarProducto(Producto producto) {
        datosProductos.add(producto);
    }


}