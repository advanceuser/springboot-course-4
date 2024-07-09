package com.luis.curso.springboot.di.factura.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luis.curso.springboot.di.factura.models.Client;
import com.luis.curso.springboot.di.factura.models.Invoice;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

	@Autowired
	private Invoice invoice;

	@GetMapping("/show")
	public Invoice show() {
		Invoice i = new Invoice();
		Client c = new Client();
		c.setName(invoice.getClient().getName());
		c.setLastName(invoice.getClient().getLastName());
		i.setClient(c);
		i.setDescription(invoice.getDescription());
		i.setItems(invoice.getItems());
		return i;
	}
}
