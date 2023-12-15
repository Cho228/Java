package Lab5;

import java.sql.SQLException;

public class CreateTables {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/Lab5";
        String user = "root";
        String password = "password";

        DBExecuter dbExecuter = new DBExecuter(url, user, password);

        try {
            createTables(dbExecuter);

            System.out.println("Таблиці успішно створено!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTables(DBExecuter dbExecuter) throws SQLException {
        String createDepartmentTable = "CREATE TABLE Department (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "name VARCHAR(255) NOT NULL" +
                ")";
        dbExecuter.executeQueryWithNoResult(createDepartmentTable);

        String createProjectTable = "CREATE TABLE Project (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "name VARCHAR(255) NOT NULL," +
                "department_id INT," +
                "FOREIGN KEY (department_id) REFERENCES Department(id)" +
                ")";
        dbExecuter.executeQueryWithNoResult(createProjectTable);

        String createEmployeeTable = "CREATE TABLE Employee (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "name VARCHAR(255) NOT NULL," +
                "position VARCHAR(255) NOT NULL," +
                "salary INT," +
                "birthDate DATE," +
                "project_id INT," +
                "FOREIGN KEY (project_id) REFERENCES Project(id)" +
                ")";
        dbExecuter.executeQueryWithNoResult(createEmployeeTable);

        String createCompanyTable = "CREATE TABLE Company (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "name VARCHAR(255) NOT NULL," +
                "headquarters_location VARCHAR(255)" +
                ")";
        dbExecuter.executeQueryWithNoResult(createCompanyTable);
    }
}

