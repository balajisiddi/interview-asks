package map_problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

record Employee(int id, String name, String department, int salary){
	  
}
public class GroupingObject {
	public static void main(String[] args) {
		 List<Employee> employees = Arrays.asList(
		            new Employee(1, "Alice", "HR", 50000),
		            new Employee(2, "Bob", "IT", 75000),
		            new Employee(3, "Charlie", "IT", 80000),
		            new Employee(4, "David", "Finance", 90000),
		            new Employee(5, "Eve", "HR", 65000),
		            new Employee(6, "Kave", "IT", 90000)
		        );
		 Map<String, List<Employee>> empByDepartment= employees.stream()
				 .collect(Collectors.groupingBy(Employee::department));
		 empByDepartment.entrySet().forEach(System.out::println);
		 
		 Map<String, Employee> highSalaryByDepartment = employees.stream()
				 .collect(Collectors.groupingBy(Employee::department, 
						 Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Employee::salary)),
								 Optional::get)));
		 for(Map.Entry<String, Employee> entry: highSalaryByDepartment.entrySet()) {
			 System.out.println(entry.getKey()+"|||"+entry.getValue());
		 }
		 
		 Optional<Integer> secondHighestSalary = employees.stream()
				 .filter(e->"IT".equalsIgnoreCase(e.department()))
				 .map(Employee::salary)
				 .distinct()
				 .sorted(Comparator.reverseOrder())
				 .skip(1)
				 .findFirst();
				 
		 secondHighestSalary.ifPresentOrElse(salary->System.out.println("Second Highest Salary"+salary), ()->System.out.println("Not enough data found"));
		 Optional<Employee> highestSalaryEmp= employees.stream()
		 .filter(emp->"IT".equals(emp.department()))
		 .sorted(Comparator.comparingInt(Employee::salary).reversed())
		 .skip(1)
		 .findFirst();
		 
		 Map<String, Long> employeesByDepartment= employees.stream()
				 .collect(Collectors.groupingBy(Employee::department, Collectors.counting()));
		 employeesByDepartment.forEach((dept, count)->System.out.println(dept+"==="+count));
		 
		 Optional<Employee> highestSalaried= employees.stream()
				 .collect(Collectors.maxBy(Comparator.comparingInt(Employee::salary)));
		 highestSalaried.ifPresentOrElse(salary->System.out.println("Hish"+salary), ()->System.out.println("Not enough of the data"));
		 
		 List<Employee> allHighestSalaried = employees.stream()
				 .sorted(Comparator.comparingInt(Employee::salary).reversed()).toList();
		 allHighestSalaried.forEach(System.out::println);
		 
		 int maxSal= employees.stream()
				 .mapToInt(Employee::salary)
				 .max().orElse(0);
		 List<Employee> allHighs= employees.stream()
				 .filter(e->e.salary()==maxSal)
				 .toList();
		 allHighs.forEach(System.out::println);
		 int lowSal= employees.stream()
				 .mapToInt(Employee::salary)
				 .min().orElse(0);
		 List<Employee> lowsalaried = employees.stream()
				 .filter(e->e.salary()==lowSal).toList();
		 lowsalaried.forEach(System.out::println);
		 List<Employee> sortedByName =employees.stream()
		 .sorted(Comparator.comparing(Employee::name)).collect(Collectors.toList());
		 sortedByName.forEach(System.out::println);
	}
	
}
