package dk.projectsbygroup7.testproject.services;

import dk.projectsbygroup7.testproject.pojos.Course;
import dk.projectsbygroup7.testproject.pojos.Subject;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CourseService {

    private Subject s1 = new Subject("English", 2010, true);
    private Subject s2 = new Subject("Math", 2012, false);

    private ArrayList<Course> courses = new ArrayList<>(Arrays.asList(
            new Course(1, s1, 30, LocalDate.now(), LocalDate.now().plusMonths(1)),
            new Course(2, s1, 60, LocalDate.now(), LocalDate.now().plusMonths(1)),
            new Course(3, s2, 40, LocalDate.now(), LocalDate.now().plusMonths(1)),
            new Course(4, s2, 80, LocalDate.now(), LocalDate.now().plusMonths(1))
    ));

    public boolean enrollInCourse() {
        throw new NotImplementedException();
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Course getCourse(int id) {
        for (Course c :
                courses) {
            if(c.getId() == id) return c;
        }
        throw new NullPointerException();
    }
}
