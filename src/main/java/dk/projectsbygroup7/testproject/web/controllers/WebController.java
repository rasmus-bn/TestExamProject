package dk.projectsbygroup7.testproject.web.controllers;

import dk.projectsbygroup7.testproject.pojos.Course;
import dk.projectsbygroup7.testproject.services.CourseService;
import dk.projectsbygroup7.testproject.web.exceptions.Exception404;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {

    @Autowired
    CourseService courseService;

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
}
