package Lab4;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CompanyBuilder {

    private String name;
    private List<Department> departments;

    private Validator validator;

    public CompanyBuilder name(String name) {
        this.name = name;
        return this;
    }

    public CompanyBuilder departments(List<Department> departments) {
        this.departments = departments;
        return this;
    }

    public Company build() {
        validate();
        return new Company (name, departments);
    }

    private void validate() {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<CompanyBuilder>> violations = validator.validate(this);

        if (!violations.isEmpty()) {
            List<String> errorMessages = new ArrayList<>();
            for (ConstraintViolation<CompanyBuilder> violation : violations) {
                errorMessages.add(violation.getMessage());
            }
            throw new IllegalArgumentException(String.join(", ", errorMessages));
        }
    }
}
