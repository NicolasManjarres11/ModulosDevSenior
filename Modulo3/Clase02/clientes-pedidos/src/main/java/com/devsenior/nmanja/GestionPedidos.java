package com.devsenior.nmanja;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GestionPedidos {

    private static final Logger LOG = LoggerFactory.getLogger(GestionPedidos.class);

    private List<Pedidos> pedidos;
    private GestionClientes clientes;

    

    public GestionPedidos(GestionClientes clientes) {

        LOG.debug("Creando una instancia de gestion de pedidos");
        pedidos = new ArrayList<>();
        this.clientes = clientes;
    }

    public void crearPedido(String clienteId, String producto, int cantidad) throws PedidoInvalidoException {

        
        LOG.trace("Llamando a crear pedido");
        LOG.debug("Los parametros son {} {} {}", new Object[] {clienteId,producto,cantidad});

        try {
            var cliente =clientes.buscarCliente(clienteId);
            LOG.debug("El cliente es: {}", cliente);
        } catch (ClienteNoEncontradoException e) {
            LOG.warn("Cliente no existe: {}",clienteId);
            throw new PedidoInvalidoException("No se encontro el cliente");
        }

        if(producto.isEmpty()){
            LOG.warn("Producto esta vacio");
            throw new PedidoInvalidoException("El producto no puede estar vacio");
        }

        if(cantidad <=0){
            LOG.warn("La cantidad es menos que 0");
            throw new PedidoInvalidoException("La cantidad debe ser mayor a 0");

        }



        var pedido = new Pedidos(clienteId, producto, cantidad);
        LOG.debug("Agregando pedido al sistema: {}",producto);
        pedidos.add(pedido);
        LOG.info("Pedido agregado con exito");

    }

    public Pedidos buscarPedido(String clienteId, String... producto){

        LOG.trace("Ingreso a buscar pedido");
        LOG.debug("Ingresa con los datos {} {}", clienteId, producto);

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

        LOG.warn("El pedido no existe");

        return null;

    }


}
