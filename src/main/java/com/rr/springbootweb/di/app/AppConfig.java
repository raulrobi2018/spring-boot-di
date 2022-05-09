package com.rr.springbootweb.di.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rr.springbootweb.di.app.models.services.IService;
import com.rr.springbootweb.di.app.models.services.MyComplexService;
import com.rr.springbootweb.di.app.models.services.MyService;
import com.rr.springbootweb.di.app.models.services.domain.InvoiceLine;
import com.rr.springbootweb.di.app.models.services.domain.Product;

/*
 * Esta es otra forma de registrar un componente. De esta forma no se necesita registrar
 * a la clase MyService con @Component.
 * 
 * ES IMPORTANTE QUE ESTA CLASE ESTÉ EN EL PACKAGE PRINCIPAL
 * 
 * Aquí también se puede configurar un componente como @Primary
 */
@Configuration
public class AppConfig {

	@Bean("mySingleService")
	public IService registerMyService() {
		return new MyService();
	}

	@Bean("myComplexService")
	public IService registerMyComplexService() {
		return new MyComplexService();
	}

	@Bean("invoiceLines")
	public List<InvoiceLine> registerInvoiceLines() {
		Product p1 = new Product("Product 1", 1500.0);
		Product p2 = new Product("Product 2", 5830.0);

		InvoiceLine l1 = new InvoiceLine(p1, 4);
		InvoiceLine l2 = new InvoiceLine(p2, 12);

		return Arrays.asList(l1, l2);
	}

	@Bean("invoiceLines2")
	//Si queremos hacer referencia al Bean defaulta, simplemente ponemos "default" en el Bean
	public List<InvoiceLine> registerSecondInvoiceLines() {
		Product p1 = new Product("Orange", 10.0);
		Product p2 = new Product("Apple", 22.0);
		Product p3 = new Product("Oinion", 13.0);
		Product p4 = new Product("Carrot", 5.0);
		Product p5 = new Product("Banana", 35.0);
		Product p6 = new Product("Letuce", 41.0);

		InvoiceLine l1 = new InvoiceLine(p1, 3);
		InvoiceLine l2 = new InvoiceLine(p2, 2);
		InvoiceLine l3 = new InvoiceLine(p3, 4);
		InvoiceLine l4 = new InvoiceLine(p4, 6);
		InvoiceLine l5 = new InvoiceLine(p5, 4);
		InvoiceLine l6 = new InvoiceLine(p6, 2);

		return Arrays.asList(l1, l2, l3, l4, l5, l6);
	}

}
