package Lab3;

import Lab1.src.Department;
import Lab1.src.Employee;
import Lab1.src.Project;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CompanyServiceStream {

    public static List<Employee> sortBySalary(List<Employee> employees) {
        return employees.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public static List<Project> sortProjectsByEmployeeCount(List<Project> projects) {
        Comparator<Project> comparator = Comparator.comparingInt(project -> project.getEmployees().size());
        return projects.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    public static List<Department> sortDepartmentsByName(List<Department> departments) {
        return departments.stream()
                .sorted(Comparator.comparing(Department::getName))
                .collect(Collectors.toList());
    }
}