package Lab4;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ProjectBuilder {


    private String name;
    private List<Employee> employees;
    private Validator validator;

    public ProjectBuilder name(String name) {
        this.name = name;
        return this;
    }

    public ProjectBuilder employees(List<Employee> employees) {
        this.employees = employees;
        return this;
    }

    public Project build() {
        validate();
        return new Project(name, employees);
    }

    private void validate() {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<ProjectBuilder>> violations = validator.validate(this);

        if (!violations.isEmpty()) {
            List<String> errorMessages = new ArrayList<>();
            for (ConstraintViolation<ProjectBuilder> violation : violations) {
                errorMessages.add(violation.getMessage());
            }
            throw new IllegalArgumentException(String.join(", ", errorMessages));
        }
    }
}
