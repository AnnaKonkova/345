package hospital.service;

import hospital.domain.Department;
import hospital.domain.Patient;
import hospital.integration.database.DepartmentRepositoryImpl;
import hospital.repository.DepartmentRepository;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Scanner;

public class DepartmentService {
    private final DepartmentRepository repository;

    public DepartmentService(DepartmentRepositoryImpl repository) {
        this.repository = repository;
    }

    public String  getByIdDep() {return  repository.findD();}
    public void addDepartmentt(HttpServletRequest request){
        repository.addDepartment();
    }
    public void addPatients(Scanner scanner){repository.addPatients();}
    public void removeDepartment(HttpServletRequest scanner){repository.removeDepartment();}
    public void removePatient(Scanner scanner){repository.removePatients();}

    public List<Department> getAllDep() {
        return repository.listD();
    }
    public List<Patient> getAllPati() {return repository.listP();}
}
