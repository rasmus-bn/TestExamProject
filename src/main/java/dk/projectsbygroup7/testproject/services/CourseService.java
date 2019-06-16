package dk.projectsbygroup7.testproject.services;

import dk.projectsbygroup7.testproject.dataaccess.course.CourseDAO;
import dk.projectsbygroup7.testproject.dataaccess.student.StudentDAO;
import dk.projectsbygroup7.testproject.pojos.Course;
import dk.projectsbygroup7.testproject.pojos.CreditCardInfo;
import dk.projectsbygroup7.testproject.pojos.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseDAO courseDAO;

    @Autowired
    StudentDAO studentDAO;

    public List<Course> getCourses() {
        ArrayList<Course> courses = courseDAO.getAll();
        return courses;
    }

    public Course getCourse(int id) {
        Course course = courseDAO.getById(id);
        return course;
    }
}
