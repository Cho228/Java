package Lab4;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try {
            Employee employee = new EmployeeBuilder()
                    .name("John Doe")
                    .position("Software Developer")
                    .salary(50000)
                    .build();
            System.out.println("Employee: " + employee);
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating Employee: " + e.getMessage());
        }

        try {
            Project project = new ProjectBuilder()
                    .name("Project A")
                    .employees(Arrays.asList(
                            new Employee("John Doe", "Software Developer", 50000),
                            new Employee("Jane Doe", "QA Engineer", 45000)
                    ))
                    .build();
            System.out.println("Project: " + project);
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating Project: " + e.getMessage());
        }

        try {
            Department department = new DepartmentBuilder()
                    .name("Development Department")
                    .projects(Arrays.asList(
                            new Project("Project A", Arrays.asList(
                                    new Employee("John Doe", "Software Developer", 50000),
                                    new Employee("Jane Doe", "QA Engineer", 45000)
                            )),
                            new Project("Project B", Arrays.asList(
                                    new Employee("John Doe", "Software Developer", 50000)
                            ))
                    ))
                    .build();
            System.out.println("Department: " + department);
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating Department: " + e.getMessage());
        }

        try {
            Company company = new CompanyBuilder()
                    .name("XYZ IT Solutions")
                    .departments(Arrays.asList(
                            new Department("Development Department", Arrays.asList(
                                    new Project("Project A", Arrays.asList(
                                            new Employee("John Doe", "Software Developer", 50000),
                                            new Employee("Jane Doe", "QA Engineer", 45000)
                                    )),
                                    new Project("Project B", Arrays.asList(
                                            new Employee("John Doe", "Software Developer", 50000)
                                    ))
                            )),
                            new Department("QA Department", Arrays.asList(
                                    new Project("Project C", Arrays.asList(
                                            new Employee("Jack Doe", "QA Tester", 40000)
                                    ))
                            ))
                    ))
                    .build();
            System.out.println("Company: " + company);
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating Company: " + e.getMessage());
        }
    }
}
