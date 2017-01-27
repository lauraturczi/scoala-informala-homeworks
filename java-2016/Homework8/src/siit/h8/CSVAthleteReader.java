package siit.h8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads text form a csv buffering characters so as to provide efficient reading
 * of lines.
 * 
 * @author Laura
 * @version 1.0
 *
 */
public class CSVAthleteReader extends BufferedReader {

	public CSVAthleteReader(Reader in) {
		super(in);
	}

	/**
	 * Reads line by line from a csv and parses each line into an instance of
	 * class Athlete
	 * 
	 * @return
	 * @throws IOException
	 */
	public List<Athlete> readAthelete() throws IOException {
		String line = readLine();
		ArrayList<Athlete> athletes = new ArrayList<>();
		while (line != null) {
			String[] tokens = line.split(",");
			Athlete a = new Athlete(tokens[0], tokens[1], tokens[2]);
			a.setFirstShootingRange(tokens[4]);
			a.setSecondShootingRange(tokens[5]);
			a.setThirdShootingRange(tokens[6]);
			a.setResult(tokens[3]);
			athletes.add(a);
			line = readLine();
		}
		return athletes;
	}

}
