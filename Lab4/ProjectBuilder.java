package Lab4;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import java.util.HashSet;
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
        Project project = new Project(name, employees);
        validate(project);
        return project;
    }

    private void validate(Project project){
        Validator validator = (Validator) Validation.buildDefaultValidatorFactory().getValidator();

        Set<String> validationMessages = new HashSet<>();
        Set<ConstraintViolation<Project>> violations = validator.validate(project);

        for (ConstraintViolation<Project> violation : violations) {
            validationMessages.add(violation.getInvalidValue() + ": " + violation.getMessage());
        }

        if (!validationMessages.isEmpty()) {
            throw new IllegalArgumentException("Invalid fields: " + String.join(", ", validationMessages));
        }
    }
}
