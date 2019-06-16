package dk.projectsbygroup7.testproject.pojos;

import java.time.LocalDate;

public class Student {
    private int id;
    private String name;
    private LocalDate birthday;
    private String email;

    public Student() {
    }

    public Student(int id, String name, LocalDate birthday, String email) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        Student student = (Student) obj;

        return this.id == student.getId()
                && this.name.equals(student.getName())
                && this.birthday.equals(student.getBirthday())
                && this.email.equals(student.getEmail());
    }
}
