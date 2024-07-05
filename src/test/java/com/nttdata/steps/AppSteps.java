package com.nttdata.steps;

import com.nttdata.screens.AppScreen;
import org.junit.Assert;


public class AppSteps {
    AppScreen app;

    public void verificarProducto() {
        app.verificarProductos();
    }

    public void seleccionarProductos(String producto,int cantidad){
        app.agregarProductoAlCarrito(producto,cantidad);
        app.compraProductos();
    }

    public void verificarCarrito(){
        app.verCarrito();
        app.comprobarCarrito();
    }
}
