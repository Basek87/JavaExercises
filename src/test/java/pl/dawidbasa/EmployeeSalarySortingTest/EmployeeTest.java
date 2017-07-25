package pl.dawidbasa.EmployeeSalarySortingTest;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import pl.dawidbasa.EmployeSalarySorting.App;
import pl.dawidbasa.EmployeSalarySorting.Employee;

public class EmployeeTest {

	App app = new App();

	List<Employee> employees = Arrays.asList(

			new Employee("Dawid", 1000), new Employee("Roman", 2000), new Employee("Tomasz", 3000));

	@Test
	public void testCalculateAverageSalary() {
		Object averageSalary = App.calculateAverageSalary(employees);
		assertEquals(averageSalary, 2000.0);
	}


}