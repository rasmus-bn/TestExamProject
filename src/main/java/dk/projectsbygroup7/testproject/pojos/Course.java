package dk.projectsbygroup7.testproject.pojos;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Course {
    int id;
    Subject subject;
    int hours;
    LocalDate startDate;
    LocalDate endDate;

    public Course() {
    }

    public Course(int id, Subject subject, int hours, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.subject = subject;
        this.hours = hours;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM-yyyy");

        String txt = subject.subject + ", ";
        txt += hours + " hours, ";
        txt += "start: " + startDate.format(formatter) + ", ";
        txt += "end: " + endDate.format(formatter) + "";
        return txt;
    }
}
