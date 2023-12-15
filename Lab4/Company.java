package Lab4;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.transform.Source;
import java.util.List;

public class Company implements Source {

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

    @Override
    public void setSystemId(String systemId) {

    }

    @Override
    public String getSystemId() {
        return null;
    }
}
