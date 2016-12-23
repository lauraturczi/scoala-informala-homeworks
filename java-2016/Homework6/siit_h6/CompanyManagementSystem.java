package siit_h6;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

/**
 * Receives a list of employees as an input and implements the following
 * methods:
 * <p>
 * <b> Methods</b>
 * <p>
 * getParkingInfo
 * <p>
 * populateMap
 * 
 * @author Laura
 * @version 1.0
 */

public class CompanyManagementSystem {

	HashMap<Boolean, List<Employee>> hMap = new HashMap<Boolean, List<Employee>>();
	private List<Employee> listNoParking = new LinkedList<>();
	private List<Employee> listWithParking = new LinkedList<>();

	/**
	 * Prints the list of employees with no parking.
	 * <p>
	 * The list is sorted by seniority, the employee who has worked the longest
	 * at the company will be the first one displayed
	 * 
	 * @param company
	 */
	public void getParkingInfo(Company company) {
		List<Employee> empl = company.getAllEmployees();
		Collections.sort(empl, Employee.YEARS_OF_SERVICE);
		for (Employee employee : empl) {
			populateMap(employee);

		}
		for (Boolean key : hMap.keySet()) {
			List<Employee> emp = hMap.get(key);
			if (key == false) {
				System.out.println("Employees without parking\n" + emp);

			}
		}

	}

	private void populateMap(Employee employee) {
		if (employee.getHasParking()) {
			listWithParking.add(employee);
			hMap.put(employee.getHasParking(), listWithParking);
		} else {
			listNoParking.add(employee);
			hMap.put(employee.getHasParking(), listNoParking);
		}
	}

}
