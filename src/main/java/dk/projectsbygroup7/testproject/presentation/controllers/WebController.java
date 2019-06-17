package dk.projectsbygroup7.testproject.presentation.controllers;

import dk.projectsbygroup7.testproject.business.StudentService;
import dk.projectsbygroup7.testproject.pojos.Course;
import dk.projectsbygroup7.testproject.pojos.CreditCardInfo;
import dk.projectsbygroup7.testproject.pojos.Student;
import dk.projectsbygroup7.testproject.business.CourseService;
import dk.projectsbygroup7.testproject.presentation.exceptions.Exception404;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class WebController {

    @Autowired
    CourseService courseService;

    @Autowired
    StudentService studentService;

    @RequestMapping(value={"", "/", "/index","/home"})
    public String home() {
        return "home.html";
    }

    @RequestMapping("courseprogram")
    public String courseProgram(Model model) {
        List<Course> courses = courseService.getCourses();
        model.addAttribute("courses", courses);

        return "courseprogram.html";
    }

    @RequestMapping("coursedetails")
    public String courseDetails(@RequestParam int courseid, Model model) {
        try {
            Course course = courseService.getCourse(courseid);
            model.addAttribute("course", course);

            return "coursedetails.html";
        } catch (NullPointerException e) {
            throw new Exception404();
        }
    }

    @RequestMapping("enrollcourse")
    public String enrollToCourse(
            @RequestParam String courseId,
            @RequestParam String name,
            @RequestParam String birthday,
            @RequestParam String email,
            @RequestParam String cardNumber,
            @RequestParam int expirationMonth,
            @RequestParam int expirationYear,
            @RequestParam int cvv,
            Model model) {

        CreditCardInfo card = new CreditCardInfo(
                cardNumber,
                expirationMonth + "",
                expirationYear + "",
                cvv + ""
        );
        Student student = new Student(0, name, LocalDate.parse(birthday), email);

        studentService.enrollInCourse(card, student, Integer.parseInt(courseId));
        model.addAttribute("message", "Enrollment succes");
        return "succesmessage.html";
    }
}
