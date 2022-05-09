package com.rr.springbootweb.di.app.models.services;

import org.springframework.context.annotation.Primary;
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
//@Component("myComplexService")
//Se anota con Primary porque sino el IndexController no sabe cual implementación 
//de IService utilizar ya que existen dos. Si utilizamos @Qualifier en el Controller,
//también podemos ponerle un nombre al componente, como por ej. myMainService y 
//llamar a ese servicio en vez de utilizar @Primary
//@Primary
public class MyComplexService implements IService {
	
	@Override
	public String operation() {
		return "Running a process using DI with MyComplexService class...";
	}
}
