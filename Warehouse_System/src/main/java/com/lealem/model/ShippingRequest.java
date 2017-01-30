package com.lealem.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class ShippingRequest {
	@GeneratedValue
	@Id
	private Long id;
	@OneToMany(mappedBy = "shippingRequest", cascade = CascadeType.ALL)
	private List<ItemToBeShipped> items = new ArrayList<ItemToBeShipped>();
	@Enumerated(EnumType.STRING)
	private ShipmentStatus status;
	@NotEmpty
	private String destination;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ItemToBeShipped> getItems() {
		return items;
	}

	public void setItems(List<ItemToBeShipped> items) {
		this.items = items;
	}

	public ShipmentStatus getStatus() {
		return status;
	}

	public void setStatus(ShipmentStatus status) {
		this.status = status;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String address) {
		this.destination = address;
	}

}
