package Lab4;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class Company {

    @NotNull(message = "Name cannot be null")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @NotNull(message = "Departments cannot be null")
    @Size(min = 1, message = "Company must have at least one department")
    private List<Department> departments;

    public Company(String name, List<Department> departments) {
        this.name = name;
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", departments=" + departments +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
