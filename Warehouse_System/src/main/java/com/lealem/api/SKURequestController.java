package com.lealem.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lealem.model.SKUCreationRequest;
import com.lealem.service.SKUCreationRequestService;

@RestController("/warehouse")
public class SKURequestController {

	@Autowired
	SKUCreationRequestService skuService;

	
	@PutMapping("/skuCreationRequest")
	public SKUCreationRequest createSKUCreationRequest(@Valid SKUCreationRequest skuRequest) {
		return this.skuService.save(skuRequest);
	}

}
