package siit.h8.tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import org.junit.Test;

import siit.h8.Athlete;
import siit.h8.CSVAthleteReader;

public class CSVAthleteReaderTest {

	@Test
	public void whenParsingCSVList_withOneAthlete_shouldReturnAthleteList_ofOneAthlete() throws IOException {
		String csv = "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo\n";
		StringReader sr = new StringReader(csv);
		try (CSVAthleteReader athleteReader = new CSVAthleteReader(sr)) {
			List<Athlete> athletes = athleteReader.readAthelete();
			assertEquals(1, athletes.size());
			Athlete expected = new Athlete("11", "Umar Jorgson", "SK");
			expected.setFirstShootingRange("xxxox");
			expected.setSecondShootingRange("xxxxx");
			expected.setThirdShootingRange("xxoxo");
			expected.setResult("30:27");
			assertEquals(expected, athletes.get(0));
		}
	}

	@Test
	public void whenParsingCSVList_withTwoAthlets_shouldReturnAthleteList_ofTwoAthlets() throws IOException {
		String csv = "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo\n" + "1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo\n";
		StringReader sr = new StringReader(csv);
		try (CSVAthleteReader athleteReader = new CSVAthleteReader(sr)) {
			List<Athlete> athletes = athleteReader.readAthelete();
			assertEquals(2, athletes.size());
			Athlete first = new Athlete("11", "Umar Jorgson", "SK");
			Athlete second = new Athlete("1", "Jimmy Smiles", "UK");
			first.setFirstShootingRange("xxxox");
			first.setSecondShootingRange("xxxxx");
			first.setThirdShootingRange("xxoxo");
			first.setResult("30:27");
			second.setFirstShootingRange("xxoox");
			second.setSecondShootingRange("xooxo");
			second.setThirdShootingRange("xxxxo");
			second.setResult("29:15");
			Athlete[] expected = new Athlete[] { first, second };
			Athlete[] actual = new Athlete[2];
			athletes.toArray(actual);
			assertArrayEquals(expected, actual);
		}
	}

	@Test
	public void checkIfNewTimeisCalculatedCorrectly() throws IOException {
		String csv = "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo\n";
		StringReader sr = new StringReader(csv);
		try (CSVAthleteReader athleteReader = new CSVAthleteReader(sr)) {
			List<Athlete> athlets = athleteReader.readAthelete();
			assertEquals(1, athlets.size());
			String expectedResult = "30:57";
			assertTrue(expectedResult.equals(athlets.get(0).calculateNewScores()));
		}
	}

	@Test
	public void checkIfNewTimeisCalculatedCorrectlyWhenNewMinuteShouldBeAdded() throws IOException {
		String csv = "1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo\n";
		StringReader sr = new StringReader(csv);
		try (CSVAthleteReader athleteReader = new CSVAthleteReader(sr)) {
			List<Athlete> athletes = athleteReader.readAthelete();
			assertEquals(1, athletes.size());
			String expectedResult = "30:15";
			assertTrue(expectedResult.equals(athletes.get(0).calculateNewScores()));
		}

	}

	@Test
	public void checkIfNewTimeisCalculatedCorrectlyWhenAllShotsAreMissed() throws IOException {
		String csv = "1,Jimmy Smiles,UK,29:15,ooooo,ooooo,ooooo\n";
		StringReader sr = new StringReader(csv);
		try (CSVAthleteReader athleteReader = new CSVAthleteReader(sr)) {
			List<Athlete> athletes = athleteReader.readAthelete();
			assertEquals(1, athletes.size());
			String expectedResult = "31:45";
			assertTrue(expectedResult.equals(athletes.get(0).calculateNewScores()));
		}

	}

	@Test
	public void checkCompareToSecondAthleteIsGreaterThanFirst() throws IOException {
		String csv = "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo\n" + "1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo\n";
		StringReader sr = new StringReader(csv);
		try (CSVAthleteReader athleteReader = new CSVAthleteReader(sr)) {
			List<Athlete> athletes = athleteReader.readAthelete();
			assertEquals(2, athletes.size());
			int val = athletes.get(0).compareTo(athletes.get(1));
			assertTrue(val > 0);
		}
	}

	@Test
	public void checkCompareToFirstAthleteGreaterThanSecond() throws IOException {
		String csv = "1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo\n" + "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo\n";
		StringReader sr = new StringReader(csv);
		try (CSVAthleteReader athleteReader = new CSVAthleteReader(sr)) {
			List<Athlete> athletes = athleteReader.readAthelete();
			assertEquals(2, athletes.size());
			int val = athletes.get(0).compareTo(athletes.get(1));
			assertTrue(val < 0);
		}
	}

	@Test
	public void checkIfPenaltyCalculationsAreCorrect() throws IOException {
		String csv = "1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo\n";
		StringReader sr = new StringReader(csv);
		try (CSVAthleteReader athleteReader = new CSVAthleteReader(sr)) {
			List<Athlete> athletes = athleteReader.readAthelete();
			assertEquals(1, athletes.size());
			int expectedResult = 60;
			assertEquals(athletes.get(0).calculatePenalty(), expectedResult);
		}

	}

}
