package siit_h6;

import siit_h6.Company.Role;

public class Main {

	public static void main(String[] args) {
		Employee manager = new Employee("George", 10);
		Employee accountant = new Employee("Jen", 5);
		//Employee engineer = new Employee("Ron", 7);
		//Employee secManager = new Employee("Ana", 2);
	//	Employee developer = new Employee("Pete", 15);
	//	Employee seniorDeveloper = new Employee("Judit", 13);
		Company company = new Company();
		CompanyManagementSystem system = new CompanyManagementSystem();
		company.addEmployee(manager, Role.MANAGER);
		company.addEmployee(accountant, Role.ACCOUNTANT);
	//	company.addEmployee(engineer, Role.ENGINEER);
	//	company.addEmployee(secManager, Role.MANAGER);
	//	company.addEmployee(developer, Role.DEVELOPER);
	//	company.addEmployee(seniorDeveloper, Role.DEVELOPER);
	//	manager.setHasParking(true);
	//	secManager.setHasParking(false);
	//	accountant.setHasParking(true);
	//	engineer.setHasParking(false);
	//	developer.setHasParking(false);
	//	seniorDeveloper.setHasParking(false);
		System.out.println(company);
	}
}
