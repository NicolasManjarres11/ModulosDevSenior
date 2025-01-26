package com.devsenior.nmanja;



public class Pedidos {

    private String clienteId;
    private String producto;
    private int cantidad;

    public Pedidos(String clienteId, String producto, int cantidad) {

        this.clienteId = clienteId;
        this.producto = producto;
        this.cantidad = cantidad;

    }

    public String getClienteId() {
        return clienteId;
    }

    public String getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    


    
}
