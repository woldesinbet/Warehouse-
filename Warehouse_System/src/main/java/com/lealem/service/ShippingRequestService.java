package com.lealem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lealem.model.ShippingRequest;
import com.lealem.repository.ShippingRequestRepository;

@Transactional
@Service
public class ShippingRequestService {
	@Autowired
	ShippingRequestRepository rep;

	public List<ShippingRequest> shipRequestsList() {
		return this.rep.shipRequestsList();
	}

	public List<ShippingRequest> peakRequestsList() {
		System.out.println(rep.peakRequestsList().size());
		return this.rep.peakRequestsList();
	}

	public ShippingRequest findOne(Long id) {
		return this.rep.findOne(id);
	}

	public ShippingRequest save(ShippingRequest request) {
		return this.rep.save(request);
	}
}
