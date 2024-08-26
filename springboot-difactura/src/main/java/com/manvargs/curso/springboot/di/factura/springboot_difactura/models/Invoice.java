package com.manvargs.curso.springboot.di.factura.springboot_difactura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
// @ApplicationScope // scope del componente; será compartido por todos los usuarios de la aplicación; el scope es mas amplio que el de un singleton (una sola aplicación)
@RequestScope // scope del componente; se generará un proxy por cada request y ya no será compartido por toda la aplicación, el cual será inyectado en el InvoiceController
// @JsonIgnoreProperties({"targetSource", "advisors"}) // ignorar los atributos del JSON, en este caso los atributos que genera el proxy
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
    @PostConstruct // indica que la siguiente función se ejecutará al inicio del ciclo de vida del componente (cuando se crea)
    public void init() {
        System.out.println("Creando el componente de la factura");
        client.setName(client.getName().concat("JUANITO"));
        description = description.concat(" DEL CLIENTE: ").concat(client.getName()).concat(" ").concat(client.getLastname());
    }

    @PreDestroy // indica ejecutar la función antes de destruir el componente o bean, esto sirve para ejecutar una tarea como puede ser, cerrar un recurso o una conexión a BD
    public void destroy() {
        System.out.println("Destruyendo el componente o bean Invoice...");
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
