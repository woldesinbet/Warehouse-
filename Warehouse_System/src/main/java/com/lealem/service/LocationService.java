package com.lealem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lealem.model.Location;
import com.lealem.repository.LocationRepository;
@Transactional
@Service
public class LocationService {
	@Autowired
	LocationRepository locationRepository;

	public void save(Location location) {
		this.locationRepository.save(location);
	}

	public List<Location> findAll() {
		return this.locationRepository.findAll();
	}
}
