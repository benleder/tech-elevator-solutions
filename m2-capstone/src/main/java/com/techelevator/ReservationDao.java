package com.techelevator;

import java.util.Date;

public interface ReservationDao {

	int setReservation(int siteId, String name, Date startDate, Date endDate);
}
