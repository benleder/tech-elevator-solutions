package com.techelevator.ssg.model.alien;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.techelevator.ssg.model.transport.Transport;

public enum Planet {

	MERCURY("Mercury", 87.96, 0.37, 56_974_146L),
	VENUS("Venus", 224.68, 0.90, 25_724_767L),
	MARS("Mars", 686.98, 0.38, 48_678_219L),
	JUPITER("Jupiter", 4329.63, 2.65, 390_674_710L),
	SATURN("Saturn", 10751.44, 1.13, 792_248_270L),
	URANUS("Uranus", 30685.55, 1.09, 1_692_662_530L),
	NEPTUNE("Neptune", 60155.65, 1.43, 2_703_959_960L);

	// Each planet has the following properties
	private final String planetName;
	private final double earthDaysPerYear;
	private final double earthRelativeGravity;
	private final long earthDistance;
	
	private Planet(String planetName, double earthDaysPerYear, double earthRelativeGravity, long earthDistance) {
		this.planetName = planetName;
		this.earthDaysPerYear = earthDaysPerYear;
		this.earthRelativeGravity = earthRelativeGravity;
		this.earthDistance = earthDistance;
	}
	
	public String getPlanetName() {
		return planetName;
	}
	// An immutable list of the planet names for display-purposes
	public static List<Planet> getAllPlanets() {
		return Collections.unmodifiableList(Arrays.asList(Planet.values()));
	}
	
	// Calculate the your age in terms of a named planet
	public static double calculateAlienAge(int earthYears, String planetName) {
		return (earthYears * 365) / Planet.valueOf(planetName).earthDaysPerYear; 
	}
	
	// Calculate the your weight in terms of a named planet
	public static double calculateAlienWeight(int earthWeight, String planetName) {
		return earthWeight * Planet.valueOf(planetName).earthRelativeGravity; 
	}
	
	/*
	 * Calculate the travel time in years to a named planet based upon a mode of transportation.
	 * 
	 * I feel justified in rounding up (ceiling) the hours and years. Stops for fuel, potty breaks, and just
	 * stretching your legs can really add up. Before you know it, you're a couple weeks, months, even years
	 * behind schedule. Better to build in some wiggle room.
	 */
	public static long calculateAlienTravelTime(String planetName, String transportName) {
		double hours = Math.ceil((double)Planet.valueOf(planetName).earthDistance / Transport.valueOf(transportName).getMPH());
		return (long)Math.ceil(hours / (365 * 24));
	}
	
}
