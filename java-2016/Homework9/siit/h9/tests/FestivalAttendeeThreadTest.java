package siit.h9.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import siit.h9.FestivalAttendeeThread;
import siit.h9.FestivalGate;
import siit.h9.FestivalStatisticsThread;
import siit.h9.TicketType;

public class FestivalAttendeeThreadTest {

	@Test
	public void testIfCorrectNumberOfThreadsAreCreated() {
		FestivalGate gate = new FestivalGate();
		FestivalAttendeeThread firstAttendee = new FestivalAttendeeThread(TicketType.FREE_PASS, gate);
		FestivalAttendeeThread secondAttendee = new FestivalAttendeeThread(TicketType.FULL, gate);
		firstAttendee.start();
		secondAttendee.start();
		try {
			firstAttendee.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int actual = gate.getQueue().size();
		assertEquals(2, actual);
	}

	
	@Test
	public void testWithNoThreadsCreated() {
		FestivalGate gate = new FestivalGate();
		int actual = gate.getQueue().size();
		assertEquals(0, actual);
	}
}
