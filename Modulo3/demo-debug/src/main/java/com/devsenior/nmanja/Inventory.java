package com.devsenior.nmanja;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<Product> products;

    public Inventory() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void sellProduct(String name, Integer quantity) {

        //Producto existente
        var product = getProductByName(name);

        //Hay cantidad suficiente

        if(product.getStock() < quantity ){
            //Cantidad insuficiente
        }

        product.setStock(product.getStock()-quantity);


    }

    public Double calculateTotalProduct() {

        var total = 0d;

        for(var product : products){
            total+= product.getStock()*product.getPrice();
        }

        return total;

    }


    private Product getProductByName(String name) {
        


        for (var product : products){
            if(name.equalsIgnoreCase(product.getName())){
                return product;
            }

        }

        return null;
    }

    
}
