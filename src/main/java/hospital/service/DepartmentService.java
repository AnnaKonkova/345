package hospital.service;

import hospital.domain.Department;
import hospital.domain.Patient;
import hospital.repository.DepartmentRepository;

import java.util.List;
import java.util.Scanner;

public class DepartmentService {
    private final DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }


    public void addDepartmentt(String title) {
        try {
            var existing = repository.getDepartmentByTitle(title);
            if(existing != null){
                throw new IllegalArgumentException("Already existing");
            }
            var depToAdd = new Department(title);
            repository.addDepartment(depToAdd);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Already existing");
        }
    }

    public void addPatients(String title, String patientName, int patientAge, String patientGender) {
        try {
            var departmentToAddPatient = repository.getDepartmentByTitle(title);
            repository.addPatients(departmentToAddPatient, patientName, patientAge, patientGender);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Не сущесвует");
        }
    }

    public void removeDepartment(String title) {
        repository.removeDepartmentByTitle(title);
    }

    public void removePatient(Scanner scanner) {
        repository.removePatients();
    }

    public String getByIdDep() {
        return repository.findD();
    }

    public String getAllDep() {
        return repository.listD();
    }

    public List<Patient> getAllPati() {
        return repository.listP();
    }
}
