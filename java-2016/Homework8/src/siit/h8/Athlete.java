package siit.h8;

/**
 * Instances of class Athlete represents biathlon athletes. Each athlete has a
 * time-result for the entire skiing session and 3 shooting ranges. Each
 * shooting range has 5 shot results. For every missed shot the athlete obtains
 * a 10 second penalty which affects the final time-result.
 * 
 * @author Laura
 * @version 1.0
 */
public class Athlete implements Comparable<Athlete> {

	private String atheleteName;
	private String atheleteNumber;
	private String countryCode;
	private String result;
	private String firstShootingRange;
	private String secondShootingRange;
	private String thirdShootingRange;

	public String getFirstShootingRange() {
		return firstShootingRange;
	}

	public String getSecondShootingRange() {
		return secondShootingRange;
	}

	public void setFirstShootingRange(String firstShootingRange) {
		this.firstShootingRange = firstShootingRange;
	}

	public void setSecondShootingRange(String secondShootingRange) {
		this.secondShootingRange = secondShootingRange;
	}

	public String getThirdShootingRange() {
		return thirdShootingRange;
	}

	public void setThirdShootingRange(String thirdShootingRange) {
		this.thirdShootingRange = thirdShootingRange;
	}

	public void setResult(String tokens) {
		this.result = tokens;
	}

	/**
	 * @param atheleteName
	 * @param atheleteNumber
	 * @param countryCode
	 */
	public Athlete(String atheleteNumber, String atheleteName, String countryCode) {
		super();
		this.atheleteNumber = atheleteNumber;
		this.atheleteName = atheleteName;
		this.countryCode = countryCode;
	}

	public String getAtheleteName() {
		return atheleteName;
	}

	public String getAtheleteNumber() {
		return atheleteNumber;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public String getResult() {
		return result;
	}

	private int getNumberOfMisses() {
		String misses = getFirstShootingRange() + getSecondShootingRange() + getThirdShootingRange();
		int numberOfMisses = 0;
		for (int i = 0; i < misses.length(); i++) {
			char c = misses.charAt(i);
			if (c == 'o') {
				numberOfMisses++;
			}
		}
		return numberOfMisses;
	}

	/**
	 * Returns a string which represents the athlet's final time score after
	 * applying the penalty.
	 * 
	 * @return newTime
	 */
	public String calculateNewScores() {
		String[] time = getResult().split(":");
		int minutes = Integer.parseInt(time[0]);
		int seconds = Integer.parseInt(time[1]);
		for (int i = 0; i < getNumberOfMisses(); i++) {
			seconds = seconds + 10;
			if (seconds > 59) {
				minutes = minutes + 1;
				seconds = seconds - 60;
			}
		}
		String newTime = Integer.toString(minutes) + ":" + Integer.toString(seconds);
		return newTime;

	}

	private int getScoresInSeconds() {
		String[] time = calculateNewScores().split(":");
		int minutes = Integer.parseInt(time[0]);
		int seconds = Integer.parseInt(time[1]);
		int score = (minutes * 60) + seconds;
		return score;
	}

	/**
	 * Returns the penalty in seconds applied to the athlete
	 * 
	 * @return getNumberOfMisses() multiplied by 10 which represents the penalty
	 *         applied for each miss
	 */
	public int calculatePenalty() {
		return getNumberOfMisses() * 10;
	}

	@Override
	public int compareTo(Athlete otherAthlete) {
		if (this.getScoresInSeconds() < otherAthlete.getScoresInSeconds()) {
			return -1;
		} else if (this.getScoresInSeconds() > otherAthlete.getScoresInSeconds()) {
			return 1;
		}

		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atheleteName == null) ? 0 : atheleteName.hashCode());
		result = prime * result + ((atheleteNumber == null) ? 0 : atheleteNumber.hashCode());
		result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime * result + ((firstShootingRange == null) ? 0 : firstShootingRange.hashCode());
		result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
		result = prime * result + ((secondShootingRange == null) ? 0 : secondShootingRange.hashCode());
		result = prime * result + ((thirdShootingRange == null) ? 0 : thirdShootingRange.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Athlete other = (Athlete) obj;
		if (atheleteName == null) {
			if (other.atheleteName != null)
				return false;
		} else if (!atheleteName.equals(other.atheleteName))
			return false;
		if (atheleteNumber == null) {
			if (other.atheleteNumber != null)
				return false;
		} else if (!atheleteNumber.equals(other.atheleteNumber))
			return false;
		if (countryCode == null) {
			if (other.countryCode != null)
				return false;
		} else if (!countryCode.equals(other.countryCode))
			return false;
		if (firstShootingRange == null) {
			if (other.firstShootingRange != null)
				return false;
		} else if (!firstShootingRange.equals(other.firstShootingRange))
			return false;
		if (result == null) {
			if (other.result != null)
				return false;
		} else if (!result.equals(other.result))
			return false;
		if (secondShootingRange == null) {
			if (other.secondShootingRange != null)
				return false;
		} else if (!secondShootingRange.equals(other.secondShootingRange))
			return false;
		if (thirdShootingRange == null) {
			if (other.thirdShootingRange != null)
				return false;
		} else if (!thirdShootingRange.equals(other.thirdShootingRange))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Athlete [atheleteName=" + atheleteName + ", atheleteNumber=" + atheleteNumber + ", countryCode="
				+ countryCode + ", result=" + result + "]";
	}

}
