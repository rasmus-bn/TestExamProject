package dk.projectsbygroup7.testproject.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @RequestMapping("editcourseprogram")
    public String editCourseProgram() {
        return "editcourseprogram.html";
    }
}
