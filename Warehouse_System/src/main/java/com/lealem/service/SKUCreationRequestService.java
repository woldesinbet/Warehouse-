package com.lealem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lealem.model.SKUCreationRequest;
import com.lealem.repository.SKUCreationRequestRepository;

@Service
public class SKUCreationRequestService {
	@Autowired
	SKUCreationRequestRepository repo;

	public SKUCreationRequest save(SKUCreationRequest skuCrtReq) {
		return this.repo.save(skuCrtReq);
	}

	public List<SKUCreationRequest> fndAll() {
		return this.repo.findAll();
	}

	public List<SKUCreationRequest> findAllNew() {
		return this.repo.findAllNew();
	}

	public SKUCreationRequest findOne(long id) {		
		return this.repo.findOne(id);
	}

}
