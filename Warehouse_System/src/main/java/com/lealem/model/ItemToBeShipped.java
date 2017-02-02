package com.lealem.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemToBeShipped {
	@Id
	private Long id;
	private int quantity;
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH })
	private SKU sku;

	@ManyToOne
	private ShippingRequest shippingRequest;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public SKU getSku() {
		return sku;
	}

	public void setSku(SKU sku) {
		this.sku = sku;
	}

	public ShippingRequest getShippingRequest() {
		return shippingRequest;
	}

	public void setShippingRequest(ShippingRequest shippingRequest) {
		this.shippingRequest = shippingRequest;
	}


}
