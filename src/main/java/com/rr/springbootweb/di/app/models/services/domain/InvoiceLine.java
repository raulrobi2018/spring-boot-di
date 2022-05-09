package com.rr.springbootweb.di.app.models.services.domain;

public class InvoiceLine {

	private Product product;
	private Integer quantity;
	
	public InvoiceLine (Product product, Integer quantity) {		
		this.product = product;
		this.quantity = quantity;
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Double calculateTotal () {
		return this.getProduct().getPrice() * this.getQuantity();
	}
	
}
