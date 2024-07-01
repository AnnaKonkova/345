package hospital.integration.database;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hospital.domain.Department;
import hospital.domain.Patient;
import hospital.repository.DepartmentRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DepartmentRepositoryImpl implements DepartmentRepository {

    private Connection connection;
    Scanner scanner = new Scanner(System.in);

    public DepartmentRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addDepartment(Department department) {
            try {
                PreparedStatement statement = connection.prepareStatement("INSERT INTO department_table (title) VALUES (?)");
                statement.setString(1, department.getTitle());
                statement.executeUpdate();
                statement.close();
                System.out.println("Отделение успешно созданно.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    @Override
    public Department getDepartmentByTitle(String title) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM department_table WHERE title = ?");
            statement.setString(1, title);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                var dep = new Department(resultSet.getLong("id"), resultSet.getString("title"));
                resultSet.close();
                statement.close();
                return dep;
            }
            return null;

        }catch(SQLException e){
            throw new RuntimeException("Error while statement executing",e);
        }
    }

    public void removeDepartmentByTitle(String title) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM department_table WHERE title = ?");
            statement.setString(1, title);
            int rowsAffected = statement.executeUpdate();
            statement.close();

            if (rowsAffected > 0) {
                System.out.println("Отделение успешно удалено.");
            } else {
                System.out.println("Отделение не найдено.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String listD() {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM department_table");
            List<Department> departments = new ArrayList<>();
            ObjectMapper mapper = new ObjectMapper();

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String title = resultSet.getString("title");
                Department department = new Department(id, title);
                departments.add(department);
            }
            return mapper.writeValueAsString(departments);

        } catch (SQLException e) {
            throw new RuntimeException("Error while statement executing");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addPatients(Department department, String patientName, int patientAge, String patientGender) {
        System.out.println("bip ");
        List<Department> departments = getAllDepartments();

        if (departments.contains(department)) {
            try {
                PreparedStatement statement = connection.prepareStatement("INSERT INTO patient_table (patientName, patientAge, patientGender,title) VALUES (?, ?, ?, ?)");
                statement.setString(1, patientName);
                statement.setInt(2, patientAge);
                statement.setString(3, patientGender);
                statement.setString(4, department.getTitle());
                /*department.setCountOfPatients(department.getCountOfPatients()+1);*/
                statement.executeUpdate();
                statement.close();
                System.out.println("Пациент  успешно добавлен в отделение.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Отделение не найдено.");
        }
    }
    public List<Department> getAllDepartments() {   //для получения пациента поо отделению
        List<Department> departments = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM department_table");
            while (resultSet.next()) {
                var dep = new Department(resultSet.getLong("id"), resultSet.getString("title"));
                departments.add(dep);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departments;
    }

    @Override
    public void removePatients() {
        System.out.println("Введите ФИО пациента для удаления:");
        String fuulName = scanner.nextLine();
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM patient_table WHERE fuulName = ?");
            statement.setString(1, fuulName);
            int rowsAffected = statement.executeUpdate();
            statement.close();
            if (rowsAffected > 0) {
                System.out.println("Пациент успешно удален.");
            } else {
                System.out.println("Пациент не найден.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Patient> listP() {
        System.out.println("Список пациентов:");
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM patient_table");
            List<Patient> patients = new ArrayList<>();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String fuulName = resultSet.getString("fuulName");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                String department_title = resultSet.getString("department_title");
                Patient patient = new Patient(id, fuulName, age, gender, department_title);
                patients.add(patient);
            }
            return patients;
        } catch (SQLException e) {
            throw new RuntimeException("Error while statement executing");
        }
    }
    @Override
    public String findD() {
        System.out.println("Введите id department:");
        Integer idDepartment = scanner.nextInt();

        List<Integer> departmentID = getIdDepartment();

        if ( departmentID.contains(idDepartment)){
            try {
                PreparedStatement statement = connection.prepareStatement("SELECT title FROM department_table WHERE id = ?");
                statement.setInt(1, idDepartment);
                ResultSet resultSet = statement.executeQuery();
                resultSet.next();
                String departmentTitle = resultSet.getString("title");
                resultSet.close();
                statement.close();
                return departmentTitle;
            }catch(SQLException e){
                    throw new RuntimeException("Error while statement executing",e);
            }
        }
        else {
            System.out.println("Department not found");
        }
        return null;
    }

    public List<Integer> getIdDepartment() {    // Метод для получения списка id всех отделов из базы данных
        List<Integer> departmentID = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id FROM department_table");

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                departmentID.add(id);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException("Error while getting department IDs", e);
        }
        return departmentID;
    }
    public List<String> getPatientsInDepartment(String groupName) {
        List<String> studentNames = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT name FROM student_table WHERE group_name = ?");
            statement.setString(1, groupName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                studentNames.add(name);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentNames;
    }
}