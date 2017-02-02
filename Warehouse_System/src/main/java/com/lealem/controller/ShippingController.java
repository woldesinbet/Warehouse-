package com.lealem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lealem.model.ShipmentStatus;
import com.lealem.model.ShippingRequest;
import com.lealem.service.ShippingRequestService;

@RequestMapping("/shipment")
@Controller
public class ShippingController {
	@Autowired
	ShippingRequestService repo;

	@GetMapping("/shipRequestsList")
	public String shipRequestsList(Model model) {
		model.addAttribute("list", this.repo.shipRequestsList());
		return "/shipment/shipRequestsList";
	}

	@GetMapping("/peakRequestsList")
	public String peakRequestsList(Model model) {
		model.addAttribute("list", this.repo.peakRequestsList());
		return "/shipment/peakRequestsList";
	}

	@GetMapping("/peakItemsList/{id}")
	public String peakItemsList(@PathVariable("id") long id, Model model) {
		model.addAttribute("request", this.repo.findOne(id));
		return "/shipment/peakItemsList";
	}

	@PostMapping("/ship")
	public @ResponseBody void ship(Long id, Model model) {
		if(id == null){
			throw new RuntimeException("Id Cant be null.");
		}
		ShippingRequest req = this.repo.findOne(id);
		if (req.getStatus() == ShipmentStatus.SHIPPED || req.getStatus() == ShipmentStatus.NEW) {
			throw new RuntimeException("Ship request already shipped or not picked.");
		}
		req.ship();
		req = this.repo.save(req);
	}

	@PostMapping("/pick")
	public String pick(long requestId, Model model) {
		ShippingRequest req = this.repo.findOne(requestId);
		if (req.getStatus() == ShipmentStatus.PICKED || req.getStatus() == ShipmentStatus.SHIPPED) {
			throw new RuntimeException("Ship request already shipped or already picked.");
		}
		req.pick();
		req = this.repo.save(req);
		return "redirect:/shipment/peakRequestsList";
	}

}
