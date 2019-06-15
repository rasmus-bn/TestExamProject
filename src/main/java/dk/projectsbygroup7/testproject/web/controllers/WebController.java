package dk.projectsbygroup7.testproject.web.controllers;

import dk.projectsbygroup7.testproject.dataaccess.DBConnection;
import dk.projectsbygroup7.testproject.pojos.Course;
import dk.projectsbygroup7.testproject.pojos.CreditCardInfo;
import dk.projectsbygroup7.testproject.pojos.User;
import dk.projectsbygroup7.testproject.services.CourseService;
import dk.projectsbygroup7.testproject.services.EnrollmentStatus;
import dk.projectsbygroup7.testproject.web.exceptions.Exception404;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.LocalDate;
import java.util.List;

@Controller
public class WebController {

    @Autowired
    CourseService courseService;

    @Autowired
    DBConnection dbConn;

    @RequestMapping(value={"", "/", "/index","/home"})
    public String home() {
        dbConn.getConn();
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
        User user = new User(name, LocalDate.parse(birthday), email);

        try {
            courseService.enrollInCourse(card, user);
            return "succes";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }
}
