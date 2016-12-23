package siit_h6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Company class has employees stored in a HashMap. Internally the company keeps
 * the employees in role-specific lists.
 * 
 * @version 1.0
 * @author Laura
 *
 */
public class Company {

	private HashMap<Role, List<Employee>> company = new HashMap<>();

	public static enum Role {
		MANAGER, DEVELOPER, ACCOUNTANT, ENGINEER;
	}

	/**
	 * Adds employee to HashMap.
	 * <p>
	 * HashMap has as key an enum type and as a value a list of employees.
	 * 
	 * @param employee
	 * @param role
	 */
	public void addEmployee(Employee employee, Role role) {
		List<Employee> list = company.get(role);
		if (list == null) {
			list = new ArrayList<>();
			company.put(role, list);
		}
		list.add(employee);
	}

	@Override
	public String toString() {
		return company.toString();
	}

	/**
	 * Gets all the employees of a company
	 * 
	 * @return all values from the Hashmap stored as an arrayList
	 */
	public List<Employee> getAllEmployees() {
		ArrayList<Employee> allEmployees = new ArrayList<>();
		for (List<Employee> employees : company.values()) {
			allEmployees.addAll(employees);
		}
		return allEmployees;
	}

	/**
	 * Displays the employees in role specific lists.
	 */
	public void listByRole() {
		Set set = company.entrySet();
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry me = (Map.Entry) iterator.next();
			System.out.print(me.getKey() + ": ");
			System.out.println(me.getValue());
		}

	}

}