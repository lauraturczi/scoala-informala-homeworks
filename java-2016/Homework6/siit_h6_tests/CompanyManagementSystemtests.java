package siit_h6_tests;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import siit_h6.Company;
import siit_h6.Employee;
import siit_h6.Company.Role;
import siit_h6.CompanyManagementSystem;

public class CompanyManagementSystemtests {

	@Test
	public void addEmployeeTest() {
		// given
		Company company = new Company();
		HashMap<Role, Employee> hMap = new HashMap<>();

		Employee manager = new Employee("George", 10);
		company.addEmployee(manager, Role.MANAGER);
		List<Employee> empl = company.getAllEmployees();
		assertTrue(empl.contains(manager));
	}

	@Test
	public void compareTest() {
		// given
		Employee secManager = new Employee("Ana", 2);
		Employee developer = new Employee("Pete", 15);
		Company company = new Company();
		company.addEmployee(secManager, Role.MANAGER);
		company.addEmployee(developer, Role.DEVELOPER);
		List<Employee> empl = company.getAllEmployees();
		// when
		Collections.sort(empl, Employee.YEARS_OF_SERVICE);
		// then

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
		// when
		system.getParkingInfo(company);
		// then
		// assertEquals()

	}

}
