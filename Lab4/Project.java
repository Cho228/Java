package Lab4;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class Project {

    @NotNull(message = "Name cannot be null")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @NotNull(message = "Employees cannot be null")
    @Size(min = 1, message = "Project must have at least one employee")
    private List<Employee> employees;


    public Project(String name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
