package com.lealem.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NaturalId;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class SKU {
	@GeneratedValue
	@Id
	private long id;
	@NaturalId
	private Long productId;
	private String name;
	private BigDecimal price;
	private String desribtion;
	private int quantitiy;

	public int getQuantitiy() {
		return quantitiy;
	}

	private long dimensions;
	private long weight;
	private long backorderAvg;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date deliveryTime;
	private String volumeMark;
	private String maxStackFloors;

	@ManyToOne
	private Location location;

	public SKU() {
	}

	public SKU(long id, String name, int quantity, BigDecimal price, String describtion) {
		this.id = id;
		this.name = name;
		this.quantitiy = quantity;
		this.price = price;
		this.desribtion = describtion;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public long getDimensions() {
		return dimensions;
	}

	public void setDimensions(long dimensions) {
		this.dimensions = dimensions;
	}

	public long getWeight() {
		return weight;
	}

	public void setWeight(long weight) {
		this.weight = weight;
	}

	public long getBackorderAvg() {
		return backorderAvg;
	}

	public void setBackorderAvg(long backorderAvg) {
		this.backorderAvg = backorderAvg;
	}

	public Date getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getVolumeMark() {
		return volumeMark;
	}

	public void setVolumeMark(String volumeMark) {
		this.volumeMark = volumeMark;
	}

	public String getMaxStackFloors() {
		return maxStackFloors;
	}

	public void setMaxStackFloors(String maxStackFloors) {
		this.maxStackFloors = maxStackFloors;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public void setQuantitiy(int quantitiy) {
		if (quantitiy <= 0) {
			throw new RuntimeException("Quantity should be greater than 0.");
		}
		this.quantitiy = quantitiy;
	}

	public void addQuantitiy(int quantity) {
		if (quantitiy <= 0) {
			throw new RuntimeException("Quantity should be greater than 0.");
		}
		this.quantitiy = this.quantitiy + quantity;
	}

	public void decreaseQuantitiy(int quantity) {
		if (quantitiy <= 0) {
			throw new RuntimeException("Quantity should be greater than 0.");
		}
		this.quantitiy = this.quantitiy - quantity;
	}

}
