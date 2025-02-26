package com.devsenior.nmanja;

import com.devsenior.nmanja.calculadora.Inventory;
import com.devsenior.nmanja.calculadora.Product;

public class Main {
    public static void main(String[] args) {
       
        var inventory = new Inventory();

        inventory.addProduct(new Product("Arroz",1,550.17d));
        inventory.addProduct(new Product("Leche",4,650d));
        inventory.addProduct(new Product("Cafe",10,40d));
        inventory.addProduct(new Product("Pan",2,150d));
        inventory.addProduct(new Product("Cafe",2,150d));
        
        var allProducts = inventory.getInventory();

        for(var value : allProducts){
            System.out.println(value);
        }

        try {
            var product = inventory.getProduct("Cafe");
        System.out.printf("%s \t%d \t$ %,.2f", 
                product.getName(),product.getQuantify(),product.getPrice());

                product = inventory.getProduct("Pasta");
                System.out.printf("%s \t%d \t$ %,.2f", 
                product.getName(),product.getQuantify(),product.getPrice());
            
        } catch (NullPointerException e) {
            System.out.println("\nEl producto no existe");
        }

        var total = inventory.getTotalInventory();

        System.out.printf("El total es: $ %,.2f %n",total);

    }
}