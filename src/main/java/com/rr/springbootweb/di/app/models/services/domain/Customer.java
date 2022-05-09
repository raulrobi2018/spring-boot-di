package com.rr.springbootweb.di.app.models.services.domain;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

/*
 * Este ejemplo es a modo ilustrativo ya que @Component implementa el patrón Singleton
 * y por lo tanto no podríamos instanciar más de un Customer
 */
@Component
@SessionScope
public class Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5488506075957497033L;
	//Estos atributos se definen en el archivo application.properties
	@Value("${customer.name}")
	private String name;
	@Value("${customer.fullName}")
	private String fullName;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	
	
}
