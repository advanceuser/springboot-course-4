package com.luis.curso.springboot.di.factura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.luis.curso.springboot.di.factura.models.Item;
import com.luis.curso.springboot.di.factura.models.Product;

@Configuration
@PropertySource("classpath:data.properties")
public class AppConfig {

	//@Primary
	@Bean("default")
	List<Item> itemsInvoice() {
		Product p1 = new Product("Camara Sony", 800);
		Product p2 = new Product("Bicicleta Bianchi 26", 1200);
		return Arrays.asList(new Item(p1, 2), new Item(p2, 4));
	}

	@Bean
	List<Item> itemsInvoiceOffice() {
		Product p1 = new Product("Monitor Asus 24", 700);
		Product p2 = new Product("Notebook Razer", 2400);
		Product p3 = new Product("Impresora HP", 800);
		Product p4 = new Product("Escritorio oficina", 900);
		return Arrays.asList(new Item(p1, 4), new Item(p2, 6), new Item(p3, 1), new Item(p4, 4));
	}
}
