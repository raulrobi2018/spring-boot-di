package com.rr.springbootweb.di.app.models.services;

import org.springframework.stereotype.Component;


/**
 * 
 * Con la anotación @Component o @Service queda registrado como un pins de Spring. 
 * Este objeto se creará una sola vez, es un singleton, se distribuye en nuestra aplicación
 * y se puede inyectar en otros componentes.
 * 
 * La diferencia entre @Component y @Service es únicamente semántica. @Service es más
 * descriptivo y denota que es un servicio
 * 
 *  Se le puede dar un nombre para distinguirlo cuando lo llamamos.
 *  
 *  Spring internamente utilizara un patrón que se llama Service Locator que se encargará
 *  de registrar y localizar los componentes
 *
 */
//@Component("mySingleService")
//@Service
public class MyService implements IService {
	
	@Override
	public String operation() {
		return "Running a process using DI...";
	}
}
