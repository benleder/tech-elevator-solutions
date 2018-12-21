package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcParkDao implements ParkDao {
	private JdbcTemplate jdbcTemplate;

	//@Autowired
	public JdbcParkDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Park> getAllParks() {

		List<Park> items = new ArrayList<Park>();

		String sql = "SELECT park_id, name, location, establish_date, area, visitors, " 
				+ " description FROM park;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

		while (results.next()) {
			Park item = new Park();
			// get park id
			item.setParkId(results.getInt("park_id"));
			item.setName(results.getString("name"));
			item.setLocation(results.getString("location"));
			item.setEstablishDate(results.getDate("establish_date"));
			item.setArea(results.getInt("area"));
			item.setVisitors(results.getInt("visitors"));
			item.setDescription(results.getString("description"));
			items.add(item);
		}
		return items;
	}
	
	private int getParkId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('park_park_id_seq')");
		if(nextIdResult.next()) {
			return nextIdResult.getInt(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new department");
		}
	}

}