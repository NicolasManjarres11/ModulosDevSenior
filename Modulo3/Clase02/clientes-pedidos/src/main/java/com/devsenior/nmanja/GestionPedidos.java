package com.devsenior.nmanja;

import java.util.ArrayList;
import java.util.List;

public class GestionPedidos {

    private List<Pedidos> pedidos;
    private GestionClientes clientes;

    

    public GestionPedidos(GestionClientes clientes) {
        pedidos = new ArrayList<>();
        this.clientes = clientes;
    }

    public void crearPedido(String clienteId, String producto, int cantidad) throws PedidoInvalidoException {

        

        try {
            var cliente =clientes.buscarCliente(clienteId);
        } catch (ClienteNoEncontradoException e) {
            throw new PedidoInvalidoException("No se encontro el cliente");
        }

        if(producto.isEmpty()){
            throw new PedidoInvalidoException("El producto no puede estar vacio");
        }

        if(cantidad <=0){
            throw new PedidoInvalidoException("La cantidad debe ser mayor a 0");

        }



        var pedido = new Pedidos(clienteId, producto, cantidad);
        pedidos.add(pedido);

    }

    public Pedidos buscarPedido(String clienteId, String producto){

        try {
            var cliente = clientes.buscarCliente(clienteId);
            
        } catch (ClienteNoEncontradoException e) {
            System.out.println("No se encontro el cliente");
        }

        

        for (Pedidos pedido : pedidos) {
            if(pedido.getClienteId().equals(clienteId) && pedido.getProducto().equals(producto)){
                return pedido;
                
            }
            
        }

        return null;

    }


}
