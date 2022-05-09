package com.rr.springbootweb.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rr.springbootweb.di.app.models.services.domain.Invoice;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {

	@Autowired
	private Invoice invoice;

	@GetMapping("/details")
	public String details(Model model) {
		model.addAttribute("invoice", invoice);
		model.addAttribute("title", "Example Invoice using DI");
		return "invoice/details";
	}
}
