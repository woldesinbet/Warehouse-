package com.lealem.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lealem.model.SKU;

public interface SKURepository extends CrudRepository<SKU, Long> {
	List<SKU> findAll();
}
