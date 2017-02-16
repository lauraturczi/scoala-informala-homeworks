package siit.h9;

/**
 * FestivalStatisticsThread wakes up every 5 seconds and reads the new data from
 * the gate and generates statistics.
 * 
 * @author Laura
 *
 */
public class FestivalStatisticsThread extends Thread {

	private FestivalGate gate;

	public FestivalStatisticsThread(FestivalGate gate) {
		super();
		this.gate = gate;
	}

	/**
	 * Reads from the gate-data only if it's not empty.
	 */
	public void run() {
		gate.enterAllAttendesGate();
		synchronized (this) {
			if (gate.getQueue().isEmpty()) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			for (int i = 0; i < gate.getQueue().size(); i++) {
				gate.getStatistics();
				try {
					sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
