package com.techelevator;

import java.util.Date;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcReservationDao implements ReservationDao {
	private JdbcTemplate jdbcTemplate;

	public JdbcReservationDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int setReservation(int siteId, String name, Date startDate, Date endDate) {
		String sql = "INSERT INTO reservation (reservation_id, site_id, name, from_date, to_date, create_date) " +
				" VALUES(?, ?, ?, ?, ?, current_date);";
		
		int reservationID = getReservationId();
		int count = jdbcTemplate.update(sql, reservationID, siteId, name, startDate, endDate );
		
		if (count != 1){
			throw new RuntimeException("Unable to add reservation.");
		}
		return reservationID;
	}
	
	private int getReservationId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('reservation_reservation_id_seq')");
		if(nextIdResult.next()) {
			return nextIdResult.getInt(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new reservation");
		}
	}
	
	
	

}
