package com.rr.springbootweb.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rr.springbootweb.di.app.models.services.IService;
import com.rr.springbootweb.di.app.models.services.MyService;

@Controller
public class IndexController {

	/*
	 * Esto es un ejemplo de implementación de un servicio sin utilizar inyección de dependencia.
	 * El problema es que si no utilizamos DI el controlador queda muy acoplado
	 * La idea con el DI es que a través de una annotation se inyecte la instancia
	 * directamente en el método
	 */
	
	//Sin DI se utiliza así, creando una nueva instancia
	//private MyService service = new MyService();
	
	//Con DI se utiliza la anotación @Autowired
	//@Autowired
	//private MyService service;
	
	//Ahora utilizamos una interfaz y desacoplamos la utilización de clases
	
	@Autowired
	//Con @Qualifier indicamos cual es el componente que queremos 
	//inyectar mplementado por la interfaz 
	@Qualifier("myComplexService")
	private IService service;
	
	/*
	 * Esta es otra forma de inyectar pero mediante constructor
	 * Cuando se pasa un parámetro que está declarado como @Component, de forma automática
	 * Spring lo va a inyectar sin necesidad de declarar la anotación @Autowired. De todas
	 * maneras se lo pone igual para que quede claro
	 */
	/*@Autowired
	public IndexController(IService service) {
		this.service = service;
	}*/
	
	/*
	 * Otra forma de inyectar es mediante el método set
	 */
	/*@Autowired
	public void setService(IService service) {
		this.service = service;
	}*/
	
	//Declaramos 3 url a las que se puede acceder al index
	@GetMapping({"/", "", "/index"})
	public String index(Model model) {
		model.addAttribute("object", service.operation());
		return "index";
	}
	
}
