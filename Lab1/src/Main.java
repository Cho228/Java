package Lab1.src;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Створюємо декілька працівників
        Employee employee1 = new Employee.Builder()
                .name("John Doe")
                .position("Software Developer")
                .salary(50000)
                .build();

        Employee employee2 = new Employee.Builder()
                .name("Drake Doe")
                .position("QA Engineer")
                .salary(45000)
                .build();

        // Створюємо проекти та призначаємо працівників до них
        Project project1 = new Project.Builder()
                .name("Project A")
                .employees(Arrays.asList(employee1, employee2))
                .build();

        Project project2 = new Project.Builder()
                .name("Project B")
                .employees(Arrays.asList(employee1))
                .build();

        // Створюємо відділи та призначаємо проекти до них
        Department department1 = new Department.Builder()
                .name("Development Department")
                .projects(Arrays.asList(project1))
                .build();

        Department department2 = new Department.Builder()
                .name("QA Department")
                .projects(Arrays.asList(project2))
                .build();

        // Створюємо ІТ компанію та призначаємо відділи до неї
        Company company = new Company.Builder()
                .name("XYZ IT Solutions")
                .departments(Arrays.asList(department1, department2))
                .build();

        // Виводимо інформацію про компанію
        System.out.println("Company Information:");
        System.out.println(company);

        // Виводимо інформацію про працівників
        System.out.println("\nEmployees Information:");
        for (Department department : company.getDepartments()) {
            for (Project project : department.getProjects()) {
                for (Employee employee : project.getEmployees()) {
                    System.out.println(employee);
                }
            }
        }
    }
}
