package map_problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
		 List<String> allDepats= employees.stream()
				 .map(Employee::department)
				 .distinct()
				 .toList();
		 allDepats.forEach(System.out::println);
		 Map<String, Integer> highSalInEachDept= employees.stream()
				 .collect(Collectors.toMap(
						 Employee::department,
						 Employee::salary,
						 Integer::max));
		 System.out.println(highSalInEachDept);
		 Map<String, Integer> reduceOptforHighsalaries = employees.stream()
				 .collect(Collectors.groupingBy(Employee::department, 
						 Collectors.reducing(0, Employee::salary, Integer::max)));
		 System.out.println(reduceOptforHighsalaries);
		 
		 Map<String, Long> empsbyDepa = employees.stream()
				 .collect(Collectors.groupingBy(Employee::department,
						 Collectors.counting()));
		 System.out.println(empsbyDepa);
		 Map<Integer, Long> nofSals = employees.stream()
				 .collect(Collectors.groupingBy(Employee::salary,
						 Collectors.counting()));
		 System.out.println(nofSals);
		 Map<Integer, List<Employee>> nofsalsforemp = employees.stream()
				 .collect(Collectors.groupingBy(Employee::salary));
		 System.out.println(nofsalsforemp);
		 Map<Integer, List<String>> saltoNames= employees.stream()
				 .collect(Collectors.groupingBy(Employee::salary,
						 Collectors.mapping(Employee::name, Collectors.toList())));
		 System.out.println(saltoNames);
		 
		 Integer maxSalinFinance = employees.stream()
				 .filter(e->"Finance".equalsIgnoreCase(e.department()))
				 .map(Employee::salary)
				 .distinct()
				 .sorted(Comparator.reverseOrder())
				 .findFirst()
				 .get();
		 System.out.println(maxSalinFinance);
		 Map<String, Long> countbyDepartment= employees.stream()
				 .collect(Collectors.groupingBy(Employee::department,
						 Collectors.counting()));
		 Entry<String, Long> smalledDept= countbyDepartment.entrySet().stream().min(Map.Entry.comparingByValue()).get();
		 System.out.println(smalledDept);
		 
		 Map<String, Long> largestDeptCount= employees.stream()
				 .collect(Collectors.groupingBy(Employee::department,
						 Collectors.counting()));
		 Entry<String, Long> largDept= largestDeptCount.entrySet().stream().max(Map.Entry.comparingByValue()).get();
		 System.out.println(largDept);
		 Map<String, List<Employee>> getEmps= employees.stream()
				 .collect(Collectors.groupingBy(Employee::department));
		 Map<String, List<String>> empondept = employees.stream()
				 .collect(Collectors.groupingBy(Employee::department,
						 Collectors.mapping(Employee::name, Collectors.toList())));
		 Entry<String, List<String>> smallis= empondept.entrySet().stream().min(Comparator.comparingInt(entry->entry.getValue().size())).get();
		 System.out.println(smallis);
		 Map<String, List<String>> finalComps= employees.stream()
				 .collect(Collectors.groupingBy(Employee::department,
						 Collectors.mapping(Employee::name, Collectors.toList())));
		 Entry<String, List<String>> largroup= finalComps.entrySet().stream().max(Comparator.comparingInt(entry->entry.getValue().size())).get();
		 System.out.println(largroup);
	}
	
}
