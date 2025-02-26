package com.devsenior.nmanja.calculadora;

public class Product {

    private String name;
    private Integer quantify;
    private Double price;

    public Product() {
    }

    
    public Product(String name, Integer quantify, Double price) {
        this.name = name;
        this.quantify = quantify;
        this.price = price;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getQuantify() {
        return quantify;
    }
    public void setQuantify(Integer quantify) {
        this.quantify = quantify;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }


    

}
