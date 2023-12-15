package Lab4;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

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
        Department departments = new Department(name, projects);
        validate(departments);
        return departments;
    }

    private void validate(Department department){
        Validator validator = (Validator) Validation.buildDefaultValidatorFactory().getValidator();

        Set<String> validationMessages = new HashSet<>();
        Set<ConstraintViolation<Department>> violations = validator.validate(department);

        for (ConstraintViolation<Department> violation : violations) {
            validationMessages.add(violation.getInvalidValue() + ": " + violation.getMessage());
        }

        if (!validationMessages.isEmpty()) {
            throw new IllegalArgumentException("Invalid fields: " + String.join(", ", validationMessages));
        }
    }
}
