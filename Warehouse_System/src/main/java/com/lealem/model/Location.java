package com.lealem.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Location {
	@GeneratedValue
	@Id
	private Long id;
	@NotEmpty
	private String building;
	@NotEmpty
	private String aisle;
	@NotEmpty
	private String palletRack;
	@NotEmpty
	private String floorStack;
	@OneToMany(mappedBy = "location")
	private List<SKU> skus = new LinkedList<>();

	public Location() {
	}

	public Location(String building, String floorStack, String aisle, String palletRack) {
		super();
		this.building = building;
		this.floorStack = floorStack;
		this.aisle = aisle;
		this.palletRack = palletRack;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getAisle() {
		return aisle;
	}

	public void setAisle(String aisle) {
		this.aisle = aisle;
	}

	public String getPalletRack() {
		return palletRack;
	}

	public void setPalletRack(String palletRack) {
		this.palletRack = palletRack;
	}

	public String getFloorStack() {
		return floorStack;
	}

	public void setFloorStack(String floorStack) {
		this.floorStack = floorStack;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isEmpty() {
		return this.skus.isEmpty();
	}

	public void addSKU(SKU sku) {
		this.skus.add(sku);
	}

	public void removeSKU(SKU sku) {
		this.skus.remove(sku);
	}

	public String getLocationNumber() {
		return this.building + "-" + this.aisle + "-" + this.palletRack + "-" + this.floorStack;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aisle == null) ? 0 : aisle.hashCode());
		result = prime * result + ((building == null) ? 0 : building.hashCode());
		result = prime * result + ((floorStack == null) ? 0 : floorStack.hashCode());
		result = prime * result + ((palletRack == null) ? 0 : palletRack.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (aisle == null) {
			if (other.aisle != null)
				return false;
		} else if (!aisle.equals(other.aisle))
			return false;
		if (building == null) {
			if (other.building != null)
				return false;
		} else if (!building.equals(other.building))
			return false;
		if (floorStack == null) {
			if (other.floorStack != null)
				return false;
		} else if (!floorStack.equals(other.floorStack))
			return false;
		if (palletRack == null) {
			if (other.palletRack != null)
				return false;
		} else if (!palletRack.equals(other.palletRack))
			return false;
		return true;
	}

}
