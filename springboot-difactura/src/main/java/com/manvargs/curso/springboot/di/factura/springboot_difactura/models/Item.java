package com.manvargs.curso.springboot.di.factura.springboot_difactura.models;

public class Item {

    private int Quantity;

    private Product product;

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
