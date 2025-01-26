package com.devsenior.nmanja;

public class Main {
    public static void main(String[] args) {
        var clientes = new GestionClientes();

        clientes.registrarCliente("1", "Nicolas");
        clientes.registrarCliente("2", "Dayana");
        clientes.registrarCliente("3", "Cerati");

        var pedidos = new GestionPedidos(clientes);

        try{

        pedidos.crearPedido("1", "Perro", 4);
        pedidos.crearPedido("2", "Manzada", 8);
        pedidos.crearPedido("5", "Panela", 10);
        } catch(PedidoInvalidoException e){
            System.out.println("Ocurrio un error al gestionar el pedido\n\t" + e.getMessage());
        }

        System.out.println("Gracias por usar nuestro servicio");
    }
}