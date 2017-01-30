package com.lealem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lealem.model.SKUCreationRequest;

public interface SKUCreationRequestRepository extends CrudRepository<SKUCreationRequest, Long> {
	List<SKUCreationRequest> findAll();
	@Query("SELECT p FROM SKUCreationRequest p WHERE p.created = false")
	List<SKUCreationRequest> findAllNew();
}
