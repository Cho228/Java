package Lab2;

import java.util.Arrays;

import Lab1.src.Company;
import Lab1.src.Department;
import Lab1.src.Employee;
import Lab1.src.Project;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        // Створюємо тестовий об'єкт Company
        Company company = createTestCompany();

        // Створюємо серіалізатори
        Serializer<Company> jsonSerializer = new JsonSerializer<>(Company.class);
        Serializer<Company> xmlSerializer = new XmlSerializer<>(Company.class);
        Serializer<Company> txtSerializer = new TxtSerializer<>();

        // Використання серіалізаторів для запису об'єкта у файли
        jsonSerializer.writeToFile(company, new File("company.json"));
        xmlSerializer.writeToFile(company, new File("company.xml"));
        txtSerializer.writeToFile(company, new File("company.txt"));

        // Використання серіалізаторів для читання об'єкта з файлів
        Company jsonDeserializedCompany = jsonSerializer.readFromFile(new File("company.json"));
        Company xmlDeserializedCompany = xmlSerializer.readFromFile(new File("company.xml"));
        Company txtDeserializedCompany = txtSerializer.readFromFile(new File("company.txt"));

        // Виведення результатів
        System.out.println("JSON Deserialized: " + jsonDeserializedCompany);
        System.out.println("XML Deserialized: " + xmlDeserializedCompany);
        System.out.println("TXT Deserialized: " + txtDeserializedCompany);
    }

    private static Company createTestCompany() {
        Employee employee1 = new Employee("John Doe", "Software Developer", 50000);
        Employee employee2 = new Employee("Jane Doe", "QA Engineer", 45000);
        Project project1 = new Project("Project A", Arrays.asList(employee1, employee2));
        Project project2 = new Project("Project B", Arrays.asList(employee1));
        Department department1 = new Department("Development Department", Arrays.asList(project1));
        Department department2 = new Department("QA Department", Arrays.asList(project2));
        return new Company("XYZ IT Solutions", Arrays.asList(department1, department2));
    }
}
