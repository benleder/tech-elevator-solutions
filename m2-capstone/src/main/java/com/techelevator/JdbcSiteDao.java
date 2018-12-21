package com.techelevator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcSiteDao implements SiteDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcSiteDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Site> getAvailableSites(int parkId, int campgroundId, Date startDate, Date endDate) {

		List<Site> items = new ArrayList<Site>();

	/**	String sql = "SELECT s.site_id, s.campground_id, s.site_number, s.max_occupancy, s.accessible, s.max_rv_length, s.utilities "
				+ "FROM site s, reservation r WHERE s.campground_id = ? AND s.site_id = r.site_id "
				+ "AND s.site_id IN (select site_id from reservation WHERE ? <= from_date "
				+ "OR ? >= to_date) " 
				+ "Union "
				+ "SELECT s.site_id, s.campground_id, s.site_number, s.max_occupancy, s.accessible, s.max_rv_length, "
				+ "s.utilities FROM site sWHERE s.campground_id = ? "
				+ "AND s.site_id NOT IN  (select site_id from reservation ) " 
				+ "order by site_id";
				**/
		
		String sql = "select site.site_id, campground_id, site_number, max_occupancy, accessible, max_rv_length, utilities "
        +"from site  "
        +"where site.campground_id = ? "
        +"group by site.site_id, campground_id, site_number, max_occupancy, accessible, max_rv_length, utilities "
        +"EXCEPT "
        +"select site.site_id, campground_id, site_number, max_occupancy, accessible, max_rv_length, utilities from site  "
        +"join reservation on site.site_id = reservation.site_id "
        +"where site.campground_id = ? "
        +"and not((? <= from_date) "
        +"or (? >= to_date)) "
        +"group by site.site_id, campground_id, site_number, max_occupancy, accessible, max_rv_length, utilities "
        +"order by 1;";
    

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, campgroundId, campgroundId, endDate, startDate);

		int count = 0;
		while (results.next() && count < 5) {
			Site item = new Site();
			item.setSiteId(results.getInt("site_id"));
			item.setCampgroundId(results.getInt("campground_id"));
			item.setSiteNumber(results.getInt("site_number"));
			item.setMaxOccupancy(results.getInt("max_occupancy"));
			item.setAccessible(results.getBoolean("accessible"));
			item.setMaxRvLength(results.getInt("max_rv_length"));
			item.setUtilities(results.getBoolean("utilities"));
			items.add(item);
			count++;
		}
		return items;
	}

	@Override
	public List<Site> getAllSites(Campground selectedCampground) {
		List<Site> items = new ArrayList<Site>();

		String sql = "SELECT s.site_id, s.campground_id, s.site_number, s.max_occupancy, s.accessible, s.max_rv_length, s.utilities "
				+ "FROM site s WHERE s.campground_id = ? ;";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, selectedCampground.getCampgroundId());

		while (results.next()) {
			Site item = new Site();
			item.setSiteId(results.getInt("site_id"));
			item.setCampgroundId(results.getInt("campground_id"));
			item.setSiteNumber(results.getInt("site_number"));
			item.setMaxOccupancy(results.getInt("max_occupancy"));
			item.setAccessible(results.getBoolean("accessible"));
			item.setMaxRvLength(results.getInt("max_rv_length"));
			item.setUtilities(results.getBoolean("utilities"));
			items.add(item);
		}
		return items;
	}
}
