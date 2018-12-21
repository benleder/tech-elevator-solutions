package com.techelevator.ssg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.ssg.model.alien.Planet;
import com.techelevator.ssg.model.transport.Transport;

@Controller
public class AlienCalculatorController {

	@RequestMapping("/alienAge")
	public String alienAge(ModelMap modelMap) {
		modelMap.put("planets", Planet.getAllPlanets());
		return "alienAge";
	}
	
	@RequestMapping("/alienAgeResult")
	public String alienAgeResult(@RequestParam int earthAge, @RequestParam String planetName, ModelMap modelMap) {
		modelMap.put("earthAge", earthAge);
		modelMap.put("planetName", Planet.valueOf(planetName).getPlanetName());
		modelMap.put("alienAge", Planet.calculateAlienAge(earthAge, planetName));
		return "alienAgeResult";
	}

	@RequestMapping("/alienWeight")
	public String alienWeight(ModelMap modelMap) {
		modelMap.put("planets", Planet.getAllPlanets());
		return "alienWeight";
	}
	
	@RequestMapping("/alienWeightResult")
	public String alienWeightResult(@RequestParam int earthWeight, @RequestParam String planetName, ModelMap modelMap) {
		modelMap.put("earthWeight", earthWeight);
		modelMap.put("planetName", Planet.valueOf(planetName).getPlanetName());
		modelMap.put("alienWeight", Planet.calculateAlienWeight(earthWeight, planetName));
		return "alienWeightResult";
	}

	@RequestMapping("/alienTravelTime")
	public String alienTravelTime(ModelMap modelMap) {
		modelMap.put("planets", Planet.getAllPlanets());
		modelMap.put("transports", Transport.getAllTransports());
		return "alienTravelTime";
	}
	
	@RequestMapping("/alienTravelTimeResult")
	public String alienTravelTimeResult(@RequestParam String planetName, @RequestParam String transportName, @RequestParam int earthAge, ModelMap modelMap) {
		modelMap.put("planetName", Planet.valueOf(planetName).getPlanetName());
		modelMap.put("modeName", Transport.valueOf(transportName).getTransportName());
		long travelTimeInYears = Planet.calculateAlienTravelTime(planetName, transportName);
		modelMap.put("alienTravelTime", travelTimeInYears);
		modelMap.put("yourAge", earthAge + travelTimeInYears);
		return "alienTravelTimeResult";
	}
	
}
