package dk.projectsbygroup7.testproject.business;

import dk.projectsbygroup7.testproject.dataaccess.CourseDAO;
import dk.projectsbygroup7.testproject.dataaccess.StudentDAO;
import dk.projectsbygroup7.testproject.pojos.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
