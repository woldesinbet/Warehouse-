package com.lealem.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.NaturalId;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SKUCreationRequest {
	@GeneratedValue
	@Id
	private Long id;
	@NaturalId
	private Long productId;
	@NotEmpty
	private String name;
	@NotNull
	private BigDecimal price;
	@NotEmpty	
	private String desribtion;	
	private int quantitiy;
	@JsonIgnore
	private boolean created;

	SKUCreationRequest() {
	}

	public SKUCreationRequest(Long productId, String name, BigDecimal price, String desribtion, int quantitiy) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.desribtion = desribtion;
		this.quantitiy = quantitiy;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDesribtion() {
		return desribtion;
	}

	public void setDesribtion(String desribtion) {
		this.desribtion = desribtion;
	}

	public int getQuantitiy() {
		return quantitiy;
	}

	public void setQuantitiy(int quantitiy) {
		this.quantitiy = quantitiy;
	}

	public boolean isCreated() {
		return created;
	}

	public void setCreated(boolean created) {
		this.created = created;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

}
