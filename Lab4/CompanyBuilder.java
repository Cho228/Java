package Lab4;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.HashSet;
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
        Company company = new Company(name, departments);
        validate(company);
        return company;
    }

    private void validate(Company company){
        Validator validator = (Validator) Validation.buildDefaultValidatorFactory().getValidator();

        Set<String> validationMessages = new HashSet<>();
        Set<ConstraintViolation<Company>> violations = validator.validate(company);

        for (ConstraintViolation<Company> violation : violations) {
            validationMessages.add(violation.getInvalidValue() + ": " + violation.getMessage());
        }

        if (!validationMessages.isEmpty()) {
            throw new IllegalArgumentException("Invalid fields: " + String.join(", ", validationMessages));
        }
    }
}
