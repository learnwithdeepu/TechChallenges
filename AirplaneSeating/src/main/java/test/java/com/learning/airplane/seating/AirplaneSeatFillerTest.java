package test.java.com.learning.airplane.seating;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.function.Executable;

import com.learning.airplane.seating.AirplaneSeatFiller;
import com.learning.airplane.seating.OutOfSeatException;

public class AirplaneSeatFillerTest {

	@Before
	public void setUp() {

	}

	@Test
	public void testAisleSeatBooked() throws OutOfSeatException {
		int[][] bay1 = new int[8][2];
		int[][] bay2 = new int[10][3];
		int[][] bay3 = new int[9][3];
		List<int[][]> bays = new ArrayList<>();
		bays.add(bay1);
		bays.add(bay2);
		bays.add(bay3);
		AirplaneSeatFiller seatFiller = new AirplaneSeatFiller(bays, 30);
		bays = seatFiller.fillAirplaneSeat();
		assertEquals(5, bays.get(0)[7][1]);
	}


	@Test
	public void testWindowSeatAfter18AisleSeatBooked() throws OutOfSeatException {
		int[][] bay1 = new int[3][2];
		int[][] bay2 = new int[4][3];
		int[][] bay3 = new int[2][3];
		int[][] bay4 = new int[3][4];
		List<int[][]> bays = new ArrayList<>();
		bays.add(bay1);
		bays.add(bay2);
		bays.add(bay3);
		bays.add(bay4);
		AirplaneSeatFiller seatFiller = new AirplaneSeatFiller(bays, 30);
		bays = seatFiller.fillAirplaneSeat();
		assertEquals(19, bays.get(0)[0][0]);
	}

	@Test
	public void testMiddleSeatAfterAisleSeatBooked() throws OutOfSeatException {
		int[][] bay1 = new int[5][2];
		int[][] bay2 = new int[2][3];
		int[][] bay3 = new int[2][3];
		int[][] bay4 = new int[6][4];
		List<int[][]> bays = new ArrayList<>();
		bays.add(bay1);
		bays.add(bay2);
		bays.add(bay3);
		bays.add(bay4);
		AirplaneSeatFiller seatFiller = new AirplaneSeatFiller(bays, 45);
		bays = seatFiller.fillAirplaneSeat();
		assertEquals(44, bays.get(3)[2][3]);
	}

	@Test
	public void testAllSeatsEmpty() throws OutOfSeatException {
		int[][] bay1 = new int[5][2];
		int[][] bay2 = new int[2][3];
		int[][] bay3 = new int[2][3];
		int[][] bay4 = new int[6][4];
		List<int[][]> bays = new ArrayList<>();
		bays.add(bay1);
		bays.add(bay2);
		bays.add(bay3);
		bays.add(bay4);
		AirplaneSeatFiller seatFiller = new AirplaneSeatFiller(bays, 0);
		bays = seatFiller.fillAirplaneSeat();
		assertEquals(0, bays.get(0)[2][0]);
	}

	@Test
	public void testExceedPassengersException() {
		assertThrows(OutOfSeatException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				int[][] bay1 = new int[5][2];
				int[][] bay2 = new int[2][3];
				int[][] bay3 = new int[2][3];
				int[][] bay4 = new int[6][4];
				List<int[][]> bays = new ArrayList<>();
				bays.add(bay1);
				bays.add(bay2);
				bays.add(bay3);
				bays.add(bay4);
				AirplaneSeatFiller seatFiller = new AirplaneSeatFiller(bays, 50);
				bays = seatFiller.fillAirplaneSeat();
			}
		});
	}

	@After
	public void tearDown() {

	}

}