package com.devsenior.nmanja;

public class Main {
    public static void main(String[] args) {
        
        var inventory = new Inventory();
        inventory.addProduct(new Product("arroz", 3, 50.0));
        inventory.addProduct(new Product("panela", 0, 33.0));

        inventory.sellProduct("arroz", 2);
        inventory.sellProduct("panela", 2);
        /* inventory.sellProduct("tablet", 2); */

        var total = inventory.calculateTotalProduct();
        System.out.printf("Valor total del inventario es: $ %.2f%n", total);

    }
}