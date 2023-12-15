package Lab4;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;

public class Department {

    @NotNull(message = "Name cannot be null")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @NotNull(message = "Projects cannot be null")
    @Size(min = 1, message = "Department must have at least one project")
    private List<Project> projects;

    public Department (String name, List<Project> projects) {
        this.name = name;
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", projects=" + projects +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
