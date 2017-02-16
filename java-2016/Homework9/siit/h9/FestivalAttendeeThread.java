package siit.h9;

/**
 * Instances of class FestivalAtthendee represents attendees.Every person is
 * represented by a special Thread that is instantiated with random ticket data.
 * Possible ticket types: full, full-vip, free-pass, one-day, one-day-vip
 * 
 * @author Laura
 * @version 1.0
 */
public class FestivalAttendeeThread extends Thread {

	private TicketType ticketType;

	public TicketType getTicketType() {
		return ticketType;
	}

	public FestivalGate getGate() {
		return gate;
	}

	private FestivalGate gate;

	public FestivalAttendeeThread(TicketType tycketType, FestivalGate gate) {
		super();
		this.ticketType = tycketType;
		this.gate = gate;
	}

	@Override
	public String toString() {
		return "FestivalAttendeeThread [tycketType=" + ticketType + ", gate=" + gate + "]";
	}

	@Override
	public void run() {

		gate.validateTicket();
		try {
			sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
