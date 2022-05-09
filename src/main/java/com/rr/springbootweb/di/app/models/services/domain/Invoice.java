package com.rr.springbootweb.di.app.models.services.domain;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

/*
 * Este ejemplo es a modo de ejemplo ya que @Component implementa el patrón Singleton
 * y por lo tanto no podríamos instanciar más de un Invoice
 */
@Component

//Otro scope existente es el @ApplicationScope, la cual funciona igual a @Component pero no
//estará en el ApplicationContext del Spring sino en el ServletContext
//@ApplicationScope

//Con esta anotación, la clase Invoice va a durar lo que dura la petición http y ya
//no será singleton
//@RequestScope
//De la misma manera que podemos manejar con request scope, también tenemos con session scope
//la cual persistirá durante toda la conexión del usuario hasta que cierre el navegador
//o pierda la conexión por timeout. Pero para utilizar session debemos implementar la interfaz Serializable
@SessionScope
public class Invoice implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2605949955101211274L;
	@Value("${invoice.description}")
	private String description;
	@Autowired
	private Customer customer;
	@Autowired
	@Qualifier("invoiceLines2")
	//Otra forma de poner un calificador es ponerlo como default o usar @Primary
	//@Qualifier("default")
	private List<InvoiceLine> lines;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<InvoiceLine> getLines() {
		return lines;
	}
	public void setLines(List<InvoiceLine> lines) {
		this.lines = lines;
	}
	
	//Anotación que se utiliza para hacer algo luego de creado el objeto
	@PostConstruct
	public void init() {
		customer.setName(customer.getName().concat(" ").concat("Alberto"));
		description = description.concat(" of customer: ").concat(customer.getName());
	}
	
	//Anotación que se utiliza para hacer algo antes que se destruya
	@PreDestroy
	public void destroy() {
		System.out.println("Destroying invoice of ".concat(description));
	}
	
}
	