package com.techelevator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import org.apache.commons.dbcp2.BasicDataSource;

public class CampgroundCLI {

	private static final String PARK_DETAIL_MENU_OPTION_VIEW_CAMPGROUNDS = "View Campgrounds";
	private static final String PARK_DETAIL_MENU_OPTION_SEARCH_FOR_RESERVATION = "Search for Reservation";
	private static final String PARK_DETAIL_MENU_OPTION_BACK = "Return to Previous Screen";
	private static final String[] PARK_DETAIL_MENU_OPTIONS = new String[] { PARK_DETAIL_MENU_OPTION_VIEW_CAMPGROUNDS,
			PARK_DETAIL_MENU_OPTION_SEARCH_FOR_RESERVATION, PARK_DETAIL_MENU_OPTION_BACK };

	private static final String VIEW_CAMPGROUNDS_MENU_OPTION_VIEW_CAMPSITES = "View all Campsites";
	private static final String VIEW_CAMPGROUNDS_MENU_OPTION_SEARCH_AVAILABLE = "Search for Available Reservation";
	private static final String VIEW_CAMPGROUNDS_MENU_OPTION_BACK = "Return to Previous Screen";
	private static final String[] VIEW_CAMPGROUNDS_MENU_OPTIONS = new String[] { VIEW_CAMPGROUNDS_MENU_OPTION_VIEW_CAMPSITES,
			VIEW_CAMPGROUNDS_MENU_OPTION_SEARCH_AVAILABLE, VIEW_CAMPGROUNDS_MENU_OPTION_BACK };

	private Menu menu;
	private ParkDao parkDao;
	private CampgroundDao campgroundDao;
	private SiteDao siteDao;
	private ReservationDao reservationDao;

 	public static void main(String[] args) {
		CampgroundCLI application = new CampgroundCLI();
		application.run();
	}

	public CampgroundCLI() {
		this.menu = new Menu(System.in, System.out);

		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/national_parks");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");

		parkDao = new JdbcParkDao(dataSource);
		campgroundDao = new JdbcCampgroundDao(dataSource);
		siteDao = new JdbcSiteDao(dataSource);
		reservationDao = new JdbcReservationDao(dataSource);
	}

	public void run() {
		while (true) {
			handleMainMenu();
		}
	}

	private void handleMainMenu() {
		Utility.clear();
		displayApplicationBanner();
		printMultiHeading("Main Menu\nView Parks Interface", "Select a Park for Further Details");
		List<Park> getAllParks = parkDao.getAllParks();
		Object response = menu.getChoiceFromOptions(getAllParks.toArray(), 'Q');
		
		if (response.toString().toUpperCase().equals("Q")) {
			System.exit(0);
		}
		Park selectedPark = (Park) response;
		handleParkDetails(selectedPark);
	}

	private void handleParkDetails(Park slectedPark) {
		Utility.clear();
		displayApplicationBanner();
		printHeading("Park Details");

		System.out.println("Id: " + slectedPark.getParkId());
		System.out.println("Name: " + slectedPark.getName());
		System.out.println("Location: " + slectedPark.getLocation());
		System.out.println("Established: " + slectedPark.getEstablishDate());
		System.out.println("Area: " + slectedPark.getArea());
		System.out.println("Visitors: " + slectedPark.getVisitors());
		System.out.println("Description: " + Utility.formatter(slectedPark.getDescription(), 13));

		printHeading("Select action");
		String choice = (String) menu.getChoiceFromOptions(PARK_DETAIL_MENU_OPTIONS);
		if (choice.equals(PARK_DETAIL_MENU_OPTION_VIEW_CAMPGROUNDS)) {
			handleViewCampgrounds(slectedPark);
		} else if (choice.equals(PARK_DETAIL_MENU_OPTION_SEARCH_FOR_RESERVATION)) {
			handleSearchForReservation(slectedPark);
		} else if (choice.equals(PARK_DETAIL_MENU_OPTION_BACK)) {
			return;
		}
	}

	private void handleSearchForReservation(Park selectedPark) {

		Utility.clear();
		displayApplicationBanner();

		printMultiHeading("Park Campgrounds", selectedPark.getName());
		System.out.printf("%-4s", "");
		System.out.printf("%-35s", "Name");
		System.out.printf("%-10s", "Open");
		System.out.printf("%-10s", "");
		System.out.printf("%-10s", "Nightly Rate");
		System.out.println();

		List<Campground> getCampgroundsForPark = campgroundDao.getCampgroundsForPark(selectedPark);
		for (Campground item : getCampgroundsForPark) {
			System.out.print("#" + item.getCampgroundId() + "  ");
			System.out.printf("%-35s", item.getName());
			System.out.printf("%-10s", Utility.month(item.getOpenFromMonth()));
			System.out.printf("%-10s", Utility.month(item.getOpenToMonth()));
			System.out.printf("%6.2f", item.getDailyFee());
			System.out.println();
		}

		printHeading("Search For Reservation at " + selectedPark.getName());
		String userInput = getUserInput("Which campground (enter 0 to cancel)? ");
		int campgroundNumber = Integer.parseInt(userInput);
		if (campgroundNumber == 0) {
			return;
		}

		userInput = getUserInput("What is the arrival date? (mm/dd/yyyy) ");
		Date startDate = Utility.toDate(userInput);
		
		userInput = getUserInput("What is the departure date? (mm/dd/yyyy) ");
		Date endDate = Utility.toDate(userInput);
		
		handleSearchForReservationDetail(selectedPark.getParkId(), campgroundNumber, startDate, endDate);
	}

	private void handleSearchForReservationDetail(int parkId, int campgroundId, Date startDate, Date endDate) {
		Utility.clear();
		displayApplicationBanner();
		List<Site> getAvailableSites = siteDao.getAvailableSites(parkId, campgroundId,  startDate,  endDate);
		if(getAvailableSites.size() == 0) {
			getUserInput("No sites found. Press Enter to continue.");
			return;
		}
		printHeading("Select site to reserve");
		System.out.print(Site.toStringHeader());
		Object response = menu.getChoiceFromOptions(getAvailableSites.toArray(), 'B');
		if (response.toString().toUpperCase().equals("B")) {
			return;
		}
		Site selectedSite = (Site) response;
		handleMakeReservation( parkId,  campgroundId,  selectedSite.getSiteId(),  startDate,  endDate);
	}

	private void handleMakeReservation(int parkId, int campgroundId, int siteId, Date startDate, Date endDate) {
		
		String userInput = getUserInput("What name should the reservation be made under?");
		int reservationResult = reservationDao.setReservation(siteId, userInput, startDate, endDate);
		
		userInput = getUserInput("The reservation has been made and the " +
		"confirmation id is " + reservationResult + ". Press Enter to continue. ");
	}

	private void handleViewCampgrounds(Park selectedPark) {
		Utility.clear();
		displayApplicationBanner();

		printMultiHeading("Park Campgrounds", selectedPark.getName());
		
		System.out.print(Campground.toStringHeader());
		List<Campground> getCampgroundsForPark = campgroundDao.getCampgroundsForPark(selectedPark);
		for (Campground item : getCampgroundsForPark) {
			System.out.print(item.toString());
		}

		printHeading("Select a command");
		String choice = (String) menu.getChoiceFromOptions(VIEW_CAMPGROUNDS_MENU_OPTIONS);
		if (choice.equals(VIEW_CAMPGROUNDS_MENU_OPTION_VIEW_CAMPSITES)) {
			handleViewAllCampsites(selectedPark);
		}if (choice.equals(VIEW_CAMPGROUNDS_MENU_OPTION_SEARCH_AVAILABLE)) {
			handleSearchForReservation(selectedPark);
		} else if (choice.equals(PARK_DETAIL_MENU_OPTION_BACK)) {
			return;
		}
	}

	private void handleViewAllCampsites(Park selectedPark) {
		Utility.clear();
		displayApplicationBanner();
		printHeading("All campsites");
		System.out.print(Site.toStringHeader());
		List<Campground> getCampgroundsForPark = campgroundDao.getCampgroundsForPark(selectedPark);

		Object response = menu.getChoiceFromOptions(getCampgroundsForPark.toArray(), 'B');
		if (response.toString().toUpperCase().equals("B")) {
			return;
		}
		
		Campground selectedCampground = (Campground)response;
		
		List<Site> allCampsites = siteDao.getAllSites(selectedCampground);
		
		System.out.print(Campground.toStringHeader());
		for (Site item: allCampsites) {
			item.toString();
		}
		
		String choice = (String) menu.getChoiceFromOptions(VIEW_CAMPGROUNDS_MENU_OPTIONS);
		if (choice.equals(VIEW_CAMPGROUNDS_MENU_OPTION_VIEW_CAMPSITES)) {
			handleViewAllCampsites(selectedPark);
		}if (choice.equals(VIEW_CAMPGROUNDS_MENU_OPTION_SEARCH_AVAILABLE)) {
			handleSearchForReservation(selectedPark);
		} else if (choice.equals(PARK_DETAIL_MENU_OPTION_BACK)) {
			return;
		}

	}

	private void printMultiHeading(String initialLine, String finalLine) {
		System.out.println("\n" + initialLine);
		printHeading(finalLine);
	}

	private void printHeading(String headingText) {
		System.out.println("\n" + headingText);
		for (int i = 0; i < headingText.length(); i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	private String getUserInput(String prompt) {
		System.out.print(prompt + " >>> ");
		return new Scanner(System.in).nextLine();
	}

	private void displayApplicationBanner() {
		System.out.println("");
		System.out.println(
				" $$\\   $$\\            $$\\     $$\\                               $$\\       $$$$$$$\\                     $$\\ ");
		System.out.println(
				" $$$\\  $$ |           $$ |    \\__|                              $$ |      $$  __$$\\                    $$ |  ");
		System.out.println(
				" $$$$\\ $$ | $$$$$$\\ $$$$$$\\   $$\\  $$$$$$\\  $$$$$$$\\   $$$$$$\\  $$ |      $$ |  $$ |$$$$$$\\   $$$$$$\\  $$ |  $$\\  $$$$$$$\\ ");
		System.out.println(
				" $$ $$\\$$ | \\____$$\\\\_$$  _|  $$ |$$  __$$\\ $$  __$$\\  \\____$$\\ $$ |      $$$$$$$  |\\____$$\\ $$  __$$\\ $$ | $$  |$$  _____|");
		System.out.println(
				" $$ \\$$$$ | $$$$$$$ | $$ |    $$ |$$ /  $$ |$$ |  $$ | $$$$$$$ |$$ |      $$  ____/ $$$$$$$ |$$ |  \\__|$$$$$$  / \\$$$$$$\\ ");
		System.out.println(
				" $$ |\\$$$ |$$  __$$ | $$ |$$\\ $$ |$$ |  $$ |$$ |  $$ |$$  __$$ |$$ |      $$ |     $$  __$$ |$$ |      $$  _$$<   \\____$$\\ ");
		System.out.println(
				" $$ | \\$$ |\\$$$$$$$ | \\$$$$  |$$ |\\$$$$$$  |$$ |  $$ |\\$$$$$$$ |$$ |      $$ |     \\$$$$$$$ |$$ |      $$ | \\$$\\ $$$$$$$  |");
		System.out.println(
				" \\__|  \\__| \\_______|  \\____/ \\__| \\______/ \\__|  \\__| \\_______|\\__|      \\__|      \\_______|\\__|      \\__|  \\__|\\_______/ ");
		System.out.println("");

	}

}
