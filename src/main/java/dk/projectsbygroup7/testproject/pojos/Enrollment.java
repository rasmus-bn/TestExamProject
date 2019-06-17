package dk.projectsbygroup7.testproject.pojos;

public class Enrollment {
    boolean paymentRecieved;
    Student student;
    Course course;

    public Enrollment() {
    }

    public Enrollment(boolean paymentRecieved, Student student, Course course) {
        this.paymentRecieved = paymentRecieved;
        this.student = student;
        this.course = course;
    }

    public boolean isPaymentRecieved() {
        return paymentRecieved;
    }

    public void setPaymentRecieved(boolean paymentRecieved) {
        this.paymentRecieved = paymentRecieved;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
