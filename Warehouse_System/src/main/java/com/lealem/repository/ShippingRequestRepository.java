package com.lealem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lealem.model.ShippingRequest;

public interface ShippingRequestRepository extends CrudRepository<ShippingRequest, Long> {

	@Query("SELECT r FROM ShippingRequest r WHERE r.status = com.lealem.model.ShipmentStatus.NEW")
	List<ShippingRequest> shipRequestsList();

	@Query("SELECT r FROM ShippingRequest r WHERE r.status = com.lealem.model.PICKED")
	List<ShippingRequest> peakRequestsList();

}
