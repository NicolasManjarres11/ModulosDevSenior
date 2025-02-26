package com.devsenior.nmanja.calculadora;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Inventory {

    private Map<String,Product> products = new HashMap<>();

    public void addProduct(Product product){

        if(products.containsKey(product.getName().toUpperCase())){
            //Si el producto ya existe
            var oldProduct = products.get(product.getName().toUpperCase());
            var quantify = oldProduct.getQuantify();
            quantify += product.getQuantify();
            oldProduct.setQuantify(quantify);
        } else {
            products.put(product.getName().toUpperCase(),product);
        }
    }

    public Queue<String> getInventory(){

        Queue<String> response = new LinkedList<>();

        for (var key : products.keySet()) { //por cada mapa, dame el conjunto de las llaves
            var value = products.get(key);
            response.offer(String.format("%s \t%d \t$ %,.2f", 
                value.getName(),value.getQuantify(),value.getPrice()));
        }

        return response;

    }

    public Product getProduct(String name){

        

        return  products.get(name.toUpperCase());
    }

    public Double getTotalInventory(){

        var total = 0d;

        for (var product : products.values()) {

            total += product.getQuantify() * product.getPrice();
            
        }

        return total;

    }

}
