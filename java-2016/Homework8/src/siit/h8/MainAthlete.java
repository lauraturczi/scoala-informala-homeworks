package siit.h8;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import java.util.Collections;
import java.util.List;

public class MainAthlete {

	public static void main(String[] args) throws IOException {
		File csv = new File("C:/Users/Laura/Documents/scoala-informala-homeworks/athlets.csv");
		try (CSVAthleteReader reader = new CSVAthleteReader(Files.newBufferedReader(csv.toPath()))) {
			List<Athlete> athletes = reader.readAthelete();
			Collections.sort(athletes);
			rankAthlets(athletes);

		}
	}

	/**
	 * Prints on the console the first three places in the biathlon
	 * 
	 * @param athletes
	 */

	public static void rankAthlets(List<Athlete> athletes) {
		System.out.println("Winner - " + athletes.get(0).getAtheleteName() + " " + athletes.get(0).calculateNewScores()
				+ " (" + athletes.get(0).getResult() + " + " + athletes.get(0).calculatePenalty() + ")");
		System.out
				.println("Runner-up - " + athletes.get(1).getAtheleteName() + " " + athletes.get(1).calculateNewScores()
						+ " (" + athletes.get(1).getResult() + " + " + athletes.get(1).calculatePenalty() + ")");
		System.out.println(
				"Third Place - " + athletes.get(2).getAtheleteName() + " " + athletes.get(2).calculateNewScores() + " ("
						+ athletes.get(2).getResult() + " + " + athletes.get(2).calculatePenalty() + ")");
	}

}
