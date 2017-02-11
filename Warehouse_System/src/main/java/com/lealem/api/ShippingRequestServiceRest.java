package com.lealem.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lealem.model.ItemToBeShipped;
import com.lealem.model.SKU;
import com.lealem.model.ShippingRequest;
import com.lealem.service.SKUService;
import com.lealem.service.ShippingRequestService;

@RestController
public class ShippingRequestServiceRest {
	@Autowired
	ShippingRequestService shippingRequestService;
	@Autowired
	SKUService skuService;

	@PostMapping("/warehouse/shippingRequest")
	public CartRequested createShippingRequest(@RequestBody CartRequested cartRequested) {
		System.out.println("The warehouse sys is called.");
		System.out.println("Desitnation: " + cartRequested);
		ShippingRequest request = new ShippingRequest(cartRequested.getFullNameOfCutomer(), cartRequested.getDestination());
		for (ItemInRequestedCart item : cartRequested.getItems()) {
			SKU sku = this.skuService.findByProductId(item.getProductId());
			ItemToBeShipped itemToBeShipped = new ItemToBeShipped(sku, item.getQuantity());
			request.addItem(itemToBeShipped);
		}
		request = this.shippingRequestService.save(request);
		if(request !=null){
			return cartRequested;
		}
		return null;
	}
}
