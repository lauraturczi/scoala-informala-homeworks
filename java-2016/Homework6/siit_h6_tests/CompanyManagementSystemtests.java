package siit_h6_tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import siit_h6.Company;
import siit_h6.Employee;
import siit_h6.Company.Role;
import siit_h6.CompanyManagementSystem;
import org.mockito.Mockito;

public class CompanyManagementSystemtests {

	@Test
	public void addEmployeeTest() {
		// given
		Company company = new Company();
		Employee manager = new Employee("George", 10);
		company.addEmployee(manager, Role.MANAGER);
		List<Employee> empl = company.getAllEmployees();
		assertTrue(empl.contains(manager));
	}

	@Test
	public void compareTestEmployeesNotSorted() {
		// given
		Employee secManager = new Employee("Ana", 2);
		Employee developer = new Employee("Pete", 15);
		Company company = new Company();
		company.addEmployee(secManager, Role.MANAGER);
		company.addEmployee(developer, Role.DEVELOPER);
		List<Employee> empl = company.getAllEmployees();
		List<Employee> sortedEmployees = new ArrayList();
		sortedEmployees.add(developer);
		sortedEmployees.add(secManager);
		// when
		Collections.sort(empl, Employee.YEARS_OF_SERVICE);
		// then
		assertArrayEquals(sortedEmployees.toArray(), empl.toArray());
	}

	@Test
	public void compareTestEmployeesAlreadySorted() {
		// given
		Employee secManager = new Employee("Ana", 2);
		Employee developer = new Employee("Pete", 15);
		Company company = new Company();
		company.addEmployee(developer, Role.DEVELOPER);
		company.addEmployee(secManager, Role.MANAGER);
		List<Employee> empl = company.getAllEmployees();
		List<Employee> sortedEmployees = new ArrayList();
		sortedEmployees.add(developer);
		sortedEmployees.add(secManager);
		// when
		Collections.sort(empl, Employee.YEARS_OF_SERVICE);
		// then
		assertArrayEquals(sortedEmployees.toArray(), empl.toArray());
	}

	@Test
	public void getParkingInfoTest() {
		// given
		Employee manager = new Employee("George", 10);
		Employee accountant = new Employee("Jen", 5);
		Employee engineer = new Employee("Ron", 7);
		Employee secManager = new Employee("Ana", 2);
		Employee developer = new Employee("Pete", 15);
		Company company = new Company();
		CompanyManagementSystem system = new CompanyManagementSystem();
		company.addEmployee(manager, Role.MANAGER);
		company.addEmployee(accountant, Role.ACCOUNTANT);
		company.addEmployee(engineer, Role.ENGINEER);
		company.addEmployee(secManager, Role.MANAGER);
		company.addEmployee(developer, Role.DEVELOPER);
		manager.setHasParking(true);
		secManager.setHasParking(false);
		accountant.setHasParking(true);
		engineer.setHasParking(false);
		developer.setHasParking(false);
		List<Employee> employeesNoParkingExpected = new ArrayList();
		employeesNoParkingExpected.add(developer);
		employeesNoParkingExpected.add(engineer);
		employeesNoParkingExpected.add(secManager);
		List<Employee> employeesNoParkingActual = new ArrayList();
		// when
		employeesNoParkingActual = system.getParkingInfo(company);
		// then
		assertArrayEquals(employeesNoParkingExpected.toArray(), employeesNoParkingActual.toArray());

	}

	@Test
	public void testToStringEmployee() {
		Employee employee = new Employee("George", 10);
		String expected = "Employee [name=George, yearsOfService=10]";
		assertEquals(expected, employee.toString());
	}

	@Test
	public void testToStringCompany() {
		Employee manager = new Employee("George", 10);
		Employee accountant = new Employee("Jen", 5);
		Company company = new Company();
		company.addEmployee(manager, Role.MANAGER);
		company.addEmployee(accountant, Role.ACCOUNTANT);
		String expected = "{MANAGER=[Employee [name=George, yearsOfService=10]], ACCOUNTANT=[Employee [name=Jen, yearsOfService=5]]}";
		assertEquals(expected, company.toString());
	}
}
