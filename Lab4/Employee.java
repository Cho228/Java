package Lab4;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class Employee {

    @NotNull(message = "Name cannot be null")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @NotNull(message = "Position cannot be null")
    @Size(min = 3, max = 50, message = "Position must be between 3 and 50 characters")
    private String position;

    @Positive(message = "Salary must be int and greater than or equal to 0")
    private int salary;

    public Employee(String name, String position, int salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
