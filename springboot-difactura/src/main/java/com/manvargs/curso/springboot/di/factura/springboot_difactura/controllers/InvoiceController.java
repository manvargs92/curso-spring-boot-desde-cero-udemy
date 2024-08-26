package com.manvargs.curso.springboot.di.factura.springboot_difactura.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manvargs.curso.springboot.di.factura.springboot_difactura.models.Client;
import com.manvargs.curso.springboot.di.factura.springboot_difactura.models.Invoice;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private Invoice invoice;

    @GetMapping("/detail")
    public Invoice detail() {
        Invoice inv = new Invoice();
        Client cli = new Client();

        cli.setLastname(invoice.getClient().getLastname());
        cli.setName(invoice.getClient().getName());
        inv.setClient(cli);
        inv.setDescription(invoice.getDescription());
        inv.setItems(invoice.getItems());

        // return invoice;
        return inv;
    }

}
