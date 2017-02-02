package com.lealem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lealem.model.SKU;
import com.lealem.model.SKUCreationRequest;
import com.lealem.repository.LocationRepository;
import com.lealem.service.SKUCreationRequestService;
import com.lealem.service.SKUService;

@RequestMapping("/sku")
@Controller
public class SkuControllerl {

	@Autowired
	SKUService skuService;

	@Autowired
	SKUCreationRequestService creationRequest;

	@Autowired
	LocationRepository locationRepository;

	@GetMapping("/details/{id}")
	public String displaySKU(@PathVariable("id") long id, Model model) {
		SKU sku = this.skuService.findOne(id);
		model.addAttribute("sku", sku);
		return "/sku/details";
	}

	
	@GetMapping("/create/{id}")
	public String displayCreateSKUForm(@PathVariable("id") long id, Model model) {
		SKUCreationRequest req = this.creationRequest.findOne(id);
		model.addAttribute("sku", new SKU());
		model.addAttribute("skucr", req);
		model.addAttribute("locations", this.locationRepository.findAll());
		return "/sku/create";
	}

	@PostMapping("/create/{id}")
	public String createSku(@PathVariable("id") long id, @Valid SKU sku, BindingResult bindingResult,Model model) {
		if (bindingResult.hasErrors()){
			System.out.println(bindingResult.getAllErrors());
			SKUCreationRequest req = this.creationRequest.findOne(id);
			model.addAttribute("sku", sku);
			model.addAttribute("skucr", req);
			model.addAttribute("locations", this.locationRepository.findAll());			
			return "/sku/create";
		}
		SKUCreationRequest req = this.creationRequest.findOne(id);
		req.setCreated(true);
		sku.setName(req.getName());
		sku.setDesribtion(req.getDesribtion());
		sku.setQuantitiy(req.getQuantitiy());
		this.skuService.save(sku);
		this.creationRequest.save(req);
		return "redirect:/sku/SKUs";
	}

	@GetMapping("/SKUs")
	public String allSKUs(Model model) {
		List<SKU> skus = this.skuService.findAll();
		model.addAttribute("skus", skus);
		return "/sku/SKUs";
	}

	@GetMapping("/SKUs/{id}")
	public String skuDetails(@PathVariable("id") long id, Model model) {
		SKU sku = this.skuService.findOne(id);
		model.addAttribute("sku", sku);
		return "/sku/details";
	}

	@GetMapping("/SKUCreationRequests")
	public String allSKUCreationRequest(Model model) {
		model.addAttribute("skus", this.creationRequest.findAllNew());
		return "/sku/SKUCreationRequests";
	}
	
	
}
