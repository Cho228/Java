package Lab4;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import java.util.HashSet;
import java.util.Set;

public class EmployeeBuilder {
    private String name;
    private String position;
    private int salary;

    private Validator validator;

    public EmployeeBuilder name(String name) {
        this.name = name;
        return this;
    }

    public EmployeeBuilder position(String position) {
        this.position = position;
        return this;
    }

    public EmployeeBuilder salary(int salary) {
        this.salary = salary;
        return this;
    }

    public Employee build() {
        Employee employee = new Employee(name, position, salary);
        validate(employee);
        return employee;
    }

    private void validate(Employee employee){
        Validator validator = (Validator) Validation.buildDefaultValidatorFactory().getValidator();

        Set<String> validationMessages = new HashSet<>();
        Set<ConstraintViolation<Employee>> violations = validator.validate(employee);

        for (ConstraintViolation<Employee> violation : violations) {
            validationMessages.add(violation.getInvalidValue() + ": " + violation.getMessage());
        }

        if (!validationMessages.isEmpty()) {
            throw new IllegalArgumentException("Invalid fields: " + String.join(", ", validationMessages));
        }
    }
}
