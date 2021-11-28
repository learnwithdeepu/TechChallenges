package com.learning.airplane.seating;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class AirplaneSeatFiller {

	private static final Logger LOGGER = Logger.getLogger(AirplaneSeatFiller.class.getName());

	private List<int[][]> baysList = new ArrayList<>();
	private int noOfPassengers;
	private int count;
	private int i;

	public AirplaneSeatFiller(List<int[][]> baysList, int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
		this.baysList = baysList;
		this.count = 0;
		this.i = 0;
	}

	public List<int[][]> fillAirplaneSeat() throws OutOfSeatException {
		validateSeatAvailability();
		fillAisleSeats();
		fillWindowSeats();
		fillMiddleSeats();
		printSeatsInConsole();
		return baysList;
	}

	private void validateSeatAvailability() throws OutOfSeatException {
		if(noOfPassengers > getTotalSeats()) {
			throw new OutOfSeatException("Total Passengers limit exceeds the Seat availablity!!!");
		}
	}

	private int getTotalSeats() {
		int totalSeats = 0;
		for (int s = 0; s < baysList.size(); s++) {
			int[][] bay = baysList.get(s);
			totalSeats += bay[0].length * bay.length;
		}
		LOGGER.info("Total seats : " + totalSeats);
		return totalSeats;
	}

	private void fillAisleSeats() {
		while (i < baysList.size()) {
			for (int k = 0; k < baysList.size(); k++) {
				boolean hasLeftWindowSeat = false;
				boolean hasRightWindowSeat = false;
				if (k == 0) {
					hasLeftWindowSeat = true;
				} else if (k == baysList.size() - 1) {
					hasRightWindowSeat = true;
				}
				getAisleSeats(baysList.get(k), hasLeftWindowSeat, hasRightWindowSeat);
			}
			i++;
		}
		i = 0;
	}

	private List<int[][]> getAisleSeats(int[][] bay, boolean hasLeftWindowSeat, boolean hasRightWindowSeat) {
		if (i < bay[0].length) {
			for (int j = 0; j < bay.length; j++) {
				if (isAisleSeat(hasLeftWindowSeat, hasRightWindowSeat, j, bay.length - 1)) {
					count++;
					bay[j][i] = count > noOfPassengers ? 0 : count;
				}
			}
		}
		return baysList;
	}

	private boolean isAisleSeat(boolean hasLeftWindowSeat, boolean hasRightWindowSeat, int j, int colLength) {
		return hasLeftWindowSeat ? colLength == j : hasRightWindowSeat ? j == 0 : (colLength == j || j == 0);
	}

	private void fillWindowSeats() {
		while (i < baysList.size()) {
			for (int k = 0; k < baysList.size(); k++) {
				boolean hasLeftWindowSeat = false;
				boolean hasRightWindowSeat = false;
				if (k == 0) {
					hasLeftWindowSeat = true;
				} else if (k == baysList.size() - 1) {
					hasRightWindowSeat = true;
				}
				getWindowSeats(baysList.get(k), hasLeftWindowSeat, hasRightWindowSeat);
			}
			i++;
		}
		i = 0;
	}

	private List<int[][]> getWindowSeats(int[][] bay, boolean hasLeftWindowSeat, boolean hasRightWindowSeat) {
		if (i < bay[0].length) {
			for (int j = 0; j < bay.length; j++) {
				if ((hasLeftWindowSeat && j == 0) || (hasRightWindowSeat && j == bay.length - 1)) {
					count++;
					bay[j][i] = count > noOfPassengers ? 0 : count;
				}
			}
		}
		return baysList;
	}

	private void fillMiddleSeats() {
		while (i < baysList.size()) {
			for (int k = 0; k < baysList.size(); k++) {
				getMiddleSeats(baysList.get(k));
			}
			i++;
		}
		i = 0;
	}

	private List<int[][]> getMiddleSeats(int[][] bay) {
		if (i < bay[0].length) {
			for (int j = 0; j < bay.length; j++) {
				if (j > 0 && j < bay.length - 1) {
					count++;
					bay[j][i] = count > noOfPassengers ? 0 : count;
				}
			}
		}
		return baysList;
	}

	private void printSeatsInConsole() {
		int k = 0;
		while (k < baysList.size()) {
			for (int[][] bay : baysList) {
				int j = 0;
				while (j < bay.length) {
					if(k >= bay[0].length) {
						System.out.print("***");
						System.out.print(" ");
						j++;
					} else {
						System.out.printf("%3d", bay[j][k]);
						System.out.print(" ");
						j++;
					}
				}
				System.out.print("    ");
			}
			System.out.println("");
			k++;
		}
	}

}
