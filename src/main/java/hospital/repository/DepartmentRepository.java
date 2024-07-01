package hospital.repository;

import hospital.domain.Department;
import hospital.domain.Patient;

import java.util.List;

//контракт
public interface DepartmentRepository {

    String findD();
    String listD();
    List<Patient>listP();

    void addDepartment(Department department);

    Department getDepartmentByTitle(String title);

    void removeDepartmentByTitle(String title);

    void addPatients(Department department, String patientName,int patientAge,String patientGender);

    void removePatients( );

    List<Department> getAllDepartments();
}
