package siit.h9;

public class Main {

	public static void main(String[] args) {

		FestivalGate gate = new FestivalGate();

		FestivalStatisticsThread statsThread = new FestivalStatisticsThread(gate);

		statsThread.start();

	}

}
