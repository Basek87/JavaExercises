package pl.dawidbasa.employeSalarySorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class App {

	public static List<Employee> sortEmployeesByName(List<Employee> Employees){
		Collections.sort(Employees, (e1, e2) -> e1.getName().compareTo(e2.getName()));
		return Employees;
	}
	
	public static List<Employee> sortEmployeesBySalary(List<Employee> Employees){
		Employees.sort
			(Comparator.comparingDouble(Employee::getSalary)
					.reversed().thenComparing((e1, e2) -> e1.getName().compareTo(e2.getName())));
		return Employees;
		
	}

	public static List<Employee> filterEmployees(List<Employee> employees, Predicate<Employee> predicate) {
		return employees.stream()
				.filter(predicate)
				.collect(Collectors.<Employee>toList());
	}

	public static Predicate<Employee> isSalaryBiggerThanAverage(Double averageSalary) {
		return e -> e.getSalary() > averageSalary;
	}
	
	public static double calculateAverageSalary(List<Employee> Employees){
		return  Employees.stream()
				.mapToDouble(Employee::getSalary)
				.average()
				.getAsDouble();
	}
	
	
	public static void main(String[] args) {

		List<Employee> Employees = Arrays.asList(

				new Employee("Dawid", 3000), 
				new Employee("Roman", 3000), 
				new Employee("Tomasz", 3000),
				new Employee("Marcin", 4730),
				new Employee("Adrian", 1999), 
				new Employee("Mariusz", 1234),
				new Employee("Micha³", 8503), 
				new Employee("Kamil", 12000));

		// 1. Sort Staff by name
		System.out.println("Sort By name " + App.sortEmployeesByName(Employees));

		// 2. Sort Staff by salary
		System.out.println("Sort By salary " + App.sortEmployeesBySalary(Employees));

		// 3. Calculate average salary
		System.out.println("Average Salary " + App.calculateAverageSalary(Employees));

		// 4. Get Staff with sallary bigger than average salary.
		System.out.println("Staff with sallary bigger than average " +filterEmployees(Employees, isSalaryBiggerThanAverage(App.calculateAverageSalary(Employees))));

	}
	
	

}
