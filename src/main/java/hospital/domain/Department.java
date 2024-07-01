package hospital.domain;

import java.util.List;
import java.util.Objects;

public class Department {
    private Long id;
    private String title;
//    private List<Patient> patients;
 /*   private int countOfPatients;*/

    public Department(Long id, String title, List<Patient> patients) {
        this.id = id;
        this.title = title;
//        this.patients = patients;
        /*this.countOfPatients=countOfPatients;*/
        /*this.countOfPatients = patients.size();*/
    }
    public Department(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Department(String title) {
        this.title = title;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

/*
    public int getCountOfPatients(){
        return countOfPatients;
    }
    public void setCountOfPatients(int countOfPatients){
        this.countOfPatients=countOfPatients;
    }
*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department box = (Department) o;
        return Objects.equals(id, box.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
