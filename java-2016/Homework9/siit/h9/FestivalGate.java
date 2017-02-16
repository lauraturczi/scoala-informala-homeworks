package siit.h9;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Class FestivalGate represents a gate through which attendees need to go, one
 * at a time.
 * 
 * @author Laura
 * @version 1.0
 *
 */
public class FestivalGate {

	private Queue<TicketType> gate = new ConcurrentLinkedQueue<TicketType>();
	private boolean available;
	public Object lock1 = new Object();

	public Queue<TicketType> getQueue() {
		return gate;
	}

	/**
	 * Creates one instance of class FestivalAttendeeThread. Ticket type is
	 * randomly picked from :full, full-vip, free-pass, one-day, one-day-vip.
	 * 
	 * @return festivalAttendee
	 */
	public FestivalAttendeeThread createOnePerson() {
		Random random = new Random();
		TicketType ticketType = TicketType.values()[random.nextInt(TicketType.values().length)];
		FestivalAttendeeThread festivalAttendee = new FestivalAttendeeThread(ticketType, this);
		return festivalAttendee;
	}

	/**
	 * Starts each FestivalAttendeeThread.
	 */

	public void enterGate() {
		synchronized (lock1) {
			while (available) {
				try {
					lock1.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			FestivalAttendeeThread f;
			f = createOnePerson();
			f.start();
			lock1.notifyAll();
		}
	}

	/**
	 * Randomly generates multiple attendee threads - at least 100.
	 */

	public void enterAllAttendesGate() {
		Random random = new Random();
		int number = random.nextInt(100000) + 100;
		for (int i = 0; i < number; i++) {

			enterGate();
		}

	}

	/**
	 * Adds the ticket type generated to a queue.
	 * 
	 * @return f FestivalAttendeeThread
	 */
	public FestivalAttendeeThread validateTicket() {
		FestivalAttendeeThread f;
		f = createOnePerson();
		synchronized (this) {
			gate.add(f.getTicketType());
		}
		return f;

	}

	/**
	 * Gets the statistics of the queue.
	 */

	public synchronized void getStatistics() {
		System.out.println(gate.size() + " HAVE ENTERED");
		System.out.println(countFull() + " have full tickets");
		System.out.println(countFreePass() + " have free passes");
		System.out.println(countFullVIP() + " have full VIP passes");
		System.out.println(countOneDay() + " have one day passes");
		System.out.println(countOneDayVIP() + " have one day VIP passes");
	}

	public int getNumberOfAttendes() {
		return gate.size();

	}

	private int countFreePass() {
		int i = 0;
		for (TicketType ticket : gate) {
			if (ticket.equals(TicketType.FREE_PASS)) {
				i++;
			}
		}
		return i;

	}

	private int countFull() {
		int i = 0;
		for (TicketType ticket : gate) {
			if (ticket.equals(TicketType.FULL)) {
				i++;
			}
		}
		return i;
	}

	private int countFullVIP() {
		int i = 0;
		for (TicketType ticket : gate) {
			if (ticket.equals(TicketType.FULL_VIP)) {
				i++;
			}
		}
		return i;
	}

	private int countOneDay() {
		int i = 0;
		for (TicketType ticket : gate) {
			if (ticket.equals(TicketType.ONE_DAY)) {
				i++;
			}
		}
		return i;
	}

	private int countOneDayVIP() {
		int i = 0;
		for (TicketType ticket : gate) {
			if (ticket.equals(TicketType.ONE_DAY_VIP)) {
				i++;
			}
		}
		return i;
	}

}
