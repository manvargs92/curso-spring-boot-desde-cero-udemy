package com.manvargs.curso.springboot.di.factura.springboot_difactura.models;

public class Item {

    private Integer quantity;

    private Product product;

    public Item() {
    }

    public Item(Integer quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getImporte() {
        return quantity * product.getPrice();
    }

}
