package Lab4;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.ArrayList;
import java.util.List;
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
        validate();
        return new Employee (name, position, salary);
    }

    private void validate() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Set<ConstraintViolation<EmployeeBuilder>> violations = validator.validate(this);

        if (!violations.isEmpty()) {
            List<String> errorMessages = new ArrayList<>();
            for (ConstraintViolation<EmployeeBuilder> violation : violations) {
                errorMessages.add(violation.getMessage());
            }
            throw new IllegalArgumentException(String.join(", ", errorMessages));
        }
    }
}
