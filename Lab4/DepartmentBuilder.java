package Lab4;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DepartmentBuilder {

    private String name;
    private List<Project> projects;

    private Validator validator;

    public DepartmentBuilder name(String name) {
        this.name = name;
        return this;
    }

    public DepartmentBuilder projects(List<Project> projects) {
        this.projects = projects;
        return this;
    }

    public Department build() {
        validate();
        return new Department(name, projects);
    }

    private void validate() {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<DepartmentBuilder>> violations = validator.validate(this);

        if (!violations.isEmpty()) {
            List<String> errorMessages = new ArrayList<>();
            for (ConstraintViolation<DepartmentBuilder> violation : violations) {
                errorMessages.add(violation.getMessage());
            }
            throw new IllegalArgumentException(String.join(", ", errorMessages));
        }
    }
}
