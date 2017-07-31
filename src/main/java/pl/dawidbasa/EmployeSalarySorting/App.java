package pl.dawidbasa.employeSalarySorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class App {

	public static void main(String[] args) {

		List<Employee> employess = Arrays.asList(

				new Employee("Dawid", 3000), 
				new Employee("Roman", 5942), 
				new Employee("Tomasz", 2345),
				new Employee("Marcin", 4730),
				new Employee("Adrian", 1999), 
				new Employee("Mariusz", 1234),
				new Employee("Micha³", 8503), 
				new Employee("Kamil", 12000));

		// 1. Sort Staff by name
		System.out.println(App.sortEmployessByName(employess));

		// 2. Sort Staff by salary
		System.out.println(App.sortEmployessBySalary(employess));

		// 3. Calculate average salary
		System.out.println(App.calculateAverageSalary(employess));

		// 4. Get Staff with sallary bigger than average salary.
		System.out.println(filterEmployees(employess, isSalaryBiggerThanAverage(App.calculateAverageSalary(employess))));

	}
	
	public static List<Employee> sortEmployessByName(List<Employee> employess){
		Collections.sort(employess, (e1, e2) -> e1.getName().compareTo(e2.getName()));
		return employess;
	}
	
	public static List<Employee> sortEmployessBySalary(List<Employee> employess){
		employess.sort
			(Comparator.comparingDouble(Employee::getSalary)
					.reversed());
		return employess;
		
	}

	public static List<Employee> filterEmployees(List<Employee> employees, Predicate<Employee> predicate) {
		return employees.stream()
				.filter(predicate)
				.collect(Collectors.<Employee>toList());
	}

	public static Predicate<Employee> isSalaryBiggerThanAverage(Double averageSalary) {
		return e -> e.getSalary() > averageSalary;
	}
	
	public static double calculateAverageSalary(List<Employee> employess){
		return  employess.stream()
				.mapToDouble(Employee::getSalary)
				.average()
				.getAsDouble();
	}

}
