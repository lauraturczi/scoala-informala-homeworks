package siit_h7;

/**
 * Class Job is implemented to test if the generic sorting algorithm works as
 * expected.
 * 
 * @version 1.0
 * @author Laura
 *
 */

public class Job implements Comparable<Job> {

	@Override
	public String toString() {
		return name;
	}

	private String name;
	private int importance;

	public int getImportance() {
		return importance;
	}

	/**
	 * @param name
	 *            job description
	 * @param importance
	 *            the job with the lowest value is considered the most important
	 */
	public Job(String name, int importance) {
		this.name = name;
		this.importance = importance;
	}

	public String getName() {
		return name;
	}

	@Override
	public int compareTo(Job otherJob) {
		if (this.getImportance() < otherJob.getImportance()) {
			return -1;
		} else if (this.getImportance() > otherJob.getImportance()) {
			return 1;
		}

		return 0;
	}
}
