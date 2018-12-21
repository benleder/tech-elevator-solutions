package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcCampgroundDao implements CampgroundDao {
	private JdbcTemplate jdbcTemplate;

	public JdbcCampgroundDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Campground> getCampgroundsForPark(Park selectedPark){

		List<Campground> items = new ArrayList<Campground>();

		String sql = "SELECT campground_id, park_id, name, open_from_mm, open_to_mm, daily_fee FROM campground "
				+ " WHERE park_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, selectedPark.getParkId());

		while (results.next()) {
			Campground item = new Campground();
			item.setCampgroundId(results.getInt("campground_id"));
			item.setParkId(results.getInt("park_id"));
			item.setName(results.getString("name"));
			item.setOpenFromMonth(results.getInt("open_from_mm"));
			item.setOpenToMonth(results.getInt("open_to_mm"));
			item.setDailyFee(results.getBigDecimal("daily_fee"));
			items.add(item);
		}
		return items;
	}
}
