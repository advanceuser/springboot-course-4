package com.luis.curso.springboot.di.factura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@RequestScope
//@JsonIgnoreProperties({ "targetSource", "advisors" })
public class Invoice {

	@Autowired
	private Client client;
	@Value("${invoice.description}")
	private String description;
	@Autowired
	@Qualifier("default")
	private List<Item> items;

	public Invoice() {
		System.out.println("Creando el componente de la factura  [Constructor]");
	}

	@PostConstruct
	public void init() {
		System.out.println("Creando el compomente de la factura [PostConstruct]");
		client.setName(client.getName().concat(" Pepe"));
		description = description.concat(" del cliente: ").concat(client.getName().concat(" "))
				.concat(client.getLastName());
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Destruyendo el componente o bean Invoice");
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public int getTotal() {
//		int total = 0;
//		for (Item item : items) {
//			total += item.getImport();
//		}
		int total = items.stream().map(item -> item.getImport()).reduce(0, (sum, importe) -> sum + importe);
		return total;
	}

}
