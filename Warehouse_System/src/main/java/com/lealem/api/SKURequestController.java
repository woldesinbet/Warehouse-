package com.lealem.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lealem.model.SKUCreationRequest;
import com.lealem.service.SKUCreationRequestService;

@RestController
public class SKURequestController {

	@Autowired
	SKUCreationRequestService skuService;

	@PostMapping("/warehouse/skuCreationRequest")
	public SKUCreationRequest createSKUCreationRequest(@RequestBody SKUCreationRequest skuRequest) {
		return this.skuService.save(skuRequest);
	}

}
