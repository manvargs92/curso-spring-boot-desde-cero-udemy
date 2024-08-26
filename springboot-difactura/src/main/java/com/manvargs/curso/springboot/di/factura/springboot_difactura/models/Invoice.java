package com.manvargs.curso.springboot.di.factura.springboot_difactura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

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

    /* Ciclo de vida del componente */
    @PostConstruct // indica que la siguiente fucnión se ejecutará al inicio del ciclo de vida del componente (cuando se crea)
    public void init() {
        System.out.println("Creando el componente de la factura");
        client.setName(client.getName().concat("JUANITO"));
        description = description.concat(" DEL CLIENTE: ").concat(client.getName()).concat(" ").concat(client.getLastname());
    }
    /****************************** */

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
