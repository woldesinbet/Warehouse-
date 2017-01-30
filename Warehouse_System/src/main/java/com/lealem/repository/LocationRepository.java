package com.lealem.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lealem.model.Location;

public interface LocationRepository extends CrudRepository<Location, Long> {
	List<Location> findAll();
}
