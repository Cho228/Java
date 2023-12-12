package Lab1.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Клас, що представляє ІТ компанію.
 */
public class Company {

    private String name;
    private List<Department> departments;

    public Company(String name, List<Department> departments) {
        this.name = name;
        this.departments = departments;
    }
    private Company(Builder builder) {
        this.name = builder.name;
        this.departments = builder.departments;
    }

    public List<Project> getAllProjects() {
        List<Project> allProjects = new ArrayList<>();
        for (Department department : departments) {
            allProjects.addAll(department.getProjects());
        }
        return allProjects;
    }

    public List<Employee> getAllEmployees() {
        List<Employee> allEmployees = new ArrayList<>();
        for (Department department : departments) {
            for (Project project : department.getProjects()) {
                allEmployees.addAll(project.getEmployees());
            }
        }
        return allEmployees;
    }
    /**
     * Метод для отримання назви компанії.
     */
    public String getName() {
        return name;
    }

    /**
     * Метод для отримання списку відділів компанії.
     */
    public List<Department> getDepartments() {
        return departments;
    }

    /**
     * Метод для отримання рядкового представлення компанії.
     */
    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", departments=" + departments +
                '}';
    }

    /**
     * Метод для порівняння компаній за допомогою equals.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(name, company.name);
    }

    /**
     * Метод для отримання хеш-коду компанії.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    /**
     * Внутрішній клас Builder для побудови об'єкту Company.
     */
    public static class Builder {
        private String name;
        private List<Department> departments;

        /**
         * Конструктор з обов'язковим параметром - назва компанії.
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Метод для додавання списку відділів компанії.
         */
        public Builder departments(List<Department> departments) {
            this.departments = departments;
            return this;
        }

        /**
         * Метод для побудови об'єкту Company.
         */
        public Company build() {
            return new Company(this);
        }
    }
}