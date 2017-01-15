package siit_h6;

import java.util.Comparator;

/**
 * Class Employee implements Comparable.
 * 
 * @param name
 *            String type shows the name of the employee
 * @param yearsOfService
 *            integer type shows the years the employee's been working at the
 *            company
 *            <p>
 *            An object of class employee should have the variable hasParking
 *            set
 * @author Laura
 *         <p>
 * @version 1.0
 */
public class Employee implements Comparable<Employee> {

	private String name;
	private int yearsOfService;
	private boolean hasParking;

	public Employee(String name, int yearsOfService) {
		this.name = name;
		this.yearsOfService = yearsOfService;

	}

	public int getYearsOfService() {
		return yearsOfService;
	}

	public String getName() {
		return name;
	}

	public boolean getHasParking() {
		return hasParking;
	}

	public void setHasParking(boolean hasParking) {
		this.hasParking = hasParking;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", yearsOfService=" + yearsOfService + "]";
	}

	@Override
	public int compareTo(Employee o) {
		String anotherString = null;
		return o.getName().compareTo(anotherString);
	}

	public static final Comparator<Employee> YEARS_OF_SERVICE = new Comparator<Employee>() {

		@Override
		public int compare(Employee e1, Employee e2) {
			if (e2.getYearsOfService() == e1.getYearsOfService()) {
				return 0;
			} else if (e2.getYearsOfService() > e1.getYearsOfService()) {
				return 1;
			}
			return -1;
		}
	};

}
