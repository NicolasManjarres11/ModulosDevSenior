package com.devsenior.nmanja.demo_tutoria1_modulo6.model.dto;

public class ProductDto {

    private String name;
    private double price;

    public ProductDto(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductDto [name=" + name + ", price=" + price + "]";
    }
}
