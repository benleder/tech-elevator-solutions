package com.techelevator;

import java.util.Date;
import java.util.List;

public interface SiteDao {

	List<Site> getAvailableSites(int parkId, int campgroundId,  Date startDate,  Date endDate);
	List<Site> getAllSites(Campground selectedCampground);
}
