package Lab3;

import Lab1.src.Company;
import Lab1.src.Department;
import Lab1.src.Employee;
import Lab1.src.Project;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Company company = createTestCompany();

        CompanyServiceStream.sortBySalary(company.getAllEmployees());
        CompanyServiceStream.sortProjectsByEmployeeCount(company.getAllProjects());
        CompanyServiceStream.sortDepartmentsByName(company.getDepartments());

        System.out.println("Sorted Employees by Salary: " + company.getAllEmployees());
        System.out.println("Sorted Projects by Employee Count: " + company.getAllProjects());
        System.out.println("Sorted Departments by Name: " + company.getDepartments());

        List<Employee> sortedEmployees = CompanyServiceStream.sortBySalary(company.getAllEmployees());
        List<Project> sortedProjects = CompanyServiceStream.sortProjectsByEmployeeCount(company.getAllProjects());
        List<Department> sortedDepartments = CompanyServiceStream.sortDepartmentsByName(company.getDepartments());

        System.out.println("Sorted Employees by Salary (Stream API): " + sortedEmployees);
        System.out.println("Sorted Projects by Employee Count (Stream API): " + sortedProjects);
        System.out.println("Sorted Departments by Name (Stream API): " + sortedDepartments);
    }

    private static Company createTestCompany() {
        Employee employee1 = new Employee("John Doe", "Software Developer", 50000);
        Employee employee2 = new Employee("Jane Doe", "QA Engineer", 45000);
        Project project1 = new Project("Project A", Arrays.asList(employee1, employee2));
        Project project2 = new Project("Project B", Arrays.asList(employee1));
        Department department1 = new Department("Development Department", Arrays.asList(project1));
        Department department2 = new Department("QA Department", Arrays.asList(project2));
        return new Company("XYZ IT Solutions", Arrays.asList(department1, department2));
    }
}
