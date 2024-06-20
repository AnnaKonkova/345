package hospital.domain;

import java.util.Objects;

public class Patient {
    private Long id;
    private String fuulName;
    private int age;
    private String gender;
    private String title;


    public Patient(Long id, String fuulName, int age,String gender, String title) {// тут был Department title
        this(fuulName, age, gender, String.valueOf(title));
        this.id = id;
       /* department.setCountOfPatients(department.getCountOfPatients()+1);*/

    }

    public Patient(String fuulName, int age,String gender,String title) {
        this.fuulName = fuulName;
        this.age = age;
        this.gender =gender;
        this.title=title;

    }

    public Long getId() {return id;}
    public int getAge() {return age;}
    public String getGender() {return gender;}
    public String getFuulName() {
        return fuulName;
    }
    public String getTitle() {return title;}
    public void setId(int id) {
    }

    public void setFullName(String fullName) {}

    public void setAge(int age) {}

    public void setGender(String gender) {}

    public void setDepartmentTitle(String departmentTitle) {}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient fruit = (Patient) o;
        return Objects.equals(id, fruit.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
