package com.manvargs.curso.springboot.di.factura.springboot_difactura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Invoice {

    @Value("${invoice.description.office}")
    // @Value("${invoice.description}")
    private String description;

    @Autowired
    @Qualifier("invoiceOfficeItems")
    private List<Item> items;

    @Autowired
    private Client client;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Autowired
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getTotal() {
        // int total = 0;
        // for (Item item : items) {
        //     total += item.getImporte();
        // }

        int total = items.stream()
        .map(item -> item
        .getImporte())
        .reduce(0, (subTotal, importe) -> subTotal + importe);

        return total;
    }

}
