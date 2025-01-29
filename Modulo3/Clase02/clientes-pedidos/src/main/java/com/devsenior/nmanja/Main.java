package com.devsenior.nmanja;

import org.apache.logging.log4j.LogManager;

public class Main {
    public static void main(String[] args) {

         var log = LogManager.getLogger(Main.class);   //Llamamos al administrador de Logger, llamamos el método get y colocamos como parámetro Main.class

         log.info("Inicia la ejecucion del programa");


        var clientes = new GestionClientes();

        log.debug("Registrando el cliente (1, Nicolas)");
        clientes.registrarCliente("1", "Nicolas");
        log.info("Se creo el cliente Nicolas");

        log.debug("Registrando el cliente (2, Dayana)");
        clientes.registrarCliente("2", "Dayana");
        log.info("Se creo el cliente Nicolas");

        log.debug("Registrando el cliente (3, Cerati)");
        clientes.registrarCliente("3", "Cerati");
        log.info("Se creo el cliente Cerati");

        var pedidos = new GestionPedidos(clientes);

        try{

            
        log.debug("Creando el pedido (1, perro, 4)");
        pedidos.crearPedido("1", "Perro", 4);
        log.debug("Creando el pedido (2, manzana, 8)");
        pedidos.crearPedido("2", "Manzada", 8);
        log.debug("Creando el pedido (5, panela, 10)");
        pedidos.crearPedido("5", "Panela", 10);
        } catch(PedidoInvalidoException e){
            log.warn("No se pudo agregar uno de los pedidos",e);
            System.out.println("Ocurrio un error al gestionar el pedido\n\t" + e.getMessage());
        }

        System.out.println("Gracias por usar nuestro servicio");


        log.info("Salio de la aplicacion");

    }
}