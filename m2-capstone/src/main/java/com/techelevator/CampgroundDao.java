package com.techelevator;

import java.util.List;

public interface CampgroundDao {
	List<Campground> getCampgroundsForPark(Park selectedPark);
}
