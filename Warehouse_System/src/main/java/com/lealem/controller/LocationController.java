package com.lealem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lealem.model.Location;
import com.lealem.service.LocationService;

@RequestMapping("/location")
@Controller
public class LocationController {
	@Autowired
	LocationService locationService;

	@GetMapping("/createLocation")
	public String displayAddLocationForm(@ModelAttribute("location") Location location) {
		return "/location/createLocation";
	}

	@PostMapping("/createLocation")
	public String addLocation(@Valid Location location, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "/location/createLocation";
		}
		this.locationService.save(location);
		return "redirect:/location/locations";
	}

	@GetMapping("/locations")
	public String getAll(Model model) {
		List<Location> locations = this.locationService.findAll();
		model.addAttribute("locations",locations);
		return "/location/locations";
	}
}
